<%@ page import="java.util.ArrayList" %>
<%@page import="com.proyecto.administraciontiendawebapp.model.Producto" %>
<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 04-07-2023
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main class="container">
<body>
<h1>Registro de productos</h1>
<h2>${status}</h2>
<section>
  <article>
    <form action="buscarProducto" method="post">
      <label for="nombreProducto">
        Nombre producto
        <input placeholder="Nombre producto" name="nombreProducto" type="text" id="nombreProducto">
      </label>
      <label for="categoria">
        Elegir categoria
        <select name="categoria" id="categoria">
          <option value="0" selected>Elija uno</option>
          <c:forEach items="${categorias}" var="categoria">
            <option value="${categoria.getValue("cod_categoria")}">
                ${categoria.getValue("des_categoria")}
            </option>
          </c:forEach>
        </select>
      </label>
      <button type="submit">Submit</button>
    </form>
  </article>
</section>
</body>
</main>
</html>
