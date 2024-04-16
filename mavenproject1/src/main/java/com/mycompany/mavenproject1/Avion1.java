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
    private int capacidadMaximaPasajeros = (100+random.nextInt(200));
    private int numeroPasajeros;
    
    @Override
    public void run() {
        
        System.out.println("APARECE EN EL HANGAR");
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
           //Solicita puerta de embarque
           
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
