<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 02-07-2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="container">
<body>
<h1>Registrar nueva categoria</h1>
<h2>${status}</h2>
    <section>
        <article>
            <form action="registroCategoria" method="post">
                <label for="categoria">
                    Nombre categoria
                    <input placeholder="Nombre categoria" name="categoria" id="categoria" type="text" required>
                    <button type="submit">Submit</button>
                </label>
            </form>
        </article>
    </section>
</body>
</main>
<footer>
    <p style="text-align: center">&copy; 2023 Marcelo Castro y Javier Luengo. <br>Todos los derechos reservados.</p>
</footer>
</html>
