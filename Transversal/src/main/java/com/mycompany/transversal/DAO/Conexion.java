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
    static Connection conn;
    static Statement st;
    
    public void Conectar() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost/universidad",
            "estudiante",
         "estudiante");   
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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

