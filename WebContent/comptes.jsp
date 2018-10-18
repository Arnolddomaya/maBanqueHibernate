<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.ynov.guerny.banque.model.Client" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    	<p>N°<c:out value="${ status.count }" /> : <c:out value="${ account.getLibelle() }" /> !</p>
	</c:forEach>
</body>
</html>