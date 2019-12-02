import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import static java.lang.Thread.sleep;

public class Perso implements Runnable{

	private static int compteur=0;
	private int id;
	private final Object m = new Object();
	private int beffect;
	private Plateau p;
	private int x, y;
	private int portee;
	private int e = 0;

	public Perso(Plateau p, int x,int y) {
		synchronized(m) {
			id=compteur++;
		}
		this.p=p;
		p.spawn(x,y);
		this.x = x;
		this.y = y;
	}

	public void changerE(int KeyCode) {
		this.e=KeyCode;
		System.out.print("test "+ e);
		synchronized (m) {
			m.notifyAll();
		}
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void run() {
		while(true) {
		/*if() {
			Bombe b = new Bombe();
			Thread t = new Thread(b);
			
		}*/

			if (e == 65) {
				Bombe b = new Bombe(portee, p, x, y);
				Thread t = new Thread(b);
				t.start();
			}
			if (e == 40) {//vers le bas
				System.out.print("test2");
				System.out.println("0");
				p.deplacement(this, x, y, x, y + 1);
				try {
					synchronized (m) {
						m.wait();
					}
				} catch (InterruptedException ignored) {
				}
			}
			if(e==37) { //
				p.deplacement(this, x, y, x - 1, y);
			}
			if(e==39) { //vers la droite
				p.deplacement(this, x, y, x + 1, y);

			}
			if(e==38) {
				p.deplacement(this, x, y, x, y - 1);
			}
			try{
				synchronized (m){
					m.wait();
				}
			}catch(InterruptedException ignored) {}
			try {
				sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
