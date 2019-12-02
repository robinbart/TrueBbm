public class Plateau {

    private Case[][] tab;
    private int taille;

    public Plateau(int taille) {
        this.taille = taille;
        tab = new Case[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
            	int rand = (Math.random() * 10);
                if (rand % 10 > 4) {
                    tab[i][j] = new Case(Contenu.Vide);
                } else {
                	if(rand > 2) {
                		tab[i][j] = new Case(Contenu.Mur);
                	}else {
                		tab[i][j] = new Case(Contenu.Mur_Cassable);
                	}
                }
            }
        }
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

    public void deplacement(Perso p, int x, int y, int i, int j) { //plus du genre a se tp
        if (i < taille && j < taille && i >= 0 && j >= 0) {
            if (tab[x][y].getC() == Contenu.Perso) {
                if (tab[i][j].getC() == Contenu.Vide) {
                    System.out.println("4");
                    tab[x][y].setC(Contenu.Vide);
                    tab[i][j].setC(Contenu.Perso);
                    p.setXY(i, j);
                }
            }
        }
    }

    public void explosion(int portee, int x, int y) {
        tab[x][y].deflag();
        for (int j = 1; j < portee; j++) {
            if (tab[x][Math.min(y + j, taille - 1)].getC() == Contenu.Vide || tab[x][Math.min(y + j, taille - 1)].getC() == Contenu.Perso) {
                tab[x][Math.min(y + j, taille - 1)].setExplo();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[x][Math.max(y - j, 0)].getC() == Contenu.Vide || tab[x][Math.max(y - j, 0)].getC() == Contenu.Perso) {
                tab[x][Math.max(y - j, 0)].setExplo();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[Math.min(x + j, taille - 1)][y].getC() == Contenu.Vide || tab[Math.min(x + j, taille - 1)][y].getC() == Contenu.Perso) {
                tab[Math.min(x + j, taille - 1)][y].setExplo();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[Math.max(x - j, 0)][j].getC() == Contenu.Vide || tab[Math.max(x - j, 0)][y].getC() == Contenu.Perso) {
                tab[Math.max(x - j, 0)][j].setExplo();
            } else {
                break;
            }
        }
    }

    public void finexplo(int portee, int x, int y) {
        for (int j = 1; j < portee; j++) {
            if (tab[x][Math.min(y + j, taille - 1)].getC() == Contenu.Vide || tab[x][Math.min(y + j, taille - 1)].getC() == Contenu.Perso) {
                tab[x][Math.min(y + j, taille - 1)].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[x][Math.max(y - j, 0)].getC() == Contenu.Vide || tab[x][Math.max(y - j, 0)].getC() == Contenu.Perso) {
                tab[x][Math.max(y - j, 0)].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[Math.min(x + j, taille - 1)][y].getC() == Contenu.Vide || tab[Math.min(x + j, taille - 1)][y].getC() == Contenu.Perso) {
                tab[Math.max(x + j, taille - 1)][y].finBoom();
            } else {
                break;
            }
        }
        for (int j = 1; j < portee; j++) {
            if (tab[Math.max(x - j, 0)][j].getC() == Contenu.Vide || tab[Math.max(x - j, 0)][y].getC() == Contenu.Perso) {
                tab[Math.max(x - j, 0)][j].finBoom();
            } else {
                break;
            }
        }
        tab[x][y].finBoom();
    }
}
