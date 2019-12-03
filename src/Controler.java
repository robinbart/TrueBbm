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
        if (kc == 37 || kc == 38 || kc == 39 || kc == 40 || kc == 65 || kc == 18) {
            p.get(0).changerE(kc);
        }
        if(kc == 90){
            System.out.println("Axel is better than Barth in english !");
            p.get(0).changerE(kc);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
