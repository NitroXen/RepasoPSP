/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        
        int MAX_CUENTA = 100;
        
        Hilo[] h = new Hilo[MAX_CUENTA];
        
        Contador c = new Contador();
        
        for(int i =0;i<h.length;i++){
            h[i] = new Hilo(c);
            h[i].start();
        }
        
        for(Hilo hilo : h){
            try{hilo.join();}catch(InterruptedException ex){}
        }
        
        System.out.println(c.getCuenta());
        
        
    }
}
