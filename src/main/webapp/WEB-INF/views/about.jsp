<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About - Library Book Management System</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f9f9f9;
        }

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

        .about {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .about h1, .about h2 {
            color: #2c3e50;
        }
        .about p, .about ul {
            font-size: 16px;
            color: #333;
            line-height: 1.6;
        }
        .about ul {
            list-style: none;
            padding: 0;
        }
        .about ul li {
            padding: 5px 0;
        }

        /* Side-by-side buttons */
        .button-group {
            display: flex;
            justify-content: center;
            gap: 20px; /* space between buttons */
            margin-top: 30px;
        }
        .button-group a {
            display: inline-block;
            padding: 12px 22px;
            background: #2c3e50;
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
            font-weight: bold;
            transition: all 0.3s ease;
            box-shadow: 0 3px 6px rgba(0,0,0,0.2);
        }
        .button-group a:hover {
            background: #34495e;
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(0,0,0,0.3);
        }
        .button-group a:active {
            background: #1a252f;
            transform: translateY(0);
            box-shadow: 0 2px 4px rgba(0,0,0,0.2);
        }
        /* Style for icons in navbar and buttons */
		.icon-small {
    	width: 20px;       /* set the icon width */
    	height: 20px;      /* set the icon height */
    	vertical-align: middle; /* align icon vertically with text */
    	margin-right: 6px; /* space between icon and text */
	}

/* Optional: add a small hover effect for icons in buttons */
.button-group a .icon-small:hover {
    transform: scale(1.1);
    transition: transform 0.2s ease-in-out;
}
        

        .footer {
            background-color: #2c3e50;
            color: white;
            text-align: center;
            padding: 15px 0;
            margin-top: 30px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="brand">Library Book Management</div>
        <div>
            <a href="<c:url value='/'/>"><img src="images/home (3).png" class="icon-small">Home</a>
            <a href="<c:url value='/register_Books'/>"><img src="images/add.png" class="icon-small">Add Book</a>
            <a href="<c:url value='/report'/>"><img src="images/report (2).png" class="icon-small">Report</a>
            <a href="<c:url value='/About'/>"><img src="images/about.png" class="icon-small">About</a>
        </div>
    </div>

    <!-- About Section -->
    <div class="about">
        <h1>About Library Book Management System</h1>
        <p>
            The <strong>Library Book Management System</strong> is a browser-based Spring Boot MVC web application 
            designed for university librarians to efficiently manage books in the library. 
            It provides a user-friendly interface to add, update, delete, search, and sort books, 
            while maintaining a database of all records.
        </p>

        <h2>Core Functional Features:</h2>
        <ul>
            <li><strong>Add New Book:</strong> Add a book with Title, Author, ISBN Number, Price, and Genre. Data is stored in the database using Spring Data JPA.</li>
            <li><strong>Display All Books:</strong> View a list of all books with details like Title, Author, ISBN, Price, and Genre.</li>
            <li><strong>Validate Form Inputs:</strong> Ensure Title, Author, ISBN, and Price meet validation rules (e.g., ISBN length, positive price).</li>
            <li><strong>Delete Books:</strong> Remove books from the database with a single click and update the list instantly.</li>
            <li><strong>Search Books:</strong> Search books by title keyword (case-insensitive).</li>
        </ul>

        <h2>Advanced Functional Enhancements:</h2>
        <ul>
            <li><strong>Book Availability Toggle:</strong> Mark books as available/unavailable and display status in the list.</li>
            <li><strong>Genre Selection Dropdown:</strong> Use a predefined dropdown for genres: Fiction, Science, History, Technology, Other.</li>
            <li><strong>View Only Available Books:</strong> Filter the list to show only books marked as available.</li>
            <li><strong>Sort Books:</strong> Sort books by Title (A-Z) or Price (Low to High) using a dropdown menu.</li>
            <li><strong>Edit Existing Books:</strong> Update existing book details via a pre-filled form.</li>
        </ul>

        <h2>Technology Stack:</h2>
        <ul>
            <li>Spring Boot MVC (for building modular web applications without REST APIs)</li>
            <li>Spring Data JPA (for database interactions with PostgreSQL)</li>
            <li>Servlet & JSP (for dynamic page rendering)</li>
            <li>JSTL (JavaServer Pages Standard Tag Library for clean JSP code)</li>
            <li>HTML5, CSS3 (for responsive and user-friendly design)</li>
        </ul>

        <h2>Benefits:</h2>
        <ul>
            <li><strong>Efficiency:</strong> Streamlines book management with minimal manual effort.</li>
            <li><strong>Accuracy:</strong> Maintains reliable records with automated validation.</li>
            <li><strong>User-Friendly:</strong> Easy-to-navigate interface for librarians and staff.</li>
            <li><strong>Scalability:</strong> Can be extended with online issuing, notifications, and digital library features.</li>
        </ul>

        <h2>Future Enhancements:</h2>
        <ul>
            <li>Online book issuing and returning system.</li>
            <li>User login & authentication for librarians and staff.</li>
            <li>Email notifications for due/overdue books.</li>
            <li>Integration with a digital library platform.</li>
        </ul>

        <!-- Side-by-side buttons -->
        <div class="button-group">
            <a href="<c:url value='/'/>"><img src="images/home (3).png" class="icon-small">Back to Home</a>
            <a href="<c:url value='/report'/>"><img src="images/report (2).png" class="icon-small">Report</a>
        </div>
    </div>

    <!-- Footer -->
    <div class="footer">
        &copy; <%= java.time.Year.now() %> Library Book Management System | All Rights Reserved.
    </div>

</body>
</html>
