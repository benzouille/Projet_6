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
        <h1 class="display-4"><strong>Titre du topo</strong></h1>
    </div>
    <blockquote class="blockquote text-right">
        <p class="mb-0">Crée par : NOM</p>
    </blockquote>
    <div>
        <hr class="my-4">
    </div>

    <div class="information row">
        <div class="info col-lg-4">
            <div class="row">
                <div class="secteur_list_1 col-lg-12">
                    <h3 class="text-center"><strong>Information</strong></h3>
                    <hr class="my-4">
                    <ul class="list-group">
                        <li class="list-group-item list-group-item-success" style="text-align: center">DISPONIBLE</li>
                        <li class="list-group-item list-group-item-danger" style="text-align: center">NON DISPONIBLE</li>
                        <a href="secteur" class="list-group-item list-group-item-action">Nom du spot : SPOT</a>
                        <a href="secteur" class="list-group-item list-group-item-action">Date de création : DATE</a>
                        <a href="secteur" class="list-group-item list-group-item-action">nom du secteur</a>
                        <a href="secteur" class="list-group-item list-group-item-action">nom du secteur</a>
                    </ul>
                </div>
            </div>
        </div>
        <div class="describe col-lg-8">
            <h3 class="text-center"><strong>Description</strong></h3>
            <hr class="my-4">
            <p>Departement : n°</p>
            <p>spot lié, date, description,indication si réservé ou non, bouton réservation, bouton owner mise à disposition</p>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. In fringilla, eros eget aliquet sodales,
                nunc justo porta augue, cursus cursus libero massa sit amet tellus. Etiam accumsan aliquam pulvinar.
                Nulla facilisi. Aliquam a consectetur erat. Aenean efficitur velit ut gravida consequat.
                Suspendisse convallis sem enim, mattis venenatis magna facilisis eu. Sed vitae consequat urna.
                In mattis diam id mauris tristique condimentum. In sit amet pretium mauris. In malesuada purus vitae enim convallis ornare.
                Mauris nibh nisi, elementum eu consequat vitae, egestas at magna. Phasellus eros nisl, fringilla vel auctor nec, vehicula vel felis.
                Vivamus id lacus fermentum, tempus nisi eu, malesuada metus. Fusce dictum ut est vitae ultrices.

                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean risus ex, ultrices vitae gravida eget,
                condimentum quis neque. Etiam feugiat iaculis magna, sit amet gravida odio vulputate sit amet.
                Pellentesque at rutrum ex, eu congue nisl. Duis eleifend rhoncus libero, at sagittis elit. Morbi congue eu diam at mollis.
                Aenean venenatis metus ut efficitur blandit. Suspendisse potenti. Nam porttitor lacus sit amet enim pretium iaculis.
                Fusce interdum aliquet eleifend. Nulla a tempus leo. Phasellus mattis varius nibh ut varius. Lorem ipsum dolor sit amet,
                consectetur adipiscing elit. In hac habitasse platea dictumst. Cras vel ante ut erat placerat auctor ac ut tellus. Nullam ac nisi mi.
            </p>
        </div>
    </div>
    <hr class="my-4">
    <div class="commentaire">
        <h3 class="text-center"><strong>Réservation</strong></h3>
        <div>
            <table class="table table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Nom</th>
                    <th scope="col">Date</th>
                    <th scope="col">Durée</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Admin</td>
                    <td>01/01/2001</td>
                    <td>matin</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Coincoin</td>
                    <td>après-midi</td>
                    <td>01/01/2001</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Bouh</td>
                    <td>01/02/2001</td>
                    <td>journée</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>Admin</td>
                    <td>01/03/2001</td>
                    <td>journée</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div  class="col-lg-12">
                <c:if test="${ !empty sessionScope.utilisateur}">
                    <form class="form-inline pull-right" action="spot" method="post">
                        <a href="#" class="btn btn-outline-success" role="button"><i class="fa fa-plus"></i> Réserver</a>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="/WEB-INF/header_footer/footer.jsp" %>

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
