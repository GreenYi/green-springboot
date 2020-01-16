<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.min.js"></script>
<script type="text/javascript">setTimeout("$('#message').hide('show');",3000);</script>
<html>
<head>
<title>身份证查询</title>
</head>
<body style="font-size:30px;">
	<span>快速查询姓名与身份证号码是否一致，实时联网公安核查，100%准确。</span>
	<form action="${pageContext.request.contextPath}/idCard/getIdCardInfo.html" method="post">
		姓名：<input type="text" name="name" id="name"/><br>
		身份证号码：<input type="text" name="cardno" id="cardno"/><br>
		<input type="submit" value="查询">
	</form>
	<span id="message" style="color:red;">${message}</span>
	<table border="1" style="width: 80%" cellspacing="0">
		<tr>
			<th>代码</th>
			<th>描述</th>
			<th>生日</th>
			<th>性别</th>
			<th>地址</th>
		</tr>
		<tr>
			<td>${idCard.code}</td>
			<td>${idCard.desc}</td>
			<td>${idCard.birthday}</td>
			<td>${idCard.sex}</td>
			<td>${idCard.address}</td>
		</tr>
	</table>
	<%@ include file="foot.jsp"%>
</body>
</html>