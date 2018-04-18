<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="events"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

<header>
    <div class="header-content">
    </div>
</header>
<div class="container">
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
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Eptituder
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${eventList}" var="event">
            <div class="col-md-3 portfolio-item">
                <s:url value="/events/${event.id}" var="eventLink"/>
                <a href="${eventLink}">
                    <img class="img-responsive" src="./images/hero11.jpg" alt="">
                </a>
                <h3>
                    <a href="${eventLink}">${event.name}</a>
                </h3>
            </div>
        </c:forEach>
    </div>
    <div class="row text-center">
        <div class="col-lg-12">
            <ul class="pagination">
                <li>
                    <a href="#">&laquo;</a>
                </li>
                <li class="active">
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>
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
<footer class="page-footer">
    <div class="container">
        <p><span class="glyphicon glyphicon-globe"></span>  Yasen' Bloodislav Danikman  <span class="glyphicon glyphicon-globe"></span>
    </div>
</footer>
<script src="<s:url value='/resources/js/jquery-1.11.3.min.js'/>"></script>
<script src="<s:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>