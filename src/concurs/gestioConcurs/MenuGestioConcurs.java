package concurs.gestioConcurs;

import concurs.gestioConcursants.Concursants;
import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;

/**
 *
 * @author Llorenç Garcia Martinez
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
        final String[] OPCIONS_MENU ={"Gestió Qualificacions","Iniciar concurs","Puntuar ronda actual","Llistar qualificacions ronda","Finalitzar ronda",
                                      "Llistar qualificacions pel twitter","Tornar"};
        int opcio;
        
        
        do{
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);

            switch(opcio){
                case 1:
                    //Publicar llista twitter
                    llistaConcursants.llistar(new boolean[] {false, true, true, false, false}, 0, sortida.formatDadesTwitter, sortida);
                    //dadesConcurs.llistar
                    break;
                case 2:
                    dadesConcurs.puntuar(entrada, sortida, llistaConcursants);
                    break;
                case 3:
                    //Concurs.Dades.Qualificacions.llistarQualificacionsRonda();
                    //dadesConcurs.llistar(new boolean[] {false, true, true, false, false}, 0, sortida.formatDadesTwitter, sortida); 
                    
                    break;
                case 4:
                    //Concurs.Dades.Qualificacions.finalitzarRonda();
                    break;
                case 5:
                    //Concurs.Dades.Qualificacions.llistarQualificacionsTwitter();
                    break;					
                case 6:
                    //Concurs.Principal.menu();
                    break;
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length-1) );
    }
}