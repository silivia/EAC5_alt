package concurs.gestioConcursants;

/**
 *
 * @author Llorenç Garcia Martinez
 */

import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;

public class MenuGestioConcursants {
     /**
     * Punt d'entrada al gestor d'inscripcions
     *
     * @param entrada referència a la variable general d'entrada de dades
     * @param sortida referència a la variable general de sortida de dades
     * @param llistaConcursants referència a la variable que conté la llista de concursants
     */
    public void menu(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants){
        final String[] OPCIONS_MENU ={"Gestió Inscripcions","Inscripció de concursants nous","Modificació de concursants","Llistat de concursants","Tornar"};
        int opcio;
        
        do{
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);


            switch(opcio){
                case 1:
                    //Afegir concursant
                    Concursant nouConcursant;
                    do{
                        nouConcursant = entrada.solicitarDadesConcursant();
                        System.out.println("Les dades enregistrades són:");
                        sortida.mostrarCapcaleraLlista(new boolean[] {true, true, true, true, false}, sortida.formatDades);
                        sortida.mostrarConcursant(nouConcursant, new boolean[] {true, true, true, true, false}, sortida.formatDades);
                    }while (!entrada.confirmar());
                    if(!llistaConcursants.afegir(nouConcursant)){
                        System.out.println("No es poden inscriure més concursants.");
                    }
                    break;
                case 2:
                    //Modificar concursant
                    menuModificarDades(entrada, sortida, llistaConcursants);
                    break;
                case 3:
                    System.out.println("Llistat de concursants inscrits:");
                    llistaConcursants.llistar(new boolean[] {true, true, true, true, false}, 0, sortida.formatDades, sortida);
                    break;
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length-1) );
    }
    
    private void menuModificarDades(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants){
        final String[] OPCIONS_MENU ={"Quina dada desitja modificar?","Nom","Cognoms","Telèfon","Cap"};
        int opcio;
        
        String dni;
        int[] posicioIndexs = {-3,-3,-3};
        
        System.out.println("Indica el DNI de l'usuari a modificar:");
        do{
            if(posicioIndexs[0]==-2){
                System.out.println("Concursant no trobat");
            }
            dni = entrada.solicitarDNI();
            posicioIndexs = llistaConcursants.cercaConcursant(dni);
        }while(posicioIndexs[0] == -2);
        
        do{
            String novaDada;
            
            System.out.println("Dades actuals:");
            sortida.mostrarCapcaleraLlista(new boolean[] {true, true, true, true, false}, sortida.formatDades);
            sortida.mostrarConcursant(llistaConcursants.dadesConcursant(posicioIndexs[0]), new boolean[] {true, true, true, true, false}, sortida.formatDades);
        
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);
            
            System.out.println("Introdueixi la nova dada:");

            switch(opcio){
                case 1:
                    //Modificar nom
                    novaDada = entrada.solicitarNom();
                    llistaConcursants.modificarConcursant(posicioIndexs[0], opcio, novaDada);
                    break;
                case 2:
                    novaDada = entrada.solicitarCognoms();
                    llistaConcursants.modificarConcursant(posicioIndexs[0], opcio, novaDada);
                    break;
                case 3:
                    novaDada = entrada.solicitarTelefon();
                    llistaConcursants.modificarConcursant(posicioIndexs[0], opcio, novaDada);
                    break;
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length-1) );
    }
    
    private void menuLlistatConcursants(EntradaTeclat entrada, SortidaPantalla sortida, Concursants llistaConcursants){
        final String[] OPCIONS_MENU ={"Llistes disponibles:","Localització","Twitter","Cap"};
    }
}

