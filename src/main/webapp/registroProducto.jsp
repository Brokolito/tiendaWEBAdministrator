<%@ page import="com.proyecto.administraciontiendawebapp.model.Trabajador" %><%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 02-07-2023
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
    <section>
        <article>
            <form action="">
                <label for="nombreProducto">
                    <input placeholder="Nombre producto" name="nombreProducto" type="text" id="nombreProducto" required>
                    <input type="text"  value="${rut}">
                </label>
            </form>
        </article>
    </section>
</body>
</html>
