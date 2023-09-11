/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transversal.DAO;

import com.mycompany.transversal.Entidades.Alumno;
import com.mycompany.transversal.Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jdbar
 */
public class MateriaConexion {

    private Connection con = null;

    public MateriaConexion(Conexion conn) {
        this.con = conn.getConnection();
    }

    public void newAlumno(Materia materia) {
        try {
            String sql = "INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES (?,?,?)";

            PreparedStatement sqlPS = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sqlPS.setString(1, materia.getNombre());
            sqlPS.setInt(2, materia.getAño());
            sqlPS.setBoolean(3, materia.isEstado());
            sqlPS.executeUpdate();
            sqlPS.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }

    }

    public Materia buscarMAteria(int id) {

        Materia materia = null;
        String sql = "SELECT nombre , año , estado FROM materia WHERE idMatria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria("idMateria");
                materia.setNombre("nombre");
                materia.setAño(rs.getInt("dni"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return materia;
    }

}
