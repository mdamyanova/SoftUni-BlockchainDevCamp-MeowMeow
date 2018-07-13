<%@ page import="org.meow.meow.repos.AdoptionCatRepository" %>
<%@ page import="org.meow.meow.models.AdoptionCat" %><%--
  Created by IntelliJ IDEA.
  User: MirelaDamyanova
  Date: 12-Jul-18
  Time: 02:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MeowMeow</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style type="text/css">
        <%@include file="../assets/styles/style.css" %>
        <%@include file="../gadgets/normalize/normalize.css" %>
    </style>
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">MeowMeow<span class="hearts">*</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="../home">home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="all">cats</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="add">add cat</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../about">about</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<body>
<main>
    <h1>All Cats</h1>
    <hr />
    <% AdoptionCatRepository cats = (AdoptionCatRepository) application.getAttribute("cats"); %>
    <% for(AdoptionCat cat : cats.all()) { %>
    <h3>
        <a href="profile?catName=<%= cat.getName()%>"><%= cat.getName()%></a>
    </h3>
    <% } %>

    <br />

</main>
</body>
<footer>
    <p class="container-fluid"><b>MeowMeow</b> by Mirela &copy;</p>
</footer>
</html>
<script>
    <%@include file="../assets/scripts/app.js" %>
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
        integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>