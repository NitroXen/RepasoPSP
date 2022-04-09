/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_propios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Views {
    
    public static void menuCabecera(){
        System.out.println("---------------------------------"
                         + "\n||      Caja Registradora      ||"
                +          "\n---------------------------------");
    }
    
    public static void menuPrincipal(){
        System.out.println("Que desea hacer?:"
                + "\n1)Cobrar"
                + "\n2)CobrarLibre"
                + "\n3)SALIR");
    }
    
    public static double leerDouble(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la cantidad en €uros:");
        return sc.nextDouble();
    }
    
    public static int leerInteger(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un numero:");
        return sc.nextInt();
    }
    
    public static int tirarDado(){
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }
    
}
