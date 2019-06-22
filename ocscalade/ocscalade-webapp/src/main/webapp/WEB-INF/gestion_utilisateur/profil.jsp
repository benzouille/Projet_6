<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style type="text/css">  <%@ include file="/WEB-INF/css/utilisateur.css" %> </style>
    <title>profil</title>
</head>
<body>
<%@ include file="../header_footer/header.jsp" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%--<form class="box" action="profil" method="post">--%>
<%--<h1>Profil</h1>--%>
<%--<input type="text" name="pseudo" placeholder="Pseudo">--%>
<%--<input type="text" name="email" placeholder="e-mail">--%>
<%--<input type="password" name="password" placeholder="Mot de passe">--%>
<%--<input type="submit" name="_ok_profil_" value="ok">--%>

<%--</form>--%>

<div class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 profil">
            <form action="profil" method="post">
                <div class="row">
                    <div class="col-lg-4">
                        <label for="id_pseudo" class="">Pseudo : </label>
                    </div>
                    <div class="col-lg-8">
                        <input id="id_pseudo" class="" type="text" value="test ${utilisateur.pseudo}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_email" class="">Email : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_email" class="" type="text" name="email" value="email ${utilisateur.email}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_password" class="">Mot de passe : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_password" class="" type="text" name="password" value="password ${utilisateur.email}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_sexe" class="">Sexe : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_sexe" class="" type="text" name="sexe" value="sexe ${utilisateur.email}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_departement" class="">Departement : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_departement" class="" type="text" name="departement" value="departement ${utilisateur.email}"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-1"></div>
    </div>
</div>

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