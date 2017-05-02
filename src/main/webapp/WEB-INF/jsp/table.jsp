<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../style.css">
        <title>${table}</title>
    </head>
    <body>
        <table>
            <tr>
                <c:forEach var="column" items="${columns}">
                    <th>
                        <c:out value="${column}"/>
                    </th>
                </c:forEach>
            </tr>
            <c:forEach var="row" items="${rows}">
                <tr>
                    <c:forEach var="cell" items="${row}">
                        <td>
                            <c:out value="${cell}"/>
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
