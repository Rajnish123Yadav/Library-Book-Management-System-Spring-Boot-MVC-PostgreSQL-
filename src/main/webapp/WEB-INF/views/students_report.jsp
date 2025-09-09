<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Report</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
    }
    h1 {
        text-align: center;
        color: orange;
    }
    .report-table {
        width: 80%;
        margin: auto;
        border-collapse: collapse;
        margin-bottom: 30px;
    }
    .report-table th, .report-table td {
        border: 1px solid #ccc;
        padding: 8px;
        text-align: center;
    }
    .report-table th {
        background-color: #f2f2f2;
    }

    /* Action Buttons */
    .btn {
        display: inline-block;
        padding: 6px 12px;
        font-size: 14px;
        border-radius: 5px;
        text-decoration: none;
        color: white;
        font-weight: bold;
        margin: 2px;
        transition: background-color 0.3s ease;
    }
    .btn-edit { background-color: #3498db; }
    .btn-edit:hover { background-color: #217dbb; }
    .btn-delete { background-color: #e74c3c; }
    .btn-delete:hover { background-color: #c0392b; }
    .btn-add { background-color: #2ecc71; }
    .btn-add:hover { background-color: #27ae60; }

    /* Back to Home button */
    .btn-home {
        display: inline-flex;
        align-items: center;
        justify-content: center;
        background-color: orange;
        color: white;
        text-decoration: none;
        padding: 10px 18px;
        border-radius: 6px;
        font-size: 16px;
        font-weight: bold;
        margin: 20px auto;
        transition: background-color 0.3s ease;
    }
    .btn-home:hover { background-color: darkorange; }
    .btn-home img {
        width: 20px;
        height: 20px;
        margin-right: 8px;
    }
    .btn-container { text-align: center; }

    /* Success message */
    .success-msg {
        width: 80%;
        margin: 15px auto;
        padding: 12px;
        border-radius: 6px;
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
        font-size: 15px;
        text-align: center;
        font-weight: bold;
    }
    .error-msg {
        width: 80%;
        margin: 15px auto;
        padding: 12px;
        border-radius: 6px;
        background-color:#f8d7da;
        color: #155724;
        border: 1px solid #c3e6cb;
        font-size: 15px;
        text-align: center;
        font-weight: bold;
    }
</style>
</head>
<body>

<h1>Student Report</h1>

 <!-- Success Message -->
    <c:if test="${not empty successMsg}">
        <div class="success-msg">${successMsg}</div>
    </c:if>

    <!-- Error Message -->
    <c:if test="${not empty errorMsg}">
        <div class="error-msg">${errorMsg}</div>
    </c:if>
    
    <!-- Success Message -->
<c:if test="${not empty resultMsg}">
    <div class="success-msg">${resultMsg}</div>
</c:if>

<!-- Error Message -->
<c:if test="${not empty errorMsg}">
    <div class="error-msg">${errorMsg}</div>
</c:if>

<!-- Success Message -->
<c:if test="${not empty param.resultMsg}">
    <div class="success-msg">
        ${param.resultMsg}
    </div>
</c:if>

<!-- Report Table -->
<c:if test="${not empty listVO}">
    <table class="report-table">
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vo" items="${listVO}">
                <tr>
                    <td>${vo.sid}</td>
                    <td>${vo.sname}</td>
                    <td>${vo.semail}</td>
                    <td>${vo.smobile}</td>
                    <td>${vo.sdepartment}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/students/update/${vo.sid}" class="btn btn-edit">
                        		Edit
                        </a>
                       <a href="${pageContext.request.contextPath}/students/delete/${vo.sid}" 
   class="btn btn-delete" 
   onclick="return confirm('Are you sure you want to delete this student?')">
   Delete
</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- Back Add Buttons -->
<div class="btn-container">
    <a href="./" class="btn-home">
        <img src="images/home (3).png" alt="Home"> Back to Home
    </a>
    <a href="add" class="btn-home">
        <img src="images/add.png" alt="Add" style="width:18px; height:18px; margin-right:5px;"> Add Student
    </a>
    
</div>

</body>
</html>
