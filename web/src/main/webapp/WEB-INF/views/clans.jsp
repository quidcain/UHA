<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Clans</title>
</head>
<body>
<h2>Add new clan</h2>
<s:url var="currentUrl" value='' />
<form:form action="${currentUrl}" method="post" modelAttribute="form">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="side">Side</form:label></td>
            <td>
                <form:select path="side">
                    <form:option value="good"/>
                    <form:option value="evil"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:textarea path="description"></form:textarea></td>
            <td><form:errors path="description" cssStyle="color: red;"/></td>
        </tr>
    </table>
    <input type="submit">
</form:form>
<h2>Clans</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Side</th>
    </tr>
    <c:forEach items="${clanList}" var="clan">
        <tr>
            <s:url value="/clans/${clan.id}" var="clanLink"/>
            <td><a href="${clanLink}">${clan.name}</a></td>
            <td>${clan.side}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
