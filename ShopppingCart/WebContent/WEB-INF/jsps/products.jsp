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
<h1>All Products</h1>
<c:forEach var="p" items="${list }">
<h2><c:out value="${p.getName() }"/></h2>
<a href="<%=request.getContextPath()%>/Show-Product?id=<c:out value="${p.getId() }"/>">View  Description</a>


</c:forEach>
</body>
</html>