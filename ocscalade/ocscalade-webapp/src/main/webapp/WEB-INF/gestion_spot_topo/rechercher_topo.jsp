<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 22/06/2019
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous">
    <style type="text/css">  <%@ include file="/WEB-INF/css/spot_topo.css" %> </style>
    <title>Recherche de topo</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<%-- BODY --%>
<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong>Rechercher un topo</strong></h1>
    </div>

    <hr class="my-4">

    <div class="recherche">
        <form action="rechercher" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Par départements</label>
                    <div class="input-group mb-3">
                        <select class="custom-select" name="departement" id="departement">
                            <option selected>Séléctionnez</option>
                            <c:forEach items="${vListDepartements}" var="departement">
                                <option><c:out value="${departement.num}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label>Par spot lié</label>
                    <div class="input-group mb-3">
                        <select class="custom-select" name="spot" id="spot">
                            <option selected>Séléctionnez</option>
                            <c:forEach items="${vListSpots}" var="spot">
                                <option><c:out value="${spot}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label>Par créateur</label>
                    <div class="input-group mb-3">
                        <select class="custom-select" name="createur" id="createur">
                            <option selected>Séléctionnez</option>
                            <c:forEach items="${vListUtilisateurs}" var="utilisateur">
                                <option><c:out value="${utilisateur}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label>Par date</label>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon3">après le : </span>
                        </div>
                        <input type="date" class="form-control" name="date" id="date" aria-describedby="basic-addon3">
                    </div>
                </div>
                <div class="row col-12">
                    <div class="form-check col-lg-5 col-md-5" style="margin-left: 15px">
                        <input class="form-check-input" type="checkbox" value="" name="disponible" id="disponible">
                        <label class="form-check-label" for="disponible">Disponible</label>
                    </div>
                </div>
            </div>
            <div class="pull-right" style="margin-top: 20px">
                <input type="submit" name="_recherche_topo_" value="Rechercher" class="btn btn-outline-secondary"/>
            </div>
        </form>
        <br>
        <c:if test="${ !empty erreur}">
            <p class="red">${ erreur }</p>
        </c:if>
    </div>

    <div>
        <hr class="my-4">
    </div>

    <div class="resultat table-responsive">
        <h3 class="text-center"><strong>Résultat</strong></h3>
        <table class="table table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Département</th>
                <th scope="col">Spot lié</th>
                <th scope="col">Auteur</th>
                <th scope="col">Date de création</th>
                <th scope="col">Disponible</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListTopoRecherche}" var="topo">
                <tr>
                    <form action="topos/topo" method="post">
                        <input type="hidden" name="idTopo" value="${topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" value="${topo.nom}"/></td>
                    </form>
                    <td>${topo.spot.departement.nom}</td>
                    <form action="topos/topo" method="post">
                        <input type="hidden" name="idTopo" value="${topo.spot.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" value="${topo.spot.nom}"/></td>
                    </form>
                    <td>${topo.utilisateur.pseudo}</td>
                    <td class="date">${topo.date_creation}</td>
                    <c:choose>
                        <c:when test="${topo.reservable}">
                            <td><i class="fa fa-check-square" style="color: green; font-size:25px;"></i></td>
                        </c:when>
                        <c:otherwise>
                            <td><i class="fa fa-window-close" style="color: red; font-size:25px;"> </i></td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="/WEB-INF/header_footer/footer.jsp" %>

<!-- SCRIPTS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>

<script type="application/javascript">
    $(".date").each(function() {
        gooddate = this.innerText.split(' ')[0].split('-');
        $(this).text(gooddate[2]+"/"+gooddate[1]+"/"+gooddate[0]);
    });
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
