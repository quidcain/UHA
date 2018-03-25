<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<c:set var="pageName" value="login"/>
<%@ include file="/WEB-INF/views/fragments/header.jspf"%>

    <header>
        <div class="header-content">
        </div>
    </header>
    <div class="contact">
        <div class="container">
            <form class="form-horizontal" method="post" action="<s:url value='/login'/>">
                <div class="form-group">
                    <label for="inputUser" class="col-sm-2 control-label">User</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputUser" placeholder="User" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" id="inputPassword" placeholder="Password">
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