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
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong>Spots</strong></h1>
        <p class="lead">Voici la liste des différents spots répertoriés par la communauté.</p>
    </div>

    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <a href="/ocscalade/spots/recherche" class="btn btn-outline-secondary btn-lg" role="button"> <i class="fa fa-search"></i> Rechercher</a>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-6">
            <c:if test="${ !empty sessionScope.utilisateur}">
                <form class="form-inline pull-right" action="topos" method="post">
                    <a href="/ocscalade/spots/nouveau" class="btn btn-outline-success btn-lg" role="button"><i class="fa fa-plus"></i> Nouveau</a>
                </form>
            </c:if>
        </div>
    </div>

    <hr class="my-4">

    <%-- ajouter id--%>
    <div class="row marginBottom">
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="/ocscalade/spots/spot" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="/ocscalade/spots/spot" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>

        <div class="col-lg-3 col-md-4 col-sm-2 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Nom du spot</h5>
                    <p class="card-text">résumé du spot.</p>
                    <a href="#" class="btn btn-primary">plus d'information</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row marginBottom">
        <div class="col">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
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