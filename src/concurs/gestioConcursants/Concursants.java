package concurs.gestioConcursants;

import concurs.interficie.SortidaPantalla;

/**
 *
 * @author Llorenç Garcia Martinez
 */
public class Concursants {
    private Concursant[] llistaConcursants;
    private int[][] indexs;  // 0 -> Cognoms, 1 -> Punts
    int lengthLlistaConcursants=0;


    /** Inicialitza la llista de concursants
    *
    * @param numConcursants número màxim de concursants.
    */
    public Concursants(int numConcursants) {
        this.llistaConcursants = new Concursant[numConcursants];
        this.indexs = new int[2][numConcursants];
    }

    /** Afegeix un nou concursant a la llista de concursants.
    *
    * @param dadesNouConcursant dades del nou concursant
    * @return true si s'ha realitzat, false si la llista ja està plena.
    */
    public Boolean afegir(Concursant dadesNouConcursant){
       
        if(lengthLlistaConcursants < llistaConcursants.length){
            this.llistaConcursants[lengthLlistaConcursants] = dadesNouConcursant;

            afegeixAIndex(0,2,0,lengthLlistaConcursants); //Afegir i Ordenar a index cognoms
            afegeixAIndex(1,0,1,lengthLlistaConcursants); //Afegir i Ordenar a index punts
            lengthLlistaConcursants++;
            return true;
        }else{
            return false;
        }

    }
    
    /** Afegeix un nou concursant a la llista de concursants.
    *
    * @param dadesNouConcursant dades del nou concursant
    */
    private void afegeixAIndex(int llistaAOrdenar, int campAOrdenar, int ordre, int posIndexAInserir) {
        indexs[ordre][posIndexAInserir]=posIndexAInserir;
        ordenarIndex(llistaAOrdenar, campAOrdenar, ordre, posIndexAInserir);
    }
    
    /** Ordena l'index.
    *
    * @param dadesNouConcursant dades del nou concursant
    */
    private void ordenarIndex(int llistaAOrdenar, int campAOrdenar, int ordre, int posIndexAOrdenar){
        boolean ordenat=false;
        //baixar
        for( int posIndex=posIndexAOrdenar; posIndex>0 && !ordenat; posIndex--){
            int posDades1 = indexs[ordre][posIndex-1];
            int posDades2 = indexs[ordre][posIndex];

            if (llistaAOrdenar == 0){ //Ordenar per cognom
                String [] dadesAComparar = {llistaConcursants[posDades1].dades[campAOrdenar], llistaConcursants[posDades2].dades[campAOrdenar]};
                ordenat = comparar(dadesAComparar);
            }else if (llistaAOrdenar == 1){ //Ordenar per puntuacio
                Integer [] dadesAComparar = {llistaConcursants[posDades1].puntuacio, llistaConcursants[posDades2].puntuacio};
                ordenat = comparar(dadesAComparar);
            }

            if(!ordenat){
                int aux = indexs[ordre][posIndex-1];
                indexs[ordre][posIndex-1] = indexs[ordre][posIndex];
                indexs[ordre][posIndex] = aux;
            }
        }

        //pujar
        ordenat = false;
        for( int posIndex=posIndexAOrdenar; posIndex<(lengthLlistaConcursants-1) && !ordenat; posIndex++){
            int posDades1 = indexs[ordre][posIndex];
            int posDades2 = indexs[ordre][posIndex+1];

            if (llistaAOrdenar == 0){ //Ordenar per cognom
                String [] dadesAComparar = {llistaConcursants[posDades1].dades[campAOrdenar], llistaConcursants[posDades2].dades[campAOrdenar]};
                ordenat = comparar(dadesAComparar);
            }else if (llistaAOrdenar == 1){ //Ordenar per puntuacio
                Integer [] dadesAComparar = {llistaConcursants[posDades1].puntuacio, llistaConcursants[posDades2].puntuacio};
                ordenat = comparar(dadesAComparar);
            }

            if(!ordenat){
                int aux = indexs[ordre][posIndex+1];
                indexs[ordre][posIndex+1] = indexs[ordre][posIndex];
                indexs[ordre][posIndex] = aux;
            }
        }
    }
    
    /** Compara cognom o puntuació.
    *
    * @param valors dades a comparar
    */
    private boolean comparar(Object[] valors){
        if (valors[0] instanceof String) {
            String valorDades1 = (String) valors[0];
            String valorDades2 = (String) valors[1];
            return valorDades1.compareTo(valorDades2)<=0;
        }else if(valors[0] instanceof Integer) {
            int valorDades1 = (Integer) valors[0];
            int valorDades2 = (Integer) valors[1];
            return (valorDades1 >= valorDades2);
        }else{
            return false;
        }
    }
    
    /** Llistar
    *
    * @param dadesAMostrar array que indica quines dades s'han de mostrar (true, false,...)
    * @param ordre indica l'index que s'ha d'utilitzar.
    * @param formatDades array amb el format de les dades per a 
    * @param sortida 
    */
    public void llistar(boolean[] dadesAMostrar, int ordre, String[][] formatDades, SortidaPantalla sortida){
        sortida.mostrarCapcaleraLlista(dadesAMostrar, formatDades);
        
        int[] indexAMostrar = indexs[ordre];
        
        for (int i=0; i < lengthLlistaConcursants; i++){
            sortida.mostrarConcursant(llistaConcursants[indexAMostrar[i]], dadesAMostrar, formatDades);
        }
    }
    
    /** Modifica dades del concursant indicat
    *
    * @param posicio id de l'usuari a modificar
    * @param dada 1=nom, 2=cognoms, 3=telefon
    * @param nouValor nou valor per al concursant
    * @return 0=OK, -1=no modificat
    */
    public int modificarConcursant(int posicio, int dada, String nouValor){
        int resultat;

        if(llistaConcursants[posicio].dades[dada].equals(nouValor)){
            resultat = -1;
        }else{
            llistaConcursants[posicio].dades[dada]=nouValor;
            resultat = 0;
              
            if(dada == 2){
                ordenarIndex(0,2,0,posicio); //Ordenar a index cognoms
            }
        }
        return resultat;
    }
    
    public int modificarPuntuacio(int posicio, int nouValor){
        llistaConcursants[posicio].puntuacio += nouValor;
        ordenarIndex(1,0,1,posicio); //Ordenar index puntuació
        return llistaConcursants[posicio].puntuacio;
    }
    
    /** Cerca concursant per DNI.
    *
    * @param dni dni del concursant a cercar
    * @return array amb la posició als diferents indexs.
    */
    public int[] cercaConcursant(String dni){
        int [] posicio={-2, -2, -2};
        for (int i=0; i < lengthLlistaConcursants && posicio[0]==-2; i++){
            if(llistaConcursants[i].dades[0].equals(dni)){
                posicio[0] = i;
            }
        }
        
        if(posicio[0] != -2){
            //Cercar posició a l'index de cognoms
            for (int i=0; i < lengthLlistaConcursants && posicio[1]==-2; i++){
                if(posicio[0] == indexs[0][i]){
                    posicio[1] = i;
                }
            }
            
            //Cercar posició a l'index de punts
            for (int i=0; i < lengthLlistaConcursants && posicio[2]==-2; i++){
                if(posicio[0] == indexs[1][i]){
                    posicio[2] = i;
                }
            }
        }
        return posicio;
    }
    
    /** Veure dades concursant
    *
    * @param posicio id de l'usuari.
    * @return concursant
    */
    public Concursant dadesConcursant(int posicio){
        
        return llistaConcursants[posicio];
    }
    
    /** Veure numero concursant
    *
    * @return concursant
    */
    public int length(){
        return lengthLlistaConcursants;
    }
    
}