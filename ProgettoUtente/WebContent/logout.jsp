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

div{
float:right;
border:double;
background-color:white;
width:20%;
height:450px;
margin-right:50px;
text-align:center;

}

</style>
</head>
<body>
	<header><jsp:include page="header.jsp" /></header>
	<div>
	    <form method="link" action="logout.jsp">
		<h1><font color="darkgreen">Hai eseguito con successo il logout</font></h1>
		<a href="home.jsp">Torna alla Home Page</a>
</div>

		<%
			session.invalidate();
		%>
	
</body>
</html>