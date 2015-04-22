package concurs.interficie;

import concurs.gestioConcursants.Concursant;

/**
 *
 * @author Llorenç Garcia Martinez
 */
public class SortidaPantalla {
    String newLine = System.getProperty("line.separator");
    
    public final String[][] formatDades = { {"DNI", "%-9s", "%9s"}, 
                                         {"NOM", "%-15s", "%-15s"}, 
                                         {"COGNOMS", "%-25s", "%-25s"},
                                         {"TELEFON", "%-12s", "%12s"},
                                         {"PUNTS", "%-5s", "%5d"}};
    
    public final String[][] formatDadesTwitter = { {"DNI", "%-9s", "%9s"}, 
                                         {"NOM", "%-15s", "%-15s"}, 
                                         {"COGNOMS", "%-16s", "%-16s"},
                                         {"TELEFON", "%-12s", "%12s"},
                                         {"PUNTS", "%-5s", "%5d"}};
    
    /** Mostra menú d'opcions.
    *
    * @param opcions Llista d'opcions que contindrà el menú, el primer element és el títol del menú.
    */
    public void menu(String[] opcions){
        //private static final String[] OPCIONS_MENU ={"Concurs","Gestió Inscripcions","Gestió Qualificacions","Sortir"};
	//Concurs.Interficie.sortida.menu(OPCIONS_MENU);
        System.out.println(newLine + opcions[0].toUpperCase() + newLine);
        for(int i=1; i<opcions.length; i++){
            System.out.println(i + ".- " + opcions[i]);
        }
        
    }
    
    /** Mostra la capçalera del llistat
    *
    * @param dadesAMostrar array booleà que indica per a cada dada si s'ha de mostrar.
    * @param formatDades array que determina el format de cada dada.
    */
    public void mostrarCapcaleraLlista(boolean[] dadesAMostrar, String[][] formatDades){
        String resultat = newLine;
        
        for (int i=0; i < dadesAMostrar.length; i++){
            if(dadesAMostrar[i]){
                resultat += String.format(formatDades[i][1], formatDades[i][0]) + " ";
            }
        }
        System.out.println(resultat);
    }
    
    
    /** Mostra una línea del llistat amb les dades del concursant
    *
    * @param concursant dades del concursant a mostrar.
    * @param dadesAMostrar array booleà que indica per a cada dada si s'ha de mostrar.
    * @param formatDades array que determina el format de cada dada.
    */
    public void mostrarConcursant(Concursant concursant, boolean[] dadesAMostrar, String[][] formatDades){
        String resultat = "";
        String textCurt;
        for (int i=0; i < dadesAMostrar.length; i++){
            if(dadesAMostrar[i]){
                if(i<concursant.dades.length){
                    int max = Integer.parseInt(formatDades[i][2].replaceAll("\\D+",""));
                    String text = concursant.dades[i];
                    if(concursant.dades[i].length() > max){
                        text = concursant.dades[i].substring(0, max-4) + "...";
                    }
                    
                    resultat += String.format(formatDades[i][2], text) + " ";
                }else{
                    resultat += String.format(formatDades[i][2], concursant.puntuacio) + " ";
                }
            }
        }
        System.out.println(resultat);

    }
}
