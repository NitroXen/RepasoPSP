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
    
    //constructor abstracto para crear personal de la oficina 
    public Persona(String nombre){
        super.setName(nombre);
    }
    
    
    //nos dice el nombre
    public String getNombre(){
        return getName();
    }

    //un metodo abstracto para el run
    public abstract void aCurrar();

    
    //el metodo Run donde lo que modificaremos sera el aCurrar
    @Override
    public void run(){
        aCurrar();
    }
}
