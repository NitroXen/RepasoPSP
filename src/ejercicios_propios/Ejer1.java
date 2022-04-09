/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Ejer1 {
    private Tarot[] cartasElegidas = new Tarot[4];
    private Tarot[] cartas = Tarot.values();
    private Random rand = new Random();


    public Ejer1(){
        for(int i = 0; i<cartasElegidas.length;i++){
            Tarot cartaToma = cartas[rand.nextInt(cartas.length)];
            cartasElegidas[i]= cartaToma;
        }
    }
    
    public void mostrarCartas(){
        for (int i = 0; i < cartasElegidas.length; i++) {
            System.out.println(i+")"+cartasElegidas[i].name());
        }
    }
    
    
    public static void main(String[] args) {
        
        Ejer1 uno = new Ejer1();
        
        uno.mostrarCartas();
        
    }
}
