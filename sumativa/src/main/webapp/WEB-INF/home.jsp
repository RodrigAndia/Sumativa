<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <!-- Bootstrap CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

                <title>Seleccione los productos a comprar!</title>
            </head>

            <body>
                <div class="container">
                    <div>
                        <h1>Home</h1>
                        <h5><a href="/usuario/logout">Cerrar sesion</a></h5>

                        <br>
                        <h1>Lista de productos</h1>
    					<p><c:out value="${error}" /></p>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Precio</th>
                                    <th>Caracteristicas</th>
                                    <th>Existencias</th>
                                    <th>Elegir</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <form action="/producto/resumen" method="post">
                                        <c:forEach var="producto" items="${lista_productos}">
                                            <tr>
                                                <td>
                                                    <c:out value=""></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${producto.nombre}"></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${producto.precio}"></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${producto.caracteristicas}"></c:out>
                                                </td>
                                                <td>
                                                    <c:out value="${producto.existencias}"></c:out>
                                                </td>
                                                <td>
                                                    <input type="checkbox" id="prod" value="${producto.id}" name="prod" />
                                                </td>
                                           </tr>
                                        </c:forEach>
                                        <br>
                                </tr>
                            </tbody>
                        </table>
                        <input class="btn btn-primary mx-auto d-block" type="submit" value="Comprar">
                     </form>
                    </div>
                </div>
            </body>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

            </html>