<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>主页</title>
</head>
<body style="font-size:30px;">
	<h1 style="text-align:center">主页</h1>
	<table border="1" style="width: 80%" cellspacing="0">
		<tr>
			<th>功能</th>
			<th>描述</th>
			<th>按钮</th>
		</tr>
		<tr>
			<td>部门（测试）</td>
			<td>用于测试数据库</td>
			<td>
				<a href="${pageContext.request.contextPath}/dept/showAddDept.htm">点我</a>
			</td>
		</tr>
		<tr>
			<td>身份证核验</td>
			<td>快速查询姓名与身份证号码是否一致，实时联网公安核查，100%准确。</td>
			<td>
				<a href="${pageContext.request.contextPath}/idCard/show.htm">点我</a>
			</td>
		</tr>
		<tr>
			<td>想要什么新功能请联系我</td>
			<td></td>
			<td>
			</td>
		</tr>
	</table>
	<%@ include file="web/common/foot.jsp"%>
</body>
</html>