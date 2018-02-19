<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@taglib prefix="sv" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Vendor Registration</h1>

<sv:form action="${pageContext.request.contextPath }/vendor-register" method="POST" commandName="vendor">

Name:<sv:input type="text" path="name" name="name" /><sv:errors path="name"/><br><br>
City:<sv:input type="text" path="city" name="city" /><sv:errors path="city"/><br><br>
Email:<sv:input type="text" path="email" name="email" /><sv:errors path="email"/><br><br>
Password:<sv:input type="text" path="password" name="password" /><sv:errors path="password"/><br><br>
Re-Password:<input type="text"  name="repassword" />


<input type="submit" value="Register">


</sv:form>
</body>
</html>