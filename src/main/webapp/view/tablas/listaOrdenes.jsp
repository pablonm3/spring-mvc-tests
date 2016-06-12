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

	<table>
		<thead>
			<tr >
				<th>marca:</th>
				<th>modelo:</th>
				<th>patente:</th>
				<th>fecha: </th>
				<th>estado: </th>
				<th>detalle: </th>
				<th>propietario: </th>
				<th>precio final: </th>
				<th>accion: </th>
			</tr>
		</thead>	
	<tbody>
				<c:if test="${!empty listaOrdenes}">
					<c:forEach items="${listaOrdenes}" var="l">
						<tr>
							<td><c:out value="${l.getMarca()}"></c:out></td>
							<td><c:out value="${l.getModelo()}"></c:out></td>
							<td><c:out value="${l.getPatente()}"></c:out></td>
							<td><fmt:formatDate value="${l.getFecha()}" pattern="yyyy-dd-MM" /></td>
							<td><c:out value="${l.getEstado()}"></c:out></td>
							<td><a href = "/TrabajoFinal/tablas/detalleOrden/${l.getId()}">ver detalle</a></td>
				  			<td><a href = "/TrabajoFinal/propietario/${l.getPropietario().getDni()}"><c:out value="${l.getPropietario().getNombre()}"></c:out></a></td>
							<td>
								<c:if test="${l.isActivo()}">
									no disponible		
								</c:if>
								
								<c:if test="${not l.isActivo()}">
									<c:out value="${l.getPrecioFinal()} $"></c:out>
								</c:if>
							
							</td>
							<td>
								<c:if test="${l.isActivo()}">
									<a href= "/TrabajoFinal/editarOrden/${l.getId()}">EDITAR </a>
									/
									<a href= "abm/finalizarOrden/${l.getId()}">FINALIZAR</a>
								</c:if>
								
								<c:if test="${not l.isActivo()}">
									<a href = "/TrabajoFinal/costos/${l.getId()}">VER COSTOS </a>
								</c:if>
							
							</td>
						</tr>

					</c:forEach>
				</c:if>
				<c:if test="${empty listaOrdenes}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
					</tr>
				</c:if>
			</tbody>
	
	</table>
