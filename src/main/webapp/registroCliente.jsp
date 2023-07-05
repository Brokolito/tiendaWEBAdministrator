<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 30-06-2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="assets/nav.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="container">
<body>
<h1>Registrar nuevo cliente</h1>
<h2>${status}</h2>
  <section>
    <article>
      <form method="post" action="registroCliente">

        <div >

          <!-- Markup example 1: input is inside label -->
          <label for="rut">
            Rut cliente
            <input type="text" id="rut" name="rut" placeholder="Rut cliente" required>
          </label>

          <label for="nombre">
            Nombre cliente
            <input type="text" id="nombre" name="nombre" placeholder="Nombre de cliente" required>
          </label>
          <label for="direccion">
            Direccion cliente
            <input type="text" id="direccion" name="direccion" placeholder="Direccion cliente" required>
          </label>
          <label for="telefono">
            Telefono cliente
            <input type="text" id="telefono" name="telefono" placeholder="Telefono cliente" required>
          </label>
          <label for="correo">
            Correo cliente
            <input type="email" name="correo" id="correo" placeholder="Correo cliente">
          </label>
        </div>

        <!-- Markup example 2: input is after label -->


        <!-- Button -->
        <button type="submit">Submit</button>

      </form>
    </article>
  </section>
</body>
</main>
<footer>
  <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
