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
public class Cliente extends Thread {
    
    public Cliente(String name){
        super(name);
    }
    
    
    @Override
    public void run(){
        Libro l = Libreria.getInstancia().getLibro(new Random().nextInt(Libreria.getInstancia().numLibrosEnLibreria()));
        
        try{Thread.sleep(1000);}catch(InterruptedException ex){}
        if(l != null){
            Libreria.getInstancia().retirarLibro(l);
        }
    }
    
    
}
