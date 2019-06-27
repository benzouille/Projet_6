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
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous">
    <style type="text/css">  <%@ include file="/WEB-INF/css/utilisateur.css" %> </style>
    <title>profil</title>
</head>
<body>

<%-- HEADER --%>
<%@ include file="../header_footer/header.jsp" %>

<%-- BODY --%>
<div class="container">
    <div class="row">
        <div class="col-xl-2 col-lg-2 col-md-2"></div>
        <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12">
            <form class="box-profil" action="profil" method="post">
                <h1>Profil</h1>
                <div class="row">
                    <div class="col-lg-4">
                        <label for="id_pseudo" class="">Pseudo : </label>
                    </div>
                    <div class="col-lg-8">
                        <input id="id_pseudo" class="" type="text" value="<c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.pseudo }</c:if>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_email" class="">Email : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_email" class="" type="text" name="email" value="<c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.email }</c:if>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_password" class="">Mot de passe : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <input id="id_password" class="" type="text" name="password" value="<c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.password }</c:if>"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_sexe" class="">Sexe : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <select class="custom-select" id="id_sexe">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-12">
                        <label for="id_departement" class="">Departement : </label>
                    </div>
                    <div class="col-lg-8 col-md-12">
                        <select class="custom-select" id="id_departement">
                            <option selected>Choose...</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-xl-2 col-lg-2 col-md-2"></div>
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