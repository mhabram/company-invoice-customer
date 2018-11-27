<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

    <title>Faktura</title>
</head>
<body class="bg-dark">

<c:url var="updateInvoice" value="/updateInvoice">
    <c:param name="id" value="${invoice.id}"/>
</c:url>

<c:url var="deleteInvoice" value="/deleteInvoice">
    <c:param name="id" value="${invoice.id}"/>
</c:url>

<div class="container text-light">
    <div class="container border mt-3 bg-secondary">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <h2>
                    <span class="font-weight-bold ">Faktura Nr ${invoice.id}/${invoice.issueDate.substring(6)}</span>
                </h2>
            </div>
        </div>

        <div class="row justify-content-md-center mt-2">
            <span>informacje szczególne</span>
        </div>

        <div class="row justify-content-around border m-2 pb-2">
            <div class="col-md-auto">
                <span class="text-light mb-1">Sprzedawca:</span>
                <div class="border p-4">
                    <div>
                        <span class="text-light mt-1">${invoice.company.name}</span>
                    </div>
                    <div>
                        <span>ul. ${invoice.company.fullAdderss}</span>
                    </div>
                    <div>
                        <span>NIP ${invoice.company.vatID}</span>
                    </div>
                </div>
            </div>
            <div class="col-md-auto">
                <span class="text-light center mb-1">Nabywca:</span>
                <div class="border p-4">
                    <div>
                        <span>${invoice.customer.name} ${invoice.customer.lastName}</span>
                    </div>
                    <div>
                        <span>ul. ${invoice.customer.fullAdderss}</span>
                    </div>
                    <div>
                        <span>PESEL ${invoice.customer.peselId}</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <div class="row">
                    <div class="col">
                        <span>Data zakończenia dostawy towaru/ wykonania usugi:</span>
                    </div>
                    <div class="col">
                        <span>${invoice.endDate}</span>
                    </div>
                </div>

                <hr/>

                <div class="row">
                    <div class="col">
                        <span>Data wystawienia:</span>
                    </div>
                    <div class="col">
                        <span>${invoice.issueDate}</span>
                    </div>
                </div>

                <hr/>

                <div class="row">
                    <div class="col">
                        <span>Termin płatności:</span>
                    </div>
                    <div class="col">
                        <span>przelew</span>
                    </div>
                </div>

                <hr/>

                <div class="row">
                    <div class="col">
                        <span>Nr konta bankowego:</span>
                    </div>
                    <div class="col">
                        <span>${invoice.company.accountNumber}</span>
                    </div>
                </div>

                <hr/>

                <div class="row">
                    <div class="col">
                        <span>Uwagi:</span>
                    </div>
                    <div class="col">
                        <span>${invoice.comments}</span>
                    </div>
                </div>

                <hr/>

                <div class="row">
                    <div class="col">
                        <span>Podstawa prawna zwolnienia:</span>
                    </div>
                    <div class="col">
                        <span>art. 43 ust. 1 pkt 2 ustawy o VAT</span>
                    </div>
                </div>
            </div>
        </div>

        <table class="table table-bordered text-white">
            <thead>
            <tr>
                <th scope="col">L.p.</th>
                <th scope="col">Nazwa towaru/usługi</th>
                <th scope="col">ilość</th>
                <th scope="col">J.m.</th>
                <th scope="col">Stawka VAT</th>
                <th scope="col">Cena jedn. netto</th>
                <th scope="col">Wartość netto</th>
                <th scope="col">Podatek VAT</th>
                <th scope="col">Wartość Brutto</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>${invoice.subject}</td>
                <td>${invoice.quantity}</td>
                <td>szt.</td>
                <td>${invoice.taxRate}%</td>
                <td>${invoice.netValue}</td>
                <td>${nettoAmount}</td>
                <td>${vatTax}</td>
                <td>${grossValue}</td>
            </tr>
            </tbody>
        </table>

        <span class="text-light center"> w tym </span>
        <table class="table table-bordered text-white">
            <thead>
            <tr>
                <th scope="col">Stawka VAT</th>
                <th scope="col">Wartość netto</th>
                <th scope="col">Podatek VAT</th>
                <th scope="col">Wartość Brutto</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${invoice.taxRate}%</td>
                <td>${nettoAmount}</td>
                <td>${vatTax}</td>
                <td>${grossValue}</td>
            </tr>
            <tr>
                <td>ZW</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
            </tr>
            <tr>
                <td>NP</td>
                <td>0</td>
                <td>0</td>
                <td>0</td>
            </tr>
            </tbody>
        </table>

        <div class="row justify-content-end">
            <div class="col-4 mb-2">
                <strong>Do zapłaty: </strong>
                <strong>${grossValue}</strong>
                <div>
                    <span>Słownie: </span>
                    <span>${inWorlds}</span>
                </div>
            </div>
        </div>
    </div>

    <div class="row justify-content-between mt-3">
        <div class="col-4">
            <input class="btn btn-light rounded-0" type="button" value="Strona Domowa"
                   onclick="window.location.href='/'"/>
            <input class="btn btn-light rounded-0" type="button" value="Klienci"
                   onclick="window.location.href='customers'"/>
            <input class="btn btn-light rounded-0" type="button" value="Firmy"
                   onclick="window.location.href='companies'"/>
        </div>
        <div class="col-4">
            <a class="btn btn-danger rounded-0" href="${deleteInvoice}"
               onclick="if(!(confirm('Czy na pewno chcesz usunąć Fakture?'))) return false">Usun</a>
            <a class="btn btn-warning rounded-0" href="${updateInvoice}">Edytuj</a>
        </div>
    </div>
</div>
</body>
</html>
