<%--
  Created by IntelliJ IDEA.
  User: jluen
  Date: 03-07-2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<h2>${status}</h2>
<section>
  <article>
    <form action="registroProductoBodega" method="post">
      <label for="producto">
        Elegir producto
        <select name="producto" id="producto">
          <option value="0" selected>Elija uno</option>
          <c:forEach items="${productos}" var="producto">
            <option value="${producto.getValue("cod_producto")}">
                ${producto.getValue("nombre_producto")}
            </option>
          </c:forEach>
        </select>
      </label>
      <label for="bodega">
        Elegir Bodega
        <select name="bodega" id="bodega">
          <option value="0" selected>Elija uno</option>
          <c:forEach items="${bodegas}" var="bodega">
            <option value="${bodega.getValue("cod_bodega")}">
                ${bodega.getValue("direccion_bodega")}
            </option>
          </c:forEach>
        </select>

      </label>
      <label for="cantidad">
        Cantidad producto
        <input placeholder="Cantidad producto" name="cantidad" type="number" id="cantidad" required>
      </label>
      <label for="fecha_vencimiento">
        Fecha Vencimiento
        <input name="fecha_vencimiento" type="date" id="fecha_vencimiento">
      </label>
      <button type="submit">Submit</button>
    </form>
  </article>
</section>
</body>
</html>
