import javax.swing.*;
import java.awt.event.WindowEvent;

public class Oui extends JFrame implements Runnable {

    private Panneau p;
    private Plateau pl;
    private Perso p1;
    private Controler c;

    public Oui(Plateau pl, Perso p1) {
        c = new Controler(p1);
        this.p1 = p1;
        this.pl = pl;
        p = new Panneau(pl);
        this.setTitle("BomBerMan");
        this.setSize(1016, 1039);
        this.setLocation(500, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.setVisible(true);
        this.addKeyListener(c);
        /*
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width = (int)dimension.getWidth();*/
    }

    public void setP(Plateau pl, Perso p1){
        c = new Controler(p1);
        this.p1 = p1;
        this.pl = pl;
        p = new Panneau(pl);
        this.setTitle("BomBerMan");
        this.setSize(1016, 1039);
        this.setLocation(500, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.setVisible(true);
        this.addKeyListener(c);
    }


    public void run() {
        try {
            while (true) {
                Thread.sleep(50);
                p.repaint();
            }
        }catch (InterruptedException e){
            System.err.println("Fin de la partie");
        }
        finally {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}

