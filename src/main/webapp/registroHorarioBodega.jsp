<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 03-07-2023
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="assets/nav.jsp"%>
<body>
<h2>${status}</h2>
  <article>
    <form action="registroHorarioBodega" method="post">
      <label for="bodega">
        <select name="bodega" id="bodega">
          <option value="0">Selecciona una bodega</option>
          <c:forEach items="${bodegas}" var="bodega">
            <option value="${bodega.getValue("cod_bodega")}">
              ${bodega.getValue("direccion_bodega")}
            </option>
          </c:forEach>
        </select>
      </label>
      <label for="diaComienzo">
        Desde:
        <select name="diaComienzo" id="diaComienzo">
          <option value="0">Elija dia</option>
          <option value="1">Lunes</option>
          <option value="2">Martes</option>
          <option value="3">Miercoles</option>
          <option value="4">Jueves</option>
          <option value="5">Viernes</option>
          <option value="6">Sabado</option>
          <option value="7">Domingo</option>
        </select>
      </label>
      <label for="diaTermino">
        Hasta:
        <select name="diaTermino" id="diaTermino">
          <option value="0">Elija dia</option>
          <option value="1">Lunes</option>
          <option value="2">Martes</option>
          <option value="3">Miercoles</option>
          <option value="4">Jueves</option>
          <option value="5">Viernes</option>
          <option value="6">Sabado</option>
          <option value="7">Domingo</option>
        </select>
      </label>
      <label for="horaComienzo">
        De:
        <input id="horaComienzo" type="time" name="horaComienzo" required>
      </label>
      <label for="horaTermino">
        Hasta:
        <input name="horaTermino" id="horaTermino" type="time" required>
      </label>
      <button type="submit">Submit</button>
    </form>
  </article>
</body>
</html>
