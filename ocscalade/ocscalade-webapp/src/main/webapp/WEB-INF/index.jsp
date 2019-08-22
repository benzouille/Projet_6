<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <style type="text/css">  <%@ include file="/WEB-INF/css/index.css" %> </style>
    <title>Accueil</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="bd-example">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://zupimages.net/up/19/26/4gkm.jpg" class="d-block img-fluid" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h3>La faille du Sud <span class="badge badge-success">Officiel</span></h3>
                    <p>Spot officiel.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://zupimages.net/up/19/26/buy6.jpg" class="d-block img-fluid" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h3>La faille verte <span class="badge badge-success">Officiel</span></h3>
                    <p>Spot officiel.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="https://zupimages.net/up/19/26/p9te.jpg" class="d-block img-fluid" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Le pic  <span class="badge badge-success">Officiel</span></h3>
                    <p>Spot officiel.</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<hr>
<div class="container cardTab">
    <h2 class="text-center"><strong>Les derniers spots ajoutés</strong></h2>

    <hr class="my-4">

    <div class="row marginBottom">
        <c:forEach items="${vListSpots}" var="spot">
            <div class="col-lg-3 col-md-4 col-sm-6" >
                <div class="card">
                    <div class="div_image">
                        <img href="/ocscalade/spots/spot" src="https://zupimages.net/up/19/27/76vx.jpg" class="card-img-top" alt="...">
                    </div>
                    <div class="card-body">
                        <form action="spots/spot" method="post">
                            <h5 class="card-title">${spot.nom}</h5>
                            <p class="card-text">${spot.description}</p>
                            <input type="hidden" name="idSpot" value="${spot.id}"/>
                            <input type="submit" name="_spot_" id="${spot.id}" class="btn btn-primary stretched-link" value="plus d'information"/>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="row marginBottom">
        <div class="col-lg-3 col-md-4 col-sm-6" >
            <div class="card">
                <div class="div_image">
                    <img href="#" src="../images/website/connexion2.jpg" class="card-img-top" alt="...">
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
