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
		
		<table class="table w-75 p-3 center-block" style="margin:auto;">
			<thead class="thead-light">
			   <tr>
			     <th scope="col">#</th>
			     <th scope="col">Montant</th>
			     <th scope="col">Date</th>
			     <th scope="col">Libelle</th>
			   </tr>
			 </thead>
			 <tbody>
				<c:forEach items="${ ac.getTransactions() }" var="transac" varStatus="status">
				    <tr>
				      <th scope="row"><c:out value="${ status.count }" /></th>
				      <td><c:out value="${ transac.getAmount() }" /></td>
				      <td><c:out value="${ transac.getDate() }" /></td>
				      <td><c:out value="${ transac.getLabel() }" /></td>				  	
				    </tr>				
				</c:forEach> 
			 </tbody>
    	</table>
    	
    	<br/>
    	<!-- Formulaire de création de transaction -->
    	<h3> Nouvelle Transaction </h3>
    	
		<form action="<c:url value="${ Url_path.TRANSACS }"/>" method="post">
			<div class="w-50 p-3" style="margin:auto;">
			  <div class="form-group row">
			    <label for="AccountId" class="col-sm-2 col-form-label">Account id</label>
			    <div class="col-sm-10">
					<input type="number" class="form-control" name="receiverId" step="1" required>
				</div>			  
			  </div>
			  
			  <div class="form-group row">
			    <label for="Amount" class="col-sm-2 col-form-label">Amount</label>
			    <div class="col-sm-10">			    
			    	<input type="number" class="form-control" name="amount" step="0.01" required>
			    </div>
			  </div>
			  
			  <div class="form-group row">
			    <label for="exampleInputPassword1" class="col-sm-2 col-form-label">Label</label>
			    <div class="col-sm-10">
			    	<input type="text" class="form-control" name="label" >
			    </div>
			  </div>
			  <input type="hidden" name="comptId" value="${ac.getId() }" />
			  
			  <button type="submit" class="btn btn-outline-secondary btn-block">Submit</button>
			</div>
		</form>
		
		
	
		
		<%@ include file="../includes/bootstrap_script.jsp" %>
	</body>
</html>