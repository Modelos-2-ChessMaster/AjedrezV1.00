/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;

/**
 *
 * @author AndresFWilT
 */
public class Usuario extends javax.swing.JFrame {

    private String NombreJ1,NombreJ2,ColorJ1,ColorJ2;

    public Usuario() {
        this.setTitle("Ajedrez");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BJugar = new javax.swing.JButton();
        LIngresonombre = new javax.swing.JLabel();
        TNombreJ1 = new javax.swing.JTextField();
        LColor = new javax.swing.JLabel();
        JCcolor2 = new javax.swing.JComboBox<>();
        LIngresonombre1 = new javax.swing.JLabel();
        TNombreJ2 = new javax.swing.JTextField();
        JCcolor1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BJugar.setText("Jugar");
        BJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BJugarActionPerformed(evt);
            }
        });

        LIngresonombre.setText("Ingrese el nombre del primer jugador:");

        TNombreJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreJ1ActionPerformed(evt);
            }
        });

        LColor.setText("Seleccion el color de sus fichas");

        JCcolor2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Blancas","Negras"}));
        JCcolor2.setSelectedIndex(1);
        JCcolor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCcolor2ActionPerformed(evt);
            }
        });

        LIngresonombre1.setText("Ingrese el nombre del segundo jugador:");

        TNombreJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNombreJ2ActionPerformed(evt);
            }
        });

        JCcolor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Blancas","Negras"}));
        JCcolor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCcolor1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador 1");

        jLabel2.setText("Jugador 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TNombreJ1)
                    .addComponent(TNombreJ2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LIngresonombre)
                            .addComponent(LColor)
                            .addComponent(LIngresonombre1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JCcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BJugar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LIngresonombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LIngresonombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LColor)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BJugar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNombreJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreJ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNombreJ1ActionPerformed

    private void BJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BJugarActionPerformed
        NombreJ1 = TNombreJ1.getText();
        NombreJ2 = TNombreJ2.getText();
        if (NombreJ1.equals("") && NombreJ2.equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Llene los campos de nombre para cada jugador", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (NombreJ1.equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Llene el campo de nombre para el jugador 1", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (NombreJ2.equals("")) {
            JOptionPane.showMessageDialog(getContentPane(), "Llene el campo de nombre para el jugador 2", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (NombreJ1.equals(NombreJ2)) {
            JOptionPane.showMessageDialog(getContentPane(), "Cambie el nombre al menos de un jugador (No se pueden llamar igual)", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (JCcolor1.getSelectedItem() == JCcolor2.getSelectedItem()) {
            JOptionPane.showMessageDialog(getContentPane(), "Escoja fichas de distinto color", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if ((String) JCcolor1.getSelectedItem() == "Negras"){ //Esto se hace por que el Jugador 1 debe ser el que escoga las blancas
                JOptionPane.showMessageDialog(getContentPane(), "Empieza jugando el jugador: "+NombreJ2, "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
                NombreJ1 = TNombreJ2.getText();
                NombreJ2 = TNombreJ1.getText();
                ColorJ1 = (String)JCcolor2.getSelectedItem();
                ColorJ2 = (String)JCcolor1.getSelectedItem();
               }else{
                ColorJ1 = (String)JCcolor1.getSelectedItem();
                ColorJ2 = (String)JCcolor2.getSelectedItem();
                JOptionPane.showMessageDialog(getContentPane(), "Empieza jugando el jugador: "+NombreJ1, "¡AVISO!", JOptionPane.INFORMATION_MESSAGE);
            }
            Vista juego = new Vista();
            juego.IniciarVentana(NombreJ1,NombreJ2, ColorJ1, ColorJ2);
            juego.setVisible(true);
            juego.setResizable(false);
            dispose();
        }
    }//GEN-LAST:event_BJugarActionPerformed

    private void TNombreJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNombreJ2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNombreJ2ActionPerformed

    private void JCcolor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCcolor1ActionPerformed
        if (JCcolor1.getSelectedItem().equals("Negras")) {
            JCcolor2.setSelectedIndex(0);
        } else {
            JCcolor2.setSelectedIndex(1);
        }
    }//GEN-LAST:event_JCcolor1ActionPerformed

    private void JCcolor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCcolor2ActionPerformed
        if (JCcolor2.getSelectedItem().equals("Negras")) {
            JCcolor1.setSelectedIndex(0);
        } else {
            JCcolor1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_JCcolor2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BJugar;
    private javax.swing.JComboBox<String> JCcolor1;
    private javax.swing.JComboBox<String> JCcolor2;
    private javax.swing.JLabel LColor;
    private javax.swing.JLabel LIngresonombre;
    private javax.swing.JLabel LIngresonombre1;
    private javax.swing.JTextField TNombreJ1;
    private javax.swing.JTextField TNombreJ2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
