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
public class Plaza {
    
    private static int cuenta = 0;
    private Coche c;
    private int num;
    public Plaza(){
        num=cuenta++;
    }
    
    public void inCoche(Coche c){
        this.c = c;
        System.out.println(c+">>"+this);
    }
    
    public void outCoche(){
        System.out.println(this+">>"+c);
        c = null;
        
    }
    
    public boolean estaLibre(){
        return c == null;
    }
    
    public Coche getCoche(){
        return c;
    }
    
    public String toString(){
        return "P"+num;
    }
    
    
}
