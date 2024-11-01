<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loan Management</title>
</head>
<body>
    <h1>Loan Management</h1>
    
    <h2>Borrow a Book</h2>
    <form action="loans/borrow" method="post">
        <label for="bookId">Book ID:</label>
        <input type="text" name="bookId" required>
        <label for="userId">User ID:</label>
        <input type="text" name="userId" required>
        <button type="submit">Borrow</button>
    </form>

    <h2>Return a Book</h2>
    <form action="loans/return" method="post">
        <label for="loanId">Loan ID:</label>
        <input type="text" name="loanId" required>
        <button type="submit">Return</button>
    </form>

    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
</body>
</html>
