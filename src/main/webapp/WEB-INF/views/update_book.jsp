<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <!-- Link to external CSS -->
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
    <div class="container">
 <div class="page-title-wrapper">
  		<h1 class="page-title">UPDATE BOOK</h1>
	</div>
        <frm:form modelAttribute="book" method="POST" action="book_edit" class="form-card">
            <table class="form-table">
                <tr>
                    <td><label>Book Id:</label></td>
                    <td><frm:input path="id" readonly="true" cssClass="input-field"/></td>
                </tr>
                <tr>
                    <td><label>Book Title:</label></td>
                    <td><frm:input path="title" cssClass="input-field"/></td>
                </tr>
                <tr>
                    <td><label>Author Name:</label></td>
                    <td><frm:input path="authorName" cssClass="input-field"/></td>
                </tr>
                <tr>
                    <td><label>Book ISBN Number:</label></td>
                    <td><frm:input path="isbnNumber" cssClass="input-field"/></td>
                </tr>
                <tr>
                    <td><label>Book Price:</label></td>
                    <td><frm:input path="price" cssClass="input-field"/></td>
                </tr>
                <tr>
                    <td><label>Genre</label></td>
                    <td>
                    	<select name="genre" required>
                    		<option value="">-- Select Genre --</option>
   							<option value="Fiction">Fiction</option>
    						<option value="Science">Science</option>
    						<option value="Mythology">Mythology</option>
    						<option value="History">History</option>
    						<option value="Technology">Technology</option>
    						<option value="Programming">Programming</option>
    						<option value="Animation">Animation</option>
    						<option value="Self-Help">Self-Help</option>
    						<option value="Thriller">Thriller</option>
    						<option value="Finance">Finance</option>
    						<option value="Productivity">Productivity</option>
    						<option value="Research / Methodology">Research / Methodology</option>
    						<option value="Education / Research">Education / Research</option>
    						<option value="Other">Other</option>
    					</select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="btn-group">
                        <input type="submit" value="Update Book" class="btn btn-primary"/>
                        <input type="reset" value="Cancel" class="btn btn-secondary"/>
                    </td>
                </tr>
            </table>
        </frm:form>
    </div>
</body>
</html>
