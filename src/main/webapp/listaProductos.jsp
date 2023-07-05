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
            <td> ${producto.getValue("nombre_producto")}</td>
            <td> ${producto.getValue("cod_categoria")}</td>
            <td> ${producto.getValue("precio")}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
