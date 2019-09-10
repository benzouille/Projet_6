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
    <title>Topos</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4"><strong>Topos</strong></h1>
        <p class="lead">Voici la liste des différents topos crées par la communauté.</p>
    </div>
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <form class="form-inline pull-left" action="topos" method="post">
                <a href="/ocscalade/topos/rechercher" class="btn btn-outline-secondary btn-lg" role="button"> <i class="fa fa-search"></i> Rechercher</a>
            </form>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <c:if test="${ !empty sessionScope.utilisateur}">
                <form class="form-inline pull-right" action="topos" method="post">
                    <a href="#" class="btn btn-outline-success btn-lg" role="button" data-toggle="modal" data-target="#toposModal"><i class="fa fa-plus"></i> Nouveau</a>
                </form>
                <!-- Modal -->
                <div class="modal fade" id="toposModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="ModalLabel">Nouveau topo</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="topos/topo" method="post">
                                <div class="modal-body">
                                    <div class="container-fluid">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="nom">Nom</label>
                                                    <input type="text" class="form-control" name="nom" id="nom" placeholder="nom">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="spot">Spot</label>
                                                    <select id="spot" name="spot" class="form-control">
                                                        <option selected>Choose...</option>
                                                        <c:forEach items="${vListSpots}" var="spot">
                                                            <option><c:out value="${spot.nom}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" name="reservable" id="gridCheck">
                                                    <label class="form-check-label" for="gridCheck">
                                                        Mettre à disposition des utilisateurs
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputDescription">Description</label>
                                                <textarea class="form-control" name="description" id="inputDescription" rows="6" placeholder="400 caractères maxi."></textarea>
                                            </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                    <input type="submit" name="_nouveau_topo_" value="Enregistrer" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <hr class="my-4">

    <div class="table-responsive">
        <table class="table table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Auteur</th>
                <th scope="col">Spot</th>
                <th scope="col">Département</th>
                <th scope="col">Disponible</th>
                <th scope="col">Date de création</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListTopos}" var="topo">
                <tr>
                    <form action="topos/topo" method="post">
                        <input type="hidden" name="idTopo" value="${topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" value="${topo.nom}"/></td>
                    </form>
                    <td>${topo.utilisateur.pseudo}</td>
                    <form action="spots/spot" method="post">
                        <input type="hidden" name="idSpot" value="${topo.spot.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" value="${topo.spot.nom}"/></td>
                    </form>
                    <td>${topo.spot.departement.nom}</td>
                    <td class="disponible">${topo.reservable}</td>
                    <td class="date">${topo.date_creation}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <hr class="my-4">

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

    $(".disponible").each(function() {
        gooddispo = this.innerText;
        if (gooddispo == 'true') {
            $(this).text('disponible');
        }
        else{
            $(this).text('indisponible');
        }
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
