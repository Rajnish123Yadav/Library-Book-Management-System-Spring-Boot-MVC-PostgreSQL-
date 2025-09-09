<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fa;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #006400; /* Dark Green */
        }
        form {
            width: 400px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        button {
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #006400; /* Dark Green */
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        button:hover {
            background-color: #004d00;
        }
        .back-link {
            text-align: center;
            margin-top: 15px;
        }
        .back-link a {
            text-decoration: none;
            color: #006400;
            font-weight: bold;
        }
        .back-link a:hover {
            color: #004d00;
        }
        /* Flash message styling */
        .message {
            width: 400px;
            margin: 10px auto;
            text-align: center;
            padding: 10px;
            border-radius: 6px;
        }
        .success { background-color: #d4edda; color: #155724; }
        .error { background-color: #f8d7da; color: #721c24; }
    </style>
</head>
<body>
    <h2>Edit Student</h2>


    <form action="${pageContext.request.contextPath}/students/update" method="post">
        <!-- Hidden field to store student ID -->
        <input type="hidden" name="sid" value="${student.sid}" />

        <label>Name:</label>
        <input type="text" name="sname" value="${student.sname}" required />

        <label>Email:</label>
        <input type="email" name="semail" value="${student.semail}" required />

        <label>Mobile:</label>
        <input type="text" name="smobile" value="${student.smobile}" required />

        <label>Department:</label>
        <input type="text" name="sdepartment" value="${student.sdepartment}" required />

        <button type="submit">Update Student</button>
    </form>

    <div class="back-link">
        <a href="${pageContext.request.contextPath}/students/list">Back to Student List</a>
    </div>
</body>
</html>
