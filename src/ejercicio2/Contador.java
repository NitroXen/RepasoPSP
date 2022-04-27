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
public class Contador {
    private int cuenta;
    
    public Contador(){
        cuenta=0;
    }
    
    public synchronized void incremento(){
        cuenta++;
    }
    
    public int getCuenta(){
        return cuenta;
    }
}
