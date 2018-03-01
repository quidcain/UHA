<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Add new eptituder</h2>
    <s:url var="currentUrl" value='' />
    <form:form action="${currentUrl}" method="post" modelAttribute="form">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Side</form:label></td>
                <td>
                    <form:select path="side">
                        <form:option value="good"/>
                        <form:option value="evil"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="eptitudes">Eptitudes</form:label></td>
                <td><form:textarea path="eptitudes"></form:textarea></td>
            </tr>
            <tr>
                <td><form:label path="bio">Biograpy</form:label></td>
                <td><form:textarea path="bio"></form:textarea></td>
                <td><form:errors path="bio" cssStyle="color: red;"/></td>
            </tr>
        </table>
        <input type="submit">
    </form:form>
    <h2>Eptituders</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Side</th>
            <th>Clan</th>
        </tr>
        <c:forEach items="${eptituderList}" var="eptituder">
            <tr>
                <s:url value="/eptituders/${eptituder.id}" var="eptituderLink"/>
                <td><a href="${eptituderLink}">${eptituder.name}</a></td>
                <td>${eptituder.side}</td>
                <td>${eptituder.clan.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
