<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina di Logout</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width">

</head>
<header><jsp:include page="header.jsp"/></header>

<form method="link" action="logout.jsp">

	<body align="center">
	<body bgcolor="white">

		<h1>
			<font color="Red">Hai eseguito con successo il logout</font>
		</h1>

		<a href="home.jsp">Torna alla Home Page</a>
</form>


<footer><jsp:include page="Footer.jsp"/></footer>
	</body>



	<%
		session.invalidate();
	%>

</html>