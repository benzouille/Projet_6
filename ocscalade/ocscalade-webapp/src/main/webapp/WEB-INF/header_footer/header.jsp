<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<%--<nav class="navbar navbar-inverse navbar-fixed-top">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<button type="button" data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle">--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <%--<a href="/ocscalade" class="navbar-brand">OC'scalade</a>--%>
        <%--</div>--%>
        <%--<div class="collapse navbar-collapse">--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li><a href="/ocscalade/topo">Topo</a></li>--%>
                <%--<li><a href="/ocscalade/spot">Spot</a></li>--%>
                <%--<li class="nav-item dropdown">--%>
                    <%--<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Rechercher</a>--%>
                    <%--<div class="dropdown-menu">--%>
                        <%--<a class="dropdown-item" href="/ocscalade/rechercher_topo">topo</a>--%>
                        <%--<div role="separator" class="dropdown-divider"></div>--%>
                        <%--<a class="dropdown-item" href="/ocscalade/rechercher_spot">spot</a>--%>
                    <%--</div>--%>
                <%--</li>--%>
                <%--<li><a href="/ocscalade/inscription">S'inscrire</a></li>--%>
                <%--<li><a href="/ocscalade/connexion">Se connecter</a></li>--%>

                <%--<li><a href="/ocscalade/profil">profil</a></li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-fixed-top">
        <a class="navbar-brand" href="/ocscalade">OC'scalade</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/topo">Topo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/spot">Spot</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Rechercher
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/ocscalade/rechercher_topo">Topo</a>
                        <a class="dropdown-item" href="/ocscalade/rechercher_spot">Spot</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/inscription">S'incrire</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ocscalade/connexion">Se connecter</a>
                </li>
                <li class="nav-item">
                    <%--TODO A modifier et mettre un icone de bonhomme à la place de profil le faire apparaitre que si l'on est connecté--%>
                    <a class="nav-link" href="/ocscalade/profil">Profil</a>
                </li>
            </ul>
        </div>
    </nav>

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