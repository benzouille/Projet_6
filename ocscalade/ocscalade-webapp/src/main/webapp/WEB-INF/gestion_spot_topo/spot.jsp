<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 28/05/2019
  Time: 21:33
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
    <title>spot</title>
</head>
<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <div>
            <h1 class="display-4"><strong><c:out value="${spot.nom}"/></strong></h1>
            <c:if test="${spot.officiel}">
                <span class="badge badge-pill rotate badge-success"><h1><i class="fa fa-check-circle"></i> Officiel</h1></span>
            </c:if>
        </div>
    </div>
    <blockquote class="blockquote text-right">
        <p class="mb-0">Crée par : <c:out value="${spot.createur.pseudo}"/></p>
    </blockquote>
    <div>
        <hr class="my-4">
    </div>
    <%--CAROUSSEL--%>
    <div class="information row">
        <div class="photo col-lg-5">
            <div class="carousel-spot" style="margin-bottom: 10px">
                <div id="carouselCaptions" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselCaptions" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselCaptions" data-slide-to="1"></li>
                        <li data-target="#carouselCaptions" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://zupimages.net/up/19/27/mlvw.jpg" class="img_spot d-block img-fluid" alt="image du spot">
                        </div>
                        <div class="carousel-item">
                            <img src="https://static.actu.fr/uploads/2018/04/25026-180425182555366-1-854x1139.jpg" class="img_spot d-block img-fluid" alt="image du spot">
                        </div>
                        <div class="carousel-item">
                            <img src="https://zupimages.net/up/19/27/mlvw.jpg" class="img_spot d-block img-fluid" alt="image du spot">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselCaptions" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselCaptions" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="secteur_list_1 col-lg-12">
                    <h3 class="text-center"><strong>Secteurs</strong></h3>
                    <hr class="my-4">
                    <ul class="list-group">
                        <c:forEach items="${spot.secteurs}" var="secteur">
                            <form action="spot/secteur" method="post">
                                <input type="hidden" name="id_secteur" value="${secteur.id}"/>
                                <input type="submit" name="_secteur_" id="${secteur.id}" class="btn list-group-item list-group-item-action turquoise" value="${secteur.nom}"/>
                            </form>
                        </c:forEach>
                    </ul>
                    <div>
                        <c:if test="${ !empty sessionScope.utilisateur && sessionScope.utilisateur.pseudo == spot.createur.pseudo}">
                            <div class="form-inline pull-right">
                                <a href="#" class="btn btn-outline-success" role="button" style="margin-top: 10px" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-plus"></i> Nouveau secteur</a>
                            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Nouveau secteur</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form action="spot/secteur" method="post">
                                            <div class="modal-body">
                                                <div class="container-fluid">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="nom">Nom</label>
                                                            <input type="text" class="form-control" name="nom" id="nom" placeholder="nom"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputDescription">Description</label>
                                                        <textarea class="form-control" id="inputDescription" name="description" rows="6" placeholder="1000 caractères maxi."></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="hidden" name="id_spot" value="${spot.id}"/>
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                                <input type="submit" name="_nouveau_secteur_" value="Enregistrer" class="btn btn-primary"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="describe col-lg-7">
            <h3 class="text-center"><strong>Informations</strong></h3>
            <hr class="my-4">
            <p><c:out value="Localisation : ${spot.adresse}"/></p>
            <p><c:out value="Département : ${spot.departement.nom}"/></p>
            <p><c:out value="Déscription : ${spot.description}"/></p>
        </div>
    </div>
    <hr class="my-4">
    <div class="commentaire">
        <h3 class="text-center"><strong>Commentaires</strong></h3>
        <div class="row">
            <div  class="col-lg-12">
                <c:if test="${ !empty sessionScope.utilisateur}">
                    <form class="form-inline pull-right" action="spots/spot" method="post">
                        <a href="#" class="btn btn-outline-success" role="button" data-toggle="modal" data-target="#exampleModal2"><i class="fa fa-plus"></i> Nouveau commentaire</a>
                    </form>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabe2" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabe2">Nouveau commentaire</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="spot" method="post">
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <div class="form-group">
                                                <label for="inputDescription">Commentaire</label>
                                                <textarea class="form-control" id="commentaire" name="commentaire" rows="6" placeholder="1000 caractères maxi."></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                        <input type="submit" name="_nouveau_commentaire_" value="Enregistrer" class="btn btn-primary"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
        <c:forEach items="${spot.commentaires}" var="commentaire">
            <div class="card border-light mb-3">
                <div class="row no-gutters">
                    <div class="card-header row col-md-3" style="margin-left: 0px">
                        <div class="col-6 col-md-12 col-lg-12">
                            <h6>${commentaire.utilisateur.pseudo}</h6>
                        </div>
                        <div class="col-6 col-md-12 col-lg-12">
                            <div class="pull-right pull-bottom">
                                <p class="card-text"><small class="text-muted date_heure">${commentaire.date}</small></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <div class="card-body">
                            <p class="card-text">${commentaire.commentaire}</p>
                            <c:if test="${sessionScope.utilisateur.pseudo == commentaire.utilisateur.pseudo || sessionScope.utilisateur.privilege.id==2 || sessionScope.utilisateur.privilege.id==3}">
                                <div class="row pull-right" style="margin-bottom: 5px">
                                    <form action="spots/spot" method="post" style="margin-right: 5px">
                                        <a href="#" class="btn btn-outline-secondary btn-sm" role="button" data-toggle="modal" data-target="#modalEdit${commentaire.id}">Editer</a>
                                    </form>
                                    <!-- Modal -->
                                    <div class="modal fade" id="modalEdit${commentaire.id}" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalLabel">Modifier commentaire</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <form action="spot" method="post">
                                                    <div class="modal-body">
                                                        <div class="container-fluid">
                                                            <div class="form-group">
                                                                <label for="inputDescription">Commentaire</label>
                                                                <textarea class="form-control" id="modifier_commentaire" name="modifier_commentaire" rows="6" >${commentaire.commentaire}</textarea>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                                        <input type="hidden" name="id_modifier_commentaire" value="${commentaire.id}">
                                                        <input type="submit" name="_modifier_commentaire_" value="Modifier" class="btn btn-primary"/>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <form action="spot" method="post">
                                        <input type="hidden" name="id_commentaire" value="${commentaire.id}">
                                        <input type="submit" name="_supprimer_commentaire_" class="btn btn-outline-secondary btn-sm" value="Supprimer"/>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%-- FOOTER --%>
<%@ include file="/WEB-INF/header_footer/footer.jsp" %>

<!-- SCRIPTS -->
<script type="application/javascript">
    $(".date_heure").each(function() {console.debug(this);gooddate = this.innerText.split(' ')[0].split('-');
        var goodtime = this.innerText.split(' ')[1]
        console.debug(goodtime);goodtime = goodtime.split(':')
        $(this).text(gooddate[2]+"/"+gooddate[1]+"/"+gooddate[0]+" "+goodtime[0]+":"+goodtime[1]
        );
    });
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
