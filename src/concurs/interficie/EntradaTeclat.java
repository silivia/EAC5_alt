package concurs.interficie;

/**
 *
 * @author Llorenç Garcia Martinez
 */

import concurs.gestioConcursants.Concursant;
import java.util.Scanner;

public class EntradaTeclat {
    String newLine = System.getProperty("line.separator");
    
    /** Verifica que s'introdueix una opció vàlida al menú i retorna el valor.
    *
    * @param rang número d'opcions que conté el menú.
    */
    public int opcioMenu(int rang) {
        Scanner lector = new Scanner(System.in);
        int resposta;
        
        do{
            do{
                System.out.print(newLine + "Tria una opció [1-"+(rang-1)+"]: ");
            }while(!verificaNextInt(lector));
            resposta = lector.nextInt();
        }while(0 >= resposta || resposta >= rang);

        return resposta;
    }
    
    /** Verifica que s'hagi introduït un número sencer al teclat
    *
    * @param lector interfíciie d'entrada de dades System.in
    */
    private static boolean verificaNextInt(Scanner lector) {
        boolean resultat;
        
        resultat = lector.hasNextInt();
        
        if(!resultat){
            lector.nextLine();
        }
        
        return resultat;
    }
    
    /** Solicita les dades per a un nou concursant
    *
    * @return llista de dades
    */
    public Concursant solicitarDadesConcursant(){
        Scanner lector = new Scanner(System.in);
        String resposta;
        Concursant nouConcursant = new Concursant();
        
        System.out.println(newLine + "Indica les dades per al nou concursant:");

        nouConcursant.dades[0] = solicitarDNI();
        nouConcursant.dades[1] = solicitarNom();
        nouConcursant.dades[2] = solicitarCognoms();
        nouConcursant.dades[3] = solicitarTelefon();
        
        return nouConcursant;
        
    }
    
    /** Verifica que es tracta d'un DNI correcte.
    *
    * @param dni DNI a verificar
    */
    private boolean verificaDNI(String dni){
        final char[] lletresDNI ={'T','R','W','A','G','M','Y','F','P','D','X','B',
                                              'N','J','Z','S','Q','V','H','L','C','K','E'};
        final int divisorDNI = 23;
        
        //Verificar format (8 números + 1 lletra)
        if ( dni.matches("^[0-9]{8}\\D$") ) {
            //Verificar lletra: numero % 23 = número lletra
            int numero = Integer.parseInt(dni.substring(0,8));
            char lletra = Character.toUpperCase(dni.charAt(8));
            
            return (lletra == lletresDNI[numero%divisorDNI]);
        }else{
            return false;
        }
    }
    
    /** Verifica que es tracta d'un número de telèfon correcte.
    *
    * @param telefon número de telèfon a verificar
    */
    private Boolean verificaTelefon(String telefon){
        // 9 digits que poden estar separats per guió (-), punt (.) o espai ( );
        telefon = telefon.replace("-","");
        telefon = telefon.replace(".","");
        telefon = telefon.replace(" ","");

        return telefon.matches("^[0-9]{9}$");
    }
    
    /** Missatge de confirmació
    *
    * @return S = true, N = false
    */
    public Boolean confirmar(){
        Scanner lector = new Scanner(System.in);
        String resposta;

        do{
            System.out.print("És correcte? [S/N]: ");
            resposta = lector.nextLine();
        }while(!resposta.equalsIgnoreCase( "S" ) && !resposta.equalsIgnoreCase("N"));

        return resposta.equalsIgnoreCase( "S" );
    }
    
    /** Solicitar DNI del concursant.
    *
    * @return dni del concursant a modificar
    */
    public String solicitarDNI(){
        Scanner lector = new Scanner(System.in);
        String dni;
        boolean correcte;

        do{
            System.out.print("DNI: ");
            dni = lector.nextLine();
            correcte = verificaDNI(dni);
            if(!correcte){
                System.out.println("Dada incorrecte");
            }
        }while(!correcte);

        return dni;
    }
    
    /** Solicitar nom del concursant.
    *
    * @return nom del concursant.
    */
    public String solicitarNom(){
        Scanner lector = new Scanner(System.in);
        String nom;
        do{
            System.out.print("Nom: ");
            nom = lector.nextLine();
        }while(nom.equals(""));

        return nom;
    }
    
 
    /** Solicitar cognoms del concursant.
    *
    * @return cognoms del concursant.
    */
    public String solicitarCognoms(){
        Scanner lector = new Scanner(System.in);
        String cognoms;
        do{
            System.out.print("Cognoms: ");
            cognoms = lector.nextLine();
        }while(cognoms.equals(""));

        return cognoms;
    }
    
    /** Solicitar telefon del concursant.
    *
    * @return telefon del concursant.
    */
    public String solicitarTelefon(){
        Scanner lector = new Scanner(System.in);
        String telefon;
        do{
            System.out.print("Telèfon: ");
            telefon = lector.nextLine();
        }while(telefon.equals(""));

        return telefon;
    }
    
    /** Solicitar puntuació del concursant en ronda n.
    *
    * @return punts assignats
    */
    public int solicitarPuntuacio() {
        Scanner lector = new Scanner(System.in);
        int resposta;
        
        do{
            do{
                System.out.print(newLine + "Puntuació [0-3]: ");
            }while(!verificaNextInt(lector));
            resposta = lector.nextInt();
        }while(0 > resposta || resposta > 3);

        return resposta;
    }
 
}
