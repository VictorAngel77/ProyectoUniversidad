/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.transversal.Vistas.Alumno;

import Data.AlumnoConexion;
import Data.Conexion;
import com.mycompany.transversal.Entidades.Alumno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jdbar
 */
public class BusquedaAlumno extends javax.swing.JPanel {

    static Conexion conn = new Conexion();
    static AlumnoConexion aluConn = new AlumnoConexion(conn);

    private DefaultTableModel modelo = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form BusquedaAlumno
     */
    public BusquedaAlumno() {
        initComponents();
        agregarCabecera();
        ListaAlumnos();
    } //ESO ME ESTA PASANDO DESDE HOY , NO TERMINA DE CARGAR SI

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        JBNuevo = new javax.swing.JButton();
        JBEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JBAlta = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 400));

        JTBuscar.setToolTipText("Buscar");
        JTBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTBuscarActionPerformed(evt);
            }
        });
        JTBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTBuscarKeyReleased(evt);
            }
        });

        JTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTabla);

        JBNuevo.setText("Nuevo");
        JBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoActionPerformed(evt);
            }
        });

        JBEliminar.setText("Baja del Alumno");
        JBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Buscar por DNI");

        JBAlta.setText("Alta del Alumno");
        JBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAltaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JTBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(JBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoActionPerformed
        // TODO add your handling code here:
        AlumnoView alumno = new AlumnoView();
        alumno.setLocation(0, 0);
        alumno.setSize(700, 400);

        removeAll();
        add(alumno);
        revalidate();
        repaint();

    }//GEN-LAST:event_JBNuevoActionPerformed

    private void JBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEliminarActionPerformed
        // TODO add your handling code here:
        int fila = JTabla.getSelectedRow();

        if (modelo.getValueAt(fila, 4).equals("Activo")) {

            try {

                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere dar de baja a este alumno?",
                            "Confirmacion de Baja", JOptionPane.OK_CANCEL_OPTION);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        int idAlumno = (int) modelo.getValueAt(fila, 0);
                        aluConn.eliminarAlumno(idAlumno);
                        JOptionPane.showMessageDialog(this, "Eliminado Con EXITO!!!");
                        borrarfilas();
                        ListaAlumnos();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selecciono al alumno que desea eliminar");
                    borrarfilas();
                    ListaAlumnos();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar alumno :" + e);
                borrarfilas();
                ListaAlumnos();
            }

        } else {
            System.out.println("Error no se pudo ejecutar");
        }
    }//GEN-LAST:event_JBEliminarActionPerformed

    private void JTBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTBuscarKeyReleased
        // TODO add your handling code here:
        borrarfilas();
        List<Alumno> alumnos = new ArrayList();
        if (!JTBuscar.getText().isEmpty() && esNumero()) {
            alumnos = aluConn.buscarAlumnoPorDni(Integer.valueOf(JTBuscar.getText()));
            if (alumnos.isEmpty()) {
                System.out.println("El DNI ingresado no corresponde a ningún alumno");
            } else {
                for (Alumno alumno : alumnos) {
                    String estado = alumno.isActivo() ? "Activo" : "NO Activo";
                    modelo.addRow(new Object[]{
                        alumno.getIdAlumno(),
                        alumno.getDni(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        estado
                            
                    });
                }
            }
        } else {
            ListaAlumnos();
        }
    }//GEN-LAST:event_JTBuscarKeyReleased

    private void JTBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTBuscarActionPerformed

    private void JBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAltaActionPerformed
        // TODO add your handling code here:
        int fila = JTabla.getSelectedRow();
        if (modelo.getValueAt(fila, 4).equals("NO Activo")) {
            try {

                if (fila >= 0) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro que quiere dar de Alta a este alumno?",
                            "Confirmacion de Alta", JOptionPane.OK_CANCEL_OPTION);

                    if (respuesta == JOptionPane.OK_OPTION) {
                        int idAlumno = (int) modelo.getValueAt(fila, 0);
                        aluConn.altaAlumno(idAlumno);
                        JOptionPane.showMessageDialog(this, "Se Cambio su estado con EXITO!!!");
                        borrarfilas();
                        ListaAlumnos();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selecciono al alumno que desea dar de Alta");
                    borrarfilas();
                    ListaAlumnos();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al dar de alta alumno :" + e);
                borrarfilas();
                ListaAlumnos();
            }

        } else {
            System.out.println("Error no se pudo ejecutar");
        }

    }//GEN-LAST:event_JBAltaActionPerformed
    private boolean esNumero() {
        try {
            Integer.parseInt(JTBuscar.getText());
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error debe ingresar un numero");
        }
        JTBuscar.setText("");
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlta;
    private javax.swing.JButton JBEliminar;
    private javax.swing.JButton JBNuevo;
    private javax.swing.JTextField JTBuscar;
    private javax.swing.JTable JTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void agregarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Estado");
        JTabla.setModel(modelo);

    }

    private void borrarfilas() {
        int f = JTabla.getRowCount() - 1;

        for (int i = f; i >= 0; i--) {
            modelo.removeRow(i);
        }

    }

    private void ListaAlumnos() {
        List<Alumno> listaAlumnos = aluConn.listarAlumnos();

        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos en el sistema");
        } else {
            listaAlumnos.forEach(alumno -> {
                String estado = alumno.isActivo() ? "Activo" : "NO Activo";
                modelo.addRow(new Object[]{
                    alumno.getIdAlumno(),
                    alumno.getDni(),
                    alumno.getNombre(),
                    alumno.getApellido(),
                    estado
                });
            });

        }

    }
}
