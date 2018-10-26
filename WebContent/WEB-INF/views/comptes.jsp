<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Comptes</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp" %>
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgAccounts" />
	<p><%
			if (request.getAttribute("errorMsg") != null){
				out.println("Message d'erreur !!");
			}
		%></p>
	<h3><fmt:message key="msgTitle"/><c:out value="${ name }"/></h3>
	<c:forEach items="${ accounts }" var="account" varStatus="status">
    	<h3>N°<c:out value="${ status.count }" /> : <a href="<c:url value="${Url_path.TRANSACS}?comptId=${ account.getId() }"/>"><c:out value="${ account.getLibelle()}" />   <c:out value="${ account.getBalance()}" /></a></h3>
	</c:forEach>
</body>
</html>