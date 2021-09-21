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
		<form:form action="/categoria/modificar" method="post" modelAttribute="categoria">
		<input type="hidden" name="_method" value="put">
			<form:hidden path="id"/>
		
			<form:label path="nombre">nombre categoria:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<input type="submit" value="Modificar categoria">
		</form:form>
	</div>
</body>
</html>