<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="buildingListURL" value="/admin/building-list"/>

<html>
<head>
    <title>List Building</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Dashboard</li>
            </ul><!-- /.breadcrumb -->

            <div class="nav-search" id="nav-search">
                <form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input"
                                       id="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
                </form>
            </div><!-- /.nav-search -->
        </div>

        <div class="page-content">
            <div class="ace-settings-container" id="ace-settings-container">
                <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                    <i class="ace-icon fa fa-cog bigger-130"></i>
                </div>

                <div class="ace-settings-box clearfix" id="ace-settings-box">
                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <div class="pull-left">
                                <select id="skin-colorpicker" class="hide">
                                    <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                    <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                    <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                    <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                </select>
                            </div>
                            <span>&nbsp; Choose Skin</span>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                            <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                            <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                            <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                            <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                            <label class="lbl" for="ace-settings-add-container">
                                Inside
                                <b>.container</b>
                            </label>
                        </div>
                    </div><!-- /.pull-left -->

                    <div class="pull-left width-50">
                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
                            <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
                            <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                        </div>

                        <div class="ace-settings-item">
                            <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
                            <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                        </div>
                    </div><!-- /.pull-left -->
                </div><!-- /.ace-settings-box -->
            </div><!-- /.ace-settings-container -->

            <div class="page-header">
                <h1>
                    <b>Nhà nè</b>
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="widget-box ui-sortable-handle">
                        <div class="widget-header">
                            <h5 class="widget-title" style="color:black"><b>Search</b></h5>

                            <div class="widget-toolbar">

                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>
                            </div>

                            <div class="widget-body" style="color:black">
                                <div class="widget-main">
                                    <form:form id="listForm" action="${buildingListURL}" modelAttribute="modelSearch" method="GET">
                                        <div class="row">
                                            <div class="col-xs-12">
                                                <div class="col-xs-6">
                                                    <label class="name">Name Building</label>
<%--                                                    <input type="text" class="form-control" name="name" value="${modelSearch.name}">--%>
                                                    <form:input path="name" class="form-control"/>
                                                </div>

                                                <div class="col-xs-6">
                                                    <label class="name">Floor Area</label>
<%--                                                    <input type="number" class="form-control" name="floorArea" value="">--%>
                                                    <form:input path="floorArea" class="form-control"/>
                                                </div>
                                            </div>


                                            <div class="col-xs-12">
                                                <div class="col-xs-2">
                                                    <label class="name">District</label>
                                                    <form:select class="form-control" path="district">
                                                        <form:options items="${districtC}"/>
                                                    </form:select>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Ward</label>
<%--                                                    <input type="text" class="form-control" name="ward">--%>
                                                    <form:input path="ward" class="form-control"/>
                                                </div>
                                                <div class="col-xs-5">
                                                    <label class="name">Street</label>
<%--                                                    <input type="text" class="form-control" name="street">--%>
                                                    <form:input path="street" class="form-control"/>
                                                </div>
                                            </div>


                                            <div class="col-xs-12">
                                                <div class="col-xs-4">
                                                    <label class="name">Number Of Basement</label>

                                                    <form:input path="numberOfBasement" class="form-control"/>
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Direction</label>

                                                    <form:input path="direction" class="form-control"/>
                                                </div>
                                                <div class="col-xs-4">
                                                    <label class="name">Level Of Building</label>

                                                    <form:input path="level" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="col-xs-3">
                                                    <label class="name">Area From</label>

                                                    <form:input path="areaFrom" class="form-control"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Area To </label>

                                                    <form:input path="areaTo" class="form-control"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Rent Price From</label>

                                                    <form:input path="rentPriceFrom" class="form-control"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Rent Price To</label>

                                                    <form:input path="rentPriceTo" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="col-xs-3">
                                                    <label class="name">Manager Name</label>

                                                    <form:input path="managerName" class="form-control"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name"> Manager Phone</label>

                                                    <form:input path="managerPhone" class="form-control"/>
                                                </div>
                                                <div class="col-xs-3">
                                                    <label class="name">Staff in charge</label>
                                                    <form:select class="form-control" path="staffId">
                                                        <form:option value="">Select</form:option>
                                                        <form:options items="${StaffList}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="col-xs-9">
                                                    <form:checkboxes path="typeCode" items="${typeCodeC}"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-12">
                                                <div class="col-xs-9">

                                                    <button id="btnSearch" type="button" class="btn btn-primary">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                                                        </svg>
                                                        Search
                                                    </button>
                                                </div>

                                            </div>


                                        </div>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="pull-right">
								<span>
									<a href="/admin/building-edit" target="_blank">
										<button style="background-color: skyblue;" title="Add Building">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
												<path
                                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0" />
												<path
                                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z" />
												<path
                                                        d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z" />
											</svg>
										</button>
									</a>

								</span>
                        <span>
									<button style="background-color: orange;" title="Move Building" id="btnDeleteBuilding" onclick="testDelete()">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                             fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
											<path
                                                    d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1" />
											<path
                                                    d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z" />
											<path
                                                    d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z" />
										</svg>
									</button>
								</span>
                    </div>
                </div>

                <!-- List Building -->
                <div class="col-xs-12">
                    <table id="tableForm" class="table table-striped table-bordered table-hover"
                           style="margin-top: 2cm">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">
                                    <span class="lbl"></span>
                                </label>
                            </th>
                            <th>Name Building</th>
                            <th>Address</th>
                            <th>Number of Basement</th>
                            <th>Manager Phone</th>
                            <th>Manager Name</th>
                            <th>Floor Area</th>
                            <th>Rent Area</th>
                            <th>Operate</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="item" items="${buildingList1}">
                            <tr class="">
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>

                                <td>${item.name}"</td>
                                <td>${item.address}</td>
                                <td>${item.numberOfBasement}</td>
                                <td>${item.managerPhone}</td>

                                <td>${item.managerName}</td>
                                <td>${item.floorArea}</td>
                                <td>${item.rentArea}</td>

                                <td>
                                    <div>
                                        <button title="Assignment Building" Onclick="assignmentBuilding(${item.id})" type="button" class="btn btn-success" >
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-briefcase" viewBox="0 0 16 16">
                                                <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v8A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-8A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5m1.886 6.914L15 7.151V12.5a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5V7.15l6.614 1.764a1.5 1.5 0 0 0 .772 0M1.5 4h13a.5.5 0 0 1 .5.5v1.616L8.129 7.948a.5.5 0 0 1-.258 0L1 6.116V4.5a.5.5 0 0 1 .5-.5"></path>
                                            </svg>
                                        </button>
                                        <a title="Update Building" href="/admin/building-edit-${item.id}">
                                            <button type="button" class="btn btn-outline-danger">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-browser-chrome" viewBox="0 0 16 16">
                                                    <path fill-rule="evenodd" d="M16 8a8 8 0 0 1-7.022 7.94l1.902-7.098a3 3 0 0 0 .05-1.492A3 3 0 0 0 10.237 6h5.511A8 8 0 0 1 16 8M0 8a8 8 0 0 0 7.927 8l1.426-5.321a3 3 0 0 1-.723.255 3 3 0 0 1-1.743-.147 3 3 0 0 1-1.043-.7L.633 4.876A8 8 0 0 0 0 8m5.004-.167L1.108 3.936A8.003 8.003 0 0 1 15.418 5H8.066a3 3 0 0 0-1.252.243 2.99 2.99 0 0 0-1.81 2.59M8 10a2 2 0 1 0 0-4 2 2 0 0 0 0 4"></path>
                                                </svg>
                                            </button>
                                        </a>

                                            <button title="delete" type="button" class="btn btn-primary" onclick="deleteBuilding(${item.id})">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-archive" viewBox="0 0 16 16">
                                                    <path d="M0 2a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 12.5V5a1 1 0 0 1-1-1zm2 3v7.5A1.5 1.5 0 0 0 3.5 14h9a1.5 1.5 0 0 0 1.5-1.5V5zm13-3H1v2h14zM5 7.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5"></path>
                                                </svg>

                                            </button>
                                    </div>
                                </td>

                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>


                </div>


            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">

            </div>
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<%----%>
<div class="modal" tabindex="-1" role="dialog" id="assignmentBuildingModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title"><b>List Staffs</b></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="">
                <table id="staffList" class="table table-striped table-bordered table-hover"
                       style="margin-top: 0.3cm">
                    <thead>
                    <tr>
                        <th scope="col" style="width: 30%;" class="center">Select</th>
                        <th scope="col">Name</th>

                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
                <input type="hidden" id="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignmentBuilding">Confirm</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script>
    function assignmentBuilding(buildingId){
        $('#assignmentBuildingModal').modal();
        loadStaff(buildingId);
        $('#buildingId').val(buildingId);
    }
    function loadStaff(buildingId){
        $.ajax({
            type: "GET",
            url: "/api/building/" + buildingId + "/staffs",
            // data: JSON.stringify(buildingId),
            // contentType:"application/json",
            dataType:"JSON",
            success: function(response){
                var row='';
                $.each(response.data,function(i,item){
                   row += '<tr>';
                   row += '<td class="text-center"><input type="checkbox" value="' +
                       item.staffId + '" id=check_'
                       +  item.staffId + '" ' + item.checked
                       + '></td>';
                   row += '<td class="text-center">' + item.fullName + '</td>';
                   row += '</tr>';
                });
                $('#staffList tbody').html(row);
                console.log("ok");
            },
            error: function(respond){
                console.log("gaga");
            }
        });
    }
    $('#btnAssignmentBuilding').click(function (e){
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function (){
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        assginment(data);
    })

    function assginment(data){
        $.ajax({
            type: "POST",
            url: "/api/building/add",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType:"JSON",
            success: function(respond){
                console.log("ok");
            },
            error: function(respond){
                console.log("gaga");
            }

        });
    }


    // xoa 1
    function deleteBuilding(data){
        var data = [data];
        deleteBuildings(data);
    }

    // xoa nhieu

    // $('#btnDeleteBuilding').click(function(e){
    //     e.preventDefault();
    //     var data = $('#tableForm').find('tbody input[type = checkbox]:checked').map(function(){
    //         return $(this).val();
    //     }).get();
    //     // tra ve nhung cai da duoc tick
    //
    //     deleteBuildings(data);
    // });

    function testDelete(){

        var data = $('#tableForm').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        // tra ve nhung cai da duoc tick

        deleteBuildings(data);
    }
    //ajax
    function deleteBuildings(data){
        $.ajax({
            type: "Delete",
            url: "/api/building/" + data,
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType:"JSON",
            success: function(respond){
                console.log("ok");
            },
            error: function(respond){
                console.log("gaga");
            }

        });
    }



    $('#btnSearch').click(function(e){
        e.preventDefault();
        $('#listForm').submit()
    })


</script>
</body>

</html>
