<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css"><%@ include file="/css/test.css" %></style>
    <title>connexion</title>
</head>
<body>
<%@ include file="../header_footer/header.jsp" %>
<br>
<br>
<form class="box" action="connexion" method="post">
    <h1>Connexion</h1>
    <input type="text" name="pseudo" placeholder="Pseudo">
    <input type="password" name="password" placeholder="Mot de passe">
    <input type="submit" name="_ok_" value="connexion">
    <a href="/ocscalade/inscription">Pas encore de compte ?</a>
</form>

<!-- SCRIPTS -->
<script src="bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous">
</script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        crossorigin="anonymous"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa">
</script>
</body>
</html>
