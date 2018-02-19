<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page</title>
</head>
<body >
	<h3>LOGIN</h3>
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
	
	<c:if test="${param.action!= null}">
	<font color="blue" >You have logged out successfully</font>
		</c:if>
		<c:if test="${param.status!= null}">
	<font color="red" >Invalid Username and Password</font>
		</c:if>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
		
		<td>Remember me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' checked="checked"/></td>
			</tr>
		</table>
	</form>
</body>
</html>