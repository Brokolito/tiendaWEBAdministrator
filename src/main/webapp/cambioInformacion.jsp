<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 04-07-2023
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="assets/nav.jsp"%>
<body>
<main class="container">
    <h2>${status}</h2>
    <section>
        <article>
            <form action="cambioInformacion" method="post">
                <label for="telefonoNuevo">
                    Nuevo telefono de contacto:
                    <input placeholder="Nuevo telefono"
                           type="text"
                           name="telefonoNuevo"
                           value="${telefonoAntiguo}"
                           id="telefonoNuevo"
                           required
                    >
                </label>
                <label for="correoNuevo">
                    Correo nuevo de contacto:
                    <input placeholder="Correo nuevo"
                            id="correoNuevo"
                            type="text"
                           value="${correoAntiguo}"
                           name="correoNuevo"
                           required
                    >
                </label>
                <button type="submit">Submit</button>
            </form>
        </article>
    </section>
</main>
</body>
<footer>
    <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
