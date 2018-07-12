<%@ page import="org.meow.meow.repos.AdoptionCatRepository" %>
<%@ page import="org.meow.meow.models.AdoptionCat" %><%--
  Created by IntelliJ IDEA.
  User: MirelaDamyanova
  Date: 12-Jul-18
  Time: 02:20
  To change this template use File | Settings | File Templates.
--%>
<!--TODO-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MeowMeow</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<h1>All Cats</h1>
<hr />
<% AdoptionCatRepository cats = (AdoptionCatRepository) application.getAttribute("cats"); %>
<% for(AdoptionCat cat : cats.all()) { %>
<h3>
    <a href="/cats/profile?catName=<%= cat.getName()%>"><%= cat.getName()%></a>
</h3>
<% } %>

<br />
<a href="/">Back to Home</a>
</body>
</html>
