package concurs.gestioConcurs;

import concurs.gestioConcursants.Concursant;
import concurs.gestioConcursants.Concursants;
import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;

/**
 *
 * @author Llorenç Garcia Martinez
 */
public class Concurs {
    public int ronda=0;
    public int puntuacioTall=0;
    
    /** Puntua a cada concursant
    *
    * @param entrada
    * @param sortida
    * @param llistaConcursants
    */
    public void puntuar(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants) {
        int puntuacioRonda;
        //mostrar concursant
        sortida.mostrarCapcaleraLlista(new boolean[] {false, true, true, false, false}, sortida.formatDades);
        
        for (int i=0; i < llistaConcursants.length(); i++){
            if(llistaConcursants.dadesConcursant(i).puntuacio >= puntuacioTall){ //S'ha classificat a l'última ronda
                sortida.mostrarConcursant(llistaConcursants.dadesConcursant(i), new boolean[] {false, true, true, false, false}, sortida.formatDades);
                //demanar i verificar puntuació 
                puntuacioRonda = entrada.solicitarPuntuacio();
                //sumar puntuació
                llistaConcursants.modificarPuntuacio(i, puntuacioRonda);
            }
        }
    
        
    }
    
    /** Puntua a cada concursant
    *
    * @param entrada
    * @param sortida
    * @param llistaConcursants
    */
    public void llistarQualificacions(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants) {
        sortida.mostrarCapcaleraLlista(new boolean[] {true, true, true, true, true}, sortida.formatDades);
        for (int i=0; i < llistaConcursants.length(); i++){
            if(llistaConcursants.dadesConcursant(i).puntuacio >= puntuacioTall){ //S'ha classificat a l'última ronda
                sortida.mostrarConcursant(llistaConcursants.dadesConcursant(i), new boolean[] {true, true, true, true, true}, sortida.formatDades);
            }
        }
    }
}
