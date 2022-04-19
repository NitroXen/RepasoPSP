/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        final int NUM_METEORITOS = 100;
        final int NUM_NAVES_A = 5;
        final int NUM_NAVES_BS = 7;
        
        for(int i = 0;i<NUM_METEORITOS;i++)Agencia.getInstancia().addMeteorito(new Meteorito(i));
        for(int i = 0 ;i<NUM_NAVES_A;i++)new NaveA(i+"").start();
        for(int i = 0;i<NUM_NAVES_BS;i++)new NaveBS(i+"").start();
        
    }
}
