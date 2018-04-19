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

<%@ include file="/WEB-INF/views/fragments/footer.jspf"%>