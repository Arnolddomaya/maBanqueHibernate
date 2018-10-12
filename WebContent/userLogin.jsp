<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Page de login</h1>
	<%
		if (request.getAttribute("errorMsg") != null){
			out.println("Message d'erreur !!");
		}
	%>
	<div class="wrapper fadeInDown">
	  <div id="formContent">
	    <!-- Tabs Titles -->
	    <h2 class="active"> Sign In </h2>
	    <h2 class="inactive underlineHover">Sign Up </h2>
	
	    <!-- Icon -->
	    <div class="fadeIn first">
	      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
	    </div>
	
	    <!-- Login Form -->
	    <form action = "<%=request.getContextPath() + "/userLogin" %>"  method = "POST">
	      <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
	      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
	      <input type="submit" class="fadeIn fourth" value="Log In">
	    </form>
	
	    <!-- Remind Passowrd -->
	    <div id="formFooter">
	      <a class="underlineHover" href="#">Forgot Password?</a>
	    </div>
	 </div>
	</div>
</body>
</html>