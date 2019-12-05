import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Controler implements KeyListener {

    private ArrayList<Perso> p;
    private Oui fen;
    private boolean pause = false;

    public Controler(ArrayList<Perso> p, Oui fen) {
    	System.out.println("controller init");
        this.p = p;
        this.fen=fen;
        KeyEvent e;
        this.keyPressed(new KeyEvent(fen, 0, 0, 0, 0));
    } 

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e){
        System.out.println("zhhrhhert " + e.getKeyCode());
        int kc = e.getKeyCode();
        //Perso numero 1
        if (kc == 37 || kc == 38 || kc == 39 || kc == 40 || kc == 17 || kc == 18 || kc == 32) {
            p.get(0).changerE(kc);
        }else { //Perso numero 2
            if (kc == 68) {
                p.get(1).changerE(39);
            } else {
                if (kc == 83) {
                    p.get(1).changerE(40);
                } else {
                    if (kc == 81) {
                        p.get(1).changerE(37);
                    } else {
                        if (kc == 90) {
                            p.get(1).changerE(38);
                        } else {
                            if (kc == 65) {
                                p.get(1).changerE(17);
                            }
                        }
                    }
                }
            }
        }

    	System.out.println("appuyer sur une touche");
        if(kc == 27) {
        	System.out.println("appuyer sur echap");
        	if(!pause) {
            	System.out.println("j'affiche le menu");

        		fen.afficherMenu();
        		pause=true;
        	}else {
            	System.out.println("j'affiche le jeu");

        		fen.afficherJeu();
        		pause=false;
        	}
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
