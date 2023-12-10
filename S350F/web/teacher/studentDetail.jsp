<%-- 
    Document   : studentInfo
    Created on : 2023年12月3日, 上午1:44:17
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
        <h3 style=" margin-left:5%;">Student Information</h3>
        <form method="get" action="StudentInfoController" id="myForm">
            <div style="width: 24rem;" class="center-div">
                <input type="hidden" name="action" value="UpdateStuInfo" />
                <input type="hidden" name="page" value="s" />
                <input type="hidden" name="sName" value="${student.stuName}" />
                <input type="hidden" name="sId" value="${student.stuID}" />
                <input type="hidden" name="major" value="${student.majorSubject}" />
                <input type="hidden"  name="year"  value="${student.year}" />
                <p class="card-text">
                <div class="mb-3">
                    <label for="Name">Student Name</label>
                    <input type="text"  class="form-control " id="Name" aria-describedby="emailHelp" value="${student.stuName}" disabled>
                </div>
                <div class="mb-3">
                    <label for="ID">Student ID</label>
                    <input type="text" class="form-control " name="sId" id="sID" aria-describedby="emailHelp" value="${student.stuID}" disabled>
                </div>
                <div class="mb-3">
                    <label for="Major">Major</label>
                    <input type="text" class="form-control" id="Major" aria-describedby="emailHelp" value="${student.majorSubject}"  disabled>
                </div>
                <div class="mb-3">
                    <label for="Year">Study Year</label>
                    <input type="text" class="form-control " id="Year" aria-describedby="emailHelp" value="${student.year}" disabled>
                </div>

                <div class="mb-3">
                    <label for="Phone">Phone</label>
                    <input type="text" class="form-control" id="Phone" aria-describedby="emailHelp" name="phone" value="${student.phoneNumber}" disabled pattern="[0-9]{8}"  disabled>
                </div>                    
                <div class="mb-3">
                    <label for="gender">Gender</label>
                    <select name="gender" class="form-control" id="gender" disabled>
                        <option value="M" <c:if test="${student.gender == 'M'}">selected</c:if>>M</option>
                        <option value="F" <c:if test="${student.gender == 'F'}">selected</c:if>>F</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="Email">Email</label>
                        <input type="text" class="form-control" id="Email" aria-describedby="emailHelp" name="pEmail" value="${student.personalEmail}" disabled pattern="[0-9]{8}"  disabled>
                </div>                
                <div class="mb-3">
                    <label for="Address" class="form-label">Address</label>
                    <textarea class="form-control" id="Address"  name="address"rows="3" disabled>${student.address}</textarea>
                </div>
                </p>
              
            </div>
        </form>
    </body>
</html>
<style>
    .center-div {
    margin: 0 auto;
}
</style>