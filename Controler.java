import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controler implements KeyListener{
	
	private Perso p;
	
	public Controler(Perso p) {
		this.p=p;
	}
	
	public void keyTyped(KeyEvent e) {	}
	
	 public void keyPressed(KeyEvent e) {
	 	System.out.print(""+e.getKeyCode());
	 	int kc= e.getKeyCode();
	 	if(kc==37 || kc==38 || kc==39 || kc==40) {
	 		p.changerE(kc);	
	 	}
	 }

	 public void keyReleased(KeyEvent e) {	 }

}
