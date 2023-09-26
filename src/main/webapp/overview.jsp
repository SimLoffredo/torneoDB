<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Squdre</title>
</head>
<body>
<h1>${squadra.nome}</h1>
<table>
    <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Numero Maglia</th>
    </tr>
    <c:forEach items="${giocatori}" var="giocatore">
        <tr>
            <td>${giocatore.nome}</td>
            <td>${giocatore.cognome}</td>
            <td style="text-align:center">${giocatore.nMaglia}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="SZeroPoint">Homepage</a>
	

</body>
</html>