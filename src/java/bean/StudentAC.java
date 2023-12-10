/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author fg58hj123ty
 */
public class StudentAC {
    private String stuAid;
    private String password;
    
    public StudentAC(){}
    public StudentAC(String stuAid, String password) {
        this.stuAid = stuAid;
        this.password = password;
    }

    public String getStuAid() {
        return stuAid;
    }

    public void setStuAid(String stuAid) {
        this.stuAid = stuAid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
