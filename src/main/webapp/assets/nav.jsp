<%--
  Created by IntelliJ IDEA.
  User: newma
  Date: 30-06-2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
  <title>Title</title>
</head>
<nav aria-label="breadcrumb">
  <ul>

    <li><a href="administrador.jsp">Home</a></li>
    <% if(request.getSession().getAttribute("usuario")!=null){%>
      <li><a href="perfil">Profile</a></li>
      <li><a href="logout">Log out</a></li>
    <% } %>
    <li>Administrador pagina</li>
  </ul>
</nav>

