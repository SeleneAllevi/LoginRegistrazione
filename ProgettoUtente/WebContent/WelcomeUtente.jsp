<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
     <%@ page import="com.ats.model.Utente" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Utente</title>
<link href="MyHeader.css" rel="stylesheet" type="text/css">
<style>


#d{
float:left;
border:double;
border-color:green;
background-color:white;
width:40%;
height:auto;
margin:50px;
text-align:center;
}
#riga {
color:darkgreen;
border-top:double;
}
body{
background-color:silver;

}

</style>
</head>
<header>
<ul class="header">
  <li><a href="WelcomeUtente.jsp">Home</a></li>
  <li><a href="logout.jsp">Logout</a></li>
   <% if (((Utente)((session.getAttribute("UtenteCorrente")))).getUsername().equalsIgnoreCase("admin") && 
		   ((Utente)((session.getAttribute("UtenteCorrente")))).getPsw().equalsIgnoreCase("admin123")){ %>

  <li><a href="ListaServlet"> Lista </a></li><%} %>
  <li style="float:right"> <a>  <% session.getAttribute("UtenteCorrente");%>
Benvenuto <%=((Utente)((session.getAttribute("UtenteCorrente")))).getNome()%> </a> </li>
</ul>
</header>

<body>
<% String stampa= (String)session.getAttribute("UtenteAggiornato");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br> 

<div id=d>
<div>
<br>
<img src="https://steamuserimages-a.akamaihd.net/ugc/266105270676508594/1E81E71792D487ED7A249D0F8A057C2955693135/"  width="100" height="100" ><br>
<form action="UtenteServlet" method="GET">
<input type="submit" name="Cancella" value="Cancella Utente">
</form> <br>
<form action="Update.jsp">
<input type="submit" name="Aggiorna" value="Aggiorna Profilo">
</form>
</div>
<hr id="riga">
<div>
<article>
<h2> Social </h2>
<a href="https://www.instagram.com/">Instagram </a> <br>
<a href="https://twitter.com/login?lang=it">Twitter</a> <br>
<a href="https://www.linkedin.com/">Linkedin </a> <br>
<a href="https://www.facebook.com/">Facebook</a><br>
<a href="https://www.youtube.com/">YouTube</a><br><br>
</article>
</div>
</div>
</body>

<footer><jsp:include page="Footer.jsp"/></footer>
</html>