<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Squadra</title>
</head>
<body>

	<form action="SSquadre" method="post">
	<input type = "hidden" name="scelta" value="1">
	<label>Nome Squadra</label>
	<input type="text" name="nome" id="nome" placeholder="...">
	<button type="submit">Inserisci</button>
	</form>
	
	<a href="SSquadre?scelta=1">Lista Squadre</a>

</body>
</html>