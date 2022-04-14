/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Coche extends Thread {
    
    //Usaremos la clase aparcamiento para su uso de entrada y salida
    private Aparcamiento aparcamiento;
    
    
    //inicializamos con el contructor
    public Coche(String nombre, Aparcamiento aparcamiento){
        super.setName(nombre);
        this.aparcamiento= aparcamiento;
    }
    
    
    //el metodo run sobrecargado de Thread hace que entre un coche, pase un tiempo y salga
    @Override
    public void run(){
        aparcamiento.entraCoche(this);
        try{Thread.sleep(new Random().nextInt(500)+1);}catch(InterruptedException ex){}
        aparcamiento.saleCoche(this);
    }
    
    
    @Override
    public String toString(){
        return "C"+getName();
    }
}
