<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina di Logout</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<style>
#logout {
	border: double;
	border-color: green;
	background-color: white;
	width: auto;
	height: auto;
	margin: 50px;
}
body{
background-color:silver;

}
</style>
</head>
<body>
	<header><jsp:include page="header.jsp" /></header>
	<aside>
		<div id="logout">
			<form method="link" action="logout.jsp">
				<h1>
					<font color="darkgreen">Hai eseguito con successo il logout</font>
				</h1>
				<a href="home.jsp">Torna alla Home Page</a>

			</form>
			<br>
		</div>
	</aside>
	<footer><jsp:include page="Footer.jsp" /></footer>
</body>



<%
	session.invalidate();
%>


</html>