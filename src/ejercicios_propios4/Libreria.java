/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios4;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Libreria {
    private static Libreria instancia;
    private ArrayList<Libro> listaLibros;
    private double ganancias;
    
    private Libreria(){
        listaLibros = new ArrayList<>();
        ganancias = 0.0;
    }
    
    public static Libreria getInstancia(){
        if(instancia == null){
            instancia = new Libreria();
        }
        return instancia;
    }
    
    public void addLibro(Libro l){
        listaLibros.add(l);
        System.out.println("Libro "+ l.getNombre() + ": Añadido");
    }
    
    public void retirarLibro(int i){
        Libro l = listaLibros.get(i);
        ganancias += l.getPrecio();
        listaLibros.remove(l);
    }
    
    public synchronized void retirarLibro(Libro l){
        ganancias += l.getPrecio();
        listaLibros.remove(l);
    }
    
    
    
    public Libro getLibro(int id){
        Libro l = listaLibros.get(id);
        System.out.println("El libro seleccionado es: " + l.getNombre());
        return l;
    }
    
    public int numLibrosEnLibreria(){
        return listaLibros.size();
    }
    
    public double getGanancias(){
        return ganancias;
    }
    
}
