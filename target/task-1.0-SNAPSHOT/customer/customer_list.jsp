<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <title>Lista Klientow</title>
    </head>
    <body class="bg-secondary">
    <div class="container">
        <table class="table table-dark">
            <thead>
            <tr>
                <th class="text-center" scope="col">Imie</th>
                <th class="text-center" scope="col">Nazwisko</th>
                <th class="text-center" scope="col">PESEL</th>
                <th class="text-center" scope="col">Adres</th>
                <th class="text-center" scope="col">Edytuj/Usun</th>
            </tr>
            </thead>

            <c:forEach var="customer" items="${customers}">

                <c:url var="updateCustomer" value="/updateCustomer">
                    <c:param name="id" value="${customer.id}" />
                </c:url>

                <c:url var="deleteCustomer" value="/deleteCustomer">
                    <c:param name="id" value="${customer.id}" />
                </c:url>

                <tbody>
                <tr >
                    <td class="text-center">${customer.name}</td>
                    <td class="text-center">${customer.lastName}</td>
                    <td class="text-center">${customer.peselId}</td>
                    <td class="text-center">${customer.fullAdderss}</td>
                    <td class="text-center">
                        <a class="btn btn-link text-warning" href="${updateCustomer}">Edytuj</a>
                        <a class="btn btn-link text-danger" href="${deleteCustomer}">Usun</a>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>

        <div>
            <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
            <input class="btn btn-light rounded-0" type="button" value="Firmy" onclick="window.location.href='companies'" />
            <input class="btn btn-light rounded-0" type="button" value="Faktury" onclick="window.location.href='invoiceList'" />
        </div>
    </div>
    </body>
</html>
