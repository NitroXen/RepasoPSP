/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        int NUM_PARTIDOS = 5;
        int NUM_VOTANTES = 300;
        String[] nombrePartidos = {"PP","PSOE","Podemos","Ciudadanos","VOX"};
        
        Partido[] partidos = new Partido[NUM_PARTIDOS];
        
        for(int i = 0; i<partidos.length;i++){
            partidos[i] = new Partido(nombrePartidos[i]);
        }
        
        Votante[] voto = new Votante[NUM_VOTANTES];
        
        for(int i =0 ; i<voto.length;i++){
            voto[i] = new Votante(partidos);
            voto[i].start();
        }
        
        for(Votante v:voto){
            try{v.join();}catch(InterruptedException ex){}
        }
        
        Partido ganador = null;
        int totalVotos = 0, maxVotos= -1;
        boolean empate = false;
        for(Partido p : partidos){
            int numVotos = p.totalVotos();
            if(numVotos == maxVotos){
                empate = true;
            }else{
                if(numVotos > maxVotos){
                    empate = false;
                    ganador = p;
                    maxVotos = numVotos;
                }
            }
            totalVotos += numVotos;
            System.out.println(p.getNombre()+">>"+p.totalVotos());
        }
        System.out.println("Total Votos: "+totalVotos);
        System.out.println(empate?"EMPATE = RECUENTO":"GANADOR = "+ ganador.getNombre());
        
    }
}
