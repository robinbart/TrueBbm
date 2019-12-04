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
        //Perso numero 1
        if (kc == 37 || kc == 38 || kc == 39 || kc == 40 || kc == 17 || kc == 18 ||kc == 27 || kc == 32) {
            p.get(0).changerE(kc);
        }
        //Perso numero 2
        if(kc == 68){
            p.get(1).changerE(39);
        }
        if(kc == 83){
            p.get(1).changerE(40);
        }
        if(kc == 81){
            p.get(1).changerE(37);
        }
        if(kc == 90){
            p.get(1).changerE(38);
        }
        if(kc == 65){
            p.get(1).changerE(17);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
