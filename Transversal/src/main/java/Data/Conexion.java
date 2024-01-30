/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author cisco
 */
public  class Conexion {
    private static Connection conn;
    
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost/fravemax",
            "root",
         "");   
            
            System.out.println("Se conecto con exito");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}

