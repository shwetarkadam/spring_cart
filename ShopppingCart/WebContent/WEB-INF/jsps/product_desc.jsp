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


<h1>Product Description</h1>

<c:forEach var="p" items="${list }">
<c:if test="${id == p.getId() }">
<h2><c:out value="${p.getName() }"/></h2>
<c:out value="${p.getPrice() }"/><br>
<c:out value="${p.getDesc() }"/><br>
</c:if>
</c:forEach>
</body>
</html>