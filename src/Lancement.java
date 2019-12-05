import java.util.ArrayList;

public class Lancement {
    public static void main(String[] args) throws InterruptedException {
		boolean created = true;
        Oui fen = null;
        int NB_PERSO = 2;
        
        while (true){

            Plateau pl = new Plateau(10);
        	ArrayList<Perso> persos = new ArrayList<>();
        	ArrayList<Thread> th = new ArrayList<>();
            
            if(!created){
            	for (int i = 0; i < NB_PERSO; i++){
                    switch (i){
                        case 0:
                            persos.add(new Perso(pl, 9, 9));
                            break;
                        case 1:
                            persos.add(new Perso(pl, 0, 0));
                            break;
                        case 2:
                            persos.add(new Perso(pl, 0, 9));
                            break;
                        case 3:
                            persos.add(new Perso(pl, 9, 0));
                            break;
                    }
                }
            	for(int i = 0; i < NB_PERSO; i++) {
                    th.add(new Thread(persos.get(i)));
                    th.get(i).start();
            	}
            	pl.addPerso(persos);
                fen.setP(persos, pl);
                
            }else{
            	
                for (int i = 0; i < NB_PERSO; i++){
                    switch (i){
                        case 0:
                            persos.add(new Perso(pl, 9, 9));
                            break;
                        case 1:
                            persos.add(new Perso(pl, 0, 0));
                            break;
                        case 2:
                            persos.add(new Perso(pl, 0, 9));
                            break;
                        case 3:
                            persos.add(new Perso(pl, 9, 0));
                            break;
                    }
                }
                
                for(int i = 0; i < NB_PERSO; i++) {
                    th.add(new Thread(persos.get(i)));
                    th.get(i).start();
                    System.out.println("demarrage"+i);
            	}
                pl.addPerso(persos);
                fen = new Oui(pl, persos);
                Thread t3 = new Thread(fen);
                t3.start();
                System.out.println("thread oui lancé");
                
                created = false;
            }
            th.get(0).join();
        }
    }
}



