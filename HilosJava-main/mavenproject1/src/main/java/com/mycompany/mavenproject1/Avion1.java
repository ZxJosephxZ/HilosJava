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
public class Avion1 implements Runnable{
    private Aeropuerto1 aeropuerto;
    private String nombre;
    private Random random = new Random();
    private int capacidadMaximaPasajeros;
    private int numeroPasajeros;
    private int viajesRealizados;

    public Avion1 (String nombre, Aeropuerto1 aeropuerto)
    {
        this.nombre = nombre;
        this.aeropuerto = aeropuerto;
        capacidadMaximaPasajeros = (100+random.nextInt(200));
        numeroPasajeros = 0;
        viajesRealizados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaximaPasajeros()
    {
        return capacidadMaximaPasajeros;
    }

    public int getNumeroPasajeros()
    {
        return numeroPasajeros;
    }
    public void setNumeroPasajeros(int num)
    {
        numeroPasajeros += num;
    }
    @Override
    public void run() {

        aeropuerto.Hangar(this);
        try {
            aeropuerto.areaEstacionamiento(this);
            System.out.println("PASAJEROS SUBIDOS"+numeroPasajeros);
            aeropuerto.areaRodaje(this);
            
            aeropuerto.aerovias(this);
            aeropuerto.aterrizajeAvion(this);
            Thread.sleep(3000+random.nextInt(2000));
            aeropuerto.desembarqueAvion(this);
            System.out.println("Entra al area de estacionamiento, comprobaciones..");
            Thread.sleep(1000+random.nextInt(4000));
            aeropuerto.realizarInspeccionTaller(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
    
