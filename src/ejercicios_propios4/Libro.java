/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios4;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Libro {
    
    private String nombre;
    private double precio;
    
    public Libro(String nombre){
        this.nombre = nombre;
        
        
        
        precio = (new Random().nextDouble()*22)+1;
    }
    
    public String getNombre(){
        return nombre;
    }
    

    
    public double getPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        return "Libro{" +" nombre=" + nombre + "}";
    }
    
    
    
    
}
