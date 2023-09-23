/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import com.mycompany.transversal.Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.transversal.Entidades.Alumno;
import com.mycompany.transversal.Entidades.Materia;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cisco
 */
public class InscripcionData {

    private static Conexion con = new Conexion();
    private static Connection conn = con.getConnection();
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    private static MateriaConexion materiaData = new MateriaConexion(con);
    private static AlumnoConexion aluData = new AlumnoConexion(con);

    public InscripcionData() {
    }

    public void saveInscripcion(Inscripcion insc) {
        try {
            ps = conn.prepareStatement(
                    "insert into inscripcion "
                    + "(idInscripcion, nota, idAlumno, idMateria) "
                    + "values (null, ?, ?, ?);"
            );
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Inscripcion> fetchInscripciones() throws SQLException {
        List<Inscripcion> lista = new ArrayList<Inscripcion>();
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from inscripcion");
        while (rs.next()) {
            Integer idInscripcion = rs.getInt("idInscripcion");
            Alumno alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia materia = materiaData.buscarMateriaByid(rs.getInt("idMateria"));
            Double nota = rs.getDouble("nota");
            lista.add(new Inscripcion(idInscripcion, alumno, materia, nota));
        }
        return lista;
    }

    public List<Inscripcion> fetchInscripcionesByIdAlumno(int id) throws SQLException {
        List<Inscripcion> lista = new ArrayList<Inscripcion>();

        ps = conn.prepareStatement("select * from inscripcion where idAlumno = ?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer idInscripcion = rs.getInt("idInscripcion");
            Alumno alumno = aluData.buscarAlumno(rs.getInt("idAlumno"));
            Materia materia = materiaData.buscarMateriaByid(rs.getInt("idMateria"));
            Double nota = rs.getDouble("nota");
            lista.add(new Inscripcion(idInscripcion, alumno, materia, nota));
        }
        return lista;
    }

    public List<Materia> fetchMateriasCursadas(int id) throws SQLException {
        List<Materia> lista = new ArrayList<Materia>();

        ps = conn.prepareStatement(
                "select materia.idMateria, nombre, año"
                + "from inscripcion join materia "
                + "on inscripcion.idMateria = materia.idMateria "
                + "where idAlumno = ?;");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer idMateria = rs.getInt("idMateria");
            String nombre = rs.getString("nombre");
            Integer año = rs.getInt("año");
            boolean estado = rs.getBoolean("estado");
            Materia materia = new Materia(nombre, año, estado);
            materia.setIdMateria(idMateria);
            lista.add(materia);
        }
        return lista;
    }

    public List<Materia> fetchMateriasNoCursadas(int id) throws SQLException {
        List<Materia> lista = new ArrayList<Materia>();

        ps = conn.prepareStatement(
                "SELECT idMateria, nombre, año "
                + "FROM materia "
                + "WHERE idMateria NOT IN ("
                + "SELECT idMateria "
                + "FROM inscripcion "
                + "WHERE idAlumno = ?);");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Integer idMateria = rs.getInt("idMateria");
            String nombre = rs.getString("nombre");
            Integer año = rs.getInt("año");
            Materia materia = new Materia(nombre, año, true);
            materia.setIdMateria(idMateria);
            lista.add(materia);
        }
        return lista;
    }

    public void borrarInscripcionMateriaAlumno(int materia, int alumno) {
        try {
            String SQL = "DELETE FROM `inscripcion` WHERE alumno.idAlumno =? and materia.idMateria =?";
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, alumno);
            ps.setInt(2, materia);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void deleteInscripcion(int id) {
        String sql = "delete from inscripcion where idInscripcion = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void actualizarNota(int id, double nota) {
        try {
            String SQL = "UPDATE `inscripcion` SET `nota`=? WHERE idInscripcion = ?";
            ps = conn.prepareStatement(SQL);
            ps.setDouble(1, nota);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public List<Alumno> fetchAlumnosByMateria(int id) throws SQLException {
        List<Alumno> lista = new ArrayList<>();
        String sql
                = "select alumno.idAlumno, nombre, apellido, dni "
                + "from inscripcion join alumno "
                + "on inscripcion.idAlumno = alumno.idAlumno "
                + "where idMateria = ?;";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            Alumno alumno = new Alumno();
            String nombre = rs.getString("nombre"),
                    apellido = rs.getString("apellido");
            int dni = rs.getInt("dni");
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.setDni(dni);

            lista.add(alumno);
        }
        return lista;

    }
}
