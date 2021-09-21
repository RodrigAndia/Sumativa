<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
	<div>
		<form:form action="/producto/crear" method="post" modelAttribute="producto">
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="precio">Precio:</form:label>
			<form:input type="text" path="precio"/><br>

			<form:label path="caracteristicas">Caracteristicas:</form:label>
			<form:input type="text" path="caracteristicas"/><br>
			
			<form:label path="existencias">Existencias:</form:label>
			<form:input type="text" path="existencias"/><br>
			
			<input type="submit" value="Crear">
		</form:form>
		<br>
		<h1>Productos</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Caracteristicas principales</th>
					<th>Existencias</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="producto" items="${lista_productos}">
						<tr>
							<td><c:out value="${producto.id}"></c:out></td>
							<td><c:out value="${producto.nombre}"></c:out></td>
							<td><c:out value="${producto.precio}"></c:out></td>
							<td><c:out value="${producto.caracteristicas}"></c:out></td>	
							<td><c:out value="${producto.existencias}"></c:out></td>							
							<td>
								<a href="/producto/actualizar/${producto.id}">Editar</a>
								<form action="/producto/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
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