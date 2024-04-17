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
public class Avion1 implements Runnable{
    private Aeropuerto1 aeropuerto;
    private String nombre;
    private Random random = new Random();
    private int capacidadMaximaPasajeros;
    private int numeroPasajeros;

    public Avion1 (String nombre, Aeropuerto aeropuerto)
    {
        this.nombre = nombre;
        this.aeropuerto = aeropuerto;
        capacidadMaximaPasajeros = (100+random.nextInt(200));
        numeroPasajeros = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaximaPasajeros
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
        aeropuerto.areaEstacionamiento(this);
        aeropuerto.areRodaje(this);
        System.out.println("ESPERANDO PUERTA DE EMBARQUE");
        System.out.println("INGRESANDO PUERTA DE EMBARQUE");
        System.out.println("SUBIENDO PASAJEROS");
        try
        {
           if(true)//capacidadMaximaPasajeros compara con los pasajeros de los aeropuertos si es mayor
            {
                //tomamos los pasajeros que tengan, hacemos este proceso 3 veces esperando
                Thread.sleep(1000+random.nextInt(2000));
            }
           else
           {
               //tomamos los pasajeros maximos
           }
           System.out.println("PASAJEROS SUBIDOS"+numeroPasajeros);
           Thread.sleep(1000+random.nextInt(4000));
           //Liberar puerta de embarque
            System.out.println("INGRESANDO AREA DE RODAJE");
            System.out.println("Revisando estado....");
            Thread.sleep(1000+random.nextInt(4000));
            //esperando pista
            //pista otorgada
            System.out.println("Ultimas revisiones");
            Thread.sleep(1000+random.nextInt(2000));
            System.out.println("Despega"); //tarda el despeje 1 y 5
            Thread.sleep(1000+random.nextInt(4000));
            System.out.println("Contacta con la aeorivia");
            Thread.sleep(15000+random.nextInt(15000));
            while (!true)//solicita pista si no se la dan espera hasta que tenga espacio
            {
                Thread.sleep(1000+random.nextInt(4000));
            }
            System.out.println("LLEGA A LA PISTA");
            Thread.sleep(1000+random.nextInt(4000));
            System.out.println("ACCEDE AREA DE RODAJE");
            //solicita puerta de embarque
            Thread.sleep(3000+random.nextInt(2000));
            //deseembarca pasajeros
            Thread.sleep(1000+random.nextInt(4000));
            //Accede al area de estacionamiento
            System.out.println("comprobaciones");
            Thread.sleep(1000+random.nextInt(4000));
            //habra que pensar una manera de contabilizar el numero de vuelos que realiza en todo caso una varibale entera
            if (true)//vuelos = 15
            {
                Thread.slepp(1000);
                //intenta ingresar al taller
                System.out.println("LIMPIEZA A PROFUNDIDAD");
                Thread.sleep(5000+random.nextInt(5000));

            }
            else
            {
                //intenta ingresar al taller
                Thread.sleep(1000+random.nextInt(4000));
            }
           if(random.boolean()) //50/50
            {
                //va al hangar a descansar
                Thread.sleep(15000+random.nextInt(15000));
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
