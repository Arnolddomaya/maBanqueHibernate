<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@ include file="../includes/bootstrap_cdn.jsp" %>
		<title>Listes des comptes</title>
	</head>
	<body >
		<%@ include file="../includes/navbar.jsp" %>
		<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgAccounts" />
		

		<br/>
		<h3><fmt:message key="msgTitle"/> <c:out value="${ name }"/></h3>
		<br/>
		<div style="width:97%; margin:auto;" >
			<table class="table table-sm  center-block">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Libellé</th>
			      <th scope="col">Balance</th>
			      <th scope="col">Id compte</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${ accounts }" var="account" varStatus="status">
				    <tr>
				      <th scope="row"><c:out value="${ status.count }" /></th>
				      <td><c:out value="${ account.getLibelle()}" /></td>
				      <td><c:out value="${ account.getBalance()}" /></td>
				      <td><c:out value="${ account.getId()}" /></td>				      
				      
				      <td>				      
				      	<form method="get" action="<c:url value="${Url_path.TRANSACS}"/>">
				    	  <button type= "submit" class="btn btn-outline-secondary btn-block">Details</button>
						  <input type="hidden" name="comptId" value="${ account.getId() }" />
						</form>
					  </td>
					  <td>
						<form method="get" action="<c:url value="${Url_path.DELETE_ACCOUNT}"/>">
				    	  <button type= "submit" class="btn btn-outline-danger btn-block" data-toggle="confirmation" data-title="Are you sure?">Suprimer</button>
						  <input type="hidden" name="comptId" value="${ account.getId() }" />
						</form>	
				      </td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			
			<form method="get" action="<c:url value="${Url_path.NEW_ACCOUNT}"/>">
			    <button type= "submit" class="btn btn-outline-secondary btn-lg btn-block">Nouveau compte</button>
			</form>
		</div>
		
		
		<%@ include file="../includes/bootstrap_script.jsp" %>
		<script src="../../js/bootstrap-confirmation.min.js"></script>	
	</body>
</html>