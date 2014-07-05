/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.tampilan;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author compaq
 */
public class SIM_surat extends JFrame{

    public static void main(String[] args) {
 try {
            // TODO code application logic here
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    TampilanAwal fm = new TampilanAwal();
                    fm.setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SIM_surat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
    /*public static void main(String[] args) {
       new Login().setVisible(true); 
    }*/

