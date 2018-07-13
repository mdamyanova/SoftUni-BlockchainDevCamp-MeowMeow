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
    <label>Name: <input type="text" name="name" /></label><br/>
    <label>Age: <input type="number" name="age" /></label><br/>
    <label>Gender: <input type="text" name="gender" /></label><br/>
    <label>Town: <input type="text" name="town" /></label><br/>
    <label>Description: <input type="text" name="description" /></label><br/>
    <label>Image: <input type="text" name="imageHash" /></label><br/> <!--TODO - Image upload-->
    <label>Organization: <input type="text" name="organization" /></label><br/>
    <button type="submit">Add Cat for Adoption</button>
</form>
<br/>
<a href="../home">Back to Home</a>
</body>
</html>