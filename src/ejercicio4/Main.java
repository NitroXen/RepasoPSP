/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        int NUM_EMPLEADOS = 10;
        int cuandoLlegaElJefe = new Random().nextInt(NUM_EMPLEADOS+1);
        Oficina o = new Oficina();
        
        for(int i = 0;i<NUM_EMPLEADOS;i++){
            if(i == cuandoLlegaElJefe){
                new Jefe("Jefe", o).start();
            }else{
                new Empleado(""+(i<cuandoLlegaElJefe?i:i-1), o).start();
            }
        }
        
        
    }
}
