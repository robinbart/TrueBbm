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
    private int clignotement[];
    private int vie;
    private int fullPerso;

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
        fullPerso = pl.getFullPerso().size();
        clignotement = new int[fullPerso];
        for(int i = 0;i<fullPerso;i++) {
        	clignotement[i]=0;
        }
        try {
            this.img1 = ImageIO.read(new File("testsprite1.png"));
            this.img2 = ImageIO.read(new File("testsprite2.png"));
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void setPlateau(Plateau pl) {
    	this.pl = pl;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < pl.getSize(); i++) {
            for (int j = 0; j < pl.getSize(); j++) {
                if (pl.getTab(i, j).getC() == Contenu.Vide) {
                    if (pl.getTab(i, j).isExplo()) {
                        g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0, 202, 100,
                                302, Color.red, this);
                    } else {
                        g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0+(tabcase[i][j]*101), 0, 100+(tabcase[i][j]*101),
                                100, Color.red, this);
                    }
                   
                } else {
                    if (pl.getTab(i, j).getC() == Contenu.Mur) {
                        /*g.setColor(Color.black);
                        g.fillRect(i * 100, j * 100, 100, 100);*/
                        g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100,101, 202, 201,
                                302, this);
                    } else {
                    	if (pl.getTab(i, j).getC() == Contenu.Mur_Cassable) {
                            /*g.setColor(Color.DARK_GRAY);
                            g.fillRect(i * 100, j * 100, 100, 100);*/
                    		g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 202, 202, 302,
                                    302, this);
                    	}else {
                            if (pl.getTab(i, j).isExplo()) {
                                 g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0, 202, 100,
                                         302, Color.red, this);
                            } else {
                                g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 0+(tabcase[i][j]*101), 0, 100+(tabcase[i][j]*101),
                                        100, Color.red, this);
                            }
                            if(clignotement[pl.retournnumberperso(i,j)]%2==0) {
                            	g.drawImage(img1, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100, 196, 0, 222,
                                    34, this);
                            }
                        }
                    }
                }
                if (pl.getTab(i, j).isAmorce()) {
                    /*g.setColor(Color.black);
                    g.fillOval(i * 100 + 25, j * 100 + 25, 50, 50);*/
                    g.drawImage(img2, i * 100, j * 100, (i + 1) * 100, (j + 1) * 100,0, 101, 100,
                            201, this);
                }
                
            }
        }
        for(int i = 0; i<fullPerso ; i++) {
        	if(pl.isPersoHurt(i)) {
                clignotement[i]++;
            }else {
            	clignotement[i]=0;
            }
        }
        for(int j = 0;j<fullPerso;j++) {
	    	vie = pl.getPerso(j).getVie();
	    	for(int i = 0; i <3 ; i++) {
	    		if(i<vie) {
	    			g.drawImage(img2, i * 40+j*200, 0, ((i + 1) * 40)+j*200,40, 384, 101, 464,
	                        180, this);
	    		}else {
	    			g.drawImage(img2, i * 40+j*200, 0, ((i + 1) * 40)+j*200,40, 303, 101, 383,
	                        180, this);
	    		}
	    	}
        }
    }
}
