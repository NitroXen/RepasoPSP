/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class ApuestaResultado {
    
    String resultado;
    int importe;
    int numApuestas;
    
    public ApuestaResultado(String resultado){
        this.resultado = resultado;
        this.importe = 0;
        this.numApuestas =0;
    }
    
    public synchronized void apuesta(int importe){
        int importeHastaAhora= this.importe;
        try{
            Thread.sleep(new Random().nextInt(200));
        }catch(InterruptedException ex){}
        this.importe = importeHastaAhora+importe;
        this.numApuestas++;
    }
    
    @Override
    public String toString(){
        return "{"+numApuestas+" apuestas, que suman "+importe+"€ }";
    }
    
}
