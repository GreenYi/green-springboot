<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>主页</title>
</head>
<body style="font-size:30px;">
	<h1>假如我是主页</h1>
	<%-- 
	<table border="1" style="width: 80%" cellspacing="0">
		<tr>
			<th>父类</th>
			<th>功能描述</th>
			<th>地址</th>
		</tr>
		<tr>
			<td>部门</td>
			<td>增加部门</td>
			<td>
				<a href="${pageContext.request.contextPath}/dept/showAddDept.html">添加</a>
			</td>
		</tr>
		<tr>
			<td>部门</td>
			<td>显示部门</td>
			<td>
				<a href="${pageContext.request.contextPath}/dept/getAllDept.html">显示</a>
			</td>
		</tr>
	</table>
	 --%>
	 <form action="${pageContext.request.contextPath}/idCard/getIdCardInfo.html" method="post">
		姓名：<input type="text" name="name" id="name"/><br>
		身份证号码：<input type="text" name="cardno" id="cardno"/><br>
		<input type="submit" value="查询">
	</form>
	<%@ include file="web/idCard/foot.jsp"%>
</body>
</html>