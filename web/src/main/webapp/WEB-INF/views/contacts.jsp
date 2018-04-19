<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="pageName" value="contacts"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

    <header>
        <div class="header-content"> 
        </div>
    </header>
	<div class="contact">
        <div class="container">
            <h2 class="section-heading">Contact Us</h2>
            <p><span class="glyphicon glyphicon-earphone"></span><br> 911 </p>
            <p><span class="glyphicon glyphicon-envelope"></span><br> UHATeam@gmail.com </p>
        </div>
    </div>
    <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?um=constructor%3A3f66f056c5cde91b16c63d9d19f20d34d0bf867a0b2b8688bb69609f68c930b8&amp;width=100%25&amp;height=400&amp;lang=ru_RU&amp;scroll=true"></script>

<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>