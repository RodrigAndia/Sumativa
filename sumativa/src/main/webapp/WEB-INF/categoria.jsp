<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categoria</title>
</head>
<body>
	<div>
		<form:form action="/categoria/crear" method="post" modelAttribute="categoria">
			
			<form:label path="nombre">nombre categoria:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<input type="submit" value="Crear">
		</form:form>
		<br>
		<h1>categorias</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre categoria</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="categoria" items="${lista_categorias}">
						<tr>
							<td><c:out value="${categoria.id}"></c:out></td>
							<td><c:out value="${categoria.nombre}"></c:out></td>
							<td>
								<a href="/categoria/actualizar/${categoria.id}">Editar</a>
								<form action="/categoria/eliminar" method="POST">
									<input type="hidden" name="id" value="<c:out value="${categoria.id}" />" >
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