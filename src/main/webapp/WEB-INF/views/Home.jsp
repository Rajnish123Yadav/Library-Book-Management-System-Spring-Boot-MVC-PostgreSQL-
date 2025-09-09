<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <!-- Linking external CSS -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <style>
    	.body{    
    		background-color:white;
    	}
        /* Navbar styling */
        .navbar {
            background-color: #2c3e50;
            padding: 14px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar .brand {
            font-size: 20px;
            color: white;
            font-weight: bold;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            transition: 0.3s;
            font-size: 16px;
        }
        .navbar a:hover {
            color: #1abc9c;
            text-decoration: underline;
        }

        /* Page Content */
        .content {
            text-align: center;
            margin-top: 80px;
        }
        .content h1 {
            color: #2c3e50;
            font-size: 36px;
        }
        .content p {
            font-size: 18px;
            color: #555;
        }

        /* Footer */
        .footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 15px 0;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="brand">Library Management</div>
        <div>
            <a href="<c:url value='/'/>"> 
            	<img src="images/home (3).png" class="icon-small">HOME
            </a>
            <a href="<c:url value='/register_Books'/>"> 
            	<img src="images/add.png" class="icon-small">ADD
            </a>
            <a href="<c:url value='/report'/>"> 
            	<img src="images/report (2).png" class="icon-small">REPORT
            </a>
            <a href="<c:url value='/About'/>"> 
            	<img src="images/about.png" class="icon-small">ABOUT
            </a>
        </div>
    </div>

    <!-- Main Content -->
    <div class="content">
        <h1>Welcome to Library</h1>
        <p>Manage your books efficiently with our Library Management System.</p>
        <h2 class="link">
            <a href="report">BOOKS LIST
            <img src="images/report (2).png" class="icon-small">
            </a>
        </h2>
        <h2 class="link">
            <a href="students_report">STUDENTS LIST
            <img src="images/students.png" class="icon-small">
            </a>
        </h2>
        <h2 class="link">
            <a href="list">TRANSACTION
            <img src="images/borrow.png" class="icon-small">
            </a>
        </h2>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; <%= java.time.Year.now() %> Library Book Management System | All Rights Reserved.
    </div>

</body>
</html>
