/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import bean.AS;

import bean.Student;
import bean.StudentGrade;
import bean.StudentScore;
import bean.TeacherAssignment;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fg58hj123ty
 */
public class TeacherDB {

    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public TeacherDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean isValidUser(String stuAId, String pwd) {
        boolean isValid = false;
        PreparedStatement ps = null;
        Connection ct = null;
        try {
            ct = getConnection();
            String sql = "SELECT * FROM teacher WHERE teacher_id = ? and password = ?";
            ps = ct.prepareStatement(sql);
            ps.setString(1, stuAId);
            ps.setString(2, pwd);
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ct.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return isValid;
    }

    public void addScore(String courseID, String stuID, String category, String score_category, String grade, String fullM, double GM, int gid) {
        PreparedStatement ps = null;
        Connection ct = null;
        try {
            ct = getConnection();
            String sql = "INSERT INTO studend_score(course_id, stu_id, category, score_category, grade, full_mark, getMark, grade_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = ct.prepareStatement(sql);
            ps.setString(1, courseID);
            ps.setString(2, stuID);
            ps.setString(3, category);
            ps.setString(4, score_category);
            ps.setString(5, grade);
            ps.setString(6, fullM);
            ps.setDouble(7, GM);
            ps.setInt(8, gid);
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ct.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

   public boolean newAssigement(String courseId, String aTitle, String aMaterial, String dueDate) {
    boolean a = false;
    try {
        Connection ct = getConnection();
        String sql1 = "INSERT INTO assignment(course_id, assignment_title, assignment_material, due_date) VALUES (?, ?, ?, ?)";
        PreparedStatement ps1 = ct.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
        ps1.setString(1, courseId);
        ps1.setString(2, aTitle);
        ps1.setString(3, aMaterial);
        ps1.setString(4, dueDate);
        int rs1 = ps1.executeUpdate();
        
        if (rs1 >= 1) {
            ResultSet generatedKeys = ps1.getGeneratedKeys();
            if (generatedKeys.next()) {
                int firstId = generatedKeys.getInt(1);
                String sql2 = "INSERT INTO studentassignment(assignment_id, stu_id) " +
                              "SELECT ?, cs.stu_id " +
                              "FROM courseselection cs " +
                              "WHERE cs.course_id = ? AND cs.stu_id IS NOT NULL";
                PreparedStatement ps2 = ct.prepareStatement(sql2);
                ps2.setInt(1, firstId);
                ps2.setString(2, courseId);
                int rs2 = ps2.executeUpdate();
                
                if (rs2 >= 1) {
                    a = true;
                }
                ps2.close();
            }
            generatedKeys.close();
        }
        ps1.close();
        ct.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return a;
}

        public void updateStudentGrade(int gid, String grade, String status) {
        try {
            Connection ct = getConnection();;
            String sql = "update student_grade set grade = ? , Status = ?  where id = ? ";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setString(1, grade);
            ps.setString(2, status);
            ps.setInt(3, gid);
            int rs = ps.executeUpdate();
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentScore(int id) {
        try {
            Connection ct = getConnection();;
            String sql = "delete from studend_score where id = ? ";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<StudentGrade> getStudentGradeInfo(String teacherID) {
        PreparedStatement ps = null;
        Connection ct = null;
        ArrayList<StudentGrade> as = new ArrayList<>();
        try {
            ct = getConnection();
            String sql = "select * from student_grade sc ,course c where ? = c.teacher_id and c.course_id = sc.course_id";
            ps = ct.prepareStatement(sql);
            ps.setString(1, teacherID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentGrade s = new StudentGrade();
                s.setId(rs.getInt(1));
                s.setCourseID(rs.getString(2));
                s.setStudentID(rs.getString(3));
                s.setGrade(rs.getString(4));
                s.setStatus(rs.getString(5));
                as.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ct.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return as;
    }

    public ArrayList<Student> getAllStudentInfo(String tId) {

        ArrayList<Student> studentList = new ArrayList<>();
        try {
            Connection ct = getConnection();
            String sql = "SELECT DISTINCT s.stu_id , s.stu_name , s.year , s.personal_email ,s.gender , s.age , s.address , s.phone_number , s.major_subject , s.stu_aid "
                    + "FROM student s "
                    + " JOIN courseselection cs ON s.stu_id = cs.stu_id "
                    + " JOIN course c ON cs.course_id = c.course_id "
                    + " WHERE c.teacher_id = ? ";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setString(1, tId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStuID(rs.getString(1));
                student.setStuName(rs.getString(2));
                student.setYear(rs.getString(3));
                student.setPersonalEmail(rs.getString(4));
                student.setGender(rs.getString(5));
                student.setAge(rs.getInt(6));
                student.setAddress(rs.getString(7));
                student.setPhoneNumber(rs.getInt(8));
                student.setMajorSubject(rs.getString(9));
                student.setStu_aid(rs.getString(10));
                studentList.add(student);
            }
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public ArrayList<StudentScore> getStudentScoreInfo(int Grafeid) {
        PreparedStatement ps = null;
        Connection ct = null;
        ArrayList<StudentScore> as = new ArrayList<>();
        try {
            ct = getConnection();
            String sql = "select * from studend_score where grade_id = ? order by field(score_category, 'test', 'assignment', 'exam');";
            ps = ct.prepareStatement(sql);
            ps.setInt(1, Grafeid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentScore s = new StudentScore();
                s.setId(rs.getInt(1));
                s.setCourseID(rs.getString(2));
                s.setStuID(rs.getString(3));
                s.setCategory(rs.getString(4));
                s.setScoreCategory(rs.getString(5));
                s.setGrade(rs.getString(6));
                s.setFullMark(rs.getString(7));
                s.setGetMark(rs.getString(8));
                as.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ct.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return as;

    }

    public ArrayList<TeacherAssignment> getTeacherAssignment(String teachId) {
        ArrayList<TeacherAssignment> taList = new ArrayList<>();
        try {
            Connection ct = getConnection();;
            String sql = " select c.course_id, a.assignment_id , a.assignment_title , a.due_date ,a.status "
                    + " from assignment a , teacher t ,course c where a.course_id = c.course_id and c.teacher_id = ? ";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setString(1, teachId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TeacherAssignment t = new TeacherAssignment();
                t.setCourseId(rs.getString(1));
                t.setAssId(rs.getInt(2));
                t.setAssTitle(rs.getString(3));
                t.setDueDate(rs.getDate(4));
                t.setAssStatus(rs.getString(5));
                taList.add(t);
            }
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return taList;
    }

    public ArrayList<AS> getSpecificAssignments(int AssId) {
        ArrayList<AS> aList = new ArrayList<>();
        try {
            Connection ct = getConnection();;
            String sql = "SELECT s.stu_id, s.stu_name, sm.status, sm.submit_time"
                    + " FROM studentassignment sm"
                    + " JOIN student s ON sm.stu_id = s.stu_id "
                    + " JOIN assignment a ON sm.assignment_id = a.assignment_id "
                    + " WHERE a.assignment_id = ?;";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setInt(1, AssId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AS a = new AS();
                a.setStuId(rs.getString(1));
                a.setStuName(rs.getString(2));
                a.setStatus(rs.getString(3));
                a.setSubmitTime(rs.getDate(4));
                aList.add(a);
            }
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aList;
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
