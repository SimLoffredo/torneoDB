<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Inserimento giocatore</h3>

	<form action= "SGiocatore" method="post">
	<input type = "hidden" name="scelta" value = "1">
	
	<label>Nome</label>
	<input type="text" name="nome" id ="nome" placeholder="...">
	<br>
	<label>Cognome</label>
	<input type="text" name="cognome" id="cognome" placeholder="...">
	<br>
	<label>Numero Maglia</label>
	<input type="number" name="numMaglia" id= "numMaglia" placeholder="...">
	<br>
	<label>Data di nascità</label>
	<input type="date" name="date"  id="date" placeholder="...">
	<br>
	<label>Squadra</label>
	        <select name="squadre" >
	        	<option disabled selected>Seleziona la squadra</option>
	        		<c:forEach var="s" items="${squadre}">
           			 	<option value ="${s.id}" >${s.nome}</option>
            		</c:forEach>
        	</select>
        	
    <br><br>
	<button type="submit">Aggiungi Giocatore</button>
	</form>
</body>
</html>