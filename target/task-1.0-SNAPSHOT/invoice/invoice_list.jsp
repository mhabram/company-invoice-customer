<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">

        <title>Lista Faktur</title>
    </head>
    <body class="bg-secondary">
        <div class="container">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th class="text-center" scope="col">Numer Fakruty</th>
                    </tr>
                </thead>

                <c:forEach var="invoice" items="${invoices}">

                    <c:url var="showInvoice" value="/invoice">
                        <c:param name="id" value="${invoice.id}" />
                    </c:url>

                    <tbody>
                        <tr >
                            <td class="text-center">
                                <a class="btn btn-link text-light" href="${showInvoice}">${invoice.id}/${invoice.issueDate.substring(6)}</a>
                             </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>

            <div>
                <input class="btn btn-light rounded-0" type="button" value="Strona Domowa" onclick="window.location.href='/'" />
                <input class="btn btn-light rounded-0" type="button" value="Klienci" onclick="window.location.href='customers'" />
                <input class="btn btn-light rounded-0" type="button" value="Firmy" onclick="window.location.href='companies'" />
            </div>
        </div>
    </body>
</html>
