<%@page import="com.proyecto.administraciontiendawebapp.model.Producto" %>
<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 04-07-2023
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="container">
<body>
<h1>Lista de productos encontrados</h1>
<br>
<table>
    <tr>
        <th>Nombre</th>
        <th>Categoria</th>
        <th>Precio</th>
    </tr>
    <c:forEach items="${productos}" var="producto">
        <tr>
            <td> ${producto.nombre}</td>
            <td> ${producto.categoria}</td>
            <td> $${producto.precio}</td>
        </tr>
    </c:forEach>
</table>
</body>
</main>
<footer>
    <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
