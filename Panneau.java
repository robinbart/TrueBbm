import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	
	private int x=0;
	private int y=0;
	public Image img;
	private Plateau pl;

	public Panneau(Plateau pl) {
		super();
		this.pl=pl;
		try {
			Image img = ImageIO.read(new File("testsprite1.png"));
			this.img=img;
		} catch(IOException e){
			System.out.print("probleme d'ouverture");
		}
	}
	
	public void adaptation(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public void paintComponent(Graphics g) {
		
		
		
		for(int i = 0; i < pl.getSize();i++) {
			for(int j = 0; j < pl.getSize() ; j++) {
				if(pl.getTab(i,j).getC()==Contenu.Vide) {
					g.setColor(Color.green);
					g.fillRect(i*100, j*100, 100, 100);
				}else {
					if(pl.getTab(i,j).getC()==Contenu.Mur) {
						g.setColor(Color.black);
						g.fillRect(i*100, j*100, 100, 100);
					}else {
						if(pl.getTab(i,j).getC()==Contenu.Perso) {
							g.drawImage(img, i*100, j*100,(i+1)*100 , (j+1)*100, 196, 0, 222, 34,Color.green,  this);
						}
					}
				}
			}
		}
		
		//g.drawImage(img, x, y, x+75, y+93, 197, 1, 219, 32,Color.green,  this);
		
		/*
		System.out.print("probleme d'ouverture");
		Color c;
		int k=0;
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if((j+k)%2==0) {
					c=Color.black;
				}else {
					c=Color.red;
				}
				g.setColor(c);
				g.fillRect(i*100,j*100,100,100);
			}
			k++;
		}
		*/
	}
}
