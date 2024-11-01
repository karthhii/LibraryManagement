<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library - Book List</title>
</head>
<body>
<h1>Library Book List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Available</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author.name}</td>
            <td>${book.isbn}</td>
            <td>${book.available ? 'Yes' : 'No'}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
