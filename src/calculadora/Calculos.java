/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Calculos {
    
    public static double sumar(ArrayList<Double> suma){
        double total = 0;
        for(int i = 0;i<suma.size();i++){
            total += suma.get(i);
        }
        return total;
    }
    
    public static double restar(ArrayList<Double> resta){
        double total = 0;
        for(int i =0;i<resta.size();i++){
            total -= resta.get(i);
        }
        return total;
    }
    
    public static double multiplicar(ArrayList<Double> mult){
        double total = 0;
        for(int i =0; i<mult.size();i++){
            total *= mult.get(i);
        }
        return total;
    }
    
    public static double dividir(ArrayList<Double> div){
        double total = 0;
        for(int i =0;i<div.size();i++){
            total /= div.get(i);
        }
        return total;
    }
    
}
