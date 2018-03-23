<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>UHA Team</title>
    <link href="<s:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/login.css'/>" rel="stylesheet">
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
                    <span class="glyphicon glyphicon glyphicon-comment"></span>
                    UHA Team
                </a>
            </div>
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="./index.html">Home</a>
                    </li>
                    <li>
                        <a href="<s:url value='/eptituders'/>">Eptituders</a>
                    </li>
                    <li>
                        <a href="<s:url value='/clans'/>">Clans</a>
                    </li>
                    <li>
                        <a href="<s:url value='/events'/>">Events</a>
                    </li>
                    <li>
                        <a href="./contacts.html">Contact</a>
                    </li>
                    <li>
                        <a href="<s:url value='/login'/>">Log in</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <header>
        <div class="header-content">
        </div>
    </header>
    <div class="contact">
        <div class="container">
            <form class="form-horizontal" method="post" action="/login">
                <div class="form-group">
                    <label for="inputUser" class="col-sm-2 control-label">User</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputUser" placeholder="User" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-1 col-sm-10">
                        <button type="submit" class="btn btn-default">Sing in</button>
                    </div><br>
                </div>
            </form>
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