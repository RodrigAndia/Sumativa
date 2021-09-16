<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venta</title>
</head>
<body>
	<div>
		<form:form action="/venta/modificar" method="post" modelAttribute="venta">
		<input type="hidden" name="_method" value="put">
			<form:hidden path="id"/>
		
			<form:label path="prod">numero producto:</form:label>
			<form:input type="text" path="prod"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="valor">valor:</form:label>
			<form:input type="text" path="valor"/><br>
			
			<input type="submit" value="Modificar Venta">
		</form:form>
	</div>
</body>
</html>