<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica</title>
</head>
<body>
	<form action ="SGiocatore" method= "post" >
		<input type="hidden" name="scelta" value="2">
		<input type="hidden" name="idGiocatore" value="${giocatore.id}">
	
	
		<label>Nome</label>
		<input type="text" name="nome" id ="nome" value="${giocatore.nome}">
		<br>
		<label>Cognome</label>
		<input type="text" name="cognome" id="cognome" value="${giocatore.cognome}">
		<br>
		<label>Numero Maglia</label>
		<input type="number" name="nMaglia" id= "nMaglia" value="${giocatore.nMaglia}">
		<br>
		<label>Data di nascità</label>
		<input type="date" name="date"  id="date" value="${giocatore.dataNascita}">
		<br>
		
		<label>Squadra</label>
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
	
		
	<button type="submit">Modifica</button>
	</form>
	<br>
	<br>
	<a href="homepage.jsp">Homepage</a>
	<br><br>
	<a href= "SGiocatore?scelta=1">Inserisci Giocatori</a>

</body>
</html>