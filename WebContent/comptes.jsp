<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Comptes</title>
</head>
<body>
<h1>COMPTES</h1>
	<p><%
		if (request.getAttribute("errorMsg") != null){
			out.println("Message d'erreur !!");
		}
	%></p>

</body>
</html>