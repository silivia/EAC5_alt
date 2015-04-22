package concurs.gestioConcurs;

import concurs.gestioConcursants.Concursants;
import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;

/**
 *
 * @author Llorenç Garcia Martinez, Jose Isern Barceló, Silvia Toro García
 */
public class MenuGestioConcurs {
     /**
     * Punt d'entrada al gestor d'inscripcions
     *
     * @param entrada referència a la variable general d'entrada de dades
     * @param sortida referència a la variable general de sortida de dades
     * @param llistaConcursants referència a la variable que conté la llista de concursants
     * @param dadesConcurs referència a la variable que conté els mètodes de gestió del concurs
     */
    public void menu(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants, Concurs dadesConcurs){
        final String[] OPCIONS_MENU ={"Gestió Qualificacions","Puntuar ronda actual","Llistar qualificacions ronda","Finalitzar ronda",
                                      "Llistar qualificacions pel twitter","Tornar"};
        int opcio;
        
        
        do{
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);

            switch(opcio){
                case 1:
                    //puntuar concursants ronda actual
                    dadesConcurs.puntuar(entrada, sortida, llistaConcursants);
                    break;
                case 2:
                    //llistar qualificacions ronda
                    dadesConcurs.llistarQualificacions(entrada, sortida, llistaConcursants);
                    //Concurs.Dades.Qualificacions.llistarQualificacionsRonda();
                    //dadesConcurs.llistar(new boolean[] {false, true, true, false, false}, 0, sortida.formatDadesTwitter, sortida); 
                    
                    break;
                case 3:
                    //finalitzar ronda
                    dadesConcurs.finalitzarRonda(entrada, sortida, llistaConcursants);
                    break;
                case 4:
                    //Llistar classificats/eliminats twitter
                    menuLlistatQualificacionsTwitter(entrada, sortida, llistaConcursants, dadesConcurs);
                    //dadesConcurs.llistarQualificacionsTwitter(entrada, sortida, llistaConcursants);
                    break;					
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length-1) );
    }
    
    /**
     * Menú per a mostrar els concursants eliminats i classificats l'última ronda.
     *
     * @param entrada referència a la variable general d'entrada de dades
     * @param sortida referència a la variable general de sortida de dades
     * @param llistaConcursants referència a la variable que conté la llista de concursants
     */
    private void menuLlistatQualificacionsTwitter(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants, Concurs dadesConcurs){
        final String[] OPCIONS_MENU ={"Llistes Twitter de l'última ronda:","Classificats","Eliminats","Tornar"};
        int opcio;
        
        do{
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);
            
            switch(opcio){
                case 1:
                    System.out.println("Concursants que s'han classificat:");
                    dadesConcurs.llistarQualificacionsTwitter(0, entrada, sortida, llistaConcursants);
                    //llistaConcursants.llistar(new boolean[] {false, true, true, false, false}, 1, sortida.formatDades, sortida);
                    break;
                case 2:
                    System.out.println("Concursants que han estat eliminats:");
                    dadesConcurs.llistarQualificacionsTwitter(1, entrada, sortida, llistaConcursants);
                    //llistaConcursants.llistar(new boolean[] {false, true, true, false, false}, 1, sortida.formatDadesTwitter, sortida);
                    break;
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length-1) );
        
    }
}