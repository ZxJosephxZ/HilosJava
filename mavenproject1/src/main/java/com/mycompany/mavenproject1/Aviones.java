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
public class Aviones extends Thread{
    private String id;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int capacidadMaxima;
    private int vuelosRealizados;
    private int pasajerosEmbarcados;
    private Random random = new Random();
    public Aviones(String id, int capacidadMaxima, Aeropuerto origen, Aeropuerto destino)
    {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        
    }
    public void embarcarPasajeros(int numPasajeros) {
        pasajerosEmbarcados += numPasajeros;
    }
    public String getid()
    {
        return id;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getPasajerosEmbarcados() {
        return pasajerosEmbarcados;
    }

    public int getVuelosRealizados() {
        return vuelosRealizados;
    }
    @Override
    public void run() {
        while (true)
        {
            try {
                origen.accesoEstacionamiento(this);
                origen.embarcarPasajeros(id);
                origen.despegue();
                Thread.sleep(random.nextInt(16) + 15);
                destino.aterrizaje(id);
                destino.desembarcarPasajeros(id);
                destino.accesoEstacionamiento(this);
                destino.revisionTaller(id);
                if (random.nextBoolean())
                {
                    Thread.sleep(random.nextInt(1)+1);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
