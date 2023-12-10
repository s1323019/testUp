<%-- 
    Document   : showStudentMark
    Created on : 2023年11月11日, 下午4:13:16
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
    <body>
          <jsp:include page="courseber.jsp"/>   
        <table>
            <p>${sc.courseID}</p>        
            <c:if test="${scList != null}">
                <c:forEach items="${scList}" var="sc">

                    <tr>
                        <c:choose>
                            <c:when test="${sc.scoreCategory eq 'Test'}">
                                <c:set var="v" value="${v + 1}" />
                                <td>${sc.scoreCategory}${v}</td>
                            </c:when>
                            <c:otherwise>
                                <td>${sc.scoreCategory}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>${sc.fullMark}%</td>
                        <td>${sc.markLevel}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>


        <c:if test="${not empty existingFileName}">
            <p>not score</p>
        </c:if>

    </body>
</html>
