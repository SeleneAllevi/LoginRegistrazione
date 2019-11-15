<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrazioneUtente</title>
</head>
<header> <jsp:include page="header.jsp"/></header>
<body>
<%String stampa= (String)session.getAttribute("erroreUserInesistente");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br>
<%String stampa1= (String)session.getAttribute("erroreData");
if (stampa1!=null){
response.getWriter().append(stampa1);}
%> <br>
<form action="UtenteServlet" method="POST">
	<b>Inserisci i dati Utente:</b>
	Username: <input placeholder="username" type="text" name="username" > <br>
	Password:<input placeholder="password" type="password" name="psw" > <br>
	Nome:<input placeholder="nome" type="text" name="nome" > <br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" > <br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" > <br>
	Città:<input placeholder="città" type="text" name="citta" > <br>
	Data di nascita: <input placeholder="Data di nascita" type="date" name="dataNascita" >
					  <br>
	<input type="submit" value="crea">
</form>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>