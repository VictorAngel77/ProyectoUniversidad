/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

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

    public boolean newMateria(Materia materia) {
        try {
            String sql = "INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES (?,?,?)";

            PreparedStatement sqlPS = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sqlPS.setString(1, materia.getNombre());
            sqlPS.setInt(2, materia.getAño());
            sqlPS.setBoolean(3, materia.isEstado());
            sqlPS.executeUpdate();
            sqlPS.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }
return false;
    }

    public List<Materia> buscarMateria(int id) {
        List<Materia> materias = new ArrayList();
        String sql = "SELECT idMateria, nombre , año , estado FROM materia WHERE idMateria like ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materias;
    }
    
    public Materia buscarMateriaByid(int id) {
        Materia materia = new Materia();
        String sql = "SELECT idMateria, nombre , año , estado FROM materia WHERE idMateria like ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return materia;
    }
    
    
        public boolean modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ? , año = ? WHERE idMateria = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }
        return false;
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
            String sql = "SELECT * FROM materia ";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    
                    Materia materia = new Materia();
                    materia.setNombre(rs.getString("nombre"));
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

          public boolean materiaExistente(String nombre,int anio) {
        String sql = "SELECT nombre , año FROM materia WHERE  año = ? AND nombre= ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, anio);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
     
             
          public List<Materia>listarMateriasCompleta() {
        List<Materia> listaCompleta = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while  (rs.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAño(rs.getInt("año"));
                    materia.setEstado(rs.getBoolean("estado"));
                    listaCompleta.add(materia);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return listaCompleta;
    }
          
          
          
          
}
