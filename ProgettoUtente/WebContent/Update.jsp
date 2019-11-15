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
<header><jsp:include page="WelcomeUtente.jsp"/></header>
<form action="UpdateServlet" method="POST">
	<%session.getAttribute("UtenteCorrente"); %>
<c:set var="UtenteCorrenteNome" value="${UtenteCorrente.nome}"/>
<c:set var="UtenteCorrenteCognome" value="${UtenteCorrente.cognome}"/>
<c:set var="UtenteCorrentePsw" value="${UtenteCorrente.psw}"/>
<c:set var="UtenteCorrenteInd" value="${UtenteCorrente.indirizzo}"/>
<c:set var="UtenteCorrenteCitta" value="${UtenteCorrente.citta}"/>
<c:set var="UtenteCorrenteData" value="${UtenteCorrente.dataNascita}"/>
	<b>Inserisci i dati Utente:</b>
	Password:<input placeholder="password" type="password" name="psw" value="${UtenteCorrentePsw}" required> <br>
	Nome:<input placeholder="nome" type="text" name="nome" value="${UtenteCorrenteNome}" required> <br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" value="${UtenteCorrenteCognome}" required> <br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" value="${UtenteCorrenteInd}" required> <br>
	Città:<input placeholder="città" type="text" name="citta" value="${UtenteCorrenteCitta}" required> <br>
	Data di nascita: <input placeholder="Data di nascita" type="date" name="dataNascita" value="${UtenteCorrenteData}" required>
					  <br>
	<input type="submit" value="aggiorna">
	</form>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>