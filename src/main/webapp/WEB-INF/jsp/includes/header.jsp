<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>


<%--HEADER--%>

<html>
    <head>

        <%--VIEWPORT--%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%--JQuery--%>
        <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery" />
            <script src="${jquery}"></script>


        <%--Bootstrap--%>
        <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.min.js" var="bootstrapJS" />
            <script src="${bootstrapJS}"></script>

        <%--<c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrapCSS" />--%>
            <%--<link href="${bootstrapCSS}" rel="stylesheet" media="screen" />--%>

        <c:url value="/static/css/bootswatch_paper.css" var="bootstrapCSS" />
            <link href="${bootstrapCSS}" rel="stylesheet" media="screen" />

        <%--custom JS--%>
        <c:url value="/static/js/common.js" var="common" />
            <script src="${common}"></script>

        <%--customCSS--%>
        <c:url value="/static/css/astonengineer.css" var="bootstrapCUSTOM" />
            <link href="${bootstrapCUSTOM}" rel="stylesheet" media="screen">

        <title>Aston Tech HR Application</title>
    </head>

    <body>


