<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
HEllo
<h3>
Email is <c:out value="${email }"/>
</h3>

<h4>Name is <c:out value="${name }"/></h4>
<br>
<a href="<%=request.getContextPath() %>/Show-All-Products">SHow All Products</a><br>
<a href="<%=request.getContextPath() %>/Vendor-Registration">Vendor Registration
</a>
<br>
<a href="<%=request.getContextPath() %>/Add-Product">Add-Product</a>
</body>
</html>