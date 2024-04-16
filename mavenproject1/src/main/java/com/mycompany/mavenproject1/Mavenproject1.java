/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author Joseph
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Aeropuerto origen = new Aeropuerto("Origen");
        Aeropuerto destino = new Aeropuerto("Destino");

        Aviones avion1 = new Aviones("AV1", 200, origen, destino);

        Autobuses autobus1 = new Autobuses("BUS1", origen);

        avion1.start();
        autobus1.start();
    }
   

    private static String generarCodigoAvion() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            int index = (int)(letras.length() * Math.random());
            sb.append(letras.charAt(index));
        }
        sb.append("-");
        sb.append(String.format("%04d", (int)(10000 * Math.random())));
        return sb.toString();
    }

    private static String generarCodigoAutobus() {
        return "B-" + String.format("%04d", (int)(10000 * Math.random()));
    }
    }

