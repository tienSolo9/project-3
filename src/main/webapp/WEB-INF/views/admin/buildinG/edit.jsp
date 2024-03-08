<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try { ace.settings.check('main-container', 'fixed') } catch (e) { }
    </script>

    <div id="sidebar" class="sidebar                  responsive">
        <script type="text/javascript">
            try { ace.settings.check('sidebar', 'fixed') } catch (e) { }
        </script>

        <script type="text/javascript">
            try { ace.settings.check('sidebar', 'collapsed') } catch (e) { }
        </script>
    </div>

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
                        Update Building
                    </h1>
                </div><!-- /.page-header -->


                <div class="row">
                    <div class="col-xs-12">
                        <form:form class="form-horizontal" role="form" id="updateForm" modelAttribute="modelEdit" method="GET">
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Name Building
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input class="form-control" path="name"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        District
                                    </label>
                                </div>
                                <div class="col-xs-4">
                                    <form:select class="form-control" path="district">
                                        <form:option value="">Select</form:option>
                                        <form:options items="${districtC}"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Ward
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="ward" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Street
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="street" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Number Of Basement
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="numberOfBasement" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        floorArea
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="floorArea" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Direction
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="direction" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Rent Area
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="rentArea" name="rentArea">
                                    <form:input path="rentArea" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Manager Name
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="managerName" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Manager Phone
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:input path="managerPhone" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Type Building
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <form:checkboxes path="typeCode" items="${typeCodeC}"/>

                                </div>
                            </div>
                            <div class="form-group">
                                <div  class="col-xs-2">
                                    <label class="name">
                                        Note
                                    </label>
                                </div>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="note" name="name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-4"></label>
                                <div class="col-xs-8">
                                    <c:if test="${not empty modelEdit.id}">
                                        <a type="button" class="btn btn-primary" id="btnUpdateBuilding" href="/admin/building-list">Update</a>
                                        <button type="button" class="btn btn-primary" id="btnExitBuilding">Exit</button>
                                    </c:if>
                                    <c:if test="${empty modelEdit.id}">
                                        <button type="button" class="btn btn-primary" id="btnUpdateBuilding">Add</button>
                                        <button type="button" class="btn btn-primary" id="btnExitBuilding">Exit</button>
                                    </c:if>
                                </div>
                            </div>
                            <form:hidden path="id" id="buildingId"/>
                        </form:form>
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


    <!-- basic scripts -->

    <!--[if !IE]> -->
    <script src="assets/js/jquery.2.1.1.min.js"></script>

    <script>
        $('#btnUpdateBuilding').click(function(){
            var data = {};
            var typeCode = [];
            var formData = $('#updateForm').serializeArray();
            $.each(formData,function(i, v){
                if(v.name != 'typeCode'){
                    data[v.name] = v.value;
                }
                else{
                    typeCode.push(v.value);
                }
            });
            data['typeCode'] = typeCode;

            if(typeCode != ''){
                updateBuilding1();
            }
            else{
                window.location.href = "/admin/building-edit?typeCode=mkmk";
            }
        });

        function updateBuilding1(){
            $.ajax({
                type: "POST",
                url: "/api/building",
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
        $('#btnExitBuilding').click(function (){
           window.location.href = "/admin/building-list";
        });
    </script>
</div>
</body>
</html>
