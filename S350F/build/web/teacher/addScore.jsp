<%-- 
    Document   : addScore
    Created on : 2023年11月30日, 下午3:56:58
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


        <h3 style=" margin-left:5%;">Student ID:${sid}</h3>
         <div class="table-container"> 
        <table class="table table-hover" style="width:60%">
            <thead>
                <tr>
                    <th>Category</th>
                    <th>Score Category</th>
                    <th>Score</th>
                    <th>Grade</th>
                    <th>
                        <svg data-bs-toggle="modal" data-bs-target="#exampleModal" width="28" height="28" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M3 6.25A3.25 3.25 0 0 1 6.25 3h11.5A3.25 3.25 0 0 1 21 6.25v11.5A3.25 3.25 0 0 1 17.75 21H6.25A3.25 3.25 0 0 1 3 17.75V6.25Zm9.75 1.5a.75.75 0 0 0-1.5 0v3.5h-3.5a.75.75 0 0 0 0 1.5h3.5v3.5a.75.75 0 0 0 1.5 0v-3.5h3.5a.75.75 0 0 0 0-1.5h-3.5v-3.5Z" fill="#212121"/>
                        </svg>
                    </th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${studentScoreList}" var="c"> 
                    <tr>
                        <td>${c.category}</td>
                        <td>${c.scoreCategory}</td>
                        <td>${c.getMark}/${c.fullMark}</td>
                        <td>${c.grade}</td>
                        <td>
                            <a href="TeacherController?action=deleteScore&&gid=${id}&&sid=${sid}&&cid=${cid}&&id=${c.id}">
                                <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z" fill="#212121"/>
                                </svg>
                            </a>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
             
         </div>
         <div class="ad">
              This Course The Total Grade is : ${totalGrade}             
         </div>    


        <!-- Button trigger modal -->
        <!--    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add SCORE
            </button>-->

        <!-- Modal -->
        <form method="get" action="TeacherController" id="submitAddScore">
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">ADD SCORE</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="action" name="action" value="addScore" >
                            <input type="hidden" id="gid" name="gid"value="${id}">
                            <input type="hidden" id="cid" name="cid"value="${cid}">
                            <input type="hidden" id="sid" name="sid"value="${sid}">
                            <input type="hidden" id="grade"  name="grade" value="">
                            <label for="Category">Category</label>
                            <select  class="form-select" aria-label="Category" id="Category" name="Category">
                                <option selected>select</option>
                                <option value="OCAS">OCAS</option>
                                <option value="OES">OES</option>
                            </select>

                            <label for="ScoreCategory">Score Category</label>
                            <select class="form-select" aria-label="ScoreCategory" id="ScoreCategory" name="ScoreCategory">
                                <option selected>select</option>
                                <option value="Lab">Lab</option>
                                <option value="Test">Test</option>
                                <option value="Assignment">Assignment</option>
                                <option value="Exam">Exam</option>
                            </select>
                            
                            <div class="row" id="testNumberRow" style="display: none;">
                                <label for="testNumber" class="form-label">Test Number</label>
                                <div class="col">
                                    <input type="number" id="testNumber" name="testNumber" class="form-control" placeholder="Test Number">
                                </div>
                            </div>


                            <div class="row">
                                <label for="exampleInputEmail1" class="form-label"> to receive a score</label>
                                <div class="col">
                                    <input type="text" id="gM" name="gM" class="form-control" placeholder="to receive a score">
                                </div>
                                /
                                <div class="col">
                                    <input type="text" id="fullM" name="fullM"  class="form-control" placeholder="Full Maek">
                                </div>                       
                            </div>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Upload Score</button>
                        </div>


                    </div>
                </div>
            </div>
        </form>


    </body>
</html>

<%
    Boolean overMarkObject = (Boolean) request.getAttribute("overMark");
    boolean overMark = overMarkObject != null && overMarkObject;


%>

<script>

    function checkOverMark() {
        let overMark = <%= overMark%>;
        if (overMark) {
            alert("Warning: The maximum mark exceeds the allowed range. Pls delete or modify");
            return false;
        }
    }

    window.addEventListener('DOMContentLoaded', (event) => {
        checkOverMark();
    });

    let fullMInput = document.getElementById('fullM');
    let gMInput = document.getElementById('gM');
    let gradeInput = document.getElementById('grade');
    let form = document.getElementById('submitAddScore');


    form.addEventListener('submit', function (event) {
        event.preventDefault();

        let gM = parseFloat(gMInput.value);
        let fullM = parseFloat(fullMInput.value);
        let percentage = (gM / fullM) * 100;
        let grade;
        if (gM < 0 || gM > 100 || fullM < 0 || fullM > 100) {

            alert("There is something wrong with the score you entered, please re-enter it.");
            return;
        }

        if (percentage < 40 && percentage >= 0) {
            grade = 'F';
        } else if (percentage >= 40 && percentage <= 44) {
            grade = 'C';
        } else if (percentage >= 45 && percentage <= 50) {
            grade = 'C+';
        } else if (percentage >= 51 && percentage <= 56) {
            grade = 'B-';
        } else if (percentage >= 57 && percentage <= 62) {
            grade = 'B';
        } else if (percentage >= 63 && percentage <= 69) {
            grade = 'B+';
        } else if (percentage >= 70 && percentage <= 76) {
            grade = 'A-';
        } else if (percentage >= 77 && percentage <= 100) {
            grade = 'A';
        } else {
            alert("There is something wrong with the score you entered, please re-enter it.");

            gradeInput.value = "Test";
            var inputs = form.elements;
            for (var i = 0; i < inputs.length; i++) {
                var input = inputs[i];
                console.log(input.value);
            }
            return;
        }
        gradeInput.value = grade;


        form.submit();
    });
</script>

<script>
    document.getElementById("ScoreCategory").addEventListener("change", function() {
        var selectedOption = this.value;
        var testNumberRow = document.getElementById("testNumberRow");

        if (selectedOption === "Test") {
            testNumberRow.style.display = "flex";
        } else {
            testNumberRow.style.display = "none";
        }
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
    
    .ad{
         margin-left:  20%;
        display: flex;
     
    }
    

</style>