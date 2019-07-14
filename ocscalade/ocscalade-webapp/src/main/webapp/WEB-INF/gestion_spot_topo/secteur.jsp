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
    <title>secteur</title>
</head>
<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <div>
            <%--TODO ajouter condition d'apparition du tag officiel--%>
            <h1 class="display-4"><strong>Titre du secteur </strong></h1>
        </div>
    </div>
    <blockquote class="blockquote text-right">
        <p class="mb-0">Crée par : NOM</p>
    </blockquote>
    <div>
        <hr class="my-4">
    </div>
    <div class="information row">
        <div class="describe col-lg-6">
            <h3 class="text-center"><strong>Informations</strong></h3>
            <hr class="my-4">
            <p>
                Description : Lorem ipsum dolor sit amet, consectetur adipiscing elit. In fringilla, eros eget aliquet sodales,
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

                Etiam semper pharetra nisi, eu pharetra lorem condimentum ut. Suspendisse placerat auctor leo ac tincidunt.
                Ut non orci finibus, semper est vitae, dapibus massa. Suspendisse tempor urna eu elit porttitor, vel porttitor ante tempus.
                Maecenas ut sapien quis sem auctor bibendum nec sed nibh. Fusce tristique nisi vitae turpis molestie, varius rutrum erat tempor.
                Proin euismod mi quis facilisis congue. Fusce blandit risus eu feugiat hendrerit. Fusce accumsan, leo quis pulvinar luctus,
                eros mauris ornare nisi, ut porta leo neque at ligula.

                Nam semper est vel iaculis consequat. Nunc lobortis interdum faucibus. Vivamus laoreet, metus et malesuada euismod,
                erat enim cursus eros, sit amet varius sapien enim aliquet eros. Cras arcu metus, ultricies ac ante ut, imperdiet laoreet elit.
                Sed risus enim, porta a tellus sit amet, rhoncus faucibus felis. Sed vel velit neque. Phasellus est leo, finibus id ante eget,
                convallis porttitor elit. Praesent elit augue, blandit in massa ac, placerat placerat mi. Curabitur quis purus consequat,
                mattis massa eget, eleifend felis. Donec consequat, erat id rutrum pulvinar, eros turpis blandit orci, at vehicula massa lectus sed diam.

                Morbi nec velit est. Donec vel tempus erat. Nullam sit amet ex semper, fermentum quam ut, auctor sem.
                Etiam eget dui vestibulum, ullamcorper nisl ac, malesuada sapien. Duis quis quam mauris. Praesent luctus mauris ut odio iaculis sodales.
                Cras non mauris eget eros vehicula eleifend nec id lacus. Cras in leo nulla. Phasellus quis egestas urna, quis cursus tortor.
                Nunc et cursus nibh. Integer porta maximus tortor, vitae venenatis dolor tristique non.
            </p>
        </div>
        <div class="voie col-lg-6">
            <div class="row">
                <div class="voie_list col-lg-12">
                    <h3 class="text-center"><strong>Voies</strong></h3>
                    <hr class="my-4">
                    <div class="accordion" id="accordionExample">
                        <div class="card">
                            <div class="card-header" id="headingOne">
                                <h2 class="mb-0">
                                    <button class="btn btn-link turquoise" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        Nom de voie
                                    </button>
                                </h2>
                            </div>

                            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                <div class="card-body padding-0">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Difficulté : DIFF</li>
                                        <li class="list-group-item ">Equipé : <i class="fa fa-check-square" style="color: green; font-size:25px;"></i> </li>
                                        <li class="list-group-item ">Nombre de point : NBRE</li>
                                        <li class="list-group-item ">Equipé : <i class="fa fa-window-close" style="color: red; font-size:25px;"> </i> </li>
                                        <li class="list-group-item">Nombre de longueur : NBRE_LONG</li>
                                        <li class="list-group-item"><p>Déscription : </p><p>DESC Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                        </p></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" id="headingTwo">
                                <h2 class="mb-0">
                                    <button class="btn btn-link collapsed turquoise" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Nom de voie
                                    </button>
                                </h2>
                            </div>
                            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                                <div class="card-body padding-0">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Difficulté : DIFF</li>
                                        <li class="list-group-item ">Equipé : <i class="fa fa-window-close" style="color: red; font-size:25px;"> </i> </li>
                                        <li class="list-group-item">Nombre de longueur : NBRE_LONG</li>
                                        <li class="list-group-item"><p>Déscription : </p><p>DESC Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                        </p></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header" id="headingThree">
                                <h2 class="mb-0">
                                    <button class="btn btn-link collapsed turquoise" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        Nom de voie
                                    </button>
                                </h2>
                            </div>
                            <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                                <div class="card-body padding-0">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Difficulté : DIFF</li>
                                        <li class="list-group-item ">Equipé : <i class="fa fa-check-square" style="color: green; font-size:25px;"></i> </li>
                                        <li class="list-group-item ">Nombre de point : NBRE</li>
                                        <li class="list-group-item">Nombre de longueur : NBRE_LONG</li>
                                        <li class="list-group-item"><p>Déscription : </p><p>DESC Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
                                        </p></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <%-- TODO condition : propriétaire du spot --%>
                        <form class="form-inline pull-right" action="spot" method="post">
                            <a href="/ocscalade/spots/spot/voie/nouveau" class="btn btn-outline-success" role="button" style="margin-top: 10px" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-plus"></i> Nouvelle voie</a>
                        </form>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Nouvelle voie</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form>
                                                <div class="form-row">
                                                    <div class="form-group col-md-9">
                                                        <label for="nom">Nom</label>
                                                        <input type="text" class="form-control" id="nom" placeholder="nom">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="inputDep">Difficulté</label>
                                                        <select id="inputDep" class="form-control">
                                                            <option selected>Choose...</option>
                                                            <option>...</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="input-group mb-3">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="checkbox" aria-label="Checkbox for following text input">
                                                        </div>
                                                    </div>
                                                    <input type="text" class="form-control" aria-label="Text input with checkbox">
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <div class="form-check">
                                                            <label class="form-check-label" for="equipementCheck">Equipement</label>
                                                            <input class="form-check-input" type="checkbox" id="equipementCheck">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <label for="inputDescription">Description</label>
                                                    <textarea class="form-control" id="inputDescription" rows="6" placeholder="400 caractères maxi."></textarea>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr class="my-4">
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
