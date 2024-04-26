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
        Autobus1 autobus2 = new Autobus1("Autobus2",origen);
        Autobus1 autobus3 = new Autobus1("Autobus3",origen);
        Thread thread = new Thread(autobus1);
        Thread thread1 = new Thread(autobus2);
        Thread thread2 = new Thread(autobus3);
        thread.start();
        thread1.start();
        thread2.start();
    }
}


