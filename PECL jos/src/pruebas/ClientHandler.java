/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket socket;
    private final InterfazGrafica interfaz;
    private final PrintWriter out;

    public ClientHandler(Socket socket, InterfazGrafica interfaz) throws IOException {
        this.socket = socket;
        this.interfaz = interfaz;
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void SolicitarCliente(String mensaje)
    {
        try {
            // Establecer un flujo de salida para enviar datos al cliente
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Enviar un mensaje al cliente
            out.println(mensaje);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Mensaje recibido: " + line);
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String identifier = parts[0];
                    String data = parts[1];
                    System.out.println(identifier + data);
                    // Actualizar el campo de texto correspondiente
                    interfaz.updateTextField(identifier, data);
                } else {
                    System.out.println("Mensaje recibido no válido: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}