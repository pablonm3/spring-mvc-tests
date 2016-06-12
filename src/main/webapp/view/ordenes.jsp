<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/resources/css/stylesheet.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ver ordenes</title>
	</head>
	<body>
	<h1>lista de ordenes</h1>

	<c:if test ="${!empty orden}">
		<jsp:include page="tablas/detalleOrden.jsp" />
	</c:if>
	
	<c:if test="${!empty listaOrdenes}">
		<jsp:include page="tablas/listaOrdenes.jsp" />
	</c:if>
	
	<a href="/TrabajoFinal/" class="buttonBlue">Volver al index</a>
	</body>
</html>