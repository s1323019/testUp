
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="bean.TeacherAssignment" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<%

        String dburl = "jdbc:mysql://localhost:3306/s350f";
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Connection ct = DriverManager.getConnection(dburl, "root", "");
    
    PreparedStatement ps = ct.prepareStatement("select * from student");
     ResultSet rs = ps.executeQuery();
     
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body>
         <jsp:include page="itber.jsp"/>   
         <h1>Sudent Info</h1>
          <table class="table table-hover">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name </th>
                    <th>Year</th>
                    <th>Major</th>
                    <th>Edit/View</th>
                </tr>
            </thead>
            <tbody>
               <%
               while(rs.next()){
               %>
                <tr>
                    <td><%= rs.getString(1) %></td>
                    <td><%= rs.getString(2) %> </td>
                    <td><%= rs.getString(3) %></td>
                    <td><%= rs.getString(9) %></td>
                    <td>
                       <a href="ItStaffController?action=editStudent&&sId=<%=rs.getString(1)%>">
                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                         <path d="M12 2v6a2 2 0 0 0 2 2h4.92c-.596.22-1.144.554-1.558.97l-6.05 6.092a2.815 2.815 0 0 0-.728 1.279l-.525 2.03A2.082 2.082 0 0 0 10.3 22H5.5A1.5 1.5 0 0 1 4 20.5v-17A1.5 1.5 0 0 1 5.5 2H12Z" fill="#212121"/>
                        <path d="M13.5 2.5V8a.5.5 0 0 0 .5.5h5.5l-6-6ZM12.196 17.572l5.902-5.902a2.285 2.285 0 1 1 3.233 3.232l-5.903 5.902a2.684 2.684 0 0 1-1.247.707l-1.831.457a1.087 1.087 0 0 1-1.318-1.318l.457-1.83c.118-.473.362-.904.707-1.248Z" fill="#212121"/>
                        </svg>
                        </a>
                    </td>

                </tr>
                <%
                    }

                ps.close();
                ct.close();
                %>
            </tbody>
        </table>
    </body>
</html>
