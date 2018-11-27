<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

    <title>Lista Firm</title>
</head>
<body class="bg-secondary">
<div class="container">
    <table class="table table-dark">
        <thead>
        <tr>
            <th class="text-center" scope="col">Nazwa Firmy</th>
            <th class="text-center" scope="col">NIP</th>
            <th class="text-center" scope="col">Numer Konta</th>
            <th class="text-center" scope="col">Adres</th>
            <th class="text-center" scope="col">Edytuj/Usun</th>
        </tr>
        </thead>

        <c:forEach var="company" items="${companies}">

            <c:url var="updateCompany" value="/updateCompany">
                <c:param name="id" value="${company.id}" />
            </c:url>

            <c:url var="deleteCompany" value="/deleteCompany">
                <c:param name="id" value="${company.id}" />
            </c:url>

            <tbody>
            <tr >
                <td class="text-center">${company.name}</td>
                <td class="text-center">${company.vatID}</td>
                <td class="text-center">${company.accountNumber}</td>
                <td class="text-center">${company.fullAdderss}</td>
                <td class="text-center">
                    <a class="btn btn-link text-warning" href="${updateCompany}">Edytuj</a>
                    <a class="btn btn-link text-danger" href="${deleteCompany}">Usun</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>

    <div>
        <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
        <input class="btn btn-light rounded-0" type="button" value="Klienci" onclick="window.location.href='customers'" />
        <input class="btn btn-light rounded-0" type="button" value="Faktury" onclick="window.location.href='invoiceList'" />
    </div>
</div>
</body>
</html>
