/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import bean.StudentScore;
import bean.Student;
import bean.StudentAssignmentInfo;
import bean.StudentT;
import bean.TeacherAssignment;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fg58hj123ty
 */
public class StudentDB {

    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public StudentDB(String dburl, String dbUser, String dbPassword) {
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
            String sql = "SELECT * FROM student_account WHERE stu_aid = ? and password = ?";
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

    public Student getPersonalInfo(String stu_aid) {
        PreparedStatement ps = null;
        Connection ct = null;
        Student student = null;
        try {
            ct = getConnection();
            String sql = "SELECT * FROM student WHERE stu_aid = ? ";
            ps = ct.prepareStatement(sql);
            ps.setString(1, stu_aid);
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStuID(rs.getString("stu_id"));
                student.setStuName(rs.getString("stu_name"));
                student.setPersonalEmail(rs.getString("personal_email"));
                student.setYear(rs.getString("year"));
                student.setAddress(rs.getString("address"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setPhoneNumber(rs.getInt("phone_number"));
                student.setMajorSubject(rs.getString("major_subject"));
                student.setStu_aid(rs.getString("stu_aid"));
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

        return student;
    }
    
    
        public Student getPersonalInfoForsId(String sid) {
        PreparedStatement ps = null;
        Connection ct = null;
        Student student = null;
        try {
            ct = getConnection();
            String sql = "SELECT * FROM student WHERE stu_id = ? ";
            ps = ct.prepareStatement(sql);
            ps.setString(1, sid);
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStuID(rs.getString("stu_id"));
                student.setStuName(rs.getString("stu_name"));
                student.setPersonalEmail(rs.getString("personal_email"));
                student.setYear(rs.getString("year"));
                student.setAddress(rs.getString("address"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setPhoneNumber(rs.getInt("phone_number"));
                student.setMajorSubject(rs.getString("major_subject"));
                student.setStu_aid(rs.getString("stu_aid"));
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

        return student;
    }


    public Boolean updateStuInfo(String sId, String sName, String year, String major, int phone, String gender, String email, String address) {
        PreparedStatement ps = null;
        Connection ct = null;
        Student student = null;
        try {
            ct = getConnection();
            String sql = "UPDATE student "
                    + "SET stu_id = ? , stu_name = ? , year = ? , major_subject = ? ,phone_number = ?, gender = ?, personal_email = ?, address = ? "
                    + "WHERE stu_id = ?";
            ps = ct.prepareStatement(sql);
            ps.setString(1, sId);
            ps.setString(2, sName);
            ps.setString(3, year);
            ps.setString(4, major);
            ps.setInt(5, phone);
            ps.setString(6, gender);
            ps.setString(7, email);
            ps.setString(8, address);
            ps.setString(9, sId);
            int rs = ps.executeUpdate();
            if (rs >= 1) {
                return true;
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

        return false;
    }

    public StudentAssignmentInfo getAssignmentInfo(int asId, String stuID) {
        PreparedStatement ps = null;
        Connection ct = null;
        Student student = null;
        StudentAssignmentInfo as = new StudentAssignmentInfo();
        try {
            ct = getConnection();
            String sql = "SELECT DISTINCT sa.assignment_id , a.course_id , a.assignment_title, a.assignment_material,  sa.status,  a.due_date ,sa.assignment ,sa.submit_time"
                    + " FROM studentassignment sa "
                    + " JOIN student s ON sa.stu_id = s.stu_id "
                    + " JOIN assignment a ON sa.assignment_id = a.assignment_id "
                    + " WHERE a.assignment_id = ? and sa.stu_id = ?";
            ps = ct.prepareStatement(sql);
            ps.setInt(1, asId);
            ps.setString(2, stuID);
            ResultSet rs = null;
            rs = ps.executeQuery();
            if (rs.next()) {
                as.setAssignmentID(rs.getInt("assignment_id"));
                as.setCourseID(rs.getString("course_id"));
                as.setAssigmentTitle(rs.getString("assignment_title"));
                as.setAssigmentMaterial(rs.getString("assignment_material"));
                as.setStatus(rs.getString("status"));
                as.setDue_date(rs.getDate("due_date"));
                as.setSubmissionTime(rs.getDate("submit_time"));
                as.setStuAs(rs.getString("assignment"));
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

    public boolean uploadStundetAssignment(String stuID, int assID, String fileName) {
        PreparedStatement ps = null;
        Connection ct = null;
        Date currentDate = new Date(System.currentTimeMillis());
        try {
            ct = getConnection();
            String sql = "UPDATE studentassignment SET assignment = ?, status = ? , submit_time = ? WHERE stu_id = ? AND assignment_id = ?";
            ps = ct.prepareStatement(sql);
            ps.setString(1, fileName);
            ps.setString(2, "submitted");
            ps.setDate(3, currentDate);
            ps.setString(4, stuID);
            ps.setInt(5, assID);
            int rs = ps.executeUpdate();
            if (rs >= 1) {
                return true;
            }
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

//    public ArrayList<StudentScore> getScore(String courseID, String stuID) {
//        PreparedStatement ps = null;
//        Connection ct = null;
//        ArrayList<StudentScore> seList = new ArrayList<>();
//        try {
//            ct = getConnection();
//            String sql = " SELECT * "
//                    + " FROM studend_score"
//                    + " WHERE course_id = ? AND stu_id =? ";
//            ps = ct.prepareStatement(sql);
//            ps.setString(1, courseID);
//            ps.setString(2, stuID);
//            ResultSet rs = null;
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                StudentScore sc = new StudentScore();
//                sc.setId(rs.getInt("id"));
//                sc.setCourseID(rs.getString("course_id"));
//                sc.setStuID(rs.getString("stu_id"));
//                sc.setScoreCategory(rs.getString("score_category"));
//                sc.setMarkLevel(rs.getString("marks_level"));
//                sc.setFullMark(rs.getString("full_mark"));
//                sc.setComment(rs.getString("comment"));
//                seList.add(sc);
//            }
//            ps.close();
//            ct.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return seList;
//    }

    public ArrayList<StudentT> getTranscript(String stuId) {
        PreparedStatement ps = null;
        Connection ct = null;
        ArrayList<StudentT> stList = new ArrayList<>();
        try {
            ct = getConnection();
            String sql = "SELECT distinct c.course_id, c.course_name, sg.grade "
                    + " FROM student s, student_grade sg, course c "
                    + " WHERE sg.student_id = ? "
                    + "  AND sg.course_id = c.course_id "
                    + " AND sg.Status LIKE '%Finish%' ";
            ps = ct.prepareStatement(sql);
            ps.setString(1, stuId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentT s = new StudentT();
                s.setCourseId(rs.getString(1));
                s.setCourseName(rs.getString(2));
                s.setGrade(rs.getString(3));
                stList.add(s);
            }
            ps.close();
            ct.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stList;

    }

    public ArrayList<TeacherAssignment> getAllAssignments(String sId) {
        ArrayList<TeacherAssignment> aList = new ArrayList<>();
        try {
            Connection ct = getConnection();;
            String sql = "SELECT DISTINCT a.assignment_id, a.course_id, a.assignment_title, a.due_date, a.status "
                    + " FROM assignment a "
                    + " JOIN courseselection cs ON a.course_id = cs.course_id "
                    + " WHERE cs.stu_id = ? ";
            PreparedStatement ps = ct.prepareStatement(sql);
            ps.setString(1, sId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TeacherAssignment t = new TeacherAssignment();
                t.setAssId(rs.getInt(1));
                t.setCourseId(rs.getString(2));
                t.setAssTitle(rs.getString(3));
                t.setDueDate(rs.getDate(4));
                t.setAssStatus(rs.getString(5));
                aList.add(t);
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
