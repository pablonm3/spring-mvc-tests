<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
	<title>añadir repuestos</title>
</head>
	<body>
	
	<h1>agregar repuestos: </h1>
	<%if ("POST".equalsIgnoreCase(request.getMethod())){  %>
		<p class = "notification"> dato cargado exitosamente</p>
	<%} %>
	
		
		
		
		<form action = "/TrabajoFinal/abm/addRepuestoAction" method="post">
		<label>seleccione repuesto:</label>
		<select name = "idRepuesto" >
		<c:forEach items="${listaRepuestos}" var="rep">
				<option value="${rep.id}">
					<c:out value="${rep.nombre} (precio: ${rep.precio}$)"></c:out>
				</option>
			</c:forEach>
		
		</select>
		
		<br>
		<label >cantidad: </label>
		<input type = "text" name = "cantidad"/>
		<input type="hidden" name="idOrden" value="${idOrden}">
		
		<input type="submit" value="Guardar" />
		</form>



	<a href="/TrabajoFinal/editarOrden/${idOrden}" class="buttonOrange">Volver a pagina anterior</a>
	
	<a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>