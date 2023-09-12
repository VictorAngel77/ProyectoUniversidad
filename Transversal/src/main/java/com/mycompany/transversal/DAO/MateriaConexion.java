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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Materia buscarMateria(int id) {

        Materia materia = null;
        String sql = "SELECT nombre , año , estado FROM materia WHERE idMatria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setEstado(rs.getBoolean("estado"));
            } else {
                throw new IllegalArgumentException("No existe la materia con ID: " + id);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materia;
    }
    
        public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ? , año = ? WHERE idMateria = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El matria no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }
    }
        
        public void eliminarMateria(int id) {
        try {
            String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, " Se eliminó la Materia.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Matria");
        }
    } 
        
        public Map<Boolean ,List<Materia>> listarMaterias() {
        Map<Boolean ,List<Materia>> materiaSeparadas = new HashMap<>(){};
        List<Materia> materiasVerdaderas = new ArrayList<>();
        List<Materia> materiasFalsas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM matria ";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    
                    Materia materia = new Materia();
                    materia.setNombre("nombre");
                    materia.setAño(rs.getInt("año"));
                    materia.setEstado(rs.getBoolean("estado"));
                    
                    if(materia.isEstado()){
                    materiasVerdaderas.add(materia);
                    }else{
                    materiasFalsas.add(materia);
                    }
                }
                materiaSeparadas.put(true, materiasVerdaderas);
                materiaSeparadas.put(false, materiasFalsas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return materiaSeparadas;
    }

}
