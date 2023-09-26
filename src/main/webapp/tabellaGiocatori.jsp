<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabella Giocatori</title>
</head>
<body>
	<h1>Giocatori</h1>
	<table>
	
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Numero Maglia</th>
			<th>Data di nascita</th>
			<th>Squadra</th>
			<th>Modifica</th>
			<th>Cancella</th>
		</tr>
		
			
			<c:forEach items="${giocatori}" var="giocatore">
			<tr>
				<td>${giocatore.nome}</td>
				<td>${giocatore.cognome}</td>
				<td style="text-align:center">${giocatore.nMaglia}</td>
				<td>${giocatore.dataNascita}</td>
				<td>
						<c:forEach items="${squadre}" var="squadra">
							<c:if test="${squadra.id == giocatore.id_squadra}">
							${squadra.nome}
							</c:if>
						</c:forEach>
				
				</td>
				<td>
					<form action="SGiocatore">
						<input type="hidden" name="scelta" value="4">
						<input type="hidden" name="idGiocatore" value="${giocatore.id}">
						<input type="hidden" name="idSquadra" value="${giocatore.id_squadra}">
						<button type="submit">Modifica</button>
						</form>
						</td>
				<td><a href="SGiocatore?scelta=3&id=${giocatore.id}"><button type="submit">Elimina</button></a></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<a href="SZeroPoint">Homepage</a>
	<br><br>
	<a href= "SGiocatore?scelta=1">Inserisci Giocatori</a>

</body>
</html>