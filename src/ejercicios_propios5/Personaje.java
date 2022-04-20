/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios5;

/**
 *
 * @author Admin
 */
public abstract class Personaje extends Thread{
    
    public Personaje(String name){
        super(name);
    }
    
    
    public abstract void accion();
    
    @Override
    public void run(){
        accion();
    }
    
}
