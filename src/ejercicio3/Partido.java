/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Partido {
    
    private String nombre;
    private int votos;
    
    public Partido(String nombre){
        this.nombre = nombre;
        votos =0;
    }
    
    public synchronized void incrementaVotos(){
        int i = votos;
        try{Thread.sleep(new Random().nextInt(5)+1);}catch(InterruptedException ex){}
        votos = i+1;
    }
    
    public int totalVotos(){
        return votos;
    }
    
    public String getNombre(){
        return nombre;
    }
    
}
