<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<div>
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			
			<input type="submit" value="Crear">
		</form:form>
		<br>
		<h1>Usuarios</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="usuario" items="${lista_usuarios}">
						<tr>
							<td><c:out value="${usuario.id}"></c:out></td>
							<td><c:out value="${usuario.rut}"></c:out></td>
							<td><c:out value="${usuario.nombre}"></c:out></td>
							<td><c:out value="${usuario.apellido}"></c:out></td>
							<td><c:out value="${usuario.email}"></c:out></td>
							<td>
								<a href="/usuario/actualizar/${usuario.id}">Editar</a>
								<form action="/usuario/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${usuario.id}" />" >
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