<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.ats.model.*"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EveryOne</title>
<section><jsp:include page="section.jsp"/></section>
<style>
#stileTab1{
 	border:1px solid #eee;
	border-collapse:collapse;
	
	padding: 5px;
	

 }
 
 thead{
 	font-size: large;
 	font-weight: bold;
 	color: white;
 	background-color: navy; 
 }
 

 
 td, th{
		border: 1px solid #ddd;
		padding: 8px;
		}


</style>
</head>
<body>

<% 
 session.getAttribute("EveryOne");

 %>

<table>
	<thead>
		<tr>
			<td>Username</td>
			<td>Password</td>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Indirizzo</td>
			<td>Citt�</td>
			<td>DataNascita</td>
			<td>Actions</td>
		</tr>
	</thead>
	
	  <c:forEach items="${EveryOne}" var="current">
	  <c:set var="user" value="${current.username}"/>
        <tr>
          <td><c:out value="${current.username}" />
           <td><c:out value="${current.psw}" />
            <td><c:out value="${current.nome}" />
             <td><c:out value="${current.cognome}" />
              <td><c:out value="${current.indirizzo}" />
               <td><c:out value="${current.citta}" />
                <td><c:out value="${current.dataNascita}" />
                
                
                
     
      
      
		<td> <a href="AdminServlet"=${current}><input type="button" name="Elimina" value="Delete" onclick="eliminazione"></a><

		
        </tr>
      </c:forEach>


</table>
</body>
</html>