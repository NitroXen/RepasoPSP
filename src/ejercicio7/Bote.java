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
    
    public Bote(){
        apuestas = new HashMap<>();
        for(int golesLocal=0;golesLocal<MAX_GOLES;golesLocal++){
            for(int golesVisitantes=0;golesVisitantes<MAX_GOLES;golesVisitantes++){
                String resultado = Bote.getFormatoApuesta(golesLocal, golesVisitantes);
                apuestas.put(resultado, new ApuestaResultado(resultado));
            }   
        }
    }
    public void apuesta(String resultado, int importe){
        apuestas.get(resultado).apuesta(importe);
    }
    
    public ApuestaResultado getApuesta(String resultado){
        return apuestas.get(resultado);
    }
    
    public static String getFormatoApuesta(int golesLocal, int golesVisitante){
        return golesLocal +" - " + golesVisitante;
    }
    
    public static String getFormatoApuesta(){
        int golesLocal=r.nextInt(MAX_GOLES);
        int golesVisitante = r.nextInt(MAX_GOLES);
        return Bote.getFormatoApuesta(golesLocal, golesVisitante);
    }
    
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
