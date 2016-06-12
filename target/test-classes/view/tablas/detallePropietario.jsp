<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>tabla propietario</title>
	</head>
	<body>
	

	<table>
		<thead>
	<tr >
		
			<th>nombre:</th>
			<th>dni:</th>
			<th>direccion:</th>
			<th>telefono: </th>
	</tr>
		</thead>
	<tbody>
				<c:if test="${!empty propietario}">
						<tr>
							<td><c:out value="${propietario.getNombre()}"></c:out></td>
							<td><c:out value="${propietario.getDni()}"></c:out></td>
							<td><c:out value="${propietario.getDireccion()}"></c:out></td>
							<td><c:out value="${propietario.getTelefono()}"></c:out></td>		
					</tr>

				</c:if>
				<c:if test="${empty propietario}">
					<tr>
						<td colspan="5">No hay datos disponibles por el momento</td>
					</tr>
				</c:if>

			</tbody>
	
	</table>
		
		

</html>