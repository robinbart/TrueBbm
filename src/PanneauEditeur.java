import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauEditeur extends JPanel{
    private Image img1;
    private Image img2;
    //private Plateau pl;
    private int tabcase[][];
    private int taille;
    private int tabrand[][];
    private JButton menuprincipale;
    
    public PanneauEditeur(int taille, Oui fen) {
    	this.taille=taille;
		menuprincipale = new JButton(new ActionButton(fen,"affichermenu"));
		this.add(menuprincipale);
    	tabrand =new int[taille][taille];
        for(int i = 0; i < taille; i++ ) {
        	for(int j = 0; j < taille; j++) {
        		tabrand[i][j] = (int)(Math.random()*7);
        	}
        }
    	try {
            this.img1 = ImageIO.read(new File("testsprite1.png"));
            this.img2 = ImageIO.read(new File("testsprite2.png"));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    	tabcase = new int[10][10];
    	for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	tabcase[i][j]=0;
            	
            }
    	}
    }
    
    public void setXY(int i, int j) {
    	tabcase[i][j]=++tabcase[i][j]%3;
    	this.repaint();
    }
    
    public void paintComponent(Graphics g) {
    	for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	switch(tabcase[i][j]) {
	            	case 0:
	            		g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0+(tabrand[i][j]*101), 0, 100+(tabrand[i][j]*101),
                                100, Color.red, this);
	            		break;
	            	case 1:
	            		g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100,101, 202, 201,
                                302, this);
	            		break;
	            	case 2:
	            		g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 202, 202, 302,
                                302, this);
            	}
            }
    	}
    }
}
