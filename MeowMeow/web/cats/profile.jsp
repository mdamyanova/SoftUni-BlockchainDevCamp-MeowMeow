<%@ page import="org.meow.meow.models.AdoptionCat" %>
<%@ page import="org.meow.meow.repos.AdoptionCatRepository" %><%--
  Created by IntelliJ IDEA.
  User: MirelaDamyanova
  Date: 12-Jul-18
  Time: 02:27
  To change this template use File | Settings | File Templates.
--%>
<!--TODO-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MeowMeow</title>
</head>
<body>
<% String name = request.getParameter("name"); %>
<% AdoptionCat cat = ((AdoptionCatRepository) application.getAttribute("cats")).byName(name); %>
<% if(cat != null) { %>
<h1>Cat - <%=cat.getName()%></h1>
<hr />
<hr />
<% } else { %>
<h1>Cat, with name <%=name%> was not found.</h1>
<% } %>

<br />
<a href="/cats/all">Back</a>
</body>
</html>