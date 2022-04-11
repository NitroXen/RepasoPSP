/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios2;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        int NUM_CLIENTES = 10;
        
        R r = new R(15);
        
        
        for(int i = 0; i<NUM_CLIENTES;i++){
            new Cliente(r).start();
            try{Thread.sleep(500);}catch(InterruptedException ex){}
        }
    }
    
}
