<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ver propietario</title>
	</head>
	<body>
		
			<h1>Detalles propietario:</h1>
 
	<jsp:include page="tablas/detallePropietario.jsp" />
	  
	<h2>Ordenes emitidas hacia el propietario:</h2>
	
	
	<jsp:include page="tablas/listaOrdenes.jsp" />
		 
	<button type="button" class = "buttonGreen"name="back" onclick="history.back()">volver a pagina anterior</button>

	 <a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>