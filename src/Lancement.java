import java.util.ArrayList;

public class Lancement {
    public static void main(String[] args) throws InterruptedException {
		/*Perso p1 = new Perso();
		Thread t = new Thread(p1);
		System.out.println("oui");
		t.start();*/
		boolean created = true;
        Oui fen = null;
        int NB_PERSO = 3;
        while (true){
            Plateau p = new Plateau(10);
            Perso p1 = new Perso(p, 0, 0);
            ArrayList<Perso> persos = new ArrayList<>();
            for (int i = 0; i < NB_PERSO; i++){
                switch (i){
                    case 0:
                        persos.add(new Perso(p, 0, 0));
                        break;
                    case 1:
                        persos.add(new Perso(p, 9, 9));
                        break;
                    case 2:
                        persos.add(new Perso(p, 0, 9));
                        break;
                    case 3:
                        persos.add(new Perso(p, 9, 0));
                        break;
                }
            }
            if(!created){
                fen.setP(p, persos);
            }
            p.addPerso(persos);
            //Perso p2 = new Perso(p, 9, 9);
            Thread t1 = new Thread(p1);
            t1.start();
            //Thread t2 = new Thread(p2);
            //t2.start();

            if(created) {
                fen = new Oui(p, persos);
                Thread t3 = new Thread(fen);
                t3.start();
                created = false;
            }
            t1.join();
        }
    }
}
