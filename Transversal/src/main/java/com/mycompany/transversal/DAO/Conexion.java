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
public  class Conexion {
    private static Connection conn;
    
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost/universidad",
            "estudiante",
         "estudiante");   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}

