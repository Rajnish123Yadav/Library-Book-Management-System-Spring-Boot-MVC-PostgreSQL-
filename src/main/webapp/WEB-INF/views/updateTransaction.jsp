<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Transaction</title>
</head>
<body>
    <h2>Edit Transaction</h2>

    <form action="${pageContext.request.contextPath}/edit/${transaction.btid}" method="post">
    <input type="hidden" name="btid" value="${transaction.btid}" />

        <label>Return Date:</label>
        <input type="date" name="returnDate" value="${transaction.returnDate}" /><br/><br/>

        <label>Returned:</label>
        <input type="checkbox" name="returned" <c:if test="${transaction.returned}">checked</c:if> /><br/><br/>

        <label>Penalty:</label>
        <input type="number" step="0.01" name="penalty" value="${transaction.penalty}" /><br/><br/>

        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="${transaction.price}" /><br/><br/>

        <label>GST:</label>
        <input type="number" step="0.01" name="gst" value="${transaction.gst}" /><br/><br/>

        <label>Total Amount:</label>
        <input type="number" step="0.01" name="totalAmount" value="${transaction.totalAmount}" /><br/><br/>

        <button type="submit">Update Transaction</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/list">Back to Transactions</a></p>
</body>
</html>
