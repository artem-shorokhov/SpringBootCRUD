<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../style.css">
        <title>Schema tables</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    Schema tables
                </th>
            </tr>
            <c:forEach var="table" items="${tables}">
                <tr>
                    <td>
                        <a href="./tables/${table}"><c:out value="${table}"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
