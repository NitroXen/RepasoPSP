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
    
    
    private Aparcamiento aparcamiento;
    
    public Coche(String nombre, Aparcamiento aparcamiento){
        super.setName(nombre);
        this.aparcamiento= aparcamiento;
    }
    
    
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
