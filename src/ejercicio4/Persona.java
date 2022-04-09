/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Admin
 */
public abstract class Persona extends Thread {
    
    public Persona(String nombre){
        super.setName(nombre);
    }
    
    public String getNombre(){
        return getName();
    }

    public abstract void aCurrar();


    @Override
    public void run(){
        aCurrar();
    }
}
