<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 14/07/2019
  Time: 11:30
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
    <title>Mes topos</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<%-- BODY --%>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong>Mes topos</strong></h1>
    </div>

    <hr class="my-4">

    <div class="mes_topos table-responsive">
        <h3 class="text-center"><strong>Mes topos</strong></h3>
        <table class="table table-hover  table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Disponible</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListMesTopos}" var="topo">
                <tr>
                    <form action="topo" method="post">
                        <input type="hidden" name="idTopo" value="${topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" value="${topo.nom}"/></td>
                    </form>
                    <td>
                        <div class="custom-control custom-switch">
                            <form action="topos/topo" method="post">
                                <c:choose>
                                    <c:when test="${topo.reservable}">
                                        <input type="checkbox" class="custom-control-input" id="customSwitch${topo.id}" checked>
                                        <label class="custom-control-label" for="customSwitch${topo.id}"></label>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" class="custom-control-input" id="customSwitch${topo.id}">
                                        <label class="custom-control-label" for="customSwitch${topo.id}"></label>
                                    </c:otherwise>
                                </c:choose>
                                <input type="hidden" name="idTopo" value="${topo.id}"/>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>
                    <div class="custom-control custom-switch">
                        <input type="checkbox" class="custom-control-input" id="customSwitch2" checked>
                        <label class="custom-control-label" for="customSwitch2"></label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <div class="form-inline pull-right">
            <a href="#" class="btn btn-outline-success" role="button"><i class="fa fa-save"></i> Enregistrer</a>
        </div>
    </div>

    <hr class="my-4">

    <div class="resultat table-responsive">
        <h3 class="text-center"><strong>Demande de réservation</strong></h3>
        <table class="table table-hover table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Demandeur</th>
                <th scope="col">Date début</th>
                <th scope="col">Date fin</th>
                <th scope="col">Message</th>
                <th scope="col">Prêter</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="i" value="0" scope="page"/>
            <c:forEach items="${vListDemandeReservations}" var="reservation">
                <tr>
                    <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                    <td>${reservation.locataire.pseudo}</td>
                    <td>${reservation.date_debut}</td>
                    <td>${reservation.date_fin}</td>
                    <td>${reservation.message}</td>
                    <td>
                        <div class="row" style="margin-bottom: 2px">
                            <div class="col-xl-6 col-md-12" style="padding: 0px">
                                <form action="mes_topos" method="post" style="margin-bottom: 0px">
                                    <input type="hidden" name="id_reservation_accepte" value="${reservation.id}">
                                    <input type="submit" name="_accepte_" id="_accepte_${reservation.id}_" class="btn btn-success btn-sm" value="Accepter"/>
                                </form>
                            </div>
                            <div class="col-xl-6 col-md-12" style="padding: 0px">
                                <form action="mes_topos" method="post" style="margin-bottom: 0px">
                                    <input type="hidden" name="id_reservation_refus" value="${reservation.id}">
                                    <input type="submit" name="_accepte_" id="_accepte_${reservation.id}_" class="btn btn-danger btn-sm" value="Refuser" style="padding-left: 12px; padding-right: 12px"/>
                                </form>
                            </div>
                        </div>
                    </td>

                </tr>
            </c:forEach>
            <tr>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>01/01/2001</td>
                <td>02/02/2001</td>
                <td>message</td>
                <td>
                    <button type="button" class="btn btn-success"><i class="fa fa-check-square"></i> Accepter</button>
                    <button type="button" class="btn btn-danger"><i class="fa fa-window-close" > </i> Refuser</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <hr class="my-4">

    <div class="resultat table-responsive">
        <h3 class="text-center"><strong>Topos qui me sont prêtés</strong></h3>
        <table class="table table-hover table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col"></th>
                <th scope="col">Nom</th>
                <th scope="col">Créateur</th>
                <th scope="col">Date début</th>
                <th scope="col">Date fin</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>01/01/2001</td>
                <td>02/02/2001</td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>01/01/2001</td>
                <td>02/02/2001</td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>01/01/2001</td>
                <td>02/02/2001</td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>01/01/2001</td>
                <td>02/02/2001</td>
            </tr>
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
