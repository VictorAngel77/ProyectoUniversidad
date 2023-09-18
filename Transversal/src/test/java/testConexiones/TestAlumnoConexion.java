package testConexiones;

import Data.AlumnoConexion;
import Data.Conexion;
import com.mycompany.transversal.Entidades.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Angel
 */
public class TestAlumnoConexion {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        AlumnoConexion adao = new AlumnoConexion(con);
        Alumno alumnoTest = new Alumno();

        //Creando Alumnos
        LocalDate fechaNacimiento = LocalDate.of(1997, 5, 15);
        Alumno alu = new Alumno("Perez", "Juan", fechaNacimiento, true, 32563542);
        adao.newAlumno(alu);
        fechaNacimiento = LocalDate.of(1995, 3, 22);
        Alumno alu1 = new Alumno("Gomez", "Pedro", fechaNacimiento, true, 335647873);
        adao.newAlumno(alu1);
        fechaNacimiento = LocalDate.of(2000, 7, 11);
        Alumno alu2 = new Alumno("Sosa", "Luciana", fechaNacimiento, true, 30948223);
        adao.newAlumno(alu2);

        //Buscar por Id
        alumnoTest = adao.buscarAlumno(7);
        System.out.println(alumnoTest.getApellido());

        //Buscar por DNI
        alumnoTest = adao.buscarAlumnoPorDni(32563542);
        System.out.println(alumnoTest.getNombre());

        //Mostrando Lista Original
        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos = adao.listarAlumnos();
        for (Alumno alumno : listaAlumnos) {
            System.out.println(alumno);
        }

        //Modificando Fecha de nacimiento y nombre
        fechaNacimiento = LocalDate.of(2000, 8, 11);
        alu2.setFechaNAc(fechaNacimiento);
        alu2.setNombre("Sofia");
        adao.modificarAlumno(alu2);

        //Mostrando Lista Modificada
        List<Alumno> listaAlumnosMod = new ArrayList<>();
        listaAlumnosMod = adao.listarAlumnos();
        for (Alumno alumno : listaAlumnosMod) {
            System.out.println(alumno);
        }

        //Eliminacion logica 
        adao.eliminarAlumno(8);

    }

}
