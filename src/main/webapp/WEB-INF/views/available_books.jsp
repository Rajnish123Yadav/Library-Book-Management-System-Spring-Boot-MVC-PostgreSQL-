<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Available Books</title>
    <style>
        /* Global Styles */
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f6f9;
            color: #2c3e50;
            padding: 20px;
            margin: 0;
        }

        h2 {
            text-align: center;
            font-size: 28px;
            font-weight: 700;
            color: #34495e;
            margin-bottom: 20px;
        }

        /*  Table Styling */
        table {
            width: 90%;
            margin: 0 auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 12px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
        }

        th {
            background: #2c3e50;
            color: #fff;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        tr:hover {
            background: #eaf4ff;
            transition: 0.3s;
        }

        td {
            color: #34495e;
        }

        /* Back Button */
        a {
            display: inline-block;
            margin-top: 20px;
            margin-left: 5%;
            padding: 10px 18px;
            background: #2c3e50;
            color: #fff;
            text-decoration: none;
            border-radius: 8px;
            font-size: 14px;
            transition: background 0.3s;
        }

        a:hover {
            background: #1abc9c;
        }
    </style>
</head>
<body>
    <h2>Available Books</h2>
    <table>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Price</th>
            <th>Genre</th>
        </tr>
        <c:forEach var="vo" items="${list}">
            <tr>
                 
                 <td>${vo.title}</td>
                 <td>${vo.authorName}</td>
                 <td>${vo.isbnNumber}</td>
                 <td>${vo.price}</td>
                 <td>${vo.genre}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="report">Back to All Books</a>
</body>
</html>
