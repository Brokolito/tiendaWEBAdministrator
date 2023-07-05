
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
  <h1>Registro de productos</h1>
  <h2>${status}</h2>
  <section>
    <article>
      <form action="buscarProductosBodega" method="post">
        <label for="bodega">
          Elegir bodega
          <select name="bodega" id="bodega">
            <option value="0" selected>Elija uno</option>
            <c:forEach items="${bodegas}" var="bodega">
              <option value="${bodega.getValue("cod_bodega")}">
                  ${bodega.getValue("direccion_bodega")}
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
