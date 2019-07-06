<%@ page language="java" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%--HEADER HERE--%>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-fixed-top">
        <a class="navbar-brand" href="/ocscalade">OC'scalade</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/topos">Topo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/spots">Spot</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-search"></i> Rechercher
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/ocscalade/topos/rechercher">Topo</a>
                        <a class="dropdown-item" href="/ocscalade/spots/rechercher">Spot</a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <c:if test="${ empty sessionScope.utilisateur}">
                    <li class="nav-item">
                        <a class="nav-link" href="/ocscalade/inscription">S'inscrire</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ocscalade/connexion">Se connecter</a>
                    </li>
                </c:if>
                <c:if test="${ !empty sessionScope.utilisateur}">
                    <li class="nav-item">
                        <a class="nav-link" href="/ocscalade"><i class="fa fa-book" style="font-size:25px"></i> Mes topos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ocscalade"><i class="fa fa-calendar" style="font-size:25px; color: #78e08f"></i> Réservation</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ocscalade/profil"><i class="fa fa-user" style="font-size:25px"></i> Profil</a>
                    </li>
                    <li style="margin-top: 5px">
                        <form class="form-inline" action="index" method="post">
                            <button class="btn btn-outline-secondary btn-outline-danger " type="submit" name="_disconnect_"><i class="fa fa-power-off"></i> Deconnexion</button>
                        </form>
                    </li>
                </c:if>
            </ul>

        </div>
    </nav>
</header>

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