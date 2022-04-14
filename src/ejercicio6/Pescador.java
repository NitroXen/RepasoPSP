/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.FileNotFoundException;

/**
 *
 * @author Admin
 */
public class Pescador extends Thread{
    
    private Archivo archivo;
    private long retraso;
    
    //inicializamos con el contructor con hilos conversadores
    public Pescador(String nombre, long retraso, Archivo archivo){
        super(nombre);
        this.retraso = retraso;
        this.archivo = archivo;
    }
    
    
    //con el metodo sobrecargado Run le decimos a cada hilo que escriba lo que esta inicializado en Archivo
    @Override
    public void run(){
        try{
            Thread.sleep(retraso);
        }catch(InterruptedException ex){}
        String linea = archivo.getLinea();
        while(linea!=null){
            System.out.println(getName()+": "+linea);
            try{Thread.sleep(retraso);
            }catch(InterruptedException ex){}
            linea = archivo.getLinea();
        }
    }
    
    public static void main(String[] args) {
        String ruta = "./holamundo.txt";
        Archivo a = null;
        try{
        a = new Archivo(ruta);
        }catch(FileNotFoundException ex){System.out.println("Archivo no encontrado.");}
        (new Pescador("FRANK", 1, a)).start();
        (new Pescador("DAMIAN", 1000, a)).start();
    }
    
}
