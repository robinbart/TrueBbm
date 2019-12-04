import java.util.ArrayList;

public class Lancement {
    public static void main(String[] args) throws InterruptedException {
		boolean created = true;
        Oui fen = null;
        int NB_PERSO = 2;
        while (true){
            Plateau p = new Plateau(10);
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
            p.addPerso(persos);
            ArrayList<Thread> th = new ArrayList<>();
            for(int i = 0; i < NB_PERSO; i++) {
                th.add(new Thread(persos.get(i)));
                th.get(i).start();
            }
            if(!created){
                fen.setP(p, persos);
            }
           

            if(created) {
                fen = new Oui(p, persos);
                Thread t3 = new Thread(fen);
                t3.start();
                created = false;
            }
            
            th.get(0).join();
        }
    }
}
