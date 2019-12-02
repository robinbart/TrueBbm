public class Case {

    private Contenu c;
    private boolean amorce;
    private boolean explo;
    private int explosimultane;

    public Case(Contenu c) {
        this.c = c;
        amorce = false;
        explo = false;
        explosimultane=0;
    }
    
    public void casse() {
    	c=Contenu.Vide;
    }

    public void amorcage() {
        amorce = true;
    }

    public synchronized void deflag() {
        amorce = false;
        explo = true;
        explosimultane++;
    }

    public synchronized void finBoom() {
    	explosimultane--;
        System.out.println(explosimultane);
    	if(explosimultane==0) {
    		explo = false;
    	}
    }

    public Contenu getC() {
        return c;
    }

    public void setC(Contenu cont) {
        c = cont;
    }

    public synchronized void setExplo() {
        explo = true;
        explosimultane++;
    }

    public boolean isAmorce() {
        return amorce;
    }

    public boolean isExplo() {
        return explo;
    }
}
