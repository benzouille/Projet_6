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
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListMesTopos}" var="topo">
                <tr>
                    <form action="topo" method="post">
                        <input type="hidden" name="idTopo" value="${topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" name="idtopo" value="${topo.nom}"/></td>
                    </form>
                    <form action="mes_topos" method="post">
                        <input type="hidden" name="idTopo" value="${topo.id}"/>
                        <td>
                            <div class="custom-control custom-switch">

                                <c:choose>
                                    <c:when test="${topo.reservable}">
                                        <input type="checkbox" class="custom-control-input" name="topo_dispo" id="customSwitch${topo.id}" checked>
                                        <label class="custom-control-label" for="customSwitch${topo.id}"></label>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" class="custom-control-input" name="topo_dispo" id="customSwitch${topo.id}">
                                        <label class="custom-control-label" for="customSwitch${topo.id}"></label>
                                    </c:otherwise>
                                </c:choose>
                                <input type="hidden" name="idTopo" value="${topo.id}"/>
                            </div>
                        </td>
                        <td>
                            <div class="form-inline pull-right">
                                <input type="submit" class="btn_form btn btn-outline-success btn-sm" name="_topo_dispo_" role="button" value="Enregistrer">
                            </div>
                        </td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>


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
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListDemandeReservations}" var="reservation">
                <tr>
                    <form action="topo" method="post">
                        <input type="hidden" name="idTopo" value="${reservation.topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" name="idtopo${reservation.topo.id}" value="${reservation.topo.nom}"/></td>
                    </form>
                    <td>${reservation.locataire.pseudo}</td>
                    <td class="date_debut">${reservation.date_debut}</td>
                    <td class="date_fin">${reservation.date_fin}</td>
                    <td>${reservation.message}</td>
                    <td>
                        <form action="mes_topos" method="post" style="margin-bottom: 3px">
                            <input type="hidden" name="id_reservation_accepte" value="${reservation.id}">
                            <input type="submit" name="_accepte_" id="_accepte_${reservation.id}_" class="btn btn-outline-success btn-sm" value="Accepter"/>
                        </form>
                    </td>
                    <td>
                        <form action="mes_topos" method="post" style="margin-bottom: 3px">
                            <input type="hidden" name="id_reservation_refus" value="${reservation.id}">
                            <input type="submit" name="_accepte_" id="_accepte_${reservation.id}_" class="btn btn-outline-danger btn-sm" value="Refuser" style="padding-left: 12px; padding-right: 12px"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <hr class="my-4">

    <div class="resultat table-responsive">
        <h3 class="text-center"><strong>Topos qui me sont prêtés</strong></h3>
        <table class="table table-hover table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Créateur</th>
                <th scope="col">Date début</th>
                <th scope="col">Date fin</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${vListPrete}" var="pret">
                <tr>
                    <form action="topo" method="post">
                        <input type="hidden" name="idTopo" value="${pret.topo.id}"/>
                        <td class="link-td-btn"><input class="link link-btn" type="submit" name="idtopo${pret.topo.id}" value="${pret.topo.nom}"/></td>
                    </form>
                    <td>${pret.topo.utilisateur.pseudo}</td>
                    <td class="date_debut">${pret.date_debut}</td>
                    <td class="date_fin_affichage">${pret.date_fin}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="/WEB-INF/header_footer/footer.jsp" %>

<!-- SCRIPTS -->
<script type="application/javascript">
    $(".date_fin_affichage").each(function() {
        var input_date = new Date(this.innerText).getTime();
        console.debug(input_date);
        var curr_date = new Date().getTime();
        console.debug(curr_date);
        if (input_date <= curr_date) {
            $(this).after('<td>EXPIRE</td>');
        }
    });

    $("[class^=date_]").each(function() {
        gooddate = this.innerText.split(' ')[0].split('-');
        $(this).text(gooddate[2]+"/"+gooddate[1]+"/"+gooddate[0]);
    });

    $(".btn_form").submit()
</script>

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
