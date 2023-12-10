<%-- 
    Document   : login
    Created on : 2023年10月13日, 上午1:39:34
    Author     : fg58hj123ty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
<% 
  String loginError = request.getHeader("loginError");
  if (loginError != null) {
%>

<script>

    alert("Something went wrong!");

</script>

<%
  }
%>
</script>
    <body>
        <section class="vh-100" style="background-color: #E0FFFF">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">  
                        <div class="card shadow-2-strong" style="border-radius: 0.7rem ; background-color: #508bfc" >
                            <div class="card-body p-5 text-center">
                                <form method="get" action="Login">
                                    <input type='hidden' name='action' value='authenticate'/>
                                    <h3 class="mb-5">MU</h3>

                                    <div class="form-floating mb-3">
                                        <input type="text" name="stuAid" id="typeEmailX-2" class="form-control" placeholder="eg s1234567" required/>
                                        <label class="form-label align-self-start" for="typeEmailX-2">ID</label>
                                    </div>
                                    
                                    
                                    <div class="form-floating">
                                        <input type="password" name="password" id="floatingPassword-2" class="form-control" placeholder="Password" required />
                                        <label class="form-label align-self-start" for="floatingPassword">Password</label>
                                    </div>          
                                    
                                    <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
