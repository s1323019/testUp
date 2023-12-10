<%-- 
    Document   : showCourse
    Created on : 2023年10月26日, 下午10:28:08
    Author     : fg58hj123ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.Course ,java.util.*"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border-bottom: 1px solid black;
                padding: 8px;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                </tr>
            </thead>
           <tbody>
            <c:forEach items="${Course}" var="c">
                <tr>
                    <td>${c.courseID}</td>
                    <td>${c.courseName}</td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
    </body>
</html>
