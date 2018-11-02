<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions page</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp" %>
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgTransacs" />
	<h2> Liste des transactions :  <c:out value="${ ac.getLibelle() }"/></h2>
	<c:forEach items="${ ac.getTransactions() }" var="transac" varStatus="status">
    	<p>transac n° <c:out value="${ status.count }" /> , Amount : <c:out value="${ transac.getAmount() }" /></p>
	</c:forEach>
	<h2> Nouvelle Transaction </h2>
		
		<form action="<c:url value="${ Url_path.TRANSACS }"/>" method="post">
		  Account id:<br>
		  <input type="number"  name="receiverId" step="1" required><br>
		  amount:<br>
		  <input type="number" name="amount" step="0.01" required><br>
		  label:<br>
		  <input type="text" name="label" ><br><br>
		  
		  <c:set var = "now" value = "<%= new java.util.Date()%>" />
		  <input type="hidden" name="date" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />">
          
          <input type="hidden" name="comptId" value="${ac.getId() }" />
          
		  <input type="submit" value="Submit">
		</form>
</body>
</html>