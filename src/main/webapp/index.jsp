<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>装备列表</title>
<link rel="stylesheet" href="css/bootstrap3/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="showProps.do">装备列表</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form action="insertProp.do" method="POST" class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" name="propsName" class="form-control"
								placeholder="请输入装备名">
							<input type="text" name="propsRole"
								class="form-control" placeholder="请输入装备类别"> 
							<input type="text" name="propsLevel" class="form-control"
								placeholder="请输入等级">
							<input type="text" name="propsDescribe" class="form-control"
								placeholder="请输入描述">
						</div>
						<button type="submit" class="btn btn-default">新增</button>
						<a href="#" class="btn btn-default">批量删除</a>
					</form>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
 		<c:if test="${result == 'SUCCESS' }">
			<div class="alert alert-success" role="alert">提示：操作成功</div>
		</c:if>
		<c:if test="${result == 'ERROR' }">
			<div class="alert alert-danger" role="alert">警告：操作失败</div>
		</c:if> 
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>ROLE</th>
							<th>LEVEL</th>
							<th>DESCRIBE</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${PropList}" var="p">
						<tr>
							<td><input type="checkbox" name="ids" value="${p.propsId}"/>${p.propsId}</td>
							<td>${p.propsName}</td>
							<td>${p.propsRole}</td>
							<td>${p.propsLevel}</td>
							<td>${p.propsDescribe}</td>
							<td><a href="removeProp.do?propsId=${p.propsId }"><span></span>删除</a></td>
						</tr>
					</c:forEach>						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="css/bootstrap3/js/bootstrap.min.js"></script>
</html>