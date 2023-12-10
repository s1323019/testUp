
<%@ page import="bean.TeacherAssignment" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    String dburl = "jdbc:mysql://localhost:3306/s350f";
    String sId = request.getParameter("sId");
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    Connection ct = DriverManager.getConnection(dburl, "root", "");

    PreparedStatement ps = ct.prepareStatement("select * from student where stu_id = ?");
    ps.setString(1, sId);
    ResultSet rs = ps.executeQuery();
    rs.next();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="itber.jsp"/>   
        <h3 >Student Information</h3>
        <form  method="get" action="StudentInfoController" id="myForm">
            <div style="width: 24rem;" class="center-div">
                <input type="hidden" name="action" value="UpdateStuInfo" />
                <input type="hidden" name="page" value="t" />
                <p class="card-text">
                    <!--Name:  <input type="text" value="<%= rs.getString(2)%>" name="sName" disabled><br>-->
                <div class="mb-3">
                    <label for="Name">Student Name</label>
                    <input type="text" name="sName"  class="form-control" id="Name" aria-describedby="emailHelp" value="<%= rs.getString(2)%>" disabled>
                </div>
                <div class="mb-3">
                    <label for="ID">Student ID</label>
                    <input type="text" class="form-control" name="sId" id="ID" aria-describedby="emailHelp" value="<%= rs.getString(1)%>" disabled>
                </div>
                <div class="mb-3">
                    <label for="Major">Major</label>
                    <input type="text" class="form-control" id="Major" aria-describedby="emailHelp" value="<%= rs.getString(9)%>" name="major" disabled>
                </div>
                <div class="mb-3">
                    <label for="Year">Study Year</label>
                    <input type="text" class="form-control" id="Year" aria-describedby="emailHelp" value="<%= rs.getString(3)%>" name="year"  disabled>
                </div>

                <div class="mb-3">
                    <label for="Phone">Phone</label>
                    <input type="text" class="form-control" id="Phone" aria-describedby="emailHelp" name="phone" value="<%=rs.getString(8)%>" disabled pattern="[0-9]{8}"  disabled>
                </div>                    
                <div class="mb-3">
                    <label for="gender">Gender</label>
                    <select name="gender" class="form-control" id="gender" disabled>
                        <option value="M">M</option>
                        <option value="F">F</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="Email">Email</label>
                    <input type="text" class="form-control" id="Email" aria-describedby="emailHelp" name="pEmail" value="<%= rs.getString(4)%>" disabled pattern="[0-9]{8}"  disabled>
                </div>                
                <div class="mb-3">
                    <label for="Address" class="form-label">Address</label>
                    <textarea class="form-control" id="Address"  name="address"rows="3" disabled><%= rs.getString(7)%> </textarea>
                </div>
                </p>
                <div id="buttons">
                    <input type="button" value="Modify" onclick="enableInputs()">
                </div>    

            </div>
        </form>
</body>
</html>
<%
    ps.close();
    ct.close();
%>

<style>
    
    .center-div {
    margin: 0 auto;
}
</style>
<script>

    function enableInputs() {
        let inputs = document.getElementsByTagName("input");
        let selects = document.getElementsByTagName("select");
        let textarea = document.getElementsByTagName("textarea");

        let buttonsDiv = document.getElementById("buttons");

        for (let i = 0; i < inputs.length; i++) {
            inputs[i].disabled = false;
        }

        for (let i = 0; i < selects.length; i++) {
            selects[i].disabled = false;
        }
        for (let i = 0; i < textarea.length; i++) {
            textarea[i].disabled = false;
        }

        buttonsDiv.innerHTML = `
    <input type="button" value="cancel" onclick="cancelEditing()">
    <input type="submit" value="Update">
  `;
    }

    function cancelEditing() {
        let inputs = document.getElementsByTagName("input");
        let selects = document.getElementsByTagName("select");
        let textarea = document.getElementsByTagName("textarea");
        let buttonsDiv = document.getElementById("buttons");

        for (let i = 0; i < inputs.length; i++) {
            inputs[i].disabled = true;
        }

        for (let i = 0; i < selects.length; i++) {
            selects[i].disabled = true;
        }
        for (let i = 0; i < textarea.length; i++) {
            textarea[i].disabled = true;
        }

        buttonsDiv.innerHTML = `<input type="button" value="modify" onclick="enableInputs()">`;
    }


</script>
