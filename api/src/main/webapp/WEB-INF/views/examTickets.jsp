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
    <h2>Add new exam ticket</h2>
    <s:url var="currentUrl" value='' />
    <form action="${currentUrl}" method="post">
        <table>
            <tr>
                <td><label for="rank">Rank</label></td>
                <td>
                    <select id="rank" name="rank">
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="S">S</option>
                    </select>
                    <select id="questions" name="questionIds" multiple>
                        <c:forEach items="${questionList}" var="question">
                            <option value="${question.id}">${question.question}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit">
    </form>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Exam ticket
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${examTicketList}" var="examTicket">
            <div class="col-md-3 portfolio-item">
                <s:url value="/examTickets/${examTicket.id}" var="examTicketLink"/>
                <a href="${examTicketLink}">
                    <img class="img-responsive" src="./images/hero11.jpg" alt="">
                </a>
                <h3>
                    <a href="${examTicketLink}">${examTicket.rank}</a>
                </h3>
            </div>
        </c:forEach>
    </div>
    <s:url value="/examTickets" var="pagingLink"/>
    <%@ include file="/WEB-INF/views/fragments/paging.jspf"%>
    <div class="row">
        <div class="col-lg-12">
            <s:url value="/questions" var="questionsLink"/>
            <h3><a href="${questionsLink}">Add questions</a></h3>
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
<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>