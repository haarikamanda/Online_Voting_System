<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color: red;"> Sorry, Access Denied</h1>

<form action='#' th:action="@{/}" method="post">
<input type="submit" value=" Go back to home"/>
</form>
</body>
</html>