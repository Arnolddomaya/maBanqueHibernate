<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@ include file="../includes/bootstrap_cdn.jsp" %>
		<title>Liste des transactions</title>
		
	</head>
	<body>
		<%@ include file="../includes/navbar.jsp" %>
		<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgTransacs" />
		<br/>
		<h3> Liste des transactions :  <c:out value="${ ac.getLibelle() }"/></h3>
		<br/>
		
		<table class="table table w-75 p-3 center-block" style="margin:auto;">
			<thead class="thead-light">
			   <tr>
			     <th scope="col">#</th>
			     <th scope="col">Montant</th>
			     <th scope="col">Date</th>
			   </tr>
			 </thead>
			 <tbody>
				<c:forEach items="${ ac.getTransactions() }" var="transac" varStatus="status">
				    <tr>
				      <th scope="row"><c:out value="${ status.count }" /></th>
				      <td><c:out value="${ transac.getAmount() }" /></td>
				      <td><c:out value="${ transac.getDate() }" /></td>				  	
				    </tr>				
				</c:forEach> 
			 </tbody>
    	</table>
		
		<!-- Formulaire de création de transaction -->
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
		
		<%@ include file="../includes/bootstrap_script.jsp" %>
	</body>
</html>