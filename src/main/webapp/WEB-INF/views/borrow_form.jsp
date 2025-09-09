<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Borrow Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fa;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #007bff;
            margin-top: 30px;
        }
        form {
            background: #fff;
            max-width: 450px;
            margin: 30px auto;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        label {
            font-weight: bold;
            color: #333;
            display: block;
            margin-bottom: 8px;
        }
        select, input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
        }
        select:focus {
            border-color: #007bff;
            outline: none;
        }
        input[type="submit"] {
            background: #007bff;
            color: white;
            font-weight: bold;
            cursor: pointer;
            border: none;
            transition: background 0.3s ease;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Borrow a Book</h2>

    <form action="borrow" method="post">
        <label>Student:</label>
        <select name="studentId" required>
            <c:forEach var="s" items="${students}">
                <option value="${s.sid}">${s.sname} (${s.semail})</option>
            </c:forEach>
        </select>

        <label>Book:</label>
        <select name="bookId" required>
            <c:forEach var="b" items="${books}">
                <c:if test="${b.available}">
                    <option value="${b.id}">${b.title} - ${b.authorName}</option>
                </c:if>
            </c:forEach>
        </select>

        <input type="submit" value="Borrow"/>
    </form>

    <a href="list">View Transactions</a>
</body>
</html>
