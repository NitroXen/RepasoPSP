/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        final int NUM_INTEGRANTES = 5;
        final int NUM_FIRMAS_INTEGRANTE = 40;
        final int NUM_FANS = 400;
        
        int numFirmados= 0;
        int numNoFirmados = 0;
        
        Integrante[] banda = new Integrante[NUM_INTEGRANTES];
        
        for(int i =0;i< NUM_INTEGRANTES;i++){
            banda[i] = new Integrante(NUM_FIRMAS_INTEGRANTE);
        }
//        
//        Recinto r = new Recinto(banda);
        Fans[] fans = new Fans[NUM_FANS];
//        
//        
//        for(int i =0; i<NUM_FANS;i++){
//            fans[i] = new Fans(r);
//            fans[i].start();
//        }
//        
        for(int i = 0;i<NUM_FANS;i++){
            fans[i] = new Fans(banda);
            fans[i].start();
        }
        for(Fans f:fans){
            try{f.join();}catch(InterruptedException e){}
        }
        System.out.println("--------------------------------------");
        
        for(Integrante i:banda){
            numFirmados+=i.getFirma();
            numNoFirmados+=i.getSinFirma();
        }
        
        System.out.println("Firmados: " + numFirmados);
        System.out.println("No Firmados: "+ numNoFirmados);
    }
    
}
