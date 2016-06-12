<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ver ordenes</title>
	</head>
	<body>
		
			<h1>Detalles:</h1>

	<table>
	<tr >
			<th>marca:</th>
			<th>modelo:</th>
			<th>patente:</th>
			<th>fecha: </th>
			<th>estado: </th>
			<th>detalle: </th>
			<th>propietario: </th>
			<th>accion: </th>
	</tr>
	<tbody>
				<c:if test="${!empty orden}">
						<tr>
							<td><c:out value="${orden.getMarca()}"></c:out></td>
							<td><c:out value="${orden.getModelo()}"></c:out></td>
							<td><c:out value="${orden.getPatente()}"></c:out></td>
							<td><fmt:formatDate value="${orden.getFecha()}" pattern="yyyy-dd-MM" /></td>
							<td><c:out value="${orden.getEstado()}"></c:out></td>
							<td><c:out value="${orden.getDetalle()}"></c:out></td>
							<td><c:out value="${orden.getPropietario().getNombre()}"></c:out></td>
								<td>
								<c:if test="${orden.isActivo()}">
									<a href= "/TrabajoFinal/editarOrden/${orden.getId()}">EDITAR </a>
									/
									<a href= "/TrabajoFinal/abm/finalizarOrden/${orden.getId()}">FINALIZAR</a>
								</c:if>
								
								<c:if test="${not orden.isActivo()}">
									<a href = "/TrabajoFinal/costos/${orden.getId()}">VER COSTOS </a>
								</c:if>
							
							
							</td>
						
						</tr>

				</c:if>
				<c:if test="${empty orden}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
					</tr>
				</c:if>

			</tbody>
	
	</table>
		
		
	<button type="button" class = "buttonGreen"name="back" onclick="history.back()">volver a pagina anterior</button>


</html>