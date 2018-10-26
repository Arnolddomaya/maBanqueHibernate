<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<%-- 	<c:set var="lang" value="${ param.lang }" scope="page" />
 --%> 	<c:set var="lang" value="${(empty param.lang) ? 'fr' : param.lang}" scope="session" />


	<!-- 	setLocale avant les autres	-->
	<fmt:setLocale value="${lang}" />
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.message" />
	<%
		String errorMsg = (String) request.getAttribute("errorMsg");
		if (errorMsg != null) {
			out.println("Message d'erreur :" + errorMsg);
			request.setAttribute("errorMsg", null);
		}
	%>	
	<form method="post" action="<%=request.getContextPath() + Url_path.LOGIN %>">
		<fieldset>
			<legend><fmt:message key="login" /></legend>
			<p>Vous pouvez changer votre mot de passe via ce formulaire.</p>
			<label for="email">Adresse email <span class="requis">*</span></label>
            <input type="text" id="email" name="login" value="" size="20" maxlength="60" />
            <br />

			<label for="motdepasse">Mot de passe <span class="requis">*</span>
			</label> <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" /> 
			<br /> 
			<input type="submit" value="connection" class="sansLabel" />
            <br />
             
			<br />
		</fieldset>
	</form>
	<form action= "<%=request.getContextPath() + Url_path.LOGIN %>" method="GET">
 					<select name=lang>
					<option >Langue</option>
					<option value="fr">Francais</option>
					<option value="en">English</option>
					</select>
					<input type="submit" value="<fmt:message key="chLang" />" />
	</form>
	<style>
		/* Général ------------------------------------------------------------------------------------- */
		body, p, legend, label, input {
		    font: normal 10pt verdana, helvetica, sans-serif;
		}
		fieldset {
		    padding: 10px;
		    margin : 150px;
		    border: 1px #0568CD solid;
		 
		}
		legend {
		    font-weight: bold;
		    color: #0568CD;
		    
		}
		/* Forms --------------------------------------------------------------------------------------- */
		
		form label {
		    float: left;
		    width: 200px;
		    margin: 3px 0px 0px 0px;
		  
		}
		form input {
		    margin: 3px 3px 0px 0px;
		    border: 1px #999 solid;
		}
		form input.sansLabel {
		    margin-left: 200px;
		}
		form .requis {
		    color: #c00;
		}
	</style>
</body>
</html>