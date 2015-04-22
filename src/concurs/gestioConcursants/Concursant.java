package concurs.gestioConcursants;

/**
 *
* @author Llorenç Garcia Martinez, Jose Isern Barceló, Silvia Toro García
 */
public class Concursant {
    public String[] dades;
    public int puntuacio;
    
    public Concursant(){
        this.dades = new String[4];
        this.puntuacio = 0;
    }
    
    /*
    public void set(Concursant novesDades){
        //Stop aqui
        System.arraycopy(novesDades.dades, 0, dades, 0, novesDades.dades.length);
        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        puntuacio = novesDades.puntuacio;
    }
    */
}
