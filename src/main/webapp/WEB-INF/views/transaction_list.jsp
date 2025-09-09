<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fa;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #28a745;
            margin-bottom: 20px;
        }
        p {
            text-align: center;
            font-size: 16px;
        }
        .search-bar {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-bar input[type="text"] {
            padding: 6px 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
            width: 150px;
            margin-right: 10px;
        }
        .search-bar button {
            padding: 6px 12px;
            border-radius: 4px;
            border: none;
            background: #007bff;
            color: #fff;
            cursor: pointer;
            font-weight: bold;
        }
        .search-bar button:hover {
            background: #0056b3;
        }
        table {
            width: 95%;
            margin: 0 auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
        }
        th {
            background: #007bff;
            color: #fff;
            text-transform: uppercase;
            font-size: 13px;
        }
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        tr:hover {
            background: #eef5ff;
        }
        .penalty-cell {
            color: red;
            font-weight: bold;
        }
        .return-btn {
            background: #ffc107;
            border: none;
            padding: 6px 12px;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            font-size: 13px;
            transition: background 0.3s ease;
        }
        .return-btn:hover {
            background: #e0a800;
        }
        .links {
            text-align: center;
            margin-top: 20px;
        }
        .links a {
            margin: 0 10px;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 15px;
            border-radius: 6px;
            transition: 0.3s ease;
            color: #fff;
        }
        .links a.borrow { background: #007bff; }
        .links a.active { background: #17a2b8; }
        .links a.returned { background: #28a745; }
        .links a.home { background: #6f42c1; }
        .links a.transaction { background:  #006400; } /* Conditional Transaction button */
        .links a:hover { opacity: 0.85; }

        /* Actions column styling */
        .actions {
            display: flex;
            justify-content: center;
            gap: 8px;
        }
        .actions a, .actions form {
            display: inline-block;
        }
        .actions a:hover {
            background-color: #f0f0f0;
        }
        .actions img.icon {
            width: 20px;
            height: 20px;
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <h2>Transaction List</h2>

    <!-- Search Bar -->
    <div class="search-bar">
        <form action="${pageContext.request.contextPath}/transaction/search" method="get">
            Transaction ID:
            <input type="text" name="transactionId" value="${transactionId}" placeholder="Enter ID"/>
            <button type="submit">Search</button>
        </form>
    </div>

    <!-- Message if no result -->
    <c:if test="${not empty resultMsg}">
        <p style="color:blue; font-weight:bold;">${resultMsg}</p>
    </c:if>

    <!-- Transaction Table -->
    <table>
        <tr>
            <th>ID</th>
            <th>Student</th>
            <th>Book</th>
            <th>Borrow Date</th>
            <th>Price</th>
            <th>GST</th>
            <th>Total</th>
            <th>Returned</th>
            <th>Return Date</th>
            <th>Penalty</th>
            <th>Action</th>
        </tr>
        <c:forEach var="t" items="${transactions}">
            <tr>
                <td>${t.btid}</td>
                <td>${t.studentName}</td>
                <td>${t.bookTitle}</td>
                <td>${t.borrowDate}</td>
                <td>${t.price}</td>
                <td>${t.gst}</td>
                <td>${t.totalAmount}</td>
                <td><c:out value="${t.returned}"/></td>
                <td>${t.returnDate}</td>
                <td class="${t.penalty gt 0 ? 'penalty-cell' : ''}">${t.penalty}</td>
                <td>
                    <div class="actions">
                        <c:if test="${!t.returned}">
                            <form action="${pageContext.request.contextPath}/return/${t.btid}" method="post" style="display:inline;">
                                <button type="submit" class="return-btn">Return</button>
                            </form>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/edit/${t.btid}">
                            <img src="<c:url value='/images/edit.png' />" alt="Edit" class="icon">
                        </a>
                        <a href="${pageContext.request.contextPath}/transaction/delete/${t.btid}" 
   onclick="return confirm('Do you want to delete this transaction?')">
    <img src="<c:url value='/images/delete.png' />" alt="Delete" class="icon">
</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- Navigation Links -->
    <div class="links">
        <a class="borrow" href="${pageContext.request.contextPath}/borrow">Borrow Book</a>
        <a class="active" href="${pageContext.request.contextPath}/active">Active Borrows</a>
        <a class="returned" href="${pageContext.request.contextPath}/returned">Returned</a>
        <a class="home" href="${pageContext.request.contextPath}/">Home</a>

        <!-- Show Transaction link only if there is a transactions list -->
        <c:if test="${not empty transactions}">
            <a class="transaction" href="${pageContext.request.contextPath}/list">Transaction</a>
        </c:if>
    </div>
</body>
</html>
