<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions page</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp" %>
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgTransacs" />
	<h3>libelle :<strong><c:out value="${ libel }"/></strong></h3>
	<c:forEach items="${ transacs }" var="transac" varStatus="status">
    	<p>transac n° <c:out value="${ status.count }" /> , Amount : <c:out value="${ transac.getAmount() }" /></p>
	</c:forEach>
</body>
</html>