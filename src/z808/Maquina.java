
package z808;

/**
 *
 * @author João Pedro Bretanha
 */
public class Maquina {
    
    public static void main(String[] args){
        Z808 proc = new Z808();
        Frame fr = new Frame(proc);
        fr.setVisible(true);
    }
    
}
