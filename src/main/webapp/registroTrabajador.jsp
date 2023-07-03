<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 01-07-2023
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
    <section>
        <article>
            <form action="registroTrabajador" method="post">
                <label for="rut">
                    Rut trabajador
                    <input placeholder="Rut trabajador" name="rut" type="text" id="rut" required>
                </label>
                <label for="nombre">
                    Nombre trabajador
                    <input placeholder="Nombre trabajador" name="nombre" type="text" id="nombre" required>
                </label>
                <label for="fechaNacimiento">
                    Fecha nacimiento
                    <input name="fechaNacimiento" type="date" id="fechaNacimiento" required>
                </label>
                <label for="fechaIngreso">
                    Fecha ingreso
                    <input name="fechaIngreso" type="date" id="fechaIngreso" required>
                </label>
                <label for="cargo">
                    Cargo del trabajador
                    <select name="cargo" id="cargo" required>
                        <option value="0" selected>Escoja una opcion</option>
                        <option value="1">Administrador de caja</option>
                        <option value="2">Jefe de local</option>
                        <option value="3">Jefe de bodega</option>
                    </select>
                </label>
                <label for="tipoContrato">
                    <select name="tipoContrato" id="tipoContrato" required>
                        <option value="0">Escoja una opcion</option>
                        <option value="1">Plazo definido</option>
                        <option value="2">Plazo Indefinido</option>
                        <option value="3">Faena/Obra</option>
                        <option value="4">Part-time</option>
                        <option value="5">Por temporada</option>
                    </select>
                </label>
                <label for="correo">
                    Correo trabajador
                    <input placeholder="Correo trabajador" name="correo" type="email" id="correo" required>
                </label>
                <label for="telefono">
                    Telefono trabajador
                    <input placeholder="Telefono trabajador" type="text" name="telefono" id="telefono" required>
                </label>
                <label for="password">
                    Clave temporal
                    <input placeholder="Contraseña temporal" name="password" type="password" id="password">
                </label>
                <button type="submit">Submit</button>
            </form>
        </article>
        <article>
            <a href="">Registrar Horario</a>
        </article>
    </section>
</body>
</html>
