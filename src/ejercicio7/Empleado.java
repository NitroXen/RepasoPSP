/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Empleado extends Thread{
    
    
    static final int NUM_APUESTAS = 5;
    Bote bote;
    HashMap<String, ApuestaResultado> apuestas;
    
    //constructor al que le damos el nombre y la clase bote para el hilo
    public Empleado(String nombre, Bote bote){
        super(nombre);
        this.bote = bote;
        apuestas = new HashMap<>();
    }
    
    
    //en el motodo run sobrecargado que gestiona el tema de las apuestas
    @Override
    public void run(){
        for(int i =0;i<NUM_APUESTAS;i++){
            int importeApostado = i+1;
            String resultado = Bote.getFormatoApuesta();
            bote.apuesta(resultado, importeApostado);
            
            System.out.println(getName()+" "+importeApostado+"€ a "+resultado);
            ApuestaResultado ar = apuestas.get(resultado);
            if(ar==null){
                ar = new ApuestaResultado(resultado);
                
            }
            ar.apuesta(importeApostado);
            apuestas.put(resultado, ar);
        }
    }
    
    //metodo de la clase ApuestaResultado que devuevle en el
    //hashmap la apuesta ganadora del partido
    public ApuestaResultado getApuestaGanadora(String resultado){
        return apuestas.get(resultado);
    }
    
    
}
