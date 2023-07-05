<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 03-07-2023
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="assets/nav.jsp"%>
<main class="container">
<body>
<section>

    <article>
      <h1>¡Hola,bienvenido a tu perfil ${nombreTrabajador}!</h1>
      <p>Aca puedes editar la informacion personal que desees</p>
      <a href="cambioPassword">Cambiar contraseña</a>
      <a href="cambioInformacion">Cambiar informacion contacto </a>
    </article>

</section>
</body>
</main>
<footer>
    <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
