/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaime.movimientomouse;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jymmy
 */
public class ventana extends javax.swing.JFrame {

    boolean estado = true;
    int xPo, yPo;
    int tiempo;

    /**
     * Creates new form ventana
     */
    public ventana() {
        initComponents();
        estados();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        xPo = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        yPo = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        jbTime.addItem("10");
        jbTime.addItem("30");
        jbTime.addItem("60");
    }

    private void estados() {
        if (estado) {
            lblEtiqueta.setText("Apagado");
            btnEncender.setText("Iniciar");
            lblDesc.setText("");
        } else {
            lblEtiqueta.setText("Encendido");
            btnEncender.setText("Apagar");
            lblDesc.setText("El programa se esta ejecutando evitando que hiberne la pc");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblEtiqueta = new javax.swing.JLabel();
        btnEncender = new javax.swing.JToggleButton();
        lblDesc = new javax.swing.JLabel();
        jbTime = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblEtiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEtiqueta.setText("texto");

        btnEncender.setText("jToggleButton1");
        btnEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncenderActionPerformed(evt);
            }
        });

        lblDesc.setText("jLabel1");

        jLabel1.setText("Tiempo expresado en segundos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addComponent(lblEtiqueta)
                .addGap(18, 18, 18)
                .addComponent(btnEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(lblDesc)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncenderActionPerformed
        tiempo = Integer.parseInt(jbTime.getSelectedItem().toString());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    tiempo = Integer.parseInt(jbTime.getSelectedItem().toString());
                    if (estado) {
                        estado = false;

                    } else {
                        estado = true;
                    }
                    estados();
                    execute();
                } catch (Exception ex) {
                    estado = true;
                    System.out.println("btnEncenderActionPerformed " + ex);
                }
            }
        };
        new Thread(r).start();
    }//GEN-LAST:event_btnEncenderActionPerformed

    public void execute() throws AWTException {
        Random r = new Random();
        Robot robot = new Robot();
        boolean regresar = false;
        tiempo = tiempo * 1000;
        while (estado == false) {
            try {

                if (regresar) {
                    //System.out.println("--regresar1 "+regresar);
                    regresar = false;
                    robot.mouseMove(xPo, yPo);

                } else {
                   //System.out.println("--regresar2 "+regresar);
                    regresar = true;
                    new Thread(new MouseMoveThread((r.nextInt(320) + 1), (r.nextInt(320) + 1), 50, 10)).start();
                }
                Thread.sleep(tiempo);
            } catch (Exception e) {
                estado = true;
                System.out.println("ERROR " + e);
            }

        }

    }
  
    private class MouseMoveThread implements Runnable {

        private Robot robot;
        private int startX;
        private int startY;
        private int currentX;
        private int currentY;
        private int xAmount;
        private int yAmount;
        private int xAmountPerIteration;
        private int yAmountPerIteration;
        private int numberOfIterations;
        private long timeToSleep;

        public MouseMoveThread(int xAmount, int yAmount,
                int numberOfIterations, long timeToSleep) {

            this.xAmount = xAmount;
            this.yAmount = yAmount;
            this.numberOfIterations = numberOfIterations;
            this.timeToSleep = timeToSleep;

            try {

                robot = new Robot();
                Point startLocation = MouseInfo.getPointerInfo().getLocation();
                startX = startLocation.x;
                startY = startLocation.y;

            } catch (Exception exc) {
                System.out.println("MouseMoveThread "+exc);
                exc.printStackTrace();
            }

        }

        @Override
        public void run() {

            currentX = startX;
            currentY = startY;

            xAmountPerIteration = xAmount / numberOfIterations;
            yAmountPerIteration = yAmount / numberOfIterations;

            while (currentX < startX + xAmount
                    && currentY < startY + yAmount) {

                currentX += xAmountPerIteration;
                currentY += yAmountPerIteration;

                robot.mouseMove(currentX, currentY);

                /*try {
                    Thread.sleep(timeToSleep);
                } catch (Exception exc) {
                    estado = true;
                    System.out.println("RUN " + exc);
                }*/

            }

        }

    }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEncender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jbTime;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblEtiqueta;
    // End of variables declaration//GEN-END:variables

}
