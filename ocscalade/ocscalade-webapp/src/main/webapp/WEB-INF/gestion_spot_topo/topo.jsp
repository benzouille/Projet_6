<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:32
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
    <title>topo</title>
</head>
<body>
<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong><c:out value="${topo.nom}"/></strong></h1>
    </div>
    <blockquote class="blockquote text-right">
        <p class="mb-0">Crée par : <c:out value="${topo.utilisateur.pseudo}"/></p>
    </blockquote>
    <div>
        <hr class="my-4">
    </div>

    <div class="information row">
        <div class="info col-lg-4">
            <div class="row">
                <div class="info col-lg-12">
                    <h3 class="text-center"><strong>Information</strong></h3>
                    <hr class="my-4">
                    <ul class="list-group">
                        <c:choose>
                            <c:when test="${topo.reservable}">
                                <li class="list-group-item list-group-item-success" style="text-align: center">DISPONIBLE</li>
                            </c:when>
                            <c:otherwise>
                                <li class="list-group-item list-group-item-danger" style="text-align: center">NON DISPONIBLE</li>
                            </c:otherwise>
                        </c:choose>
                        <li class="list-group-item list-group-item-action" style="text-align: center">
                            <form class="link-td-btn" action="../spots/spot" method="post" style="margin-bottom: 0px">
                                <input type="hidden" name="idSpot" value="${topo.spot.id}"/>
                                <input class="link link-btn" type="submit" value="${topo.spot.nom}"/>
                            </form>
                        </li>
                        <li class="list-group-item list-group-item-action">Département : ${topo.spot.departement.nom}</li>
                        <li class="list-group-item list-group-item-action">Date de création : <d class="date">${topo.date_creation}</d></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="describe col-lg-8">
            <h3 class="text-center"><strong>Déscription</strong></h3>
            <hr class="my-4">
            <p>${topo.description}</p>
        </div>
    </div>
    <hr class="my-4">
    <div class="commentaire">
        <h3 class="text-center"><strong>Réservation</strong></h3>
        <div>
            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>

                    <th scope="col">Utilisateur</th>
                    <th scope="col">Date début</th>
                    <th scope="col">Date fin</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vListReservations}" var="reservation">
                    <tr>
                        <td>${reservation.locataire.pseudo}</td>
                        <td class="date">${reservation.date_debut}</td>
                        <td class="date">${reservation.date_fin}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="row">
            <div  class="col-lg-12">
                <c:if test="${ !empty sessionScope.utilisateur && sessionScope.utilisateur.pseudo != topo.utilisateur.pseudo && topo.reservable}">
                    <form class="form-inline pull-right" action="spot" method="post">
                        <a href="#" class="btn btn-outline-success" role="button" data-toggle="modal" data-target="#topoModal"><i class="fa fa-plus"></i> Réserver</a>
                    </form>
                </c:if>
                <!-- Modal -->
                <div class="modal fade" id="topoModal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="ModalLabel">Réserver topo</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="topo" method="post">
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>Date de debut</label>
                                                <div class="input-group mb-3">
                                                    <input type="date" name="date_debut" class="form-control" id="date_debut">
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Date de fin</label>
                                                <div class="input-group mb-3">
                                                    <input type="date" name="date_fin" class="form-control" id="date_fin">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputMessage">Laissez un petit message...</label>
                                            <textarea class="form-control" name="message" id="inputMessage" rows="6" placeholder="400 caractères maxi."></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                    <input type="submit" name="_reserver_" value="Enregistrer" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
