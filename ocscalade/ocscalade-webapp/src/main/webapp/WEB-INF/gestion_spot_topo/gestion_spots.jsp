<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 30/08/2019
  Time: 22:35
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
    <title>Gestion des spots</title>
</head>

<body>

<%-- HEADER --%>
<%@ include file="/WEB-INF/header_footer/header.jsp" %>

<%-- BODY --%>

<div class="container">
    <div class="jumbotron" style="margin-top: 10px;">
        <h1 class="display-4"><strong>Gestion des spots</strong></h1>
    </div>

    <hr class="my-4">

    <div class="mes_topos table-responsive">
        <h3 class="text-center"><strong>Les spots</strong></h3>
        <table class="table table-hover  table-sm">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Nom</th>
                <th scope="col">Officiel</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${sessionScope.utilisateur.privilege.id > 1}">
                <c:forEach items="${vListSpots}" var="spot">
                    <tr>
                        <form action="spots/spot" method="post">
                            <input type="hidden" name="idSpot" value="${spot.id}"/>
                            <td class="link-td-btn"><input class="link link-btn" type="submit" name="idSpot" value="${spot.nom}"/></td>
                        </form>
                        <form action="gestion" method="post">
                            <input type="hidden" name="idSpot" value="${spot.id}"/>
                            <td>
                                <div class="custom-control custom-switch">

                                    <c:choose>
                                        <c:when test="${spot.officiel}">
                                            <input type="checkbox" class="custom-control-input" name="spot_officiel" id="customSwitch${spot.id}" checked>
                                            <label class="custom-control-label" for="customSwitch${spot.id}"></label>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="checkbox" class="custom-control-input" name="spot_officiel" id="customSwitch${spot.id}">
                                            <label class="custom-control-label" for="customSwitch${spot.id}"></label>
                                        </c:otherwise>
                                    </c:choose>
                                    <input type="hidden" name="idSpot" value="${spot.id}"/>
                                </div>
                            </td>
                            <td>
                                <div class="form-inline pull-right">
                                    <input type="submit" class="btn_form btn btn-outline-success btn-sm" name="_spot_officiel_" role="button" value="Enregistrer">
                                </div>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </c:if>
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
