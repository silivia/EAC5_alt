package concurs.gestioConcurs;

import concurs.gestioConcursants.Concursant;
import concurs.gestioConcursants.Concursants;
import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;

/**
 *
 * @author Llorenç Garcia Martinez, Jose Isern Barceló, Silvia Toro García
 */
public class Concurs {
    public int ronda=0;
    public int puntuacioTall=0;
    public int puntuacioTallAnterior=0;
    
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
    
    /** Finalitza la ronda.
    *
    * @param entrada
    * @param sortida
    * @param llistaConcursants
    */
    public void finalitzarRonda(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants) {
        puntuacioTallAnterior = puntuacioTall;
        //buscar puntuació màxima
        for (int i=0; i < llistaConcursants.length(); i++){
            if(llistaConcursants.dadesConcursant(i).puntuacio > puntuacioTall){
                puntuacioTall = llistaConcursants.dadesConcursant(i).puntuacio;
            }
        }
        System.out.println("S'ha procedit a classificar i eliminar els jugadors de la ronda actual per a la ronda següent.");
        ronda++;
    }
    
    /** Llistar classificats/eliminats twitter
    *
    * @param tipus 0=classificats, 1=eliminats
    * @param entrada
    * @param sortida
    * @param llistaConcursants
    */
    public void llistarQualificacionsTwitter(int tipus, EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants) {
        //puntuacioTallAnterior = puntuacioTall;
        sortida.mostrarCapcaleraLlista(new boolean[] {false, true, true, false, true}, sortida.formatDadesTwitter);
        int[] ordre = llistaConcursants.index(1);
        
        //mostrar classificats
        if( tipus == 0 ){
            for (int i=0; i < llistaConcursants.length(); i++){
                if(llistaConcursants.dadesConcursant(ordre[i]).puntuacio > puntuacioTall){
                    sortida.mostrarConcursant(llistaConcursants.dadesConcursant(ordre[i]), new boolean[] {false, true, true, false, true}, sortida.formatDadesTwitter);
                }
            }
        }else{
            //mostrar eliminats
            for (int i=0; i < llistaConcursants.length(); i++){
                if(llistaConcursants.dadesConcursant(ordre[i]).puntuacio < puntuacioTall && llistaConcursants.dadesConcursant(ordre[i]).puntuacio >= puntuacioTallAnterior){
                    sortida.mostrarConcursant(llistaConcursants.dadesConcursant(ordre[i]), new boolean[] {false, true, true, false, true}, sortida.formatDadesTwitter);
                }
            }
        }

    }
    
}
