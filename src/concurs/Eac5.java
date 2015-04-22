package concurs;

//import concurs.Parametres;
import concurs.gestioConcurs.Concurs;
import concurs.interficie.EntradaTeclat;
import concurs.interficie.SortidaPantalla;
import concurs.gestioConcursants.Concursants;
import concurs.gestioConcursants.MenuGestioConcursants;
import concurs.gestioConcurs.MenuGestioConcurs;

//import ioc.eines.Scanner; //necessari per a setTestOn i setTestOff;

/**
 *
 * @author Llorenç Garcia Martinez
 */
public class Eac5 {
    public static final int MAX_CONCURSANTS = 15;
    
    private EntradaTeclat entrada = new EntradaTeclat();
    private SortidaPantalla sortida = new SortidaPantalla();
    
    private MenuGestioConcursants inscripcions = new MenuGestioConcursants();
    private Concursants llistaConcursants = new Concursants(MAX_CONCURSANTS);
    private MenuGestioConcurs qualificacions = new MenuGestioConcurs();
    private Concurs dadesConcurs = new Concurs();
    
    /**
     * Punt d'entrada a l'aplicació. Aquí s'inicia el procés.
     * No està previst de rebre cap paràmetre del SO.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Eac5 programa = new Eac5();

        /*
         * Exemple d'ús de la classe Scanner de ioc.eines per automatitzar el
         * tecleig de dades. Descomenteu la sentencia per activar-lo
         */
        //Scanner.setTestOn("1\n1\n3\n0\n\n0\n1\n0\n2\n0\n3\n0\n0\ns\n");
        //Scanner.setTestOn("1\n1\n46609807P\nLlorenç\nGarcia Martinez\n696330795\n");
        
        programa.inici();
         /* 
         * Exemple d'ús de la classe Scanner de ioc.eines per finalitzar el
         * tecleig automatitzat de dades. Descomenteu la sentencia per activar-lo
         */ 
        //Scanner.setTestOff();
    }
    
    /**
     * Sequència inicial del procés
     */
    public void inici(){
        String[] OPCIONS_MENU ={"Concurs","Gestió Inscripcions","Gestió Qualificacions","Sortir"};
	int opcio;
        
        do{
            sortida.menu(OPCIONS_MENU);
            opcio = entrada.opcioMenu(OPCIONS_MENU.length);
        
            switch(opcio){
                case 1:
                    inscripcions.menu(entrada, sortida, llistaConcursants);
                    break;
                case 2:
                    qualificacions.menu(entrada, sortida, llistaConcursants, dadesConcurs);
                    break;
                default:
                    break;
            }
        }while(opcio != (OPCIONS_MENU.length -1) );
    }
}
