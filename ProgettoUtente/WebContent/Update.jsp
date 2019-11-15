<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna Dati</title>
</head>
<body>
<header><jsp:include page="WelcomeUtente.jsp"/></header>
<form action="UpdateServlet" method="POST">
	<b>Inserisci i dati Utente:</b>
	Password:<input placeholder="password" type="password" name="psw" > <br>
	Nome:<input placeholder="nome" type="text" name="nome" > <br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" > <br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" > <br>
	Città:<input placeholder="città" type="text" name="citta" > <br>
	Data di nascita: <input placeholder="Data di nascita" type="date" name="dataNascita" >
					  <br>
	<input type="submit" value="aggiorna">
	</form>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>