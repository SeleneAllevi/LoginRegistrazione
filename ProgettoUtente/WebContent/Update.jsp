<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiorna Dati</title>
<style>
#update{
float:right;
border:double;
border-color:green;
background-color:white;
width:40%;
height:auto;
margin:50px;
text-align:center;
}
body{
background-color:silver;

}

</style>
</head>
<header><jsp:include page="WelcomeUtente.jsp"/></header>
<body>
<aside id="update">
<form action="UpdateServlet" method="POST">
	<%session.getAttribute("UtenteCorrente"); %>
<c:set var="UtenteCorrenteNome" value="${UtenteCorrente.nome}"/>
<c:set var="UtenteCorrenteCognome" value="${UtenteCorrente.cognome}"/>
<c:set var="UtenteCorrentePsw" value="${UtenteCorrente.psw}"/>
<c:set var="UtenteCorrenteInd" value="${UtenteCorrente.indirizzo}"/>
<c:set var="UtenteCorrenteCitta" value="${UtenteCorrente.citta}"/>
<c:set var="UtenteCorrenteData" value="${UtenteCorrente.dataNascita}"/>
	<h3><b>Inserisci i dati Utente:</b></h3> <br>
	Password:        <input placeholder="password" type="password" name="psw" value="${UtenteCorrentePsw}" required> <br><br>
	Nome:            <input placeholder="nome" type="text" name="nome" value="${UtenteCorrenteNome}" required> <br><br>
	Cognome:         <input placeholder="cognome" type="text" name="cognome" value="${UtenteCorrenteCognome}" required> <br><br>
	Indirizzo:       <input placeholder="indirizzo" type="text" name="indirizzo" value="${UtenteCorrenteInd}" required> <br><br>
	Città:           <input placeholder="città" type="text" name="citta" value="${UtenteCorrenteCitta}" required> <br><br>
	Data di nascita: <input placeholder="Data di nascita" type="date" name="dataNascita" value="${UtenteCorrenteData}" required>
					  <br><br>
	<input type="submit" value="Aggiorna">
	</form><br>

</aside>
</body>
<footer><jsp:include page="Footer.jsp"/></footer>
</html>