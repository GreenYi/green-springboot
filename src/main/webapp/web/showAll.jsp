<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>这只是一个测试页面</title>
</head>
<body style="font-size: 30px;">
	<table border="1" style="width: 80%" cellspacing="0">
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门地址</th>
			<th>部门修改</th>
		</tr>
		<c:forEach items="${list}" var="d">
			<tr>
				<td>${d.id}</td>
				<td>${d.deptName}</td>
				<td>${d.deptLoc}</td>
				<td>
					<a href="${pageContext.request.contextPath}/dept/removeDept.html?id=${d.id}">删除</a>
					<a href="">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>