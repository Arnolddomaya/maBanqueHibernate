<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file="../includes/bootstrap_cdn.jsp" %>
	<title>Nouveau compte</title>
</head>
	<body>
		<%@ include file="../includes/navbar.jsp" %>
	
		<br/>
		<h3>Nouveau compte</h3>
		<br/>
		<form action='<c:url  value="${ Url_path.NEW_ACCOUNT }"/>' method="post">
		  <div class="w-50 p-3" style="margin:auto;">
			  <div class="form-group">
			    <label for="label">Label:</label>
			    <input type="text" name="label"class="form-control" required>
			  </div>
			  <div class="form-group">
			    <label for="solde">Solde:</label>

			    <input class="form-control" type="number"  name="solde" step="0.01" required>
			  </div>			  
			  <button type="submit" class="btn btn-outline-secondary btn-block">Submit</button>
		  </div>
		</form>
		<%@ include file="../includes/bootstrap_script.jsp" %>
	</body>
</html>