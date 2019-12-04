import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Controler implements KeyListener {

    private ArrayList<Perso> p;

    public Controler(ArrayList<Perso> p) {
        this.p = p;
    } 

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e){
        System.out.println("" + e.getKeyCode());
        int kc = e.getKeyCode();
        if (kc == 37 || kc == 38 || kc == 39 || kc == 40 || kc == 65 || kc == 18 ||kc == 27 || kc == 90) {
            p.get(0).changerE(kc);
        }
        if(kc == 100 || kc == 101 || kc == 102 || kc == 103 || kc == 104){
            p.get(1).changerE(kc - 63);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
