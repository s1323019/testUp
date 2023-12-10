<%-- 
    Document   : main
    Created on : 2023年10月14日, 上午1:09:58
    Author     : fg58hj123ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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

        a {
            text-decoration: none;
            color: #FF0000;
        }
        .ct {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;

        }
    </style>
    <body>
        <jsp:include page="navber.jsp"/>   
        <div class="card ct" style="width: 40rem;">
            <div class="card-body">
                <h5 class="card-title">My Courses</h5>
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

                                <td><a href="StudentInfoController?action=interCourse&courseID=${c.courseID}" class="card-link"> ${c.courseID} </a></td>
                                <td><a href="StudentInfoController?action=interCourse&courseID=${c.courseID}" class="card-link"> ${c.courseName} </a></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
