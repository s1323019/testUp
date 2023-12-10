<%-- 
    Document   : showAssigment
    Created on : 2023年11月6日, 下午9:48:26
    Author     : fg58hj123ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    </head>
    <body>
        <jsp:include page="courseber.jsp"/>   
        <h1>Assignment Submission for : ${as.courseID} </h1>
        <h3>Submission Status</h3>
        <div style="display: flex; justify-content: center;">
            <table >
                <tr>
                    <th class="th1">Submission status</th>
                    <th style="background-color: ${as.status == 'submitted' ? 'lightgreen' : 'inherit'};">${as.status}</th>
                </tr>
                <tr>
                    <th class="th1">Assigment Material</th>
                    <th><a href="forAssignment/${as.assigmentMaterial}">${as.assigmentMaterial}</a></th>
                </tr>
                <tr>
                    <th class="th1">Submit time</th>
                    <th>${as.submissionTime}</th>
                </tr>
                <tr>
                    <th class="th1">Due date</th>
                    <th>${as.due_date}</th>
                </tr>
                <tr>
                    <th class="th1">Your Submission</th>

                    <c:choose>
                        <c:when test="${empty as.stuAs}">
                            <th>
                                <form action="uploadStundetAssignmentController" method="post" enctype="multipart/form-data">
                                    <input type="file" name="formFile" id="formFile" required>
                                    <input type="hidden" value="${as.assignmentID}" name="assID">
                                    <input type="hidden" value="${as.courseID}" name="courseID">
                                    </tr>

                                    </table>   
                                    </div>
                                    <div style="display: flex; justify-content: center; margin: 50px">
                                        <input type="submit" value="Submit">
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                            <th>
                                <a href="${as.stuAs}">${as.stuAs}</a>
                            </th>
                        </tr>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>



    </body>    
</html>



<style>
    table {
        width: 700px;
        height:250px;
        border-collapse: collapse;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border: 1px solid black;
    }
    .th1 {
        background-color: lightgray;
        width: 200px
    }

</style>


