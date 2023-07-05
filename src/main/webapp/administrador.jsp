<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 30-06-2023
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="container">
<body>
<h1>Administrador</h1>
<section>
    <article>
        <p>Personas</p>
        <li><a href="registroCliente">Registrar Cliente</a></li>
        <li><a href="registroTrabajador">Registrar Trabajador</a></li>
        <br>
        <p>Productos</p>
        <li><a href="registroCategoria"> Registrar Categoria</a></li>
        <li><a href="registroProducto">Agregar productos</a></li>
        <li><a href="buscarProducto">Buscar productos</a></li>
        <br>
        <p>Bodega</p>
        <li><a href="registroBodega">Registrar bodega</a></li>
        <li><a href="registroProductoBodega">Registrar producto en bodega</a></li>
        <li><a href="buscarProductosBodega">Buscar productos en bodega</a></li>

    </article>
</section>
</body>
</main>
<footer>
    <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
