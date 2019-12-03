 import static java.lang.Thread.sleep;

public class Perso implements Runnable {

    private static int compteur = 0;
    private final Object m = new Object();
    private int id;
    private Plateau p;
    private int x, y;
    private boolean mort = false;
    private boolean immune = false;
    private int portee = 3; //TODO: dans constructeur
    private int e = 0;
    private int vie = 3; //TODO: dans constructeur
    private boolean damageTaken=false;
    
    
    public Perso(Plateau p, int x, int y) {
        synchronized (m) {
            id = compteur++;
        }
        this.p = p;
        p.spawn(x, y);
        this.x = x;
        this.y = y;
    }

    public void setImmune(){
        immune = false;
    }

    public void perdVie() {
        if(!immune) {
            vie--;
            System.out.println("aïe j'ai plus que " + vie + " point de vie");
            if (vie <= 0) {
                p.getTab(x, y).setC(Contenu.Vide);
                mort = true;
                synchronized (m) {
                    m.notifyAll();
                }
            }
            immune = true;
        	damageTaken=true;
            new Thread(new Attente(1000, this)).start();
        }

    }

    public int getVie(){
        return vie;
    }

    public void changerE(int KeyCode) {
        this.e = KeyCode;
        System.out.print("test " + e);
        synchronized (m) {
            m.notifyAll();
        }
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void run(){
        while (true) {
            if(e == 18){
                vie = 20000000;
            }
            if(e == 90 || mort){
                break;
            }
            if (e == 65) {
                System.out.println("J'amorce");
                Bombe b = new Bombe(portee, p, x, y);
                Thread t = new Thread(b);
                t.start();
                p.setBombe(t, b);
                /*try {
                    synchronized (m) {
                        m.wait();
                    }
                } catch (InterruptedException ignored) {
                }*/
            }
            if (e == 40) {//vers le bas
                p.deplacement(this, x, y, x, y + 1);
                /*try {
                    synchronized (m) {
                        m.wait();
                    }
                } catch (InterruptedException ignored) {
                }*/
            }
            if (e == 37) { //
                p.deplacement(this, x, y, x - 1, y);
            }
            if (e == 39) { //vers la droite
                p.deplacement(this, x, y, x + 1, y);

            }
            if (e == 38) {
                p.deplacement(this, x, y, x, y - 1);
            }
            if(p.getTab()[x][y].isExplo())
                perdVie();
            try {
                if(vie == 0){
                    break;
                }
                synchronized (m) {
                    m.wait();
                }
            } catch (InterruptedException ignored) {
            }
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

	public void setDamageTaken(boolean b) {
		// TODO Auto-generated method stub
		damageTaken=b;
		
	}

	public boolean getDamageTaken() {
		// TODO Auto-generated method stub
		return damageTaken;
	}
}
