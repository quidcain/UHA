<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="pageName" value="index"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

    <header>
        <div class="header-content"> 
        </div>
    </header>
	<div class="container-fluid" id="">
        <div class="row promo" >
        	<a href="./products.html">
				<div class="col-md-4 promo-item item-1">
				</div>
            </a>
            <a href="./products.html">
				<div class="col-md-4 promo-item item-2">
				</div>
            </a>
			<a href="./products.html">
				<div class="col-md-4 promo-item item-3">
				</div>
            </a>
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