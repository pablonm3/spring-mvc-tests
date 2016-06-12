<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>tabla costos</title>
	</head>
	<body>
	

	<table>
	<thead>
	<tr >
			<th>descripcion:</th>
			<th>cantidad:</th>
			<th>precio unitario:</th>
			<th>subtotal:</th>
	</tr>
	</thead>
		<tbody>
			<tr>
				<td>
					Horas mano de obra
				</td>
				
				<td>
					<c:out value="${orden.getHorasTrabajadas()}"></c:out>
				</td>
				<td>
					<c:out value="${valorHora} $"></c:out>
				</td>
				<td>
					<c:out value="${orden.getCostoManoObra()} $"></c:out>
				</td>
				
			</tr>
		
					<c:forEach items="${orden.getRepuestos()}" var="r">
					<tr>
					<td>
					<c:out value="${r.getRepuesto().getNombre()}"></c:out>
					</td>
					
					<td>
					<c:out value="${r.getCantidad()}"></c:out>
					</td>
					
					<td>
					<c:out value="${r.getRepuesto().getPrecio()}"></c:out>
					</td>
					
					<td>
					<c:out value="${r.getSubtotal()}"></c:out>
					</td>
					
					</tr>
		</c:forEach>
	
		
		
		
		
		</tbody>
		<tfoot >
			<tr>
				<td>Precio Final</td>
				<td>-</td>
				<td>-</td>
				<td><c:out value="${orden.getPrecioFinal()} $"></c:out></td>
			</tr>
		</tfoot>
	</table>
		
		

</html>