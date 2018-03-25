<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="clans"/>
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
            <s:url var="back" value="/clans" />
            <h2><a href="${back}">&larr;</a> Update the clan</h2>
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
                        <td><form:label path="description">Description</form:label></td>
                        <td><form:textarea path="description"></form:textarea></td>
                        <td><form:errors path="description" cssStyle="color: red;"/></td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="update">
                <input type="submit">
            </form:form>
        </div>
        <div class="col-md-3 portfolio-item">
            <h2>Clan</h2>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Side</th>
                    <th>Eptituders</th>
                </tr>
                <tr>
                    <td>${clan.name}</td>
                    <td>${clan.side}</td>
                    <td>
                        <c:forEach var="eptituder" items="${clan.eptituders}">
                            <s:url value="/eptituders/${eptituder.id}" var="eptituderLink"/>
                            <a href="${eptituderLink}">${eptituder.name}</a> &nbsp;
                        </c:forEach>
                    </td>
                </tr>
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