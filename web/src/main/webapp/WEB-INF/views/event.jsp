<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Event</title>
</head>
<body>
<s:url var="back" value="/events" />
<h2><a href="${back}">&larr;</a> Update the event</h2>
<s:url var="currentUrl" value='' />
<form:form action="${currentUrl}" method="post" modelAttribute="form">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:textarea path="description"></form:textarea></td>
            <td><form:errors path="description" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="date">Date(YYYY-MM-DD)</form:label></td>
            <td><form:input path="date"/></td>
            <td><form:errors path="date" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="status">Status</form:label></td>
            <td>
                <form:select path="status">
                    <form:option value="opened"/>
                    <form:option value="finished"/>
                </form:select>
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="update">
    <input type="submit">
</form:form>
<h2>Event</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Date</th>
        <th>Status</th>
    </tr>
    <tr>
        <td>${event.name}</td>
        <td>${event.description}</td>
        <td>${event.date}</td>
        <td>${event.status}</td>
    </tr>
</table>
<form action="${currentUrl}" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="submit" value="Delete">
</form>
<table>
    <tr>
        <th>Event's eptituders</th>
    </tr>
    <c:forEach items="${event.eptituders}" var="eptituder">
        <tr>
            <s:url value="/eptituders/${eptituder.id}" var="eptituderLink"/>
            <td><a href="${eptituderLink}">${eptituder.name}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
