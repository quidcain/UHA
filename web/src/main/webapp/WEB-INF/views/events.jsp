<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Events</title>
</head>
<body>
<h2>Add new event</h2>
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
    <input type="submit">
</form:form>
<h2>Events</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${eventList}" var="event">
        <tr>
            <s:url value="/events/${event.id}" var="eventLink"/>
            <td><a href="${eventLink}">${event.name}</a></td>
            <td>${event.date}</td>
            <td>${event.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
