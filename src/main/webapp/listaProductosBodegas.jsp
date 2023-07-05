<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 05-07-2023
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="container">
    <body>
    <h1>Lista de productos encontrados en Bodega</h1>
    <br>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Categoria</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Fecha Vencimiento</th>
        </tr>
        <c:forEach items="${productos}" var="producto">
            <tr>
                <td> <c:out value="${producto.getNombre()}"></c:out></td>
                <td> <c:out value="${producto.getCategoria()}"></c:out></td>
                <td> <c:out value="${producto.getPrecio()}"></c:out></td>
                <td> ${producto.stock}</td>
                <td> <c:out value="${producto.getFechaVencimiento()}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
    </body>
</main>
</html>