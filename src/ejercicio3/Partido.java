/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author Admin
 */
public class Partido {
    
    private String nombre;
    private int numVotos;
    
    public Partido(String nombre){
        this.nombre = nombre;
        numVotos = 0;
    }
    
    public synchronized void incremento(){
        int i = numVotos;
        try{Thread.sleep(10);}catch(InterruptedException ex){}
        numVotos = i+1;
    }
    
    public int totalVotos(){
        return numVotos;
    }
    
    public String getNombre(){
        return nombre;
    }

}
