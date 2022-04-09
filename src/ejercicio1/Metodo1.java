/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Admin
 */
public class Metodo1 {
    public static void main(String[] args) {
        
        int NUM_HILOS = 5;
        
        Hilo2 h2 = new Hilo2();
        Thread[] t = new Thread[NUM_HILOS];
        
        for(int i = 0; i<t.length;i++){
            t[i] = new Thread(h2);
            t[i].start();
        }
        
        
        
    }
}
