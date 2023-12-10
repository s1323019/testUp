<%-- 
    Document   : courseber
    Created on : 2023年11月13日, 上午7:42:39
    Author     : fg58hj123ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="CourseController?action=showCourse">MU</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav ">
                        <li class="nav-item">
                            <a class="nav-link" href="StudentInfoController?action=ShowAllAS">Assignment</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="StudentInfoController?action=ShowTranscript">Transcript</a>
                        </li>
                    </ul>
                </div>
                <ul class="navbar-nav navbar-right">
                    <li  class="nav-item dropdown">
                        <div class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img  src="photo/account.png" style="width:38px;height:38px;">
                        </div>
                        <ul class="dropdown-menu">
                                <li><a class="dropdown-item"  href="StudentInfoController?action=ShowStudentInfo">Profile</a></li>
                                <li><a class="dropdown-item" href="login.jsp">Logout</a></li>
                            </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>

