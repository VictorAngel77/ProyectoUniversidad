/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.transversal.Vistas;

import com.mycompany.transversal.Vistas.Alumno.AlumnoView;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mycompany.transversal.Vistas.Alumno.BusquedaAlumno;
import com.mycompany.transversal.Vistas.Materia.Inscripcion.VistaInscripciones;
import com.mycompany.transversal.Vistas.Materia.MateriaView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author jdbar
 */
public class Vista extends javax.swing.JFrame {
    VistaInscripciones vins;
    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        vins = new VistaInscripciones();
        jLayeredPane3.add(vins);
        jLayeredPane3.repaint();

        this.setLocationRelativeTo(null);
        //setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        VistaAlumnos = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        VistaMaterias = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jTabbedPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });
        jTabbedPane1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTabbedPane1PropertyChange(evt);
            }
        });

        VistaAlumnos.setMaximumSize(new java.awt.Dimension(700, 430));
        VistaAlumnos.setPreferredSize(new java.awt.Dimension(700, 430));

        javax.swing.GroupLayout VistaAlumnosLayout = new javax.swing.GroupLayout(VistaAlumnos);
        VistaAlumnos.setLayout(VistaAlumnosLayout);
        VistaAlumnosLayout.setHorizontalGroup(
            VistaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        VistaAlumnosLayout.setVerticalGroup(
            VistaAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Alumnos", VistaAlumnos);

        jLayeredPane3.setMaximumSize(new java.awt.Dimension(700, 430));
        jLayeredPane3.setPreferredSize(new java.awt.Dimension(700, 430));
        jLayeredPane3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLayeredPane3ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Inscripciones", jLayeredPane3);

        VistaMaterias.setMaximumSize(new java.awt.Dimension(700, 400));
        VistaMaterias.setMinimumSize(new java.awt.Dimension(700, 400));
        VistaMaterias.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                VistaMateriasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        VistaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VistaMateriasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout VistaMateriasLayout = new javax.swing.GroupLayout(VistaMaterias);
        VistaMaterias.setLayout(VistaMateriasLayout);
        VistaMateriasLayout.setHorizontalGroup(
            VistaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        VistaMateriasLayout.setVerticalGroup(
            VistaMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Materias", VistaMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here: 
        vins.configurarComboAlumnos();
        vins.selectAlumno();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTabbedPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorAdded
        // TODO add your handling code here:
        BusquedaAlumno alumno = new BusquedaAlumno();
        alumno.setLocation(0, 0);
        alumno.setSize(700, 400);
        VistaAlumnos.removeAll();
        VistaAlumnos.add(alumno);
        VistaAlumnos.revalidate();
        VistaAlumnos.repaint();

    }//GEN-LAST:event_jTabbedPane1AncestorAdded

    private void VistaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VistaMateriasMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_VistaMateriasMouseClicked

    private void VistaMateriasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_VistaMateriasAncestorAdded
        // TODO add your handling code here:
        MateriaView materia = new MateriaView();
        materia.setLocation(0, 0);
        materia.setSize(700, 400);
        VistaMaterias.removeAll();
        VistaMaterias.add(materia);
        VistaMaterias.revalidate();
        VistaMaterias.repaint();
    }//GEN-LAST:event_VistaMateriasAncestorAdded

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jTabbedPane1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1PropertyChange

    private void jLayeredPane3ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLayeredPane3ComponentResized
        // TODO add your handling code here:
                vins.setSize(
                jLayeredPane3.getSize()
        );
    }//GEN-LAST:event_jLayeredPane3ComponentResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:

    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane VistaAlumnos;
    private javax.swing.JLayeredPane VistaMaterias;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
