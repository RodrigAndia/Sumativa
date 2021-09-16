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
		<form:form action="/venta/crear" method="post" modelAttribute="venta">
			
			<form:label path="prod">numero producto:</form:label>
			<form:input type="text" path="prod"/><br>
			
			<form:label path="cantidad">cantidad:</form:label>
			<form:input type="text" path="cantidad"/><br>
			
			<form:label path="valor">valor:</form:label>
			<form:input type="text" path="valor"/><br>
			
			<input type="submit" value="Crear">
		</form:form>
		<br>
		<h1>Ventas</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Numero Producto</th>
					<th>cantidad</th>
					<th>valor</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="venta" items="${lista_ventas}">
						<tr>
							<td><c:out value="${venta.id}"></c:out></td>
							<td><c:out value="${venta.prod}"></c:out></td>
							<td><c:out value="${venta.cantidad}"></c:out></td>
							<td><c:out value="${venta.valor}"></c:out></td>
							<td>
								<a href="/venta/actualizar/${venta.id}">Editar</a>
								<form action="/venta/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${venta.id}" />" >
									<input type="submit" value="Eliminar">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>