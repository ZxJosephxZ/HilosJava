/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;

/**
 *
 * @author Joseph
 */
public class Autobuses extends Thread{
    private String id;
    private Aeropuerto aeropuerto;
    private Random random = new Random();

    public Autobuses(String id, Aeropuerto aeropuerto)
    {
        this.id = id;
        this.aeropuerto = aeropuerto;
    }
    @Override
    public void run() {
        while (true)
        {
            try
            {
                int tiempoSubida = random.nextInt(4) + 2;
            int pasajerosSuben = random.nextInt(51);
            Thread.sleep(tiempoSubida * 1000);
            System.out.println("ESPERANDO EN EL AEROPUERTO");
            aeropuerto.subirPasajeros(pasajerosSuben);

            // Simulación de viaje hacia la ciudad
            int tiempoViaje = random.nextInt(6) + 5;
            Thread.sleep(tiempoViaje * 1000);

            // Bajada de pasajeros en la ciudad
            aeropuerto.bajarPasajeros(); // Simular bajada de pasajeros en la ciudad

            // Tiempo de espera en la ciudad
            System.out.println("ESPERANDO EN LA CIUDAD");
            int tiempoEspera = random.nextInt(4) + 2;
            aeropuerto.subirPasajeros(pasajerosSuben);
            Thread.sleep(tiempoEspera * 1000);

            // Simulación de viaje de regreso al aeropuerto
            System.out.println("REGRESANDO AEROPUERTO");
            tiempoViaje = random.nextInt(6) + 5;
            Thread.sleep(tiempoViaje * 1000);

            // Bajada de pasajeros en el aeropuerto
            aeropuerto.bajarPasajeros(); 
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
