<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:31
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
    <title>Recherche de spot</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<%-- BODY --%>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong>Rechercher un spot</strong></h1>
    </div>

    <hr class="my-4">

    <div class="recherche">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Par départements</label>
                        <div class="input-group mb-3">
                            <select class="custom-select" id="inputGroupSelect01">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Par difficultés</label>
                        <div class="input-group mb-3">
                            <select class="custom-select" id="inputGroupSelect02">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Par nombre de secteur</label>
                        <div class="input-group mb-3">
                            <select class="custom-select" id="inputGroupSelect03">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                    </div>
                    <div class="row col-12">
                        <div class="form-check col-lg-5 col-md-5" style="margin-left: 15px">
                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                            <label class="form-check-label" for="defaultCheck1">
                                Equipement
                            </label>
                        </div>
                        <div class="form-check  col-lg-5 col-md-6*5" style="margin-left: 15px">
                            <input class="form-check-input pull-right" type="checkbox" value="" id="defaultCheck">
                            <label class="form-check-label" for="defaultCheck1">
                                Officiel
                            </label>
                        </div>
                    </div>
                </div>
            <div class="pull-right" style="margin-top: 20px">
                <a href="/ocscalade/topos/nouveau" class="btn btn-outline-secondary" role="button"> Rechercher</a>
            </div>
        </form>
    <br>

    </div>

    <div>
        <hr class="my-4">
    </div>

    <div class="resultat table-responsive">
        <h3 class="text-center"><strong>Résultat</strong></h3>
        <table class="table table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col"></th>
                <th scope="col">Nom</th>
                <th scope="col">Auteur</th>
                <th scope="col">Département</th>
                <th scope="col">Difficulté</th>
                <th scope="col">Secteurs</th>
                <th scope="col">Equipement</th>
                <th scope="col">Officiel</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>69</td>
                <td>6d</td>
                <td>3</td>
                <td><i class="fa fa-check-square" style="color: green; font-size:25px;"></i></td>
                <td><i class="fa fa-window-close" style="color: red; font-size:25px;"> </i></td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>69</td>
                <td>6d</td>
                <td>3</td>
                <td><i class="fa fa-check-square" style="color: green; font-size:25px;"></i></td>
                <td><i class="fa fa-window-close" style="color: red; font-size:25px;"> </i></td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>69</td>
                <td>6d</td>
                <td>3</td>
                <td><i class="fa fa-check-square" style="color: green; font-size:25px;"></i></td>
                <td><i class="fa fa-window-close" style="color: red; font-size:25px;"> </i></td>
            </tr>
            <tr>
                <th scope="row">1</th>
                <td><a class="link" href="/ocscalade/topos/topo">Bien débuter</a></td>
                <td>Admin</td>
                <td>69</td>
                <td>6d</td>
                <td>3</td>
                <td><i class="fa fa-check-square" style="color: green; font-size:25px;"></i></td>
                <td><i class="fa fa-window-close" style="color: red; font-size:25px;"> </i></td>
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
