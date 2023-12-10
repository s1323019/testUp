/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Date;

/**
 *
 * @author fg58hj123ty
 */
public class StudentAssignmentInfo {
    private int assignmentID;
    private String courseID ;
    private String assigmentTitle ;
    private String assigmentMaterial;
    private String status ;
    private Date due_date ;
    private Date submissionTime ;
    private String stuAs ;

    public int getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getAssigmentTitle() {
        return assigmentTitle;
    }

    public void setAssigmentTitle(String assigmentTitle) {
        this.assigmentTitle = assigmentTitle;
    }

    public String getAssigmentMaterial() {
        return assigmentMaterial;
    }

    public void setAssigmentMaterial(String assigmentMaterial) {
        this.assigmentMaterial = assigmentMaterial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getStuAs() {
        return stuAs;
    }

    public void setStuAs(String stuAs) {
        this.stuAs = stuAs;
    }

    
    
  
    
}
