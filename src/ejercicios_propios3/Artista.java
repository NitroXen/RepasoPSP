/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios3;

/**
 *
 * @author Admin
 */
public class Artista extends Thread {
    
    Firma f;
    
    public Artista(String nombre,Firma f){
        super(nombre);
        this.f = f;
    }
    
    
}
