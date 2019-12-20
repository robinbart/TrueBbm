import java.util.Random;

public class Case {

    private Contenu c;
    private boolean amorce;
    private boolean explo;
    private int explosimultane;
    //update bonus_malus
    private int bonus=0; //0->aucun bonus
    private Random rand;

    public Case(Contenu c) {
        this.c = c;
        amorce = false;
        explo = false;
        explosimultane=0;
    }
    
    public void casse() {
    	c=Contenu.Vide;
    	
    	//ajout du bonus sur la case
    	int i=rand.nextInt(25);
    	if(i<5) {
    		bonus=i;
    	}
    }
    
    public void bonusRecup() {
    	bonus=0;
    }
    
    public int getBonus() {
    	return bonus;
    }
    
    public boolean isBonus() {
    	if(bonus==0) {
    		return false;
    	}else {
    		return true;
    	}
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
    	if(explosimultane != 0){
    	    explosimultane--;
        }
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
