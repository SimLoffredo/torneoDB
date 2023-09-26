<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica</title>
</head>
<body>
	<form action="SSquadre" method="post">
		<input type = "hidden" name="scelta" value="2">
		<input type="hidden" id="id" name="id" value="${squadra.id}">
		<label>Nome Squadra</label>
		<input type="text" name="nome" id="nome" value="${squadra.nome}">
	<button type="submit">Modifica</button>
	
	</form>

</body>
</html>