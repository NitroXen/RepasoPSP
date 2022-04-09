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
public class Coche extends Thread{
    
    Aparcamiento aparcamiento;
    
    public Coche(String nombre, Aparcamiento aparcamiento)
    {
        super(nombre);
        this.aparcamiento = aparcamiento;
    }
    
    @Override
    public String toString(){
        return "C"+getName();
    }
    
    @Override
    public void run(){
        aparcamiento.aparcar(this);
        try{Thread.sleep(new Random().nextInt(100)+1);}catch(InterruptedException ex){}
        aparcamiento.salir(this);
    }
    
}
