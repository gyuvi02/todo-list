<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.gyula.util.Mappings" %>

<html>
<head>
    <title>Item details</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">

            <caption><h2>Item details</h2></caption>

            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Details</th>
                <th>Deadline</th>
            </tr>
            <tr>
                <th>
                    <c:out value="${todoItem.id}"/>
                </th>
                <th>
                    <c:out value="${todoItem.title}"/>
                </th>
                <th>
                    <c:out value="${todoItem.details}"/>
                </th>
                <th>
                    <c:out value="${todoItem.deadline}"/>
                </th>
            </tr>

        </table>
        <c:url var="addUrl" value="${Mappings.ITEMS}"/>
        <a href="${addUrl}">Back to the item list</a>

    </div>
</body>
</html>