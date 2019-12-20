
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Plateau extends Object{

    private Case[][] tab;
    private int taille;
    private ArrayList<Perso> p;
    private ArrayList<Thread>th = new ArrayList<>();
    private ArrayList<Bombe> bombes = new ArrayList<>();

    public Plateau(int taille) {
        this.taille = taille;
        tab = new Case[taille][taille];
        /*BufferedReader Buff=null;
        try{
        	Buff = new BufferedReader(new FileReader("zboob.txt"));
	    }
	    catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
        String ligne;
        try {
			while ((ligne = Buff.readLine()) != null) {
				char c;
				while ((c = inputStream.read()) != -1) {
	                outputStream.write(c);
	            }
			    System.out.println(ligne);
			}
		} catch (IOException e) {
			System.out.println("raf est une tantouze");
		}
        try {
			Buff.close();
		} catch (IOException e) {

			System.out.println("Aurelien aussi d'ailleurs");
		}*/
        FileReader inputStream = null;
        int i=0 , j=0;
        try {
            inputStream = new FileReader("zboob.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
	            if(c==48) {
	            	tab[i][j] = new Case(Contenu.Vide);
	            }else{
	            	if(c==50) {
	            		tab[i][j] = new Case(Contenu.Mur_Cassable);
	            	}else{
	            		if(c==49) {
	            			tab[i][j] = new Case(Contenu.Mur);
	            		}else{
	            			if(c==32) {
	            				j++;
	            			}else{
	            				if(c==13) {
	            					i++;
	            					j=0;
	            				}
			            	}
		            	}
		            }
	            }
            }
        }catch(IOException e) {}
        finally {
            if (inputStream != null) {
                try {
					inputStream.close();
				} catch (IOException e) {}
            }
        }
        
        /*for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	int rand = (int)(Math.random() * 10);
                if (rand > 2) {
                    tab[i][j] = new Case(Contenu.Vide);
                } else {
                	if(rand > 1) {
                		tab[i][j] = new Case(Contenu.Mur);
                	}else {
                		tab[i][j] = new Case(Contenu.Mur_Cassable);
                	}
                }
            }
        }*/
    }
    
    public void setArrayList(ArrayList<Perso> a) {
    	this.p = a;
    }
   
    
    public int retournnumberperso(int x , int y) {
    	for (int j = 0; j < p.size(); j++) {
    		if(p.get(j).getX()==x && p.get(j).getY()==y) {
    			return j;
    		}
    	}
    	return 0;
    }
    
    public boolean isPersoHurt(int i) {
    	return p.get(i).getImmune();
    }
    
    public Perso getPerso(int i) {
    	return p.get(i);
    }
    
    public ArrayList<Perso> getFullPerso() {
    	return p;
    }
    
    public void addPerso(ArrayList<Perso> p){
        this.p = p;
    }

    public Case getTab(int x, int y) {
        return tab[x][y];
    }

    public Case[][] getTab() {
        return tab;
    }

    public int getSize() {
        return taille;
    }

    public void spawn(int x, int y) {
        tab[x][y].setC(Contenu.Perso);
    }
    
    public Perso findPerso(int x, int y) {
    	for(int i=0; i<p.size(); i++) {
    		if(p.get(i).getX()==x && p.get(i).getY()==y) {
    			return p.get(i);
    		}
    	}
    	return null;
	}
    
    public void deplacement(Perso p, int x, int y, int i, int j) { //plus du genre a se tp
        if (i < taille && j < taille && i >= 0 && j >= 0) {
            if (tab[x][y].getC() == Contenu.Perso) {
                if (tab[i][j].getC() == Contenu.Vide) {
                    System.out.println("4");
                    tab[x][y].setC(Contenu.Vide);
                    tab[i][j].setC(Contenu.Perso);
                    if(tab[i][j].isBonus()) {
                    	switch(tab[i][j].getBonus()) {
                    	case 1:
                    		findPerso(i,j).powerUpPortee();
                    		break;
                    	case 2:
                    		findPerso(i,j).powerUpLife();
                    		break;
                    	case 3:
                    		findPerso(i,j).powerDownPortee();
                    		break;
                    	case 4:
                    		findPerso(i,j).powerDownLife();
                    	}
                    }
                    p.setXY(i, j);
                }
            }
        }
    }

    public void setBombe(Thread thread, Bombe bombe){
        th.add(thread);
        bombes.add(bombe);
    }

    public void explosion(int portee, int x, int y) {
        tab[x][y].deflag();
        if (tab[x][y].getC() == Contenu.Perso) {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).getX() == x && p.get(i).getY() == y) {
                    p.get(i).perdVie();
                }
            }
        }
        System.out.println("x : " + x + " et y : " + y);
        System.out.println("Perso 1 a " + p.get(0).getVie());
        for (int j = 1; j < portee; j++) { //vers le bas
            if (y + j < taille && (tab[x][y + j].getC() == Contenu.Vide
                    || tab[x][y + j].getC() == Contenu.Perso)) {
                if (tab[x][y + j].getC() == Contenu.Perso) {
                    for (int i = 0; i < p.size(); i++) {
                        if (p.get(i).getX() == x && p.get(i).getY() == y + j) {
                            p.get(i).perdVie();
                        }
                    }
                }
                    if (tab[x][y + j].isAmorce()) {
                        for (int i = 0; i < bombes.size(); i++) {
                            if (bombes.get(i).getX() == x && bombes.get(i).getY() == y + j) {
                                th.get(i).interrupt();
                                th.remove(i);
                                bombes.remove(i);
                                System.out.println("Je fais exploser la bombe " + i + " plus tot");
                            }
                        }
                    }
                    tab[x][y + j].setExplo();
                    //System.out.println(" la case en x : "+x+" et y : "+Math.min(y + j, taille - 1)+" a explos�");
                } else {
                    //System.out.println(" l'explo a rencontre un mur en x : "+x+" et y : "+Math.min(y + j, taille - 1));
                    if (y + j < taille && (tab[x][y + j].getC() == Contenu.Mur_Cassable)) {
                        tab[x][y + j].casse();
                    }
                    break;
                }
            }
            for (int j = 1; j < portee; j++) { //vers le haut
                if (y - j >= 0 && (tab[x][y - j].getC() == Contenu.Vide || tab[x][y - j].getC() == Contenu.Perso)) {
                    if (tab[x][y - j].getC() == Contenu.Perso) {
                        for (int i = 0; i < p.size(); i++) {
                            if (p.get(i).getX() == x && p.get(i).getY() == y - j) {
                                p.get(i).perdVie();
                                System.out.println("je perd un point " + p.get(i).getVie() + " en haut");
                            }
                        }
                    }
                    if (tab[x][y - j].isAmorce()) {
                        for (int i = 0; i < bombes.size(); i++) {
                            if (bombes.get(i).getX() == x && bombes.get(i).getY() == y - j) {
                                th.get(i).interrupt();
                                th.remove(i);
                                bombes.remove(i);
                                System.out.println("Je fais exploser la bombe " + i + " plus tot");
                            }
                        }
                    }
                    tab[x][y - j].setExplo();
                    //System.out.println(" la case en x : "+x+" et y : "+Math.max(y - j, 0)+" a explos�");
                } else {
                    //System.out.println(" l'explo a rencontre un mur en x : "+x+" et y : "+Math.min(y + j, taille - 1));
                    if (y - j >= 0 && (tab[x][y - j].getC() == Contenu.Mur_Cassable)) {
                        tab[x][y - j].casse();
                    }
                    break;
                }
            }
            for (int j = 1; j < portee; j++) { //vers la doite
                if (x + j < taille && (tab[x + j][y].getC() == Contenu.Vide
                        || tab[Math.min(x + j, taille - 1)][y].getC() == Contenu.Perso)) {
                    if (tab[x + j][y].getC() == Contenu.Perso) {
                        for (int i = 0; i < p.size(); i++) {
                            if (p.get(i).getX() == x + j && p.get(i).getY() == y) {
                                p.get(i).perdVie();
                                System.out.println("je perd un point " + p.get(i).getVie() + " a droite");
                            }
                        }
                    }
                    if (tab[x + j][y].isAmorce()) {
                        for (int i = 0; i < bombes.size(); i++) {
                            if (bombes.get(i).getX() == x + j && bombes.get(i).getY() == y) {
                                th.get(i).interrupt();
                                th.remove(i);
                                bombes.remove(i);
                                System.out.println("Je fais exploser la bombe " + i + " plus tot");
                            }
                        }
                    }
                    tab[x + j][y].setExplo();
                    //System.out.println(" la case en x : "+Math.min(x + j, taille - 1)+" et y : "+y+" a explos�");
                } else {
                    System.out.println(" l'explo a rencontre un mur en x : " + Math.max(x + j, 0) + " et y : " + y);
                    if (x + j < taille && (tab[x + j][y].getC() == Contenu.Mur_Cassable)) {
                        tab[x + j][y].casse();
                    }
                    break;
                }
            }
            for (int j = 1; j < portee; j++) { //vers la gauche
                if (x - j >= 0 && (tab[x - j][y].getC() == Contenu.Vide
                        || tab[Math.max(x - j, 0)][y].getC() == Contenu.Perso)) {
                    if (tab[x - j][y].getC() == Contenu.Perso) {
                        for (int i = 0; i < p.size(); i++) {
                            if (p.get(i).getX() == x - j && p.get(i).getY() == y) {
                                p.get(i).perdVie();
                                System.out.println("je perd un point " + p.get(i).getVie() + " a gauche");
                            }
                        }
                    }
                    if (tab[x - j][y].isAmorce()) {
                        for (int i = 0; i < bombes.size(); i++) {
                            if (bombes.get(i).getX() == x - j && bombes.get(i).getY() == y) {
                                th.get(i).interrupt();
                                th.remove(i);
                                bombes.remove(i);
                                System.out.println("Je fais exploser la bombe " + i + " plus tot");
                            }
                        }
                    }
                    tab[x - j][y].setExplo();
                    //System.out.println(" la case en x : "+Math.min(x + j, taille - 1)+" et y : "+y+" a explos�");
                } else {
                    //System.out.println(" l'explo a rencontre un mur en x : "+Math.max(x - j, 0)+" et y : "+y);
                    if (x - j >= 0 && (tab[x - j][y].getC() == Contenu.Mur_Cassable)) {
                        tab[x - j][y].casse();
                    }
                    break;
                }
            }

        }

    public void finexplo(int portee, int x, int y) {
        for (int j = 1; j < portee; j++) {
            if (y+j < taille && (tab[x][y + j].getC() == Contenu.Vide || tab[x][y + j].getC() == Contenu.Perso)) {
                tab[x][y + j].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (y-j >= 0 && (tab[x][y - j].getC() == Contenu.Vide || tab[x][y - j].getC() == Contenu.Perso)) {
                tab[x][y - j].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (x+j < taille && (tab[x + j][y].getC() == Contenu.Vide || tab[x + j][y].getC() == Contenu.Perso)) {
                tab[x + j][y].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (x-j >= 0 && (tab[x - j][y].getC() == Contenu.Vide || tab[x - j][y].getC() == Contenu.Perso)) {
                tab[x - j][y].finBoom();
            } else {
                break;
            }
        }
        tab[x][y].finBoom();
    }
}
