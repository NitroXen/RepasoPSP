/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Recinto{

    private Integrante[] banda;
    private int sinFirma;
    private int firma;
    
    
    public Recinto(Integrante[] banda) {
        this.banda = banda;

    }
    
    private Integrante getIntegrante(){
        for(Integrante i: banda){
            if(i.isDisponible()){
                return i;
            }
        }
        return null;
    }
    
    public synchronized void fanIn(Fans f){
        Integrante iLibre;
        while((iLibre = getIntegrante())==null){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        iLibre.inFan(f);
    }
     public synchronized void fanOut(Fans f){
         notify();
         for(Integrante i:banda){
             if(i.getFan()==f){
                 i.outFan();
             }
         }
     }

    public void cuentaSin() {
        for(Integrante i:banda){
            sinFirma += i.getSinFirma();
        }
        System.out.println("Fans sin Firmar: " + sinFirma);
    }
    
    public void cuenta(){
        for(Integrante i:banda){
            firma += i.getFirma();
        }
        System.out.println("Fans Firmados: " + firma);
    }
    
    

}
