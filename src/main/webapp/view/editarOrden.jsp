<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>editar orden</title>
	</head>
	<body>
	<h1>Editar Orden</h1>

	
	<%if("post".equalsIgnoreCase(request.getMethod())){%>
		<p class ="notification">cambio aplicado correctamente</p>
	<%}%>
	
	<c:if test ="${!empty id}">
		<a href="/TrabajoFinal/abm/sumarHorasTrabajo/${id}" class="buttonRed">sumar horas de trabajo</a>
		
		<a href="/TrabajoFinal/abm/agregarRepuesto/${id}" class="buttonRed">cargar repuestos utilizados</a>
	
	</c:if>
	
	<br>
	<a href="/TrabajoFinal/ordenes" class="buttonOrange">Volver a pagina anterior</a>
	
	<a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>