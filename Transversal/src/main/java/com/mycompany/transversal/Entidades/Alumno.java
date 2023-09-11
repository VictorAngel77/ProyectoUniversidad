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

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNAc, boolean activo) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNAc = fechaNAc;
        this.activo = activo;
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

    @Override
    public String toString() {
        return "Alumno{" + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNAc=" + fechaNAc + ", activo=" + activo + '}';
    }
    
    
}