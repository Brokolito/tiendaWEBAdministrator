<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 04-07-2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="assets/nav.jsp"%>
<body>
<main class="container">
  <h2>${status}</h2>
  <section>
    <article>
      <form action="cambioPassword" method="post">
        <label for="oldPassword">
          Contraseña antigua:
          <input name="oldPassword" placeholder="Contraseña antigua" type="password" id="oldPassword" required>
        </label>
        <label for="confirmOldPassword">
          Confirmar contraseña antigua
          <input name="confirmOldPassword" placeholder="Confirmar contraseña antigua" type="password" id="confirmOldPassword" required>
        </label>
        <label for="newPassword">
          Nueva contraseña:
          <input placeholder="Nueva contraseña" type="password" id="newPassword" name="newPassword" required>
        </label>
        <button type="submit">Submit</button>
      </form>
    </article>
  </section>
</main>
</body>
</html>
