/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import bean.Course;
import bean.Student;
import bean.StudentAC;
import db.CourseDB;
import db.StudentDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fg58hj123ty
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {
    private StudentDB studentDB;
    private CourseDB courseDB;

    public void init(){
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        studentDB = new StudentDB(dbUrl, dbUser, dbPassword);
        courseDB = new CourseDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if("showCourse".equals(request.getParameter("action"))){
            HttpSession session = request.getSession(true);
            StudentAC studentAc = (StudentAC) session.getAttribute("StudentAC");
            Student student = studentDB.getPersonalInfo(studentAc.getStuAid());
            ArrayList<Course> courseList = courseDB.showCourse( student.getStuID() );
            System.out.println(student.getStuID());
            request.setAttribute("Course", courseList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/main.jsp");
            rd.forward(request, response);
        
        }
            
    }
    
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
}
