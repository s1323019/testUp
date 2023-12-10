<%-- 
    Document   : showAllStudentInfo
    Created on : 2023年12月2日, 下午8:13:20
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
        <jsp:include page="teachber.jsp"/>   
        <h3 style=" margin-left:5%;">Student Info</h3>
<!--        search: <input type="text" id="searchInput"  class="test"  placeholder="Search ID..">-->
        <div class="input-group mb-3" style=" margin-left:20%; width:60%;">
            <span class="input-group-text " id="basic-addon1" style=" background-color: white;"  ><svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M10 2.5a7.5 7.5 0 0 1 5.964 12.048l4.743 4.745a1 1 0 0 1-1.32 1.497l-.094-.083-4.745-4.743A7.5 7.5 0 1 1 10 2.5Zm0 2a5.5 5.5 0 1 0 0 11 5.5 5.5 0 0 0 0-11Z" fill="#212121"/></svg></span>
            <input type="text" class="form-control" placeholder="Search ID.." aria-label="Username" aria-describedby="basic-addon1"  id="searchInput">
        </div>
    </div>
    <div class="table-container"> 
        <table class="table table-hover" style="width:60%">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Year</th>
                    <th>Gender</th>
                    <th>Major</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody id="studentTableBody">
                <c:forEach items="${studentList}" var="c"> 
                    <tr>
                        <td id="sid">${c.stuID}</td>
                        <td> ${c.stuName} </td>
                        <td>${c.year}</td>
                        <td>${c.gender}</td>
                        <td>${c.majorSubject}</td>
                        <td>
                            <a href="TeacherController?action=showStudentInfo&&sId=${c.stuID}">
                                <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M6.5 2A2.5 2.5 0 0 0 4 4.5v15A2.5 2.5 0 0 0 6.5 22h13.25a.75.75 0 0 0 0-1.5H6.5a1 1 0 0 1-1-1h14.25a.75.75 0 0 0 .75-.75V4.5A2.5 2.5 0 0 0 18 2H6.5Zm9 10.25v.5c0 1-1.383 1.75-3.25 1.75S9 13.75 9 12.75v-.5a.75.75 0 0 1 .75-.75h5a.75.75 0 0 1 .75.75ZM14 8.745a1.75 1.75 0 1 1-3.5 0C10.5 7.78 11.283 7 12.25 7S14 7.779 14 8.745Z" fill="#212121"/>
                                </svg>
                            </a>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
<script>

    var searchInput = document.getElementById("searchInput");
    var studentTableBody = document.getElementById("studentTableBody");

    searchInput.addEventListener("input", function () {
        var searchKeyword = searchInput.value.toLowerCase();
        console.log(" test ")
        Array.from(studentTableBody.getElementsByTagName("tr")).forEach(function (row) {
            var studentId = row.getElementsByTagName("td")[0].textContent.toLowerCase();

            if (studentId.includes(searchKeyword)) {
                row.classList.remove("hidden");
            } else {
                row.classList.add("hidden");
            }
        });
    });


</script>
<style>
    .hidden {
        display: none;
    }

    .table-container {
        margin-top: 3%;
        display: flex;
        justify-content: center;
    }

    

</style>