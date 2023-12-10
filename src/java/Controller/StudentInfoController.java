/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import bean.Student;
import bean.StudentAC;
import bean.StudentAssignmentInfo;
import bean.StudentScore;
import bean.StudentT;
import bean.TeacherAssignment;
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
@WebServlet(name = "StudentInfoController", urlPatterns = {"/StudentInfoController"})
public class StudentInfoController extends HttpServlet {

    private StudentDB studentDB;

    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        studentDB = new StudentDB(dbUrl, dbUser, dbPassword);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("ShowStudentInfo".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            StudentAC studentAc = (StudentAC) session.getAttribute("StudentAC");
            Student student = studentDB.getPersonalInfo(studentAc.getStuAid());
            request.setAttribute("student", student);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/studentInfo.jsp");
            rd.forward(request, response);
        }

        if ("UpdateStuInfo".equals(request.getParameter("action"))) {
            String sId = request.getParameter("sId");
            String sName = request.getParameter("sName");
            String year = request.getParameter("year");
            String major = request.getParameter("major");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String email = request.getParameter("pEmail");
            String address = request.getParameter("address");
            HttpSession session = request.getSession(true);
//            StudentAC studentAc = (StudentAC) session.getAttribute("StudentAC");
            Boolean result = studentDB.updateStuInfo(sId, sName, year, major, phone, gender, email, address);
            if ("t".equals(request.getParameter("page"))) {
                response.sendRedirect("ItStaffController?action=editStudent&&sId=" + sId + "");

            } else if ("s".equals(request.getParameter("page"))) {
                response.sendRedirect("StudentInfoController?action=ShowStudentInfo");
            }

        }

        if ("interCourse".equals(request.getParameter("action"))) {
            String courseID = (String) request.getParameter("courseID");
            HttpSession session = request.getSession(true);
            session.setAttribute("courseID", courseID);
            response.sendRedirect("StudentInfoController?action=ShowAllAS");
        }

        if ("ShowStudentAssigment".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            String StuID = (String) session.getAttribute("StuID");
            int sId = Integer.parseInt(request.getParameter("assid"));
            StudentAssignmentInfo as = studentDB.getAssignmentInfo(sId, StuID);
            request.setAttribute("as", as);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/showAssigment.jsp");
            rd.forward(request, response);
        }

        if ("ShowAllAS".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            String StuID = (String) session.getAttribute("StuID");
            ArrayList<TeacherAssignment> scList = studentDB.getAllAssignments(StuID);
            request.setAttribute("scList", scList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/ListAllAssigment.jsp");
            rd.forward(request, response);
        }

//        if ("ShowStudentScore".equals(request.getParameter("action"))) {
//            HttpSession session = request.getSession(true);
//            String courseID = (String) session.getAttribute("courseID");
//            String StuID = (String) session.getAttribute("StuID");
//            ArrayList<StudentScore> scList = studentDB.getScore(courseID, StuID);
//            request.setAttribute("scList", scList);
//            RequestDispatcher rd;
//            rd = getServletContext().getRequestDispatcher("/showStudentMark.jsp");
//            rd.forward(request, response);
//        }

        if ("ShowTranscript".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            String StuID = (String) session.getAttribute("StuID");
            ArrayList<StudentT> scList = studentDB.getTranscript(StuID);

            double totalGradePoints = 0.0;
            int totalCredits = 0;

            for (StudentT studentT : scList) {
                String grade = studentT.getGrade();
                double gradePoints;

                switch (grade) {
                    case "A":
                        gradePoints = 4.0;
                        break;
                    case "A-":
                        gradePoints = 3.7;
                        break;
                    case "B+":
                        gradePoints = 3.3;
                        break;
                    case "B":
                        gradePoints = 3.0;
                        break;
                    case "B-":
                        gradePoints = 2.7;
                        break;
                    case "C+":
                        gradePoints = 2.3;
                        break;
                    case "C":
                        gradePoints = 2.0;
                        break;
                    default:
                        gradePoints = 0.0;
                        break;
                }

                totalGradePoints += gradePoints;
                totalCredits++;
            }

            double totalGPA = totalGradePoints / totalCredits;

            request.setAttribute("scList", scList);
            request.setAttribute("totalGPA", totalGPA);

            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/showTranscript.jsp");
            rd.forward(request, response);
        }

    }

    public void getStuInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        StudentAC studentAc = (StudentAC) session.getAttribute("StudentAC");
        Student student = studentDB.getPersonalInfo(studentAc.getStuAid());
        request.setAttribute("student", student);
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
