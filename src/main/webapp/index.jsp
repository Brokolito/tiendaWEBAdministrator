<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 30-06-2023
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
    <title>Title</title>
</head>
<body >
<article>
    <form method="post" action="login">

        <!-- Grid -->
        <div >

            <!-- Markup example 1: input is inside label -->
            <label for="rut">
                Rut
                <input type="text" id="rut" name="rut" placeholder="Rut" required>
            </label>

            <label for="password">
                Password
                <input type="password" id="password" name="password" placeholder="Password" required>
            </label>

        </div>

        <!-- Markup example 2: input is after label -->


        <!-- Button -->
        <button type="submit">Submit</button>

    </form>
</article>
</body>
</html>
