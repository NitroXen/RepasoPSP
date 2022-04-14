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
    
    //para contabilizar los numeros de plazas
    private static int cuenta = 0;
    private int num;
    
    //guardamos la clase coche para las plazas
    private Coche c;
    
    public Plaza(){
        num=cuenta++;
    }
    
    //cuando el coche entra en la plaza
    public void inCoche(Coche c){
        this.c = c;
        System.out.println(c+">>"+this);
    }
    
    //cuando el Coche sale de la plaza
    public void outCoche(){
        System.out.println(this+">>"+c);
        c = null;
        
    }
    
    //comprobamos si esta disponible
    public boolean estaLibre(){
        return c == null;
    }
    
    //comprobamos el coche del aparcamiento
    public Coche getCoche(){
        return c;
    }
    
    //nombre de la plaza
    public String toString(){
        return "P"+num;
    }
    
    
}
