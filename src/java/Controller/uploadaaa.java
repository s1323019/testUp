/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import db.TeacherDB;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
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
@WebServlet(name = "uploadaaa", urlPatterns = {"/uploadaaa"})
public class uploadaaa extends HttpServlet {

    private TeacherDB teacherDB;

    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        teacherDB = new TeacherDB(dbUrl, dbUser, dbPassword);
    }

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No file uploaded");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            String filePath = null;
            String fileName = "";
            String courseId = "";
            String aTitle = "";
            String dueDate = "";
            for (FileItem item : items) {
                if (item.isFormField()) {
                    if (item.getFieldName().equals("courseId")) {
                        courseId = item.getString();
                    } else if (item.getFieldName().equals("aTitle")) {
                        aTitle = item.getString();
                    } else if (item.getFieldName().equals("dueDate")) {
                        dueDate = item.getString();
                    }
                } else {
                    fileName = new File(item.getName()).getName();
                    filePath = "F:/HKMU/S350F/web/forAssignment/" + fileName;
                    File uploadedFile = new File(filePath);
                    item.write(uploadedFile);
                }

            }
            HttpSession seesion = request.getSession(true);
            boolean h = teacherDB.newAssigement(courseId, aTitle, fileName, dueDate);
            response.sendRedirect("TeacherController?action=listAssigment");

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading file");
            e.printStackTrace();
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
