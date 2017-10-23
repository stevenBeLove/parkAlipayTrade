<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

     <!-- Bootstrap Admin Theme -->
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">
     <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme-change-size.css">
    
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/twitter-bootstrap-hover-dropdown.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-admin-theme-change-size.js"></script>
    
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-table/dist/bootstrap-table.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css">
    <style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>

</head>
<body>

<div class="container">
<div class="row">
	<div class="col-lg-12">





    <form:form method="post" commandName="role" class="form-horizontal" onsubmit="return check()">
        <form:hidden path="id"/>
        <form:hidden path="available"/>

        <div class="form-group">
            <form:label path="role"  class="col-lg-2 control-label" >角色名：</form:label>
           
           	<div class="col-lg-4">
          		 <input type="text" name="role" id="role1" class="form-control" value="${role.role }" />
            </div>
        </div>

        <div class="form-group">
            <form:label path="description"  class="col-lg-2 control-label" >角色描述：</form:label>
            
            <div class="col-lg-4">
          	  <form:input path="description"  class="form-control" />
            </div>
        </div>


        <div class="form-group">
            <form:label path="resourceIds" class="col-lg-2 control-label">拥有的资源列表：</form:label>
            <form:hidden path="resourceIds"/>
               <div class="col-lg-4">
            <input type="text" id="resourceName" class="form-control"  name="resourceName" value="${zhangfn:resourceNames(role.resourceIds)}" readonly>
            </div>
             <a id="menuBtn" href="#">
            	选择
            </a>
        </div>

	 	<div class="form-group">
			 <div class="col-lg-6">
		        <form:button class="btn btn-primary pull-right" >${op}</form:button>
		     </div>
		 </div>		

    </form:form>

	</div>
</div>
</div>

    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="tree" class="ztree" style="margin-top:0; width:160px;"></ul>
    </div>

    <script src="${pageContext.request.contextPath}/js/static/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
    <script>
	    function check(){
	    	var role1 = $("#role1").val();
    	    var resourceName  = $("#resourceName").val();
    	    if(role1 == ''){
    	        alert("角色名不能为空!");
    	        return false;
    	    }
    	    if(resourceName == ''){
    	        alert("资源列表不能为空!");
    	        return false;
    	    }
	    }
    
    
        $(function () {
            var setting = {
                check: {
                    enable: true ,
                    chkboxType: { "Y": "", "N": "" }
                },
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onCheck: onCheck
                }
            };

            var zNodes =[
                <c:forEach items="${resourceList}" var="r">
                <c:if test="${not r.rootNode}">
                { id:${r.id}, pId:${r.parentId}, name:"${r.name}", checked:${zhangfn:in(role.resourceIds, r.id)}},
                </c:if>
                </c:forEach>
            ];

            function onCheck(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#resourceIds").val(id);
                $("#resourceName").val(name);
//                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#resourceName");
                var cityOffset = $("#resourceName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
    </script>


</body>
</html>
