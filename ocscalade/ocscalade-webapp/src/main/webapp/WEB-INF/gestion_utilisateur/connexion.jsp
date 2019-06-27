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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous">
    <style type="text/css"><%@ include file="/WEB-INF/css/utilisateur.css" %></style>
    <title>connexion</title>
</head>
<body>
<%-- HEADER --%>
<%@ include file="../header_footer/header.jsp" %>

<%-- BODY --%>
<div class="container">
    <div class="row">
        <div class="col-xl-4 col-lg-4 col-md-3"></div>
        <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12">
            <form class="box" action="connexion" method="post">
                <h1>Connexion</h1>
                <input type="text" name="pseudo" placeholder="Pseudo">
                <input type="password" name="password" placeholder="Mot de passe">
                <input type="submit" name="_ok_" value="connexion">
                <a class="link" href="/ocscalade/inscription">Pas encore de compte ?</a>
            </form>
        </div>
        <div class="col-xl-4 col-lg-4 col-md-3"></div>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="../header_footer/footer.jsp" %>

<!-- SCRIPTS -->

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">

</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>

</body>
</html>
