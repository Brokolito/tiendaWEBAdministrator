<%@ page import="com.proyecto.administraciontiendawebapp.model.Trabajador" %><%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 02-07-2023
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <section>
        <article>
            <form action="registroProducto" method="post">
                <label for="nombreProducto">
                    Nombre producto
                    <input placeholder="Nombre producto" name="nombreProducto" type="text" id="nombreProducto" required>
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
                <label for="precio">
                    Precio producto
                    <input placeholder="Precio producto" name="precio" type="number" id="precio" required>
                </label>
                <button type="submit">Submit</button>
            </form>
        </article>
    </section>
</body>
</html>
