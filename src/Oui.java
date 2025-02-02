 import javax.swing.*;
import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
 import java.util.ArrayList;

 public class Oui extends JFrame implements Runnable {

    private Panneau p;
    private Plateau pl;
    private ArrayList<Perso> ap;
    private Controler c;
    private CardLayout cl;
    private JPanel jp;
    private Menu m;
    private MenuPrincipal mp;
    private PanneauEditeur edit;
    private ControlerEditeur ce = null;
    
    
    public Oui(Plateau pl, ArrayList<Perso> ap) {
        this.ap = ap;
        this.pl = pl;
        
        c = new Controler(ap,this);
        p = new Panneau(pl);
        m = new Menu(this);
        mp = new MenuPrincipal(this);
        edit = new PanneauEditeur(pl.getSize(), this);

		
        this.setTitle("BomBerMan");
        /*Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight()-40;
        int width = (int)dimension.getWidth();
        this.setSize(width, height);*/
        
        this.setBackground(Color.black);
        this.setLocation(150, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1015, 700));
        this.setVisible(true);
        this.addKeyListener(c);
        this.setResizable(false);

        
        this.cl = new CardLayout();
        this.jp = new JPanel(cl);
        
        this.setContentPane(jp);
        jp.add(edit,"editeur de niveau");
        jp.add(mp,"menuprincipal");
        jp.add(p,"jeu");
        jp.add(m, "menu");
        cl.show(jp,"menuprincipal");
    }

    public void setP(ArrayList<Perso> ap, Plateau pl){
    	this.ap = ap;
    	this.pl=pl;
        pl.setArrayList(ap);
        this.p.setPlateau(pl);
        c = new Controler(ap,this);
        this.addKeyListener(c);
    	cl.show(jp,"jeu");
    }
    
    public void afficherJeu() {
    	this.setSize(new Dimension(1000,1026));
    	this.setFocusable(true);
    	cl.show(jp,"jeu");
	}

	public void restartJeu(){
        c.restart();
    }
	
	public void afficherMenu() { 
    	cl.show(jp,"menu");
	}
	
	public void afficherEditeurNiveau() {
        if(ce == null) {
            ce = new ControlerEditeur(edit);
            this.addMouseListener(ce);
        }
    	this.setSize(new Dimension(1000,1026));
		cl.show(jp,"editeur de niveau");
	}

	public void enregistrerMap(){
        //TODO: enregistrer comme dans zboob.txt
        cl.show(jp, "enregistrer map");
    }

    public void run() {
        try {
            while (true) {
            	////System.out.println("affichage");
                Thread.sleep(20);
                p.repaint();
            }
        }catch (InterruptedException e){
            System.err.println("Fin de la partie");
        }
        finally {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }

	public void afficherMenuPrincipale() {

        this.setBackground(Color.black);
        this.setSize(new Dimension(1015, 700));
		cl.show(jp,"menuprincipal");
	}

	
}