<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
     <%@ page import="com.ats.model.Utente" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Utente</title>
<<<<<<< HEAD



<link href="MyHeader.css" rel="stylesheet" type="text/css">


<style>

#cool{
    color: pink;
}
#cool:visited {
    color: lime;
}

</style>
</head>
<body>
<header> <jsp:include page="header.jsp"/></header>
<%String stampa= (String)session.getAttribute("UtenteAggiornato");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br>


<% session.getAttribute("UtenteCorrente");
%>

Benvenuto <%=((Utente)((session.getAttribute("UtenteCorrente")))).getNome()
%>

<br>
<br>
>>>>>>> branch 'master' of https://github.com/SeleneAllevi/LoginRegistrazione.git
<form action="UtenteServlet" method="GET">
<input type="submit" name="Cancella" value="Cancella Utente">
</form>

<a id="cool" href="Update.jsp"> Aggiorna Profilo Utente</a>
<<<<<<< HEAD
<section><jsp:include page="section.jsp"/></section>
=======

 <% if (((Utente)((session.getAttribute("UtenteCorrente")))).getUsername().equalsIgnoreCase("admin") && ((Utente)((session.getAttribute("UtenteCorrente")))).getPsw().equalsIgnoreCase("admin123")){ %>

<form action="ListaServlet" method="GET">
<input type="submit" name="lista" value="lista">
</form>
 <%} %> 
<a href="logout.jsp">
<input type="button" name="bottone" value="Logout" />
</a>
>>>>>>> branch 'master' of https://github.com/SeleneAllevi/LoginRegistrazione.git
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>