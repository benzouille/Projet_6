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
        <h1 class="display-4"><strong>Spot</strong></h1>
    </div>
    <div>
        <h1 class="text-center"><strong>Titre du spot</strong></h1>
        <hr class="my-4">
    </div>
    <%--CAROUSSEL--%>
    <div class="information row">
        <div class="photo col-lg-5">
            <div class="row">
            <div class="big_photo col-lg-12">
                <img class="img_spot img-fluid" src="https://zupimages.net/up/19/27/mlvw.jpg">
            </div>
            <div class="mini_photo row">
                <div class="col-lg-4">
                    <img class="img_spot img-fluid" src="https://zupimages.net/up/19/27/mlvw.jpg">
                </div>
                <div class="col-lg-4">
                    <img class="img_spot img-fluid" src="https://zupimages.net/up/19/27/mlvw.jpg">
                </div>
                <div class="col-lg-4">
                    <img class="img_spot img-fluid" src="https://zupimages.net/up/19/27/mlvw.jpg">
                </div>
            </div>
            </div>
        </div>
        <div class="describe col-lg-7">
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
    </div>
    <hr class="my-4">
    <div class="secteur_list">
        <h5 class="text-center"><strong>Liste des secteurs</strong></h5>
        <div class="secteur_list_1 col-lg-6">
            <ul>
                <li>
                   test
                </li>
                <li>
                    test
                </li>
                <li>
                    test
                </li>
                <li>
                    test
                </li>
            </ul>
        </div>
        <div class="secteur_list_2 col-lg-6">
            <ul>
                <li>
                    test
                </li>
                <li>
                    test
                </li>
                <li>
                    test
                </li>
                <li>
                    test
                </li>
            </ul>
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
