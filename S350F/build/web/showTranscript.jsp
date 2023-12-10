<%-- 
    Document   : tesaaaa
    Created on : 2023年12月4日, 上午4:25:38
    Author     : fg58hj123ty
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>
        <body>
            <jsp:include page="courseber.jsp"/>  
            <div style="display: flex; justify-content: center; align-items: center; height: 50vh;">
                <table class="table" style="width: 60%">
                    <thead>
                        <tr>
                            <th scope="col" >CourseID</th>
                            <th scope="col" >Course Title</th>
                            <th scope="col">Grade</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach items="${scList}" var="c"> 
                            <tr>
                                <td>${c.courseId}</td>
                                <td>${c.courseName}</td>
                                <td>${c.grade}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Totale GPAs :${totalGPA} </th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </body>
    </html>  
</body>
</html>
