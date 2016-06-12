<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ver costos</title>
	</head>
	<body>
		
			<h2>Detalle de costos para: <c:out value="${orden.getPropietario().getNombre()}"></c:out>
				<br>
				dni: <c:out value="${orden.getPropietario().getDni()}"></c:out>
				<br>
				fecha inicio reparaciones: <fmt:formatDate value="${orden.getFecha()}" pattern="yyyy-dd-MM" />
			</h2>
 
	<jsp:include page="tablas/detalleCostos.jsp" />
	  

		
	<button type="button" class = "buttonGreen"name="back" onclick="history.back()">volver a pagina anterior</button>

	 <a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>