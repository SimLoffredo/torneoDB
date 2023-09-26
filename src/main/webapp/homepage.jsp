<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Torneo </title>
	
</head>
<body>
	
	<h1>Torneo</h1>
	
	<h3>Visualizzazione</h3>
	<a href = "SGiocatore?scelta=2">Lista Giocatori</a>
	<a href = "SSquadre?scelta=1">Lista Squadre</a> 
	
	<h3>Inserimento</h3>
	<a href= "inserimentoSquadra.jsp">Inserisci Squadra</a>
	<a href= "SGiocatore?scelta=1">Inserisci Giocatore</a>
	
	<h3>Squadre</h3>
		<c:forEach items="${squadre}" var="squadra">
		<a href="Sview?scelta=1&id=${squadra.id}">${squadra.nome}</a>
		<br>
		</c:forEach>

</body>
</html>