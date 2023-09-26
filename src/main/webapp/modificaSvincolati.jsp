<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione svincolati</title>
</head>

<body>

	<form action="Sview" method="post">
	
	<table>
	<tr>
	<th>Nome</th>
	<th>Cognome</th>
	<th>Modifica</th>
	<th><th>
	</tr>
	
	<c:forEach items="${giocatori}" var="giocatore">
	<input type="hidden" name="idGiocatore" value="${giocatore.id}">
	<tr>
	<td>${giocatore.nome}</td>
	<td>${giocatore.cognome}</td>
	<td>
		<select name="squadre">
    		<option disabled>Seleziona la squadra</option>
    		<c:forEach var="s" items="${squadre}">
        		<c:choose>
           		 <c:when test="${s.id == giocatore.id_squadra}">
                <option value="${s.id}" selected="selected">${s.nome}</option>
           		 </c:when>
           		 <c:otherwise>
                <option value="${s.id}">${s.nome}</option>
            	</c:otherwise>
        		</c:choose>
    		</c:forEach>
		</select>
	</td>
	<td><button type="submit">Invia</button></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	
	<h3>Visualizzazione</h3>
	<a href = "SGiocatore?scelta=2">Lista Giocatori</a>
	<a href = "SSquadre?scelta=1">Lista Squadre</a> 

</body>
</html>