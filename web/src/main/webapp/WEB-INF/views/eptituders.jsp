<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UHA Team</title>
    <link href="<s:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/custom_heroes.css'/>" rel="stylesheet">
</head>
<body>
    <nav id="siteNav" class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                	<span class="glyphicon glyphicon-th"></span> 
                	UHA Team
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="./index.html">Home</a>
                    </li>
                    <li>
                        <a href="#">Heroes</a>
                    </li>
					<li>
                        <a href="./contacts.html">Contact</a>
                    </li>
                    <li>
                        <a href="./sign_up.html">Sign up / Sign in</a>
                    </li>
                </ul>
                
            </div>
        </div>
    </nav>
    <header>
        <div class="header-content"> 
        </div>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Heroes
                    <small>List</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${eptituderList}" var="eptituder">
            <div class="col-md-3 portfolio-item">
                <s:url value="/eptituders/${eptituder.id}" var="eptituderLink"/>
                <s:url value="/clans/${eptituder.clan.id}" var="clanLink"/>
                <a href="${eptituderLink}">
                    <img class="img-responsive" src="./images/hero11.jpg" alt="">
                </a>
                <h3>
                    <a href="${eptituderLink}">${eptituder.name}</a>
                </h3>
                <p>abc</p>
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