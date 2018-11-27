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

    <title>Nowa Faktura</title>
</head>
<body class="bg-secondary">
<div class="container">
    <form:form action="saveInvoice" modelAttribute="invoice" method="POST">
        <form:hidden path="id" />

        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Data wydania</label>
                <form:input path="issueDate" type="text" class="form-control" placeholder="dd-mm-rrrr" />
                <label:errors path="issueDate" class="text-danger" />
            </div>
            <div class="form-group col-md-4">
                <label>Data zakończenia</label>
                <form:input path="endDate" type="text" class="form-control" placeholder="dd-mm-rrrr" />
                <label:errors path="endDate" class="text-danger" />
            </div>
            <div class="form-group col-md-4">
                <label>Termin</label>
                <form:input path="dueDate" type="text" class="form-control" placeholder="dd-mm-rrrr" />
                <label:errors path="dueDate" class="text-danger" />
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Produkt/Usługa</label>
                <form:input path="subject" type="text" class="form-control" placeholder="Produkt/Usługa" />
                <label:errors path="subject" class="text-danger" />
            </div>
            <div class="form-group col-md-6">
                <label>Ilość</label>
                <form:input path="quantity" type="text" class="form-control" placeholder="np. 4" />
                <label:errors path="quantity" class="text-danger" />
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Wartość Netto</label>
                <form:input path="netValue" type="text" class="form-control" placeholder="Cena usługi" />
                <label:errors path="netValue" class="text-danger" />
            </div>
            <div class="form-group col-md-6">
                <label>Wysokość podatku</label>
                <form:input path="taxRate" type="text" class="form-control" placeholder="Podatek w %" />
                <label:errors path="taxRate" class="text-danger" />
            </div>
        </div>
        <div class="form-group">
            <label>Uwagi</label>
            <form:input path="comments" type="text" class="form-control" placeholder="Uwagi" />
            <label:errors path="comments" class="text-danger" />
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>PESEL Klienta</label>
                <form:input path="customer.peselId" type="text" class="form-control" placeholder="PESEL" />
                <label:errors path="customer.peselId" class="text-danger" />
            </div>
            <div class="form-group col-md-6">
                <label>NIP Firmy</label>
                <form:input path="company.vatID" type="text" class="form-control" placeholder="NIP" />
                <label:errors path="company.vatID" class="text-danger" />
            </div>
        </div>

        <button type="submit" class="btn btn-primary rounded-0">Dodaj</button>

    </form:form>
    <div>
        <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
        <input class="btn btn-light rounded-0" type="button" value="Nowy Klient" onclick="window.location.href='newCustomer'" />
        <input class="btn btn-light rounded-0" type="button" value="Nowa Firma" onclick="window.location.href='newCompany'" />
    </div>
</div>
</body>
</html>