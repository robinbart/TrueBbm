import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Perso implements Runnable{
	
private static int compteur=0;
private int id;
private static Object m = new Object();
private int beffect;
private Plateau p;
private int x, y;
private int portee;
private int e;
private boolean boule;

public Perso(Plateau p, int x,int y) {
	synchronized(m) {
		id=compteur++;
	}
	this.p=p;
	boule=false;
	p.spawn(x,y); 
	
}  

public void changerE(int KeyCode) {
	this.e=KeyCode;
	boule=true;
	System.out.print("test1");
}

public void run() {
	while(true) {

		System.out.print(" "+e);
		/*if() {
			Bombe b = new Bombe();
			Thread t = new Thread(b);
			
		}*/
		if(e==65 && boule==true) {
			Bombe b = new Bombe(portee,p,x,y);
			Thread t = new Thread(b);
			t.start();
			try{
				Thread.sleep(500);
			}catch(InterruptedException a) {
				
			}finally {
				boule=false;
			}
		}
		if(this.e==39 /*&& boule==true*/) {
			System.out.print("test2");
			if(y<p.getSize() && p.getTab(x,y).getC()==Contenu.Vide) {
				p.deplacement(x, y, x, y+1);
				try{
					Thread.sleep(10);
				}catch(InterruptedException a) {
					
				}finally {
					boule=false;
				}
			}
		}
		if(e==40 && boule==true) { //vers le bas
			if(x>0 && p.getTab(x,y).getC()==Contenu.Vide) {
				p.deplacement(x, y, x-1, y);
				try{
					Thread.sleep(10);
				}catch(InterruptedException b) {
				}finally {
					boule=false;
				}
			}
		}
		if(e==38 && boule==true) { //vers le haut
			if(x<p.getSize() && p.getTab(x,y).getC()==Contenu.Vide) {
				p.deplacement(x, y, x+1, y);
				boule=false;
				try{
					p.deplacement(x, y, x+1, y);
					Thread.sleep(10);
				}catch(InterruptedException c) {
					
				}finally {
					boule=false;
				}
			}
		}
		if(e==37 && boule==true) {
			if(y>0 && p.getTab(x,y).getC()==Contenu.Vide) {
				p.deplacement(x, y, x, y-1);
				try{
					Thread.sleep(10);
				}catch(InterruptedException d) {
					
				}finally {
					boule=false;
				}
			}
		}
	}
}
}
