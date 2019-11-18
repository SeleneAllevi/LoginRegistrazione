<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrazioneUtente</title>

<style>
#registrazione{
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
<header> <jsp:include page="header.jsp"/></header>
<body>
<aside id="registrazione">
<%String stampa= (String)session.getAttribute("erroreUserInesistente");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br>
<%String stampa1= (String)session.getAttribute("erroreData");
if (stampa1!=null){
response.getWriter().append(stampa1);}
%> <br>
<form action="UtenteServlet" method="POST">
	<h3><b>Inserisci i dati Utente:</b></h3> <br> 
	
	Username: <input placeholder="username" type="text" name="username" > <br><br>
	Password:<input placeholder="password" type="password" name="psw" > <br><br>
	Nome:<input placeholder="nome" type="text" name="nome" > <br><br>
	Cognome:<input placeholder="cognome" type="text" name="cognome" > <br><br>
	Indirizzo:<input placeholder="indirizzo" type="text" name="indirizzo" > <br><br>
	Città:<input placeholder="città" type="text" name="citta" > <br><br>
	Data di nascita: <input placeholder="Data di nascita" type="date" name="dataNascita" >
					  <br><br>
	<input type="submit" value="Registrati">
</form>
<br>
</aside>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>