/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transversal.Entidades;

import java.time.LocalDate;

/**
 *
 * @author jdbar
 */
public class Alumno {
    private int idAlumno;
    private String apellido;
    private String nombre;
    private LocalDate fechaNAc;
    private boolean activo;
    private int Dni;

    public Alumno(String apellido, String nombre, LocalDate fechaNAc, boolean activo, int Dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNAc = fechaNAc;
        this.activo = activo;
        this.Dni = Dni;
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNAc, boolean activo, int Dni) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNAc = fechaNAc;
        this.activo = activo;
        this.Dni = Dni;
    }

    public Alumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNAc() {
        return fechaNAc;
    }

    public void setFechaNAc(LocalDate fechaNAc) {
        this.fechaNAc = fechaNAc;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
    }

    
}
