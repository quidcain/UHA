<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="examTickets"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

<header>
    <div class="header-content">
    </div>
</header>
<div class="container">
    <h2>Add new question</h2>
    <s:url var="currentUrl" value='' />
    <form:form action="${currentUrl}" method="post" modelAttribute="form">
        <table>
            <tr>
                <td><form:label path="question">Question</form:label></td>
                <td>
                    <form:input path="question"/>
                </td>
            </tr>
        </table>
        <input type="submit">
    </form:form>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Question
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${questionList}" var="question">
            <div class="col-md-3 portfolio-item">
                <s:url value="/questions/${question.id}" var="questionLink"/>
                <a href="${questionLink}">
                    <img class="img-responsive" src="./images/hero11.jpg" alt="">
                </a>
                <h3>
                    <a href="${questionLink}">${question.question}</a>
                </h3>
            </div>
        </c:forEach>
    </div>
    <s:url value="/questions" var="pagingLink"/>
    <%@ include file="/WEB-INF/views/fragments/paging.jspf"%>
    <div class="row text-center">
        <div class="col-lg-12">
            <form method="get" action="<s:url value="/questions/csv"/>" style="display: inline-block">
                <button type="submit" class="btn btn-success">Csv</button>
            </form>
            <form method="get" action="<s:url value="/questions/xls"/>" style="display: inline-block">
                <button type="submit" class="btn btn-info">Excel</button>
            </form>
            <form method="get" action="<s:url value="/questions/pdf"/>" style="display: inline-block">
                <button type="submit" class="btn btn-warning">Pdf</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>