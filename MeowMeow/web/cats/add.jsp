<%--
  Created by IntelliJ IDEA.
  User: MirelaDamyanova
  Date: 12-Jul-18
  Time: 02:21
  To change this template use File | Settings | File Templates.
--%>
<!--TODO-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MeowMeow</title>
</head>
<body>
<h1>Add Cat for Adoption</h1>
<br/>
<form method="post" action="add">
    Name: <label>
            <input type="text" name="name" />
          </label><br/>
    <button type="submit">Create Cat</button>
</form>
<br/>
<a href="../home">Back to Home</a>
</body>
</html>