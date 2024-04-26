/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Random;
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
    private AtomicInteger numHangar = new AtomicInteger(0);
    private Semaphore accesoTaller = new Semaphore(1);
    private BlockingQueue<String> colaTaller = new LinkedBlockingQueue<>();
    private Random random = new Random();
    
    public Aeropuerto1(String nombre)
    {
        this.nombre = nombre;
    }
    
    //Pueden entrar los que sean y aqui se empieza
    public void Hangar(Avion1 avion)
    {

        System.out.println("Entro al hangar el avion"+avion.getNombre());
        numHangar.incrementAndGet();
    }
    
    //Solo pueden entrar 20aviones simultaneamente
    public void Taller() throws InterruptedException
    {
        espacioTalleres.acquire();
        //logica
        espacioTalleres.release();
        
    }

    public void areaEstacionamiento(Avion1 avion) throws InterruptedException
    {

        System.out.println("Ingreso al area de estacionmiento:" + avion.getNombre());
        numHangar.decrementAndGet();
        System.out.println("Solicita puerta de embarque:" + avion.getNombre());
        PuertaEmbarque(avion);
    }

    //cambiar el string por la clase avion
    public void PuertaEmbarque(Avion1 avion) throws InterruptedException
    {
        colaEmbarque.put(avion.getNombre());
        //tomar embarque
        embarque.acquire();
        System.out.println("el"+avion+"obtuvo acceso a la puerta de embarque");
        while (!colaEmbarque.peek().equals(avion.getNombre()))
        {
            Thread.sleep(1000);
        }
        //Simulacion del embarque
        System.out.println("Avión " + avion + " está embarcando...");
        int i = 0;
        if (avion.getCapacidadMaximaPasajeros() > pasajeros.get())
        {
            while ((avion.getCapacidadMaximaPasajeros() != avion.getNumeroPasajeros()) && i != 3)
            {
                System.out.println("Pasajeros insuficientes");
                if (avion.getCapacidadMaximaPasajeros() - avion.getNumeroPasajeros() > pasajeros.get())
                {
                    avion.setNumeroPasajeros(pasajeros.get());
                    Thread.sleep(1000+random.nextInt(4000));
                    subirAvionPasajeros(pasajeros.get());
                }
                else
                {
                    avion.setNumeroPasajeros(avion.getCapacidadMaximaPasajeros() - avion.getNumeroPasajeros());
                    Thread.sleep(1000+random.nextInt(4000));
                    subirAvionPasajeros(avion.getCapacidadMaximaPasajeros() - avion.getNumeroPasajeros());
                }
                System.out.println("Subiendo pasajeros....");
                Thread.sleep(1000+random.nextInt(3000));
                i++;
            }
        }
        avion.setNumeroPasajeros(avion.getCapacidadMaximaPasajeros());
        Thread.sleep(1000+random.nextInt(4000));
        subirAvionPasajeros(avion.getCapacidadMaximaPasajeros());

        //liberar puerta de embarque
        embarque.release();
        System.out.println("Avión " + avion + " ha embarcado y liberado la puerta de embarque.");
        colaEmbarque.take(); // Se elimina el avión de la cola de embarque
    }
    public void desembarqueAvion(Avion1 avion) throws InterruptedException {
        System.out.println("Avión " + avion.getNombre() + " llegó para desembarcar.");

        // Intenta obtener acceso a la puerta de desembarque
        desembarque.acquire();
        System.out.println("Avión " + avion.getNombre() + " ha obtenido acceso a la puerta de desembarque.");

        // Simulación de desembarque
        System.out.println("Avión " + avion.getNombre() + " está desembarcando...");
        Thread.sleep(3000+random.nextInt(2000)); // Simulación de proceso de desembarque
        añadirPasajeros(avion.getNumeroPasajeros());
        // Liberar la puerta de desembarque
        desembarque.release();
        System.out.println("Avión " + avion.getNombre() + " ha desembarcado y liberado la puerta de desembarque.");
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
    public void despegueAvion(Avion1 avion) throws InterruptedException {
        System.out.println("Avión " + avion.getNombre() + " está solicitando despegue...");

        int pistaAsignada = -1;

        // Intenta obtener acceso a alguna pista disponible
        for (int i = 0; i < pistas.length; i++) {
            if (pistas[i].tryAcquire()) {
                pistaAsignada = i;
                System.out.println("Avión " + avion.getNombre() + " ha obtenido acceso a la pista " + (i + 1) + ".");
                break;
            }
        }

        if (pistaAsignada != -1) {
            // Simulación de despegue
            System.out.println("Avión " + avion.getNombre() + " está despegando desde la pista " + (pistaAsignada + 1) + "...");
            Thread.sleep(1000 + random.nextInt(4000)); // Simulación de proceso de despegue

            // Liberar la pista de despegue
            pistas[pistaAsignada].release();
            System.out.println("Avión " + avion.getNombre() + " ha despegado y liberado la pista " + (pistaAsignada + 1) + ".");
        } else {
            System.out.println("No hay pistas disponibles para el despegue del avión " + avion + ".");
        }
    }
    public void aterrizajeAvion(Avion1 avion) throws InterruptedException {
        boolean aterrizajeExitoso = false;

        while (!aterrizajeExitoso) {
            System.out.println("Avión " + avion.getNombre() + " está solicitando pista de aterrizaje...");

            int pistaAsignada = -1;

            // Intenta obtener acceso a alguna pista disponible
            for (int i = 0; i < pistas.length; i++) {
                if (pistas[i].tryAcquire()) {
                    pistaAsignada = i;
                    System.out.println("Avión " + avion.getNombre() + " ha obtenido acceso a la pista " + (i + 1) + " para aterrizaje.");
                    break;
                }
            }

            if (pistaAsignada != -1) {
                // Simulación de aterrizaje
                Thread.sleep(random.nextInt(5000) + 1000); // Tiempo de aterrizaje entre 1 y 5 segundos
                System.out.println("Avión " + avion.getNombre() + " ha aterrizado en la pista " + (pistaAsignada + 1) + ".");
                aterrizajeExitoso = true;

                // Liberar la pista de aterrizaje
                pistas[pistaAsignada].release();
                System.out.println("Avión " + avion.getNombre() + " ha liberado la pista " + (pistaAsignada + 1) + ".");
            } else {
                System.out.println("No hay pistas disponibles para el aterrizaje del avión " + avion + ". Dando un rodeo...");
                Thread.sleep(random.nextInt(5000) + 1000); // Tiempo de rodeo entre 1 y 5 segundos
            }
        }
    }
    //Pueden entrar los que sean
    
    public void realizarInspeccionTaller(Avion1 avion) throws InterruptedException {
        System.out.println("Avión " + avion + " está solicitando inspección en el taller...");

        // Intenta adquirir acceso al taller
        accesoTaller.acquire();
        System.out.println("Avión " + avion.getNombre() + " ha obtenido acceso al taller.");

        // Simulación de inspección en el taller
        int tiempoInspeccion = random.nextInt(6) + 5; // Tiempo de inspección entre 5 y 10 segundos
        Thread.sleep(tiempoInspeccion * 1000); // Convertir segundos a milisegundos
        System.out.println("Avión " + avion.getNombre() + " ha completado la inspección en el taller.");

        // Liberar acceso al taller
        accesoTaller.release();
        System.out.println("Avión " + avion.getNombre() + " ha liberado el taller.");

        // Continuar con el ciclo de vida del avión
        continuarCicloVida(avion);
    }

    private void continuarCicloVida(Avion1 avion) throws InterruptedException {

        // Decidir aleatoriamente si ir al hangar o continuar con el ciclo de vida
        if (random.nextBoolean()) {
            System.out.println("Avión " + avion.getNombre() + " se dirige al hangar para reposar.");

            // Tiempo de reposo en el hangar entre 15 y 30 segundos
            int tiempoReposo = random.nextInt(16) + 15; 
            Thread.sleep(tiempoReposo * 1000); // Convertir segundos a milisegundos
        } else {
            System.out.println("Avión " + avion.getNombre() + " continúa con el ciclo de vida.");
        }
    }

    
    //Pueden entrar los que sean
    public void areaRodaje(Avion1 avion) throws InterruptedException
    {
        System.out.println("Ingresando ha area de rodaje:"+avion.getNombre());
        System.out.println("Haciendo comprobaciones del avion:"+avion.getNombre());
        Thread.sleep(1000 + random.nextInt(4000));
        despegueAvion(avion);
    }
    
    public void aerovias(Avion1 avion) throws InterruptedException
    {
        System.out.println("CONECTA CON AEROVIA");
        System.out.println("EN VUELO...");
        Thread.sleep(15000+random.nextInt(15000));
        
    }

    public void añadirPasajeros(int numPasajeros)
    {
        pasajeros.addAndGet(numPasajeros);
        System.out.println("NUMERO DE PASAJEROS EN EL AEROPUERTO" + pasajeros);
    }

    public int subirAutobusPasajeros()
    {
        int numero = random.nextInt(50)+1;
        while (pasajeros.get() < numero)
        {
            numero = random.nextInt(50)+1;
        }
        pasajeros.addAndGet(-numero);
        return (numero);
    }
    //me quita el numero de pasajeros en el aeropuerto porque ahora estan en el avion
    public void subirAvionPasajeros(int numero)
    {
        pasajeros.addAndGet(-numero);
    }
    public void bajarAvionPasajeros(int numero)
    {
        pasajeros.addAndGet(numero);
    }
    public void pasajerosEnAeropuerto()
    {
        System.out.println("Numero actual de pasajeros en el aeropuerto"+pasajeros);
    }
}
