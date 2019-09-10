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
        <div class="box-profil col-xl-8 col-lg-8 col-md-8 col-sm-12">
            <h1>Profil</h1>
            <div class="row">
                <div class="col-lg-4">
                    <label for="pseudo" class="">Pseudo : </label>
                </div>
                <div class="col-lg-8">
                    <label id="pseudo" name="pseudo"><c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.pseudo }</c:if></label>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-12">
                    <label for="email" class="">Email : </label>
                </div>
                <div class="col-lg-8 col-md-12">
                    <label id="email"><c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.email }</c:if></label>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-12">
                    <label for="sexe" class="">Sexe : </label>
                </div>
                <div class="col-lg-8 col-md-12">
                    <label id="sexe"><c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.sexe.sexe }</c:if></label>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-12">
                    <label for="departement" class="">Departement : </label>
                </div>
                <div class="col-lg-8 col-md-12">
                    <label id="departement"><c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.departement.num }, ${ sessionScope.utilisateur.departement.nom }</c:if></label>
                </div>
            </div>
            <div class="form-inline pull-right">
                <input type="button" name="_ok_" value="Modifier" data-toggle="modal" data-target="#exampleModal">
            </div>
        </div>
        <div class="col-xl-2 col-lg-2 col-md-2"></div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modifier le profil</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="profil" method="post">
                <div class="modal-body">
                    <div class="container-fluid">
                        <div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="id_sexe">Sexe</label>
                                    <select class="custom-select" name="sexe" id="id_sexe">
                                        <option selected>Séléctionnez</option>
                                        <c:forEach items="${vListSexes}" var="sexe">
                                            <option><c:out value="${sexe.sexe}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div>
                                <div class="form-group">
                                    <label for="id_departement">Département</label>
                                    <select class="custom-select" name="departement" id="id_departement">
                                        <option selected>Séléctionnez</option>
                                        <c:forEach items="${vListDepartements}" var="departement">
                                            <option><c:out value="${departement.num}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div>
                                <div class="form-group">
                                    <label for="id_email">Email</label>
                                    <input type="email" id="id_email" class="form-control"  name="email" value="<c:if test="${ !empty sessionScope.utilisateur}">${ sessionScope.utilisateur.email }</c:if>"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <input type="submit" name="_modifier_profil_" class="btn btn-primary" value="Enregistrer"/>
                </div>
            </form>
        </div>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="../header_footer/footer.jsp" %>

<!-- SCRIPTS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">

</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>

</body>
</html>