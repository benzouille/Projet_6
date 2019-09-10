<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 30/06/2019
  Time: 10:07
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
    <title>Spots</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="container cardTab">
    <div class="jumbotron">
        <h1 class="display-4"><strong>Spots</strong></h1>
        <p class="lead">Voici la liste des différents spots répertoriés par la communauté.</p>
    </div>

    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <a href="/ocscalade/spots/rechercher" class="btn btn-outline-secondary btn-lg" role="button"> <i class="fa fa-search"></i> Rechercher</a>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <c:if test="${ !empty sessionScope.utilisateur}">
                <div class="form-inline pull-right">
                    <a href="#" class="btn btn-outline-success btn-lg" role="button" data-toggle="modal" data-target="#nouveauSpotModal"><i class="fa fa-plus"></i> Nouveau</a>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="nouveauSpotModal" tabindex="-1" role="dialog" aria-labelledby="nouveauSpotModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="nouveauSpotModalLabel">Nouveau spot</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="spots/spot" method="post" >
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="nom">Nom</label>
                                                <input type="text" class="form-control" id="nom" name="nom" placeholder="nom">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-9">
                                                <label for="localisation">Localisation</label>
                                                <input type="text" class="form-control" id="localisation" name="localisation" placeholder="localisation">
                                            </div>
                                            <div class="form-group col-md-3">
                                                <label for="departement">Département</label>
                                                <select id="departement" name="departement" class="form-control">
                                                    <option selected>Séléctionnez</option>
                                                    <c:forEach items="${vListDepartements}" var="departement">
                                                        <option><c:out value="${departement.num}"/></option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Description</label>
                                            <textarea class="form-control" id="description" name="description" rows="6" placeholder="400 caractères maxi."></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                    <input type="submit" name="_nouveau_spot_" value="Enregistrer" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <hr class="my-4">

    <%-- les differents spots--%>
    <div class="row marginBottom">
        <c:forEach items="${vListSpots}" var="spot">
            <div class="col-lg-3 col-md-4 col-sm-6" >
                <div class="card">
                    <div class="div_image">
                        <img src="<%=request.getContextPath()%>${spot.images[0].titre}" class="card-img-top card-seize" style="height: 151px" alt="...">
                    </div>
                    <div class="card-body">
                        <form action="spots/spot" method="post">
                            <h5 class="card-title">${spot.nom}</h5>
                            <p class="card-text" style="height: 48px">${spot.description}</p>
                            <input type="hidden" name="idSpot" value="${spot.id}"/>
                            <input type="submit" name="_spot_" id="${spot.id}" class="btn btn-primary stretched-link" value="plus d'information"/>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<%-- FOOTER --%>
<%@ include file="/WEB-INF/header_footer/footer.jsp" %>

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
