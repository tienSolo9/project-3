package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.IBuildingRepositoryCustom;
import com.javaweb.utils.NumberUtils;
import com.javaweb.utils.StringUtils;
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

    public void WhereQuery(StringBuilder where, BuildingSearchRequest buildingSearchRequest){
        try{
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for(Field it : fields){
                it.setAccessible(true);
                String key = it.getName();
                if(!key.equals("staffId") && !key.equals("typeCode") && it.get(buildingSearchRequest) != null &&
                        !key.startsWith("rent") &&  !key.startsWith("area")){
                    String value = it.get(buildingSearchRequest).toString();
                    if(StringUtils.check(value)){
                        where.append(" And b." + key + " like '%" + value + "%' ");
                    }

                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void SpecialWhereQuery(StringBuilder where, BuildingSearchRequest buildingSearchRequest){
        List<String> typeCode = buildingSearchRequest.getTypeCode();

        if(typeCode != null && typeCode.size() != 0){
            where.append(" And b.type like '%" + String.join(",",typeCode) + "%'" );
        }

        Long staffId = buildingSearchRequest.getStaffId();
        if(staffId != null){
            if(NumberUtils.isLong(staffId.toString())){
                where.append(" and Exists( Select 1 From assignmentbuilding a Where a.buildingid = b.id and staffid = " + staffId + ")");
            }
        }

        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
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

        Long areaFrom = buildingSearchRequest.getAreaFrom();
        Long areaTo = buildingSearchRequest.getAreaTo();

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
    public List<BuildingEntity> getAllBuildings(BuildingSearchRequest buildingSearchRequest) {
        StringBuilder sql = new StringBuilder("Select b.* From building b ");
        StringBuilder where = new StringBuilder(" where 1 ");
        WhereQuery(where,buildingSearchRequest);
        SpecialWhereQuery(where,buildingSearchRequest);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
