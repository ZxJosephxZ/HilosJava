/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pruebas;

import java.util.Map;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Joseph
 */
public class InterfazGrafica extends javax.swing.JFrame {

        private Map<String, JTextField> textFieldsMap;
        private ClientHandler clientehandler;
    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica(Map<String, JTextField> textFieldsMap) {
        initComponents();
        this.textFieldsMap = textFieldsMap;
        asociarCamposDeTexto();
        setVisible(true);
    }
    
    private void asociarCamposDeTexto() {
        HangarM.setText("0");
        HangarB.setText("0");
        PasajerosM.setText("0");
        PasajerosB.setText("0");
        RodajeM.setText("0");
        RodajeB.setText("0");
        TallerM.setText("0");
        TallerB.setText("0");
        EstacionamientoM.setText("0");
        EstacionamientoB.setText("0");
        textFieldsMap.put("HangarM", HangarM);
        textFieldsMap.put("PasajerosM", PasajerosM);
        textFieldsMap.put("RodajeM", RodajeM);
        textFieldsMap.put("TallerM", TallerM);
        textFieldsMap.put("EstacionamientoM", EstacionamientoM);
        textFieldsMap.put("HangarB", HangarB);
        textFieldsMap.put("PasajerosB", PasajerosB);
        textFieldsMap.put("RodajeB", RodajeB);
        textFieldsMap.put("TallerB", TallerB);
        textFieldsMap.put("EstacionamientoB", EstacionamientoB);
        textFieldsMap.put("AeroviaB_M", AeroviaB_M);
        textFieldsMap.put("AeroviaM_B", AeroviaM_B);
}
    
    public void setClientHandler(ClientHandler clientehandler) {
        this.clientehandler = clientehandler;
    }
    
    
     public void updateTextField(String identifier, String data) {
        SwingUtilities.invokeLater(() -> {
        JTextField textField = textFieldsMap.get(identifier);
        if (textField != null) {
            if (identifier.equals("AeroviaM_B")) {
                // Si el identificador es "aerovia", establece directamente el texto
                textField.setText(data);
                System.out.println("Campo de texto actualizado: " + identifier + " con valor: " + data);
            }
            else if(identifier.equals("AeroviaB_M"))
            {
                textField.setText(data);
                System.out.println("Campo de texto actualizado: " + identifier + " con valor: " + data);
            }
            else {
                // Si no es "aerovia", interpreta el valor como un número y sumalo al valor actual del campo de texto
                try {
                    int currentValue = Integer.parseInt(textField.getText());
                    int value = Integer.parseInt(data);
                    System.out.println(data);
                    int updatedValue = 0;
                    if (data.contains("-"))
                    {
                        updatedValue = currentValue - value;
                    }
                    else
                    {
                        updatedValue = currentValue + value;
                    }
                    //int updatedValue = currentValue + value;
                    textField.setText(String.valueOf(updatedValue));
                    System.out.println("Campo de texto actualizado: " + identifier + " con valor: " + updatedValue);
                } catch (NumberFormatException e) {
                    System.out.println("No se pudo convertir el valor a un numero para el identificador: " + identifier);
                }
            }
        } else {
            System.out.println("No se encontró un campo de texto con el identificador: " + identifier);
        }
    });
    }
    /**
     * Creates new form InterfazGrafica
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasajerosM = new javax.swing.JTextField();
        AeroviaM_B = new javax.swing.JTextField();
        AeroviaB_M = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TallerB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        HangarB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        RodajeB = new javax.swing.JTextField();
        HangarM = new javax.swing.JTextField();
        EstacionamientoM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TallerM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PasajerosB = new javax.swing.JTextField();
        RodajeM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EstacionamientoB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(PasajerosM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, -1));
        getContentPane().add(AeroviaM_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 440, -1));
        getContentPane().add(AeroviaB_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 440, -1));

        jLabel10.setText("NºAviones Taller");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        jLabel8.setText("NºPasajeros Aeropuerto");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));
        getContentPane().add(TallerB, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 170, 90, -1));

        jLabel3.setText("NºPasajeros Aeropuerto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(HangarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 90, -1));

        jLabel4.setText("NºAviones Hangar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setText("NºAviones Estacionamiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(RodajeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, 100, -1));
        getContentPane().add(HangarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 90, -1));
        getContentPane().add(EstacionamientoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 80, -1));

        jLabel9.setText("NºAviones Hangar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, -1, -1));
        getContentPane().add(TallerM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, -1));

        jLabel5.setText("NºAviones Taller");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel1.setText("AEROPUERTO MADRID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel2.setText("AEROPUERTO BARCELONA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));
        getContentPane().add(PasajerosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 90, -1));
        getContentPane().add(RodajeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 80, -1));

        jLabel7.setText("Pista 4");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));
        getContentPane().add(EstacionamientoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 80, -1));

        jLabel12.setText("NºAviones Rodaje");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, -1, -1));

        jLabel11.setText("NºAviones Estacionamiento");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        jLabel13.setText("Aerovia Madrid-Barcelona");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel14.setText("Aerovia Barcelona-Madrid");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 630, 300));

        jLabel15.setText("NºAviones Rodaje");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel16.setText("Pista 1");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel17.setText("Pista 2");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel18.setText("Pista 3");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        jButton1.setText("ABRIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 80, 20));

        jButton2.setText("CERRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 80, 20));

        jButton3.setText("ABRIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, 20));

        jButton4.setText("CERRAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 80, 20));

        jButton5.setText("ABRIR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 80, 20));

        jButton6.setText("CERRAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 80, 20));

        jButton7.setText("ABRIR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 80, 20));

        jButton8.setText("CERRAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 80, 20));

        jLabel19.setText("Pista 4");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, -1, -1));

        jLabel20.setText("Pista 1");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, -1, -1));

        jLabel21.setText("Pista 2");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));

        jLabel22.setText("Pista 3");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, -1, -1));

        jButton9.setText("ABRIR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 80, 20));

        jButton10.setText("CERRAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 80, 20));

        jButton11.setText("ABRIR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 80, 20));

        jButton12.setText("CERRAR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 80, 20));

        jButton13.setText("ABRIR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 320, 80, 20));

        jButton14.setText("CERRAR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 320, 80, 20));

        jButton15.setText("ABRIR");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 80, 20));

        jButton16.setText("CERRAR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clientehandler.SolicitarCliente("0:true:2");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clientehandler.SolicitarCliente("1:false:2");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        clientehandler.SolicitarCliente("0:true:1");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        clientehandler.SolicitarCliente("1:false:1");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clientehandler.SolicitarCliente("0:false:2");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clientehandler.SolicitarCliente("1:true:2");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clientehandler.SolicitarCliente("2:true:2");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clientehandler.SolicitarCliente("1:false:2");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        clientehandler.SolicitarCliente("3:true:2");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        clientehandler.SolicitarCliente("3:false:2");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        clientehandler.SolicitarCliente("0:false:1");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        clientehandler.SolicitarCliente("1:true:1");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        clientehandler.SolicitarCliente("2:true:1");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        clientehandler.SolicitarCliente("2:false:1");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        clientehandler.SolicitarCliente("3:true:1");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        clientehandler.SolicitarCliente("3:false:1");
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AeroviaB_M;
    private javax.swing.JTextField AeroviaM_B;
    private javax.swing.JLabel Background;
    private javax.swing.JTextField EstacionamientoB;
    private javax.swing.JTextField EstacionamientoM;
    private javax.swing.JTextField HangarB;
    private javax.swing.JTextField HangarM;
    private javax.swing.JTextField PasajerosB;
    private javax.swing.JTextField PasajerosM;
    private javax.swing.JTextField RodajeB;
    private javax.swing.JTextField RodajeM;
    private javax.swing.JTextField TallerB;
    private javax.swing.JTextField TallerM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}