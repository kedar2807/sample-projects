<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	${company} form
	<form:form commandName="student" action="../homeController/getDetails"
		id="studentForm">
Name: 
<form:input path="name" id="name" />
City:
<form:input path="city" id="city" /><br>
<c:forEach items="${student.books}" var="book" varStatus="status">
	<form:input path="books[${status.index}].bookName" id="book.bookName"/>
	<form:input path="books[${status.index}].bookAuthor" id="book.bookAuthor"/>
	<br>
</c:forEach>
		<button class="btn btn-primary" type="submit" name="submit" style="width: 60px; height: 20px;"
			value="Submit">Submit</button>
	</form:form>

</body>
</html>