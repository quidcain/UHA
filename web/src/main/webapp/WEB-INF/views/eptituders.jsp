<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Eptituders</h1>
    <table>
        <tr><th>Name</th><th>Side</th></tr>
        <c:forEach items="${eptituderList}" var="eptituder">
            <tr><td>${eptituder.name}</td><td>${eptituder.side}</td></tr>
        </c:forEach>
    </table>
</body>
</html>
