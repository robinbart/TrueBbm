 public class Bombe implements Runnable {

    private int portee;
    private Plateau p;
    private int x, y; //coordonnees de la bombe

    public Bombe(int portee, Plateau p, int x, int y) {
        this.p = p;
        this.portee = portee;
        this.x = x;
        this.y = y;
    }

    public void run() {
        try {
            p.getTab(x, y).amorcage();
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println("Je continue");
            }
            p.explosion(portee, x, y);
			System.out.println("J'EXPLOSE EN COURS");
            Thread.sleep(1000);
            p.finexplo(portee, x, y);
        } catch (InterruptedException e) {
            System.out.println("Sleep bombe bugue");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
