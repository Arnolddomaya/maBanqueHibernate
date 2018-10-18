<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="includes/jstl_includes.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<c:out value="${ param.lang }" />
	<c:set var="lang" value="${ param.lang }" scope="page" />


	<!-- 	setLocale avant les autres	-->
	<fmt:setLocale value="${lang}" />
	<fmt:setBundle basename="fr.ynov.arnold.banque.textes.message" />
	<h1>
		<fmt:message key="login" />
	</h1>
	<%
		String errorMsg = (String) request.getAttribute("errorMsg");
		if (errorMsg != null) {
			out.println("Message d'erreur :" + errorMsg);
			request.setAttribute("errorMsg", null);
		}
	%>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<h2 class="active">
				<fmt:message key="msgSign" />
			</h2>

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form action="<%=request.getContextPath() + "/userLogin"%>"
				method="POST">
				<input type="text" id="login" class="fadeIn second" name="login"
					placeholder="login"> <input type="text" id="password"
					class="fadeIn third" name="password" placeholder="password">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form>

			<form action=""<%=request.getContextPath() + "/userLogin"%>"" method="GET">
				<select name=lang>
					<option value="">Langue</option>
					<option value="fr">Francais</option>
					<option value="en">English</option>
					<input type="submit" value="<fmt:message key="chLang" />" />
				</select>
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>
		</div>
	</div>
</body>
</html>