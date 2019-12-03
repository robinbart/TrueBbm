 import static java.lang.Thread.sleep;

public class Attente implements Runnable{
    private int temps;
    private Perso p;

    public Attente(int temps, Perso p){
        this.temps = temps;
        this.p = p;
    }
    public void run() {
        try {
            sleep(temps);
            p.setImmune();
        }
        catch (InterruptedException e){
            System.err.println("Erreur in attente");
        }
    }
}
