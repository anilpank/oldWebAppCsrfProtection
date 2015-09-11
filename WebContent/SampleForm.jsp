<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="CookieReader.js"></script>
</head>
<body>




<form action="yourAction">

<!--  injected below input hidden type through jquery/javascript in all forms. Read the csrf token from cookie through
a javascript function-->
<!-- ----------------------------------------------------------------------- -->
<input type="hidden" name="csrfToken" value="getCookie('csrfToken')"/>
<!-- ----------------------------------------------------------------------- -->

<input type="text">
<input type="submit">
</form>
</body>
</html>