<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="span" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="label" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <title>Nowa Firma</title>
    </head>
    <body class="bg-secondary">
        <div class="container">
            <form:form action="saveCompany" modelAttribute="company" method="POST">
                <form:hidden path="id" />

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nazwa Firmy</label>
                        <form:input path="name" type="text" class="form-control" placeholder="Nazwwa firmy" />
                        <label:errors path="name" class="text-danger" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Adres</label>
                        <form:input path="fullAdderss" type="text" class="form-control" placeholder="przykład: Ulica 00, 00-000 Miasto" />
                        <label:errors path="fullAdderss" class="text-danger" />
                    </div>
                </div>
                <div class="form-group">
                    <label>NIP</label>
                    <form:input path="vatID" type="text" class="form-control" placeholder="NIP" />
                    <label:errors path="vatID" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Numer Konta Bankowego</label>
                    <form:input path="accountNumber" type="text" class="form-control" placeholder="00 0000 0000 0000 0000 0000" />
                    <label:errors path="accountNumber" class="text-danger" />
                </div>

                <button type="submit" class="btn btn-primary rounded-0">Dodaj</button>

                <%--<div class="input-group">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text rounded-0">Nazwa firmy</span>--%>
                    <%--</div>--%>
                    <%--<form:input path="name" type="text" class="form-control rounded-0"/>--%>
                    <%--<span:errors path="name" class="text-danger" />--%>
                <%--</div>--%>
                <%--<div class="input-group">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text rounded-0">Adres</span>--%>
                    <%--</div>--%>
                    <%--<form:input path="fullAdderss" placeholder="przykład: Ulica 00, 00-000 Miasto" type="text" class="form-control rounded-0"/>--%>
                    <%--<span:errors path="fullAdderss" class="text-danger" />--%>
                <%--</div>--%>
                <%--<div class="input-group">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text rounded-0">NIP</span>--%>
                    <%--</div>--%>
                    <%--<form:input path="vatID" type="text" class="form-control rounded-0"/>--%>
                    <%--<span:errors path="vatID" class="text-danger" />--%>
                <%--</div>--%>
                <%--<div class="input-group">--%>
                    <%--<div class="input-group-prepend">--%>
                        <%--<span class="input-group-text rounded-0">Numer Konta Bankowego</span>--%>
                    <%--</div>--%>
                    <%--<form:input  path="accountNumber" placeholder="00 0000 0000 0000 0000 0000" type="text" class="form-control rounded-0"/>--%>
                    <%--<span:errors path="accountNumber" class="text-danger" />--%>
                <%--</div>--%>

                <%--<button class="btn btn-success rounded-0" type="submit">Gotowe</button>--%>

            </form:form>
            <div>
                <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
                <input class="btn btn-light rounded-0" type="button" value="Nowy Klient" onclick="window.location.href='newCustomer'" />
                <input class="btn btn-light rounded-0" type="button" value="Strworz fakture" onclick="window.location.href='newInvoice'" />
            </div>
        </div>
    </body>
</html>