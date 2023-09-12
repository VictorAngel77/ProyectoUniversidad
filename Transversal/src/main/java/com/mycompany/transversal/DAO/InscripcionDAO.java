/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transversal.DAO;

import com.mycompany.transversal.Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.transversal.Entidades.Alumno;
import com.mycompany.transversal.Entidades.Materia;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cisco
 */
public class InscripcionDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    private MateriaConexion materiaData;
    private AlumnoConexion aluData;

    public InscripcionDAO() {
    }
    
    public void saveInscripcion(Inscripcion insc) {
        try {
            if (con == null) {
                con = new Conexion().getConnection();    
            }
            
            ps = con.prepareStatement(
                    "insert into inscripcion (idInscripcion, nota, idAlumno, idMateria) "
                            + "values (null, ?, ?, ?);"
            );
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Inscripcion> fetchInscripciones() throws SQLException {
        List<Inscripcion> lista = new ArrayList<Inscripcion>();
        if (con == null) {
            con = new Conexion().getConnection();
        }
        st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from inscripcion");
        while (rs.next()) {
            Integer idInscripcion = rs.getInt("idInscripcion");
            Alumno alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia materia = materiaData.buscarMAteria(rs.getInt("idMateria"));
            Double nota = rs.getDouble("nota");
            lista.add(new Inscripcion(idInscripcion, alumno, materia, nota));
        }
        st.close();
        con.close();
        return lista;
    }
    
    public List<Inscripcion> fetchInscripcionesByIdAlumno(int id) throws SQLException {
        List<Inscripcion> lista = new ArrayList<Inscripcion>();
        if (con == null) {
            con = new Conexion().getConnection();
        }
        ps = con.prepareStatement("select * from inscripcion where idAlumno = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer idInscripcion = rs.getInt("idInscripcion");
            Alumno alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia materia = materiaData.buscarMAteria(rs.getInt("idMateria"));
            Double nota = rs.getDouble("nota");
            lista.add(new Inscripcion(idInscripcion, alumno, materia, nota));
        }
        st.close();
        con.close();
        return lista;
    }
        /**
         * 
         * @param id del alumno
         * @return
         * @throws SQLException 
         */
        public List<Materia> fetchMateriasCursadas(int id) throws SQLException {
        List<Materia> lista = new ArrayList<Materia>();
        if (con == null) {
            con = new Conexion().getConnection();
        }
        ps = con.prepareStatement(
                "select materia.idMateria, nombre, año, nota, estado"
                        + "from inscripcion join materia "
                        + "on inscripcion.idMateria = materia.idMateria "
                        + "where idAlumno = ?;");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer idMateria = rs.getInt("idMateria"),
                    año = rs.getInt("año");
            String nombre = rs.getString("nombre");
            double nota = rs.getDouble("nota");
            boolean estado = rs.getBoolean("estado");
            lista.add(new Materia(nombre, año, estado));
        }
        ps.close();
        con.close();
        return lista;
    }
    
    
}
