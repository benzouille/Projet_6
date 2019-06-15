<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 11/06/2019
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <%--<link rel="stylesheet" href="css/index.css"/>--%>
    <link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>Test</title>
</head>
<body>
<%@ include file="header_footer/header.jsp" %>
<div class="container">
    <p>test</p>
    <p>test</p>
    <p>test</p>
    <p>test</p>
    <p>test</p>

    <h1>DEPARTEMENT</h1>

    <div class="container">
        <form class="row" method="post" action="test">
            <div class="form-group" >
                <label for="id_trad" class="col-lg-4 control-label">Selectionner le département </label>
                <div class="col-lg-4">
                    <select id="id_trad" name="id_departement" class="form-control" >
                        <c:forEach items="${departements}" var="departement">
                            <option value="${departement.id}"><c:out value="${departement.nom}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <input class="btn" type="submit" name="_ok_" value="OK" action="test">
            </div>
        </form>
        <form class="row">
            <label class="col-lg-4 control-label">Département sélectionné : </label>
            <label class="col-lg-4 control-label"><c:out value="${departement.num}" /></label>
        </form>
    </div>
    <p>test</p>
    <p>test</p>
    <p>test</p>
    <p>test</p>
    <p>test</p>
    <p>test</p>

</div>

<!-- SCRIPTS -->
<script src="bundle.js"></script>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
        crossorigin="anonymous">
</script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        crossorigin="anonymous"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa">
</script>

</body>
</html>
