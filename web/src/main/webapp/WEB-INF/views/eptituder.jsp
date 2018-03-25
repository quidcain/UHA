<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="eptituders"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Eptituder
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <s:url var="back" value="/eptituders" />
            <h2><a href="${back}">&larr;</a> Update the eptituder</h2>
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
                <input type="hidden" name="action" value="update">
                <input type="submit" class="btn btn-primary">
            </form:form>
        </div>
        <div class="col-md-3 portfolio-item">
            <h2>Eptituder</h2>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Side</th>
                    <th>Clan</th>
                </tr>
                <tr>
                    <s:url value="/clans/${eptituder.clan.id}" var="clanLink"/>
                    <td>${eptituder.name}</td>
                    <td>${eptituder.side}</td>
                    <td><a href="${clanLink}">${eptituder.clan.name}</a></td>
                </tr>
            </table>
            <form action="${currentUrl}" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="submit" class="btn btn-danger" value="Delete">
            </form>
            <table>
                <tr>
                    <th>Eptituder's events</th>
                </tr>
                <c:forEach items="${eptituder.events}" var="event">
                    <tr>
                        <s:url value="/events/${event.id}" var="eventLink"/>
                        <td><a href="${eventLink}">${event.name}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<footer class="page-footer">
    <div class="container">
        <p><span class="glyphicon glyphicon-globe"></span>  Yasen' Bloodislav Danikman  <span class="glyphicon glyphicon-globe"></span>
    </div>
</footer>
<script src="<s:url value='/resources/js/jquery-1.11.3.min.js'/>"></script>
<script src="<s:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>
