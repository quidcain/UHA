<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pageName" value="examTickets"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Question
                <small>List</small>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="jumbotron">
            <s:url var="back" value="/questions" />
            <h2><a href="${back}">&larr;</a> Update the Question</h2>
            <s:url var="currentUrl" value='' />
            <form:form action="${currentUrl}" method="post" modelAttribute="form">
                <table>
                    <tr>
                        <td><form:label path="question">Question</form:label></td>
                        <td><form:input path="question"/></td>
                        <td><form:errors path="question" cssStyle="color: red;"/></td>
                    </tr>
                </table>
                <input type="hidden" name="action" value="update">
                <input type="submit" class="btn btn-primary">
            </form:form>
        </div>
        <div class="col-md-3 portfolio-item">
            <h2>Event</h2>
            <table>
                <tr>
                    <th>Question</th>
                </tr>
                <tr>
                    <td>${question.question}</td>
                </tr>
            </table>
            <form action="${currentUrl}" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="submit" class="btn btn-danger" value="Delete">
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