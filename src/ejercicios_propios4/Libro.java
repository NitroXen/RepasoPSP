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
    
    private static int count = 0;
    private int id;
    private String nombre;
    private double precio;
    
    public Libro(String nombre){
        id = count++;
        this.nombre = nombre;
        
        precio = (new Random().nextDouble()*22)+1;
        
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getId(){
        return id;
    }
    
    public double getPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", nombre=" + nombre + "}";
    }
    
    
    
    
}
