<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="clans"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

<header>
    <div class="header-content">
    </div>
</header>
<div class="container">
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
            <tr>
                <td>Eptituders</td>
                <td>
                    <select id="eptituders" name="eptituderIds" multiple>
                        <c:forEach items="${eptituderList}" var="eptituder">
                            <option value="${eptituder.id}">${eptituder.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit">
    </form:form>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Clan
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${clanList}" var="clan">
            <div class="col-md-3 portfolio-item">
                <s:url value="/clans/${clan.id}" var="clanLink"/>
                <a href="${clanLink}">
                    <img class="img-responsive" src="./images/hero11.jpg" alt="">
                </a>
                <h3>
                    <a href="${clanLink}">${clan.name}</a>
                </h3>
            </div>
        </c:forEach>
    </div>
    <s:url value="/clans" var="pagingLink"/>
    <%@ include file="/WEB-INF/views/fragments/paging.jspf"%>
    <div class="row text-center">
        <div class="col-lg-12">
            <form method="get" action="<s:url value="/${pageName}/csv"/>" style="display: inline-block">
                <button type="submit" class="btn btn-success">Csv</button>
            </form>
            <form method="get" action="<s:url value="/${pageName}/xls"/>" style="display: inline-block">
                <button type="submit" class="btn btn-info">Excel</button>
            </form>
            <form method="get" action="<s:url value="/${pageName}/pdf"/>" style="display: inline-block">
            <button type="submit" class="btn btn-warning">Pdf</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>
