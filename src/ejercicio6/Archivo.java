/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Archivo {

    BufferedReader br;
    //inicializamos con el constructor con Throws para que lea nuestro archivo
    public Archivo(String ruta) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(ruta));

    }

    //el metodo sincronizado para leer la lineas del archivo para conversaciones a cada hilo
    public synchronized String getLinea() {
        notify();
        String linea;
        try {
            if ((linea = br.readLine()) != null) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                }
                return linea;
            }
        } catch (IOException ex) {
        }
        return null;
    }
}
