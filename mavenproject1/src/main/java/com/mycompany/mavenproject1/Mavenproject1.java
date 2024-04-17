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
        Aeropuerto1 origen = new Aeropuerto1("Madrid");


        Autobus1 autobus1 = new Autobus1("Autobus1",origen);

        autobus1.start();
    }


