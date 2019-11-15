<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
#log{
margin-left: 40%;
}



</style>
</head>
<body>
<header><jsp:include page="header.jsp"/></header>
<br>
<br>
<div id="log"><h1 >PAGINA DI LOGIN</h1>
<form action="LoginServlet" method="POST">
Username: <input placeholder="username" type="text" name="username" > <br>
Password:<input placeholder="password" type="password" name="psw" > <br>
<input type="submit" value="login">
</form>

<%String stampa= (String)session.getAttribute("erroreUser");
if (stampa!=null){
response.getWriter().append(stampa);}
%> <br>
<%String stampa1= (String)session.getAttribute("errorePasswordInesistente");
if (stampa1!=null){
response.getWriter().append(stampa1);}
%> <br>
<%String stampa2= (String)session.getAttribute("messaggioDelete");
if (stampa2!=null){
response.getWriter().append(stampa2);}
%> <br>
<a href="Registrazione.jsp"><span id="grassetto">Se non sei ancora registrato clicca qui!</span></a>
</div>
<footer><jsp:include page="Footer.jsp"/></footer>
</body>
</html>