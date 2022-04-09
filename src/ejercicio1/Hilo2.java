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
public class Hilo2 implements Runnable{

    @Override
    public void run() {
        mensaje();
    }
    
    
    public synchronized void mensaje(){
        System.out.println("Hola hilo " + Thread.currentThread().getName());
    }
}
