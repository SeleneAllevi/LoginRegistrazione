<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna Dati</title>
</head>
<body>
<header> <jsp:include page="header.jsp"/></header>
<form action="Update2Servlet" method="POST">
	<b>Inserisci i dati Utente:</b>
	<c:set var="usernamePortamiVia" value="${param.portamivia}" scope="session"/>
	
	
	Password:<input placeholder="password" type="password" name="psw" value="${param.portamiviapsw}"  required > <br>
	Nome:<input placeholder="nome" type="text" name="nome" value="${param.portamivianome}" required> <br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" value="${param.portamiviacognome}"required> <br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" value="${param.portamiviaindirizzo}" required > <br>
	Città:<input placeholder="città" type="text" name="citta" value="${param.portamiviacitta}" required> <br>
	Data di nascita: <input placeholder="Data di nascita" type="date" value="${param.portamiviadata}" name="dataNascita" required>
					  <br>
	<input type="submit" value="aggiorna">
	</form>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>