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
#cool{
    color: black;
}
#cool:visited {
    color: black;
}

</style>
</head>
<body>
<header> 
<nav>
<ul>
  <li><a href="home.jsp">Home</a></li>
  <li><a href="logout.jsp">Logout</a></li>
   <% if (((Utente)((session.getAttribute("UtenteCorrente")))).getUsername().equalsIgnoreCase("admin") && 
		   ((Utente)((session.getAttribute("UtenteCorrente")))).getPsw().equalsIgnoreCase("admin123")){ %>
  <li><a href="ListaServlet">Lista</a></li><%} %>
  <li style="float:right"> <a>  <% session.getAttribute("UtenteCorrente");%>
Benvenuto <%=((Utente)((session.getAttribute("UtenteCorrente")))).getNome()%> </a> </li>
</ul>
</nav>
</header>

<%String stampa= (String)session.getAttribute("UtenteAggiornato");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br>

<section><jsp:include page="section.jsp"/></section>

<form action="UtenteServlet" method="GET">
<input type="submit" name="Cancella" value="Cancella Utente">
</form> <br>


<a id="cool" href="Update.jsp" > Aggiorna Profilo Utente</a>

<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>