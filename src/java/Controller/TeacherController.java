/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.util.logging.Logger;
import bean.AS;
import bean.Student;
import bean.StudentGrade;
import bean.StudentScore;
import bean.Teacher;
import bean.TeacherAssignment;
import db.StudentDB;
import db.TeacherDB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author fg58hj123ty
 */
@WebServlet(name = "TeacherController", urlPatterns = {"/TeacherController"})
public class TeacherController extends HttpServlet {

    private TeacherDB teacherDB;
    private static final Logger logger = Logger.getLogger(TeacherController.class.getName());
private StudentDB studentDB;
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        teacherDB = new TeacherDB(dbUrl, dbUser, dbPassword);
                studentDB = new StudentDB(dbUrl, dbUser, dbPassword);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("showStudentGrade".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            Teacher teacher = (Teacher) session.getAttribute("Teacher");
            ArrayList<StudentGrade> studentGradeList = teacherDB.getStudentGradeInfo(teacher.getTeacherID());
            request.setAttribute("studentGradeList", studentGradeList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "uploadStudentGrade.jsp");
            rd.forward(request, response);
        }
        
         if ("showStudentInfo".equals(request.getParameter("action"))) {
            String sId = request.getParameter("sId");
            Student student  = studentDB.getPersonalInfoForsId(sId);
            request.setAttribute("student", student);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "studentDetail.jsp");
            rd.forward(request, response);
        }

        if ("addScore".equals(request.getParameter("action"))) {
            String category = request.getParameter("Category");
            String score_category = request.getParameter("ScoreCategory");
            String grade = request.getParameter("grade");
            String fullM = request.getParameter("fullM");
            double GM = Double.parseDouble(request.getParameter("gM"));
            int gid = Integer.parseInt(request.getParameter("gid"));
            String cid = request.getParameter("cid");
            String sid = request.getParameter("sid");
            if (score_category.equals("Test")) {
                score_category += request.getParameter("testNumber");
            }
            teacherDB.addScore(cid, sid, category, score_category, grade, fullM, GM, gid);
            response.sendRedirect("TeacherController?action=listScore&&id=" + gid + "&&cid=" + cid + "&&sid=" + sid + "");

        }

        if ("deleteScore".equals(request.getParameter("action"))) {
            int gid = Integer.parseInt(request.getParameter("gid"));
            String cid = request.getParameter("cid");
            String sid = request.getParameter("sid");
            int id = Integer.parseInt(request.getParameter("id"));
            teacherDB.deleteStudentScore(id);
            response.sendRedirect("TeacherController?action=listScore&&id=" + gid + "&&cid=" + cid + "&&sid=" + sid + "");
        }

       
        if ("listScore".equals(request.getParameter("action"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<StudentScore> studentScoreList = teacherDB.getStudentScoreInfo(id);
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("cid", request.getParameter("cid"));
            request.setAttribute("sid", request.getParameter("sid"));
            request.setAttribute("studentScoreList", studentScoreList);
            int maxMark = 0;
            double getMark = 0;
            int percentage = 0;
            String grade = "Not finish";
            boolean overMark = false;
            for (StudentScore s : studentScoreList) {
                maxMark += Integer.parseInt(s.getFullMark());
                getMark += Double.parseDouble(s.getGetMark());
            }
            if (maxMark > 100 || maxMark < 0) {
                overMark = true;
            } else if (studentScoreList.size() == 0) {
                grade = "No scores entered";
            } else if (maxMark == 100) {
                percentage = (int) ((getMark / maxMark) * 100);
                if (percentage < 40 && percentage >= 0) {
                    grade = "F";
                } else if (percentage >= 40 && percentage <= 44) {
                    grade = "C";
                } else if (percentage >= 45 && percentage <= 50) {
                    grade = "C+";
                } else if (percentage >= 51 && percentage <= 56) {
                    grade = "B-";
                } else if (percentage >= 57 && percentage <= 62) {
                    grade = "B";
                } else if (percentage >= 63 && percentage <= 69) {
                    grade = "B+";
                } else if (percentage >= 70 && percentage <= 76) {
                    grade = "A-";
                } else if (percentage >= 77 && percentage <= 100) {
                    grade = "A";
                }
                teacherDB.updateStudentGrade(id, grade, "Finish");
            } else {
                grade = "Not all scores filled in";
                teacherDB.updateStudentGrade(id, "N/A", "Not Finish");
            }
            request.setAttribute("totalGrade", grade);
            request.setAttribute("overMark", overMark);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "addScore.jsp");
            rd.forward(request, response);
        }

        if ("listStudentInfo".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            Teacher teacher = (Teacher) session.getAttribute("Teacher");
            ArrayList<Student> studentList = teacherDB.getAllStudentInfo(teacher.getTeacherID());
            request.setAttribute("studentList", studentList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "showAllStudentInfo.jsp");
            rd.forward(request, response);
        }

        if ("listStudentDetail".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            Teacher teacher = (Teacher) session.getAttribute("Teacher");
            ArrayList<Student> studentList = teacherDB.getAllStudentInfo(teacher.getTeacherID());
            request.setAttribute("studentList", studentList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "showAllStudentInfo.jsp");
            rd.forward(request, response);
        }

        if ("listAssigment".equals(request.getParameter("action"))) {
            HttpSession session = request.getSession(true);
            Teacher teacher = (Teacher) session.getAttribute("Teacher");
            ArrayList<TeacherAssignment> teacherAssignment = teacherDB.getTeacherAssignment(teacher.getTeacherID());
            request.setAttribute("teacherAssignment", teacherAssignment);
            request.setAttribute("tid", teacher.getTeacherID());
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "showAllAssigment.jsp");
            rd.forward(request, response);
        }

        if ("showSpecificAssignmentList".equals(request.getParameter("action"))) {
            int AssId = Integer.parseInt(request.getParameter("AssId"));
            ArrayList<AS> AsList = teacherDB.getSpecificAssignments(AssId);
            request.setAttribute("AsList", AsList);
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/teacher/" + "listStudentAssList.jsp");
            rd.forward(request, response);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
