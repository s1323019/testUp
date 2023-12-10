/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fg58hj123ty
 */
public class ItStaffDB {
    
    private String dburl = "";
    private String dbUser = "";
    private String dbPassword = "";

    public ItStaffDB(String dburl, String dbUser, String dbPassword) {
        this.dburl = dburl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean isValidUser(String itAId, String pwd) {
        boolean isValid = false;
        PreparedStatement ps = null;
        Connection ct = null;
        try {
            ct = getConnection();
            String sql = "SELECT * FROM it_staff WHERE staffId = ? and password = ?";
            ps = ct.prepareStatement(sql);
            ps.setString(1, itAId);
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
    
    public Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection(dburl, dbUser, dbPassword);
    }
}
