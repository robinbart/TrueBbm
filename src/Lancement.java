public class Lancement {
    public static void main(String[] args) throws InterruptedException {
		/*Perso p1 = new Perso();
		Thread t = new Thread(p1);
		System.out.println("oui");
		t.start();*/
        while (true){
            Plateau p = new Plateau(10);
            Perso p1 = new Perso(p, 0, 0);
            p.addPerso(p1);
            //Perso p2 = new Perso(p, 9, 9);
            Thread t1 = new Thread(p1);
            t1.start();
            //Thread t2 = new Thread(p2);
            //t2.start();

            Oui fen = new Oui(p, p1);
            Thread t3 = new Thread(fen);
            t3.start();
            t1.join();
        }

    }
}
