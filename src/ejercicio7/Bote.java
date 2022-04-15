/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class Bote {
    
    private static final int MAX_GOLES = 3;
    private static Random r = new Random();
    
    private HashMap<String, ApuestaResultado> apuestas;
    
    
    //el constructor Bote sin darle nada inicializa un
    //hashmap de apuestas con String y Apuesta Resultado
    public Bote(){
        apuestas = new HashMap<>();
        for(int golesLocal=0;golesLocal<MAX_GOLES;golesLocal++){
            for(int golesVisitantes=0;golesVisitantes<MAX_GOLES;golesVisitantes++){
                String resultado = Bote.getFormatoApuesta(golesLocal, golesVisitantes);
                apuestas.put(resultado, new ApuestaResultado(resultado));
            }   
        }
    }
    
    //damos al hashmap apropiado la apuesta
    public void apuesta(String resultado, int importe){
        apuestas.get(resultado).apuesta(importe);
    }
    
    //devolvemos el punto de la apuesta del hashmap
    public ApuestaResultado getApuesta(String resultado){
        return apuestas.get(resultado);
    }
    
    //metodo estatico de nivel devoucion de String
    //que muestra los goles que marcaron los equipos en el partido
    public static String getFormatoApuesta(int golesLocal, int golesVisitante){
        return golesLocal +" - " + golesVisitante;
    }
    
    //metodo estatico que genera los goles de los equipos
    public static String getFormatoApuesta(){
        int golesLocal=r.nextInt(MAX_GOLES);
        int golesVisitante = r.nextInt(MAX_GOLES);
        return Bote.getFormatoApuesta(golesLocal, golesVisitante);
    }
    
    //metodo entero que devuelve la recaudacion de la apuesta
    public int getRecaudacion(){
        int recaudacion=0;
        for(Map.Entry<String , ApuestaResultado> entry:apuestas.entrySet()){
            recaudacion += entry.getValue().importe;
        }
        return recaudacion;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(Map.Entry<String, ApuestaResultado> entry:apuestas.entrySet()){
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    
    
}
