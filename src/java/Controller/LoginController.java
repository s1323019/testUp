/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;
import bean.Student;
import bean.StudentAC;
import bean.Teacher;
import db.ItStaffDB;
import db.StudentDB;
import db.TeacherDB;
import java.io.IOException;
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
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {


    private StudentDB studenDB;
    private TeacherDB teacherDB;
    private ItStaffDB itStaffDB;
    
    @Override
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        studenDB = new StudentDB(dbUrl, dbUser, dbPassword);
        teacherDB = new TeacherDB(dbUrl, dbUser, dbPassword);
        itStaffDB = new ItStaffDB(dbUrl, dbUser, dbPassword);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        }

    }

    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("stuAid");
        String password = request.getParameter("password");
        String targetURL;
        boolean isStu = false;
         boolean ist = false;
         boolean isi = false;
        if(id.startsWith("s")){
            isStu = studenDB.isValidUser(id, password);
        }else if(id.startsWith("t")){
            ist = teacherDB.isValidUser(id, password);
        }else if(id.startsWith("i")){
            isi = itStaffDB.isValidUser(id, password);
        }

        if (isStu ) {
            HttpSession session = request.getSession(true);
            StudentAC studentAc = new StudentAC();
            studentAc.setStuAid(id);
            session.setAttribute("StudentAC", studentAc);
            Student student = studenDB.getPersonalInfo(id);
            session.setAttribute("StuID", student.getStuID());
//            response.sendRedirect("StudentInfoController?action=ShowStudentInfo");
            response.sendRedirect("CourseController?action=showCourse");
//            response.sendRedirect("StudentInfoController?action=ShowStudentScore");
             
        } else if(ist){
            HttpSession session = request.getSession(true);
            Teacher teacher = new Teacher();
            teacher.setTeacherID(id);
            session.setAttribute("Teacher", teacher);
            response.sendRedirect("TeacherController?action=listStudentInfo");
            
        }else if(isi){
             HttpSession session = request.getSession(true);
             response.sendRedirect("ItStaffController?action=listStudent");
        
        } else {
           
            targetURL = "login.jsp";
            String loginError = "loginError";
            request.setAttribute("loginError",loginError);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/" + targetURL);
            rd.forward(request, response);
        }

    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String targeURL = "text.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targeURL);
        rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
