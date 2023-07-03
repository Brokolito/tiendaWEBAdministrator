<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 03-07-2023
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="assets/nav.jsp" %>
<body>
{}
  <section>
    <article>
      <form action="registroBodega" method="post">
        <label for="direccionBodega">
          Direccion bodega:
          <input name="direccionBodega" type="text" id="direccionBodega" required>
        </label>
        <label for="trabajadorEncargado">
          <select name="trabajadorEncargado" id="trabajadorEncargado">
            <option value="0" selected>Elija uno</option>
            <c:forEach items="${trabajadores}" var="trabajador">
              <option value="${trabajador.getValue("rut_trabajador")}">
                  ${trabajador.getValue("nombre_trabajador")}
              </option>
            </c:forEach>
          </select>

        </label>
        <button type="submit">Submit</button>
      </form>
    </article>
  </section>
</body>
</html>
