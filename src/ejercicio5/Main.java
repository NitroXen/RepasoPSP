/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        int NUM_PLAZAS = 15;
        int NUM_COCHES = 100;
        Aparcamiento a = new Aparcamiento(NUM_PLAZAS);
        
        for(int i = 0; i< NUM_COCHES;i++){
            new Coche(""+(i+1), a).start();
        }
    }
    
    
}
