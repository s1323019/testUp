/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import bean.Course;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fg58hj123ty
 */
public class CourseDB {
    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";
    
    
    public CourseDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    
    public ArrayList<Course> showCourse(String studentID){
        PreparedStatement ps = null;
        Connection ct = null;
        ArrayList<Course> courseList = new  ArrayList<>();
        try{
        ct = getConnection();
        String sql = " SELECT c.course_id, course_name, stu_id "
                + " FROM course c INNER JOIN courseselection cs ON c.course_id = cs.course_id "
                + " WHERE cs.stu_id = ? ";
        ps = ct.prepareStatement(sql);
        ps.setString(1, studentID);
        ResultSet rs = null;
        rs = ps.executeQuery();
        while(rs.next()){
            Course course = new Course();
            course.setCourseID(rs.getString("course_id"));
            course.setCourseName(rs.getString("course_name"));
            courseList.add(course);   
        }
        ps.close();
        ct.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return courseList;
    }
    
    
     public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection(dburl, dbUser, dbPassword);
    }
    
}
