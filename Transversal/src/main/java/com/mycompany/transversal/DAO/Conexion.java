/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transversal.DAO;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cisco
 */
public class Conexion {
    private Connection conn=null;
    private Statement st;
/*
    public Conexion() {
    }
    */
    
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost/universidad",
            "root",
         "");   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    public void Desconectar() {
        try {
            conn.close();
            st.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

