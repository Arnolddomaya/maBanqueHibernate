<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/jstl_includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change password</title>
</head>
<body>
	<%@ include file="../includes/navbar.jsp"%>
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgChgPass" />

	<form method="post" action="<%=request.getContextPath() + Url_path.CHANGE_PASS%>">
		<fieldset>
			<legend>Changement de mot de passe</legend>
			<p>Vous pouvez changer votre mot de passe via ce formulaire.</p>
			<label for="ancien">Ancien mdp <span class="requis">*</span>
			</label> <input type="password" id="motdepasse" name="oldPass" value="" size="20" maxlength="20" /> 
			<br />
			<label for="motdepasse">Mot de passe <span class="requis">*</span>
			</label> <input type="password" id="motdepasse" name="pass" value="" size="20" maxlength="20" /> 
			<br /> 
			<label for="confirmation">Confirmation <span class="requis">*</span> </label> 
			<input type="password" id="confirmation" name="confirm" value="" size="20" maxlength="20" /> 
			<br /> 
			
			<input type="submit" value="Changer" class="sansLabel" />
            <br />
		</fieldset>
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