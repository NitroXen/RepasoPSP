/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios;

/**
 *
 * @author Admin
 */
public class Ejer2 {
    public static void main(String[] args) {
        Views.mensajes();
        try{Thread.sleep(1200);}catch(InterruptedException ex){}
        int i = Views.tirarDado();
        System.out.println(i);
        Views.contMensaje(i);
    }
}
