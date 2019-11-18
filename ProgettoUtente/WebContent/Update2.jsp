<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna Dati</title>
</head>

<style>

#updateDue{
float:right;
border:double;
border-color:green;
background-color:white;
width:40%;
height:auto;
margin:50px;
}
body{
background-color:silver;

}

</style>
<body>
<header> <jsp:include page="header.jsp"/></header>
<aside>
<div id="updateDue">
<form action="Update2Servlet" method="POST">
	<h3><b>Inserisci i dati Utente:</b></h3> <br>
	
	<c:set var="usernamePortamiVia" value="${param.portamivia}" scope="session"/>
	
	Password:<input placeholder="password" type="password" name="psw" value="${param.portamiviapsw}"  required > <br><br>
	Nome:<input placeholder="nome" type="text" name="nome" value="${param.portamivianome}" required> <br><br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" value="${param.portamiviacognome}"required> <br><br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" value="${param.portamiviaindirizzo}" required > <br><br>
	Città:<input placeholder="città" type="text" name="citta" value="${param.portamiviacitta}" required> <br><br>
	Data di nascita: <input placeholder="Data di nascita" type="date" value="${param.portamiviadata}" name="dataNascita" required>
					  <br><br>
	<input type="submit" value="Aggiorna">
	</form>
	<br>
	</div>
	</aside>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>