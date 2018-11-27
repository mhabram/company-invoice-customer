<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossorigin="anonymous">

        <title>Strona Domowa Mateusz Habram - Faktury</title>
    </head>
    <body class="bg-secondary">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <h2>
                        <span class="font-weight-bold">Strona Domowa Mateusz Habram - Faktury</span>
                    </h2>
                </div>
            </div>

            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='customers'; return false;">Klienci</button>
                </div>
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='companies'; return false;">Firmy</button>
                </div>
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='invoiceList'; return false;">Faktury</button>
                </div>
            </div>

            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='newCustomer'; return false;">Dodaj klienta</button>
                </div>
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='newCompany'; return false;">Dodaj firme</button>
                </div>
                <div class="col-md-auto">
                    <button type="button" class="btn btn-link text-light" onclick="window.location.href='newInvoice'; return false;">Nowa faktura</button>
                </div>
            </div>
        </div>

    </body>
</html>
