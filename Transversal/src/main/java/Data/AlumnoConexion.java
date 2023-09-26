package Data;

import com.mycompany.transversal.Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mycompany.transversal.Entidades.Alumno;
/**
 *
 * @author Victor Angel
 */
public class AlumnoConexion {

    private Connection con = null;

    public AlumnoConexion(Conexion conn) {
        this.con = Conexion.getConnection();
        System.out.println("Se conecto Alumno");
    }

    
    public void newAlumno(Alumno alumno) {
        try {
            String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            try {
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNAc()));
                ps.setBoolean(5, alumno.isActivo());
                ps.executeUpdate();
                System.out.println("Guardado con exito");
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al acceder a la tabla Alumno" + ex.getMessage() + "\nSQLState: " + ex.getSQLState());
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlumnoConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public Alumno buscarAlumno(int id)  {
        Alumno alumno = null;
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNAc(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            } else {
                System.out.println("No existe el alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumno;
    }

    
    public List<Alumno> buscarAlumnoPorDni(int dni) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni LIKE ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNAc(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                listaAlumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return listaAlumnos;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alumno WHERE estado = 1 ";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(rs.getInt("idAlumno"));
                    alumno.setDni(rs.getInt("dni"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setFechaNAc(rs.getDate("fechaNacimiento").toLocalDate());
                    alumno.setActivo(rs.getBoolean("estado"));
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return alumnos;
    }

    
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechaNacimiento = ? WHERE idAlumno = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, java.sql.Date.valueOf(alumno.getFechaNAc()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                System.out.println("Modificado Exitosamente.");
            } else {
                System.out.println("El alumno no existe");
            }
        } catch (SQLException ex) {
            System.out.println("Error al acceder a la tabla Alumno " + ex.getMessage());
        }
    }

    public void eliminarAlumno(int id) {
        try {
            String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    System.out.println(" Se eliminó el alumno.");
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error al acceder a la tabla Alumno");
        }
    }

}