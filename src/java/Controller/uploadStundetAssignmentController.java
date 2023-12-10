/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import db.StudentDB;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author fg58hj123ty
 */
@WebServlet(name = "uploadStundetAssignmentController", urlPatterns = {"/uploadStundetAssignmentController"})
public class uploadStundetAssignmentController extends HttpServlet {

    private StudentDB studentDB;

    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        studentDB = new StudentDB(dbUrl, dbUser, dbPassword);
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
            String fileName = null;
            int assID = 0 ;
            String courseID = null;
            for (FileItem item : items) {  
                if(item.isFormField()){
                    if (item.getFieldName().equals("assID")) {
                        String id = item.getString();
                        if (id != null && !id.isEmpty()) {
                            assID = Integer.parseInt(id);
                        }
                    }else if(item.getFieldName().equals("courseID")){
                        String id = item.getString();
                        if (id != null && !id.isEmpty()) {
                            courseID = id;
                        }
                    }
                }else {
                    fileName = new File(item.getName()).getName();
                    filePath = "F:/HKMU/S350F/web/forAssignment/" + fileName;
                    File uploadedFile = new File(filePath);
                    item.write(uploadedFile);
                
                }
  
            }
            HttpSession seesion = request.getSession(true);
            String StuID = (String) seesion.getAttribute("StuID");
            if( studentDB.uploadStundetAssignment( StuID ,assID ,fileName)){
                response.sendRedirect("StudentInfoController?action=ShowStudentAssigment&&courseID="+courseID+"&&assid="+assID+"");
            }
//            response.sendRedirect("StudentInfoController?action=ShowStudentAssigment");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading file");
            e.printStackTrace();
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
