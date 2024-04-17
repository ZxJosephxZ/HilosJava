/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph
 */
public class Autobus1 implements Runnable{

    private String nombre;
    private Aeropuerto1 aeropuerto;
    private Random random = new Random();
    private int numeroPasajeros;

    public Autobus1(String nombre, Aeropuerto1 aeropuerto)
    {
        this.nombre = nombre;
        this.aeropuerto = aeropuerto;
        numeroPasajeros = 0;
    }
    @Override
    public void run() {
        try {
            //Simulacion de llegada a la ciudad
            Thread.sleep(random.nextInt(1000));//deberia ser random
            System.out.println("EL autobus"+Thread.currentThread().getName()+"LLEGO A LA CIUDAD, ESPERANDO PASAJEROS...");
            numeroPasajeros = random.nextInt(50)+1;//obteniendo numero de pasajeros.
            Thread.sleep(2000+random.nextInt(3000));
            System.out.println("INICIA RECORRIDO HA AEROPUERTO...");
            Thread.sleep(5000+random.nextInt(5000));
            System.out.println("LLEGADA AL AEROPUERTO");
            //METODO PARA AÑADIR LOS PASAJEROS
            aeropuerto.añadirPasajeros(numeroPasajeros);
            System.out.println("se bajaron"+numeroPasajeros);
            System.out.println("ESPERANDO A QUE SUBAN PASAJEROS...");
            //numeroPasajeros = subirpasajerosdelaeropuerto
            numeroPasajeros = subirAutosPasajeros();
            Thread.sleep(2000+random.nextInt(3000));
            System.out.println("INICIA RECORRIDO HA CIUDAD...");
            Thread.sleep(5000+random.nextInt(5000));
            System.out.println("LLEGADA A LA CIUDAD...");
            System.out.println("BAJAN"+numeroPasajeros);
            numeroPasajeros=0;
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Autobus1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
