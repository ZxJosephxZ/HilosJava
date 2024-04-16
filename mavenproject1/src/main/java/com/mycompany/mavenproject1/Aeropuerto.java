/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Joseph
 */
public class Aeropuerto{

    private BlockingQueue<Integer> pasajeros = new LinkedBlockingQueue<>();
    private BlockingQueue<Aviones> estacionamiento = new LinkedBlockingQueue<>();
    private BlockingQueue<Aviones> taller = new LinkedBlockingQueue<>();
    private ThreadLocalRandom random = ThreadLocalRandom.current();
    private Semaphore puertasEmbarque = new Semaphore(6);
    private Semaphore pistas = new Semaphore(4);
    private String ubicacion;

    public Aeropuerto(String ubicacion)
    {
        this.ubicacion = ubicacion;
    }
    public void subirPasajeros(int numPasajeros) throws InterruptedException
    {
        pasajeros.put(numPasajeros);
        System.out.println("Pasajeros subidos"+ numPasajeros);
    }
    public void bajarPasajeros() throws InterruptedException
    {
        int pasajerosBajados = pasajeros.take();
        System.out.println("Pasajeros bajados"+ pasajerosBajados);
    }
    public void bajarPasajeros(int numPasajeros) throws InterruptedException
    {
        pasajeros.take();
        System.out.println("Pasajeros bajados en la ciudad"+ numPasajeros);
    }
    public synchronized void accesoEstacionamiento(Aviones aviones) throws InterruptedException
    {
        estacionamiento.put(aviones);
        System.out.println(aviones.getid()+"accede al estacionamiento");
        Thread.sleep(random.nextInt(6)+ 1);
    }
    public void embarcarPasajeros(String avionId) throws InterruptedException
    {
        Aviones aviones = (Aviones) Thread.currentThread();
        System.out.println("Embarcando pasajeros en el avión " + avionId);
        int intentos = 0;
        while (intentos < 3 && aviones.getPasajerosEmbarcados() < aviones.getCapacidadMaxima()) {
            int pasajerosDisponibles = estacionamiento.remainingCapacity(); // Obtener pasajeros disponibles en el aeropuerto
            int pasajerosAEmbarcar = Math.min(pasajerosDisponibles, aviones.getCapacidadMaxima() - aviones.getPasajerosEmbarcados());
            if (pasajerosAEmbarcar > 0) {
                aviones.embarcarPasajeros(pasajerosAEmbarcar);
                System.out.println("Embarcados " + pasajerosAEmbarcar + " pasajeros en el avión " + avionId);
                Thread.sleep(random.nextInt(3) + 1); // Tiempo de embarque
            }
            intentos++;
        }
        if (aviones.getPasajerosEmbarcados() < aviones.getCapacidadMaxima()) {
            System.out.println("No se pudo completar el aforo del avión " + avionId + ". La puerta de embarque cierra.");
        }
        puertasEmbarque.release();
    }
    public void despegue() throws InterruptedException {
        Aviones aviones = (Aviones) Thread.currentThread();
        System.out.println("El avión " + aviones.getId() + " está realizando comprobaciones antes del despegue.");
        Thread.sleep(random.nextInt(5) + 1); // Tiempo de comprobaciones
        System.out.println("El avión " + aviones.getId() + " ha despegado.");
        pistas.release();
    }

    public void aterrizaje(String avionId) throws InterruptedException {
        Aviones aviones = (Aviones) Thread.currentThread();
        System.out.println("El avión " + avionId + " está solicitando pista para aterrizar.");
        pistas.acquire();
        System.out.println("El avión " + avionId + " ha aterrizado.");
    }

    public void desembarcarPasajeros(String avionId) throws InterruptedException {
        Aviones aviones = (Aviones) Thread.currentThread();
        System.out.println("Desembarcando pasajeros del avión " + avionId);
        Thread.sleep(random.nextInt(5) + 1); // Tiempo de desembarque
        pasajeros.take();
    }

    public void revisionTaller(String avionId) throws InterruptedException {
        Aviones aviones = (Aviones) Thread.currentThread();
        if (aviones.getVuelosRealizados() % 15 == 0) { // Si el avión necesita inspección en profundidad
            System.out.println("El avión " + avionId + " necesita inspección en profundidad en el taller.");
        } else {
            System.out.println("El avión " + avionId + " pasa por el taller para revisión.");
        }
        Thread.sleep(random.nextInt(6) + 5); // Tiempo de revisión en el taller
        taller.remove(aviones); // El avión sale del taller
    }

    
}
