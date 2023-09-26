<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Squadre</title>
</head>
<body>
	<h1>Squadre: </h1>
	<table>
	
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Modifica</th>
		<th>Elimina</th>
	</tr>
	
	<c:forEach var="squadra" items="${squadre}">
	<tr>
		<c:if test="${squadra.id != 100 }">
		<td>${squadra.id}</td>
		<td>${squadra.nome}</td>
			<td><a href="SSquadre?scelta=3&id=${squadra.id}"><button type="submit">Modifica</button></a></td>
			<td><a href="SSquadre?scelta=2&id=${squadra.id}"><button type="submit">Cancella</button></a></td>
			</c:if>
	</tr>
	</c:forEach>
	</table>
	<br><br>
	<a href="Sview?scelta=2">Lista Svincolati</a>
	<br><br>
	<a href="SZeroPoint">Homepage</a>
	<br><br>
	<a href= "inserimentoSquadra.jsp">Inserisci Squadra</a>

</body>
</html>