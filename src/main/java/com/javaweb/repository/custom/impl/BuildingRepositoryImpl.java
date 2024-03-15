package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
import com.javaweb.utils.NumberUtils;
import com.javaweb.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
@Repository
public class BuildingRepositoryImpl implements IBuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public void WhereQuery(StringBuilder where, BuildingDTO buildingDTO){
        try{
            Field[] fields = BuildingDTO.class.getDeclaredFields();
            for(Field it : fields){
                it.setAccessible(true);
                String key = it.getName();
                if(!key.equals("staffId") && !key.equals("typeCode") && it.get(buildingDTO) != null &&
                        !key.startsWith("rent") &&  !key.startsWith("area")){
                    String value = it.get(buildingDTO).toString();
                    if(StringUtils.check(value)){
                        where.append(" And b." + key + " like '%" + value + "%' ");
                    }

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void SpecialWhereQuery(StringBuilder where, BuildingDTO buildingDTO){
        List<String> typeCode = buildingDTO.getTypeCode();

        if(typeCode != null && typeCode.size() != 0){
            where.append(" And b.type like '%" + String.join(",",typeCode) + "%'" );
        }

        Long staffId = buildingDTO.getStaffId();
        if(staffId != null){
            if(NumberUtils.isLong(staffId.toString())){
                where.append(" and Exists( Select 1 From assignmentbuilding a Where a.buildingid = b.id and staffid = " + staffId + ")");
            }
        }

        Long rentPriceFrom = buildingDTO.getRentPriceFrom();
        Long rentPriceTo = buildingDTO.getRentPriceTo();
        if(rentPriceFrom != null){
            if(NumberUtils.isLong(rentPriceFrom.toString())){
                where.append(" And b.rentprice >= " + rentPriceFrom);
            }
        }

        if(rentPriceTo != null){
            if(NumberUtils.isLong(rentPriceTo.toString())){
                where.append(" And b.rentprice <= " + rentPriceTo);
            }
        }

        Long areaFrom = buildingDTO.getAreaFrom();
        Long areaTo = buildingDTO.getAreaTo();

        if(areaFrom != null || areaTo != null){
            where.append(" and Exists( Select 1 From rentarea r Where r.buildingid = b.id");

            if(areaFrom != null){
                if(NumberUtils.isLong(areaFrom.toString())){
                    where.append(" and r.value >=" + areaFrom);
                }
            }
            if(areaTo != null){
                if(NumberUtils.isLong(areaTo.toString())){
                    where.append(" and r.value <=" + areaTo);
                }
            }
            where.append(")");
        }
    }
    @Override
    public Page<BuildingEntity> getAllBuildings(BuildingDTO buildingDTO, Pageable pageable) {
        StringBuilder sql = new StringBuilder("Select b.* From building b ");
        StringBuilder where = new StringBuilder(" where 1 ");
        WhereQuery(where,buildingDTO);
        SpecialWhereQuery(where,buildingDTO);
        sql.append(where).append(" LIMIT ").append(pageable.getPageSize()).append("\n")
                .append(" OFFSET ").append(pageable.getOffset());

        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        List<BuildingEntity> resultList = query.getResultList();
        Integer totalcount = resultList.size();
        return new PageImpl<>(resultList, pageable, totalcount);
    }

    @Override
    public int countTotalItem() {
        return 0;
    }
}
