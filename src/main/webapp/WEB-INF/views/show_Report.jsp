<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Page</title>
    <!-- External CSS -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/search.css'/>">
</head>
<body>
    <div class="page-title-wrapper">
  		<h1 class="page-title">Book List</h1>
	</div>
    
    <!-- Search Section -->
    <div class="searchSection">
        <form action="search" method="get">
            <select name="type">    			
                <option value="title">Book Title</option>
                <option value="name">Author Name</option>
                <option value="genre">Book Genre</option>
                <option value="isbn">ISBN Number</option>
            </select>
            <input type="text" name="keyword" />
            <button type="submit">Search</button>
        </form>
    </div>
	
    <!-- Report Table -->
    <c:if test="${not empty listVO}">
        <table class="report-table">
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Book Title</th>
                    <th>Author Name</th>
                    <th>ISBN Number</th>
                    <th>Book Price</th>
                    <th>Book Genre</th>
                    <th>Available</th>   <!-- Added -->
                    <th>Toggle</th>      <!-- Added -->
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vo" items="${listVO}">
                    <tr>
                        <td>${vo.id}</td>
                        <td>${vo.title}</td>
                        <td>${vo.authorName}</td>
                        <td>${vo.isbnNumber}</td>
                        <td>${vo.price}</td>
                        <td>${vo.genre}</td>

                       <!-- Show Yes/No for availability -->
<td>
    <c:choose>
        <c:when test="${vo.available}">
            <span class="available-yes" style="color:green; text-align:center; font-weight:bold;">Yes</span>
        </c:when>
        <c:otherwise> 
            <span class="available-no" style="color:red; text-align:center; font-weight:bold;"">No</span>
        </c:otherwise>
    </c:choose>
</td>

<!-- Action Button -->
<td>
    <c:choose>
        <c:when test="${vo.available}">
            <a href="<c:url value='/toggle/${vo.id}'/>" class="btn btn-danger" style="color:red; text-align:center; font-weight:bold;">Mark Unavailable</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value='/toggle/${vo.id}'/>" class="btn btn-success" style="color:green; text-align:center; font-weight:bold;">Mark Available</a>
        </c:otherwise>
    </c:choose>
</td>

                        <!-- Actions -->
                        <td class="actions">
                            <a href="book_edit?no=${vo.id}">
                                <img src="images/edit.png" alt="Edit" class="icon">
                            </a>
                            <a href="book_delete?no=${vo.id}" 
                               onclick="return confirm('Do you want to delete this book?')">
                                <img src="images/delete.png" alt="Delete" class="icon">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- No Data -->
    <c:if test="${empty listVO}">
        <h2 class="no-data">No Book Data Found</h2>
    </c:if>

    <!-- Result Message -->
    <c:if test="${not empty resultMsg}">
        <h3 class="result-msg">${resultMsg}</h3>
    </c:if>

    <!-- Buttons -->
    <div class="btn-group">
        <a href="register_Books" class="btn btn-primary">
            <img src="images/add.png" class="icon-small"> Add Book
        </a>
        <a href="./" class="btn btn-primary">
            <img src="images/home (3).png" class="icon-small"> Back to Home
        </a>
        <a href="available" class="btn btn-primary">
            <img src="images/books.png" class="icon-small"> 
            Available books
        </a>
          <a href="sort_book" class="btn btn-primary">
           <img src="images/filter.png" class="icon-small">
           Filter Books
        </a>
    </div>
</body>
</html>
