<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.ynov.guerny.banque.model.Client" %>
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
	<h3>name :<strong><%=request.getAttribute("name") %></strong></h3>
	<c:forEach var="i" begin="0" end="10" step="2">
    	<p>Un message n�<c:out value="${ i }" /> !</p>
	</c:forEach>
</body>
</html>