<%-- 
    Document   : ListAllAssigment
    Created on : 2023年12月4日, 下午3:43:51
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
        <jsp:include page="courseber.jsp"/>  
        <h3 style=" margin-left:5%;"> My Assignment</h3>
        <div class="input-group mb-3" style=" margin-left:20%; width:60%;">
            <span class="input-group-text " id="basic-addon1" style=" background-color: white;"  ><svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M10 2.5a7.5 7.5 0 0 1 5.964 12.048l4.743 4.745a1 1 0 0 1-1.32 1.497l-.094-.083-4.745-4.743A7.5 7.5 0 1 1 10 2.5Zm0 2a5.5 5.5 0 1 0 0 11 5.5 5.5 0 0 0 0-11Z" fill="#212121"/></svg></span>
            <input type="text" class="form-control" placeholder="Search Course ID .." aria-label="Username" aria-describedby="basic-addon1"  id="searchInput">
        </div>
        
         <div class="table-container"> 
        <table class="table table-hover" style="width:60%">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Title</th>
                    <th>Due Date</th>
                    <th>Assignment State</th>
                    <th>Submit</th>
                </tr>
            </thead>
            <tbody id="studentTableBody">
                <c:forEach items="${scList}" var="c"> 
                    <tr>
                        <td>${c.courseId}</td>
                        <td>${c.assTitle}</td>
                        <td>${c.dueDate}</td>
                        <td>${c.assStatus}</td>
                        <td>
                            <a href="StudentInfoController?action=ShowStudentAssigment&&assid=${c.assId}">
                                <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M12 2v6a2 2 0 0 0 2 2h4.92c-.596.22-1.144.554-1.558.97l-6.05 6.092a2.815 2.815 0 0 0-.728 1.279l-.525 2.03A2.082 2.082 0 0 0 10.3 22H5.5A1.5 1.5 0 0 1 4 20.5v-17A1.5 1.5 0 0 1 5.5 2H12Z" fill="#212121"/>
                                <path d="M13.5 2.5V8a.5.5 0 0 0 .5.5h5.5l-6-6ZM12.196 17.572l5.902-5.902a2.285 2.285 0 1 1 3.233 3.232l-5.903 5.902a2.684 2.684 0 0 1-1.247.707l-1.831.457a1.087 1.087 0 0 1-1.318-1.318l.457-1.83c.118-.473.362-.904.707-1.248Z" fill="#212121"/>
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