<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
    }
    h1 {
        text-align: center;
        color: orange;
    }
    table {
        margin: auto;
        border-spacing: 12px;
    }
    .input-field {
        padding: 6px;
        width: 250px;
    }
    .btn {
        background-color: orange;
        color: white;
        padding: 8px 16px;
        border: none;
        cursor: pointer;
        margin: 5px;
    }
    .btn-reset {
        background-color: gray;
    }
</style>
</head>
<body>
    <h1>Student Registration Page</h1>

    <frm:form action="add" modelAttribute="stud" method="post">
        <table>
            <tr>
                <td><label for="sname">Student Name</label></td>
                <td><frm:input path="sname" cssClass="input-field"/></td>
            </tr>
            <tr>
                <td><label for="semail">Email</label></td>
                <td><frm:input path="semail" cssClass="input-field"/></td>
            </tr>
            <tr>
                <td><label for="smobile">Mobile</label></td>
                <td><frm:input path="smobile" cssClass="input-field"/></td>
            </tr>
            <tr>
                <td><label for="sdepartment">Department</label></td>
                <td><frm:input path="sdepartment" cssClass="input-field"/></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Register" class="btn"/>
                    <input type="reset" value="Reset" class="btn btn-reset"/>
                </td>
            </tr>
        </table>
    </frm:form>
</body>
</html>
