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


#password{

 -webkit-text-security: circle;
}

</style>
</head>
<body>
<header><jsp:include page="WelcomeUtente.jsp"/></header>


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
			<td>Città</td>
			<td>DataNascita</td>
			<td>Actions</td>
		</tr>
	</thead>
	
	  <c:forEach items="${EveryOne}" var="current">
	 
        <tr>
          <td><c:out value="${current.username}" />
           <td id="password"><c:out value="${current.psw}" /> 
            <td><c:out value="${current.nome}" />
             <td><c:out value="${current.cognome}" />
              <td><c:out value="${current.indirizzo}" />
               <td><c:out value="${current.citta}" />
                <td><c:out value="${current.dataNascita}" />
                <td>
                 <a href="<c:url value="Update2.jsp">                            
       				<c:param name="portamivia" value="${current.username}"/>  
       				<c:param name="portamiviapsw" value="${current.psw}"/> 
       				<c:param name="portamivianome" value="${current.nome}"/>
       				<c:param name="portamiviacognome" value="${current.cognome}"/>
       				<c:param name="portamiviaindirizzo" value="${current.indirizzo}"/>
       				<c:param name="portamiviacitta" value="${current.citta}"/>
       				<c:param name="portamiviadata" value="${current.dataNascita}"/> 
       				                       
      				 </c:url>">Update</a>
                 
             	 </td>
<td><a href="<c:url value="RemoveServlet"><c:param name="userCanc" value="${current.username}"/>
      
      </c:url>"><input type="button" name="bottone" value="Delete" /></a>
      
      </td>
		
        </tr>
      </c:forEach>


</table>


</body>
</html>