import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel {

    private Image img1;
    private Image img2;
    private Plateau pl;
    private int caseherbe;
    private int tabcase[][];

    Panneau(Plateau pl) {
        super();
        int taille =pl.getSize();
        tabcase =new int[taille][taille];
        for(int i = 0; i < taille; i++ ) {
        	for(int j = 0; j < taille; j++) {
        		tabcase[i][j] = (int)(Math.random()*7);
        	}
        }
        this.pl = pl;
        try {
            this.img1 = ImageIO.read(new File("testsprite1.png"));
            this.img2 = ImageIO.read(new File("testsprite2.png"));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < pl.getSize(); i++) {
            for (int j = 0; j < pl.getSize(); j++) {
                if (pl.getTab(i, j).getC() == Contenu.Vide) {
                    if (pl.getTab(i, j).isExplo()) {
                        g.setColor(Color.red);
                        g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0, 202, 100,
                                302, Color.red, this);
                    } else {
                        g.setColor(Color.green);
                        g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0+(tabcase[i][j]*101), 0, 100+(tabcase[i][j]*101),
                                100, Color.red, this);
                    }
                   
                } else {
                    if (pl.getTab(i, j).getC() == Contenu.Mur) {
                        g.setColor(Color.black);
                        g.fillRect(i * 100, j * 100, 100, 100);
                    } else {
                    	if (pl.getTab(i, j).getC() == Contenu.Mur_Cassable) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(i * 100, j * 100, 100, 100);
                    	}else {
                            if (pl.getTab(i, j).isExplo()) {
                                g.drawImage(img1, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 196, 0, 222,
                                        34, this);
                            } else {
                                g.drawImage(img1, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 196, 0, 222,
                                        34, this);
                            }
                        }
                    }
                }
                if (pl.getTab(i, j).isAmorce()) {
                    g.setColor(Color.black);
                    g.fillOval(i * 100 + 25, j * 100 + 25, 50, 50);
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
