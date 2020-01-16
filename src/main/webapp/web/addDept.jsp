<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<form action="${pageContext.request.contextPath}/dept/addDept.html" method="post">
		部门名称：<input type="text" name="deptName" id="deptName"/><br>
		部门地址：<input type="text" name="deptLoc" id="deptName"/><br>
		<input type="submit" value="添加">
	</form>

</body>
</html>