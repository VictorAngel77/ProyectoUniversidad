/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transversal;

import com.mycompany.transversal.DAO.AlumnoConexion;
import com.mycompany.transversal.DAO.Conexion;
import com.mycompany.transversal.DAO.InscripcionDAO;
import com.mycompany.transversal.DAO.MateriaConexion;
import com.mycompany.transversal.Entidades.Alumno;
import com.mycompany.transversal.Entidades.Inscripcion;
import com.mycompany.transversal.Entidades.Materia;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author cisco
 */
public class Transversal {

    public static void main(String[] args) throws SQLException {
//        Conexion con = new Conexion();
//        AlumnoConexion adao = new AlumnoConexion(con);
//        MateriaConexion mdao = new MateriaConexion(con);
//        Materia materia = mdao.buscarMateria(1);
//        System.out.println(materia.getNombre());
       /* List<Alumno> alum = new InscripcionDAO().fetchAlumnosByMateria(1);
        
        alum.forEach( alu -> 
                System.out.println(alu.getApellido())
        );*/
    }
}
