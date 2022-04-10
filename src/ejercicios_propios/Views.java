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
    
    public static void mensajes(){
        System.out.println("Bienvenidos al maravilloso mundo de tu mente"
                + "\ndonde nada es real y todo es estupido."
                + "\n\nTe encuentras en una habitacion donde solo hay 4 paredes, una cama"
                + "\ny una puerta(Tiras el dado y si da par abres la puerta y si no, te quedas aqui).");
    }
    
    public static void contMensaje(int i){
        if(i%2==0){
            System.out.println("Decides abrir la puerta, donde hay maravillas por doquier y mundos por descubrir,"
                    + "\nEste es tu comienzo, el fin del principio, donde iras a donde quieras y tendras muchos"
                    + "\namigos y aliados con los que estar, este es el origen");
        }else{
            System.out.println("Decides quedarte dentro, resguardado del exterior, pero descubres debajo de tu cama"
                    + "\nun juego de mesa que por alguna razon aparente, esta conectado con otros juegos de mesa, dando"
                    + "\na conocer a los jugadores de un juego grupal a distancia. Vivivras aventuras epicas dentro de tu"
                    + "\ncasa y algun día, te reuniras con tus amigos del juego, este es el origen");
        }
        
        System.out.println("\nEsto es:"
                + "\n||====  ||  ||\\\\    ||  ||   =======   ========  ||=======  ||=====   ||=====   ||=====||"
                + "\n||      ||  || \\\\   ||  ||   ((           ||     ||         ||    ||  ||    ||  ||     ||"
                + "\n||====  ||  ||  \\\\  ||  ||   =======      ||     ||=======  ||=====   ||=====   ||=====||"
                + "\n||      ||  ||   \\\\ ||  ||        ))      ||     ||         || ((     || ((     ||     ||"
                + "\n||      ||  ||    \\\\||  ||   =======      ||     ||=======  ||  ((    ||  ((    ||     ||");
    }
    
    
}
