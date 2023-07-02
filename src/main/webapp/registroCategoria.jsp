<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 02-07-2023
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="assets/nav.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
    <section>
        <article>
            <form action="registroCategoria" method="post">
                <label for="categoria">
                    Nombre Categoria
                    <input placeholder="categoria" name="categoria" id="categoria" type="text" required>
                    <button type="submit">Submit</button>
                </label>
            </form>
        </article>
    </section>
</body>
</html>
