<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
	<title>añadir horas trabajo</title>
</head>
	<body>
	
	<%if ("POST".equalsIgnoreCase(request.getMethod())){  %>
		<p class = "notification"> dato cargado exitosamente</p>
	<%} %>
	
	
	<form action = "/TrabajoFinal/abm/addHorasTrabajo" method="POST">
		<label>ingrese cantidad de horas de trabajo:(se sumaran a la cantidad actual) </label>
	  	<input type="text" name="horas"/>
	  	 <input type="hidden" name="id" value="${id}">
  		<input type = "submit" value= "cargar" name = "submit">
	</form>

	<a href="/TrabajoFinal/editarOrden/${id} " class="buttonOrange">Volver a pagina anterior</a>
	
	<a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>