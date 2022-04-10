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
        int NUM_PLAZAS = 12;
        int NUM_COCHES = 100;
        Aparcamiento a = new Aparcamiento(NUM_PLAZAS);
        Coche[] c = new Coche[NUM_COCHES];
        for(int i =0;i<NUM_COCHES;i++){
            c[i] = new Coche(""+(i+1), a);
            c[i].start();
        }
        for(Coche car : c){
            try{car.join();}catch(InterruptedException ex){}
        }
        System.out.println("\nfin de la simulacion");
    }
}
