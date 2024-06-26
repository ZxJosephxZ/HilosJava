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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(PasajerosM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, -1));
        getContentPane().add(AeroviaM_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 440, -1));
        getContentPane().add(AeroviaB_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 440, -1));

        jLabel10.setText("NºAviones Taller");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jLabel8.setText("NºPasajeros Aeropuerto");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));
        getContentPane().add(TallerB, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 90, -1));

        jLabel3.setText("NºPasajeros Aeropuerto");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));
        getContentPane().add(HangarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 90, -1));

        jLabel4.setText("NºAviones Hangar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setText("NºAviones Estacionamiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(RodajeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 100, -1));
        getContentPane().add(HangarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 90, -1));
        getContentPane().add(EstacionamientoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 80, -1));

        jLabel9.setText("NºAviones Hangar");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));
        getContentPane().add(TallerM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, -1));

        jLabel5.setText("NºAviones Taller");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel1.setText("AEROPUERTO MADRID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel2.setText("AEROPUERTO BARCELONA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));
        getContentPane().add(PasajerosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 90, -1));
        getContentPane().add(RodajeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 80, -1));

        jLabel7.setText("NºAviones Rodaje");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        getContentPane().add(EstacionamientoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 80, -1));

        jLabel12.setText("NºAviones Rodaje");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jLabel11.setText("NºAviones Estacionamiento");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jLabel13.setText("Aerovia Madrid-Barcelona");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel14.setText("Aerovia Barcelona-Madrid");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 732, 532));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
