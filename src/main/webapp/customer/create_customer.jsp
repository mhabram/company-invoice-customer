<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

    <title>Nowy Klient</title>
</head>
<body class="bg-secondary">
<div class="container">
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <form:hidden path="id" />

        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Imię</label>
                <form:input path="name" type="text" class="form-control" placeholder="Imię" />
                <label:errors path="name" class="text-danger" />
            </div>
            <div class="form-group col-md-6">
                <label>Nazwisko</label>
                <form:input path="lastName" type="text" class="form-control" placeholder="Nazwisko" />
                <label:errors path="lastName" class="text-danger" />
            </div>
        </div>
        <div class="form-group">
            <label>Adres</label>
            <form:input path="fullAdderss" type="text" class="form-control" placeholder="przykład: Ulica 00, 00-000 Miasto" />
            <label:errors path="fullAdderss" class="text-danger" />
        </div>
        <div class="form-group">
            <label>PESEL</label>
            <form:input path="peselId" type="text" class="form-control" placeholder="PESEL" />
            <label:errors path="peselId" class="text-danger" />
        </div>

        <button type="submit" class="btn btn-primary rounded-0">Dodaj</button>

        <%--<div class="input-group">--%>
            <%--<div class="input-group-prepend">--%>
                <%--<span class="input-group-text">Imie</span>--%>
            <%--</div>--%>
            <%--<form:input path="name" type="text" class="form-control"/>--%>
            <%--<form:errors path="name" />--%>

            <%--<div class="input-group-prepend">--%>
                <%--<span class="input-group-text">Nazwisko</span>--%>
            <%--</div>--%>
            <%--<form:input path="lastName" type="text" class="form-control"/>--%>
            <%--<form:errors path="lastName" />--%>
        <%--</div>--%>
        <%--<div class="input-group">--%>
            <%--<div class="input-group-prepend">--%>
                <%--<span class="input-group-text">PESEL</span>--%>
            <%--</div>--%>
            <%--<form:input  path="peselId" type="text" class="form-control"/>--%>
            <%--<form:errors path="peselId" />--%>
        <%--</div>--%>
        <%--<div class="input-group">--%>
            <%--<div class="input-group-prepend">--%>
                <%--<span class="input-group-text">Adres</span>--%>
            <%--</div>--%>
            <%--<form:input path="fullAdderss" placeholder="przykład: Ulica 00, 00-000 Miasto" type="text" class="form-control"/>--%>
            <%--<form:errors path="fullAdderss" />--%>
        <%--</div>--%>
        <%--<div class="input-group">--%>
        <%--</div>--%>

        <%--<button class="btn btn-success" type="submit">Gotowe</button>--%>
    </form:form>
    <div>
        <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
        <input class="btn btn-light rounded-0" type="button" value="Nowa Firma" onclick="window.location.href='newCompany'" />
        <input class="btn btn-light rounded-0" type="button" value="Strworz fakture" onclick="window.location.href='newInvoice'" />
    </div>
</div>
</body>
</html>