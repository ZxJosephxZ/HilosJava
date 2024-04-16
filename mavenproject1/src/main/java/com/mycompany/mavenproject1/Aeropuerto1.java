/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Joseph
 */
public class Aeropuerto1 {
    private String nombre;
    private Semaphore espacioTalleres = new Semaphore(20);
    private Semaphore embarque = new Semaphore(1);
    private Semaphore desembarque = new Semaphore(1);
    private Semaphore[] puertasLibres = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
    private Semaphore[] pistas = {new Semaphore(1),new Semaphore(1),new Semaphore(1),new Semaphore(1)};
    private BlockingQueue<String> colaEmbarque = new LinkedBlockingQueue<>();
    private AtomicInteger pasajeros = new AtomicInteger(0);
    
    public Aeropuerto1(String nombre)
    {
        this.nombre = nombre;
    }
    
    //Pueden entrar los que sean y aqui se empieza
    public void Hangar()
    {
        System.out.println("EMPIEZAN LOS AVIONES TODOS AQUI");
    }
    
    //Solo pueden entrar 20aviones simultaneamente
    public void Taller() throws InterruptedException
    {
        espacioTalleres.acquire();
        //logica
        espacioTalleres.release();
        
    }
    
    //cambiar el string por la clase avion
    public void PuertaEmbarque(String avion) throws InterruptedException
    {
        System.out.println("llego para embarcar"+avion);
        colaEmbarque.put(avion);
        //tomar embarque
        embarque.acquire();
        System.out.println("el"+avion+"obtuvo acceso a la puerta de embarque");
        while (!colaEmbarque.peek().equals(avion))
        {
            Thread.sleep(1000);
        }
        //Simulacion del embarque
        System.out.println("Avión " + avion + " está embarcando...");
        //liberar puerta de embarque
        embarque.release();
        System.out.println("Avión " + avion + " ha embarcado y liberado la puerta de embarque.");
        colaEmbarque.take(); // Se elimina el avión de la cola de embarque
    }
    public void desembarqueAvion(String avion) throws InterruptedException {
        System.out.println("Avión " + avion + " llegó para desembarcar.");

        // Intenta obtener acceso a la puerta de desembarque
        desembarque.acquire();
        System.out.println("Avión " + avion + " ha obtenido acceso a la puerta de desembarque.");

        // Simulación de desembarque
        System.out.println("Avión " + avion + " está desembarcando...");
        Thread.sleep(2000); // Simulación de proceso de desembarque

        // Liberar la puerta de desembarque
        desembarque.release();
        System.out.println("Avión " + avion + " ha desembarcado y liberado la puerta de desembarque.");
    }
    public void usarPuertaLibre(String avion, int numeroPuerta) throws InterruptedException {
        System.out.println("Avión " + avion + " solicitando puerta libre " + (numeroPuerta + 1) + "...");

        // Intenta obtener acceso a la puerta libre especificada
        puertasLibres[numeroPuerta].acquire();
        System.out.println("Avión " + avion + " ha obtenido acceso a la puerta libre " + (numeroPuerta + 1) + ".");

        //AÑADIR LOGICA PARA EL CASO EN QUE SE OBTENGA LA PUERTA LIBRE DETERMINAR SI LA USARA PARA DESEMBARCAR O EMBARCAR
        // Simulación de uso de la puerta libre
        System.out.println("Avión " + avion + " está usando la puerta libre " + (numeroPuerta + 1) + "...");
        Thread.sleep(2000); // Simulación de proceso de uso de la puerta

        // Liberar la puerta libre
        puertasLibres[numeroPuerta].release();
        System.out.println("Avión " + avion + " ha usado la puerta libre " + (numeroPuerta + 1) + " y la ha liberado.");
    }
    
    //ESTAS SON LAS PISTAS
    public void despegueAvion(String avion, int pista) throws InterruptedException {
        System.out.println("Avión " + avion + " está solicitando despegue en la pista " + (pista + 1) + "...");

        // Intenta obtener acceso a la pista de despegue especificada
        pistas[pista].acquire();
        System.out.println("Avión " + avion + " ha obtenido acceso a la pista " + (pista + 1) + ".");

        // Simulación de despegue
        System.out.println("Avión " + avion + " está despegando desde la pista " + (pista + 1) + "...");
        Thread.sleep(2000); // Simulación de proceso de despegue

        // Liberar la pista de despegue
        pistas[pista].release();
        System.out.println("Avión " + avion + " ha despegado y liberado la pista " + (pista + 1) + ".");
    }
    
    //Pueden entrar los que sean
    public void areaEstacionamiento()
    {
        System.out.println("ENTRAN CUALQUIER AVION");
    }
    
    //Pueden entrar los que sean
    public void areaRodaje()
    {
        System.out.println("ENTRAN CUALQUIER AVION");
    }
    
    public void aerovias()
    {
        System.out.println("SOLO PUEDEN VER 2");
    }
}