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
        int NUM_VOTANTES = 200;
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
        int totalVotos = 0, maxVotos = -1;
        boolean empate = false;
        Partido[] duo = new Partido[2];
        for(Partido p : partidos){
            int numVotos = p.totalVotos();
            if(numVotos == maxVotos){
                empate = true;
                duo[1]=p;
            }else{
                if(numVotos > maxVotos){
                empate = false;
                ganador = p;
                maxVotos = numVotos;
                duo[0]= p;
                }
            }
            totalVotos += numVotos;
            System.out.println(p.getNombre()+">>"+numVotos);
        }
        System.out.println("Num de votantes:"+ totalVotos);
        System.out.println(empate?"EMPATE ENTRE "+duo[0].getNombre()+" Y "+duo[1].getNombre()+" => RECUENTO":"GANADOR => "+ganador.getNombre());
        
    }
}
