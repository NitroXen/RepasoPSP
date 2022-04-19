/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios3;

/**
 *
 * @author Admin
 */
public class Firma {
    
    private final int NUM_FANS = 25;
    
    private Fan[] fans;
    
            
    public Firma(){
        fans = new Fan[NUM_FANS];
        for(Fan f:fans){
            f = new Fan();
        }
    }
    
    public void firmado(Artista a){
        try{Thread.sleep(5000);}catch(InterruptedException ex){}
        for(Fan f:fans){
            f.preparado(a);
        }
        
    }
    
}
