<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sorted Books</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #34495e;
        }
        select, button {
            padding: 8px 12px;
            margin: 10px;
            font-size: 14px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        table {
            width: 90%;
            margin: 0 auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 3px 6px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background: #2c3e50;
            color: #fff;
        }
        tr:nth-child(even) { background: #f9f9f9; }
        
        /* Button Styling */
        .report_sort a {
            display: inline-block;
            padding: 10px 18px;
            background: #2c3e50;   /* dark navy */
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
            font-weight: bold;
            transition: all 0.3s ease;
            box-shadow: 0 3px 6px rgba(0,0,0,0.2);
        }
        .report_sort a:hover {
            background: #34495e;   /* lighter navy */
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(0,0,0,0.3);
        }
        .report_sort a:active {
            background: #1a252f;
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(0,0,0,0.2);
        }

        /* Flexbox for side-by-side buttons */
        .button-container {
            display: flex;
            justify-content: center;
            gap: 20px; /* space between buttons */
            margin-top: 20px;
        }

        .icon-small {
            width: 18px;
            height: 18px;
            vertical-align: middle;
            margin-right: 6px;
        }
    </style>
</head>
<body>
    <h2>Sorted Books (${sortBy})</h2>

    <!-- Sorting Dropdown -->
    <form action="sort_book" method="get" style="text-align:center;">
        <select name="sortBy">
            <option value="title" ${sortBy=="title" ? "selected" : ""}>Sort by Title (A-Z)</option>
            <option value="price" ${sortBy=="price" ? "selected" : ""}>Sort by Price (Low to High)</option>
        </select>
        <button type="submit">Sort</button>
    </form>

    <!-- Table -->
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
    
    <!-- Buttons Side by Side -->
    <div class="button-container">
        <div class="report_sort">
            <a href="<c:url value='/report'/>">
            	<img src="images/report (2).png" class="icon-small"> 
            	Back to Report</a>
        </div>
        <div class="report_sort">
            <a href="./" class="btn btn-primary">
                <img src="images/home (3).png" class="icon-small"> 
                Back to Home
            </a>
        </div>
    </div>
</body>
</html>
