import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Oui extends JFrame implements Runnable{
	
		private Panneau p;
		private Plateau pl;
		private Perso p1;
		private Controler c;
		
		 public Oui(Plateau pl, Perso p1) {
			 c = new Controler(p1);
			 this.p1=p1;
			 this.pl=pl;
			 p = new Panneau(pl);
			 this.setTitle("BomBerMan");
			 this.setSize(1000,1000);
			 this.setLocation(0,0);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 this.setContentPane(p);
			 this.setVisible(true);
			 this.addKeyListener(c);
		 }
		 
		 

		 
		 public void run() {
			 int i=0;
			 int j=0;
			 while(true) {
				 try {
					 Thread.sleep(100);
				 }catch(InterruptedException e) {
					 System.out.print("pb avec le sleep");
				 }
				 //p.adaptation(i,j);
				 p.repaint();
				 i+=100;
			 }
		 }
}

