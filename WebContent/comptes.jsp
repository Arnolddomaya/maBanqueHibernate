<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.ynov.arnold.banque.model.Client" %>
<%@ include file="includes/jstl_includes.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Comptes</title>
</head>
<body>
	<p><%
			if (request.getAttribute("errorMsg") != null){
				out.println("Message d'erreur !!");
			}
		%></p>
	<h3>name :<strong><c:out value="${ name }"/></strong></h3>
	<c:forEach items="${ accounts }" var="account" varStatus="status">
    	<p>N°<c:out value="${ status.count }" /> : <a href="<c:url value="/transacs?comptId=${ account.getId() }"/>"><c:out value="${ account.getLibelle() }" /></a></p>
	</c:forEach>
	
</body>
</html>