
public class Plateau {

	private Case[][] tab;
	private int taille;

	public Plateau(int taille) {
		this.taille=taille;
		tab = new Case[taille][taille];
		for(int i=0;i<taille;i++) {
			for(int j=0;j<taille;j++) {
				if((Math.random()*10)%10>2) {
					tab[i][j] = new Case(Contenu.Vide);
				}else {
					tab[i][j] = new Case(Contenu.Mur);
				}
			}
		}
	}



	public Case getTab(int x,int y) {
		return tab[x][y];
	}

	public Case[][] getTab(){
		return tab;
	}

	public int getSize() {
		return taille;
	}

	public  void spawn(int x, int y) {
		tab[x][y].setC(Contenu.Perso);
	}

	public void deplacement(Perso p, int x,int y, int i, int j) { //plus du genre a se tp
		if (i<taille && j<taille && i>=0 && j>=0) {
			if(tab[x][y].getC() == Contenu.Perso) {
				if(tab[i][j].getC()== Contenu.Vide) {

					System.out.println("4");
					tab[x][y].setC(Contenu.Vide);
					tab[i][j].setC(Contenu.Perso);
					p.setXY(i, j);
				}
			}
		}
	}
	public void explosion(int portee, int x, int y) {
		for(int j=1;j<portee;j++) {
			if(tab[x][y+j].getC()==Contenu.Vide || tab[x][y+j].getC()==Contenu.Perso) {
				tab[x][+j].setExplo();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x][y-j].getC()==Contenu.Vide || tab[x][y-j].getC()==Contenu.Perso) {
				tab[x][y-j].setExplo();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x+j][y].getC()==Contenu.Vide || tab[x+j][y].getC()==Contenu.Perso) {
				tab[x+j][y].setExplo();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x-j][j].getC()==Contenu.Vide || tab[x-j][y].getC()==Contenu.Perso) {
				tab[x-j][j].setExplo();
			}else {
				break;
			}
		}
	}

	public void finexplo(int portee, int x, int y) {
		for(int j=1;j<portee;j++) {
			if(tab[x][y+j].getC()==Contenu.Vide || tab[x][y+j].getC()==Contenu.Perso) {
				tab[x][+j].finBoom();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x][y-j].getC()==Contenu.Vide || tab[x][y-j].getC()==Contenu.Perso) {
				tab[x][y-j].finBoom();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x+j][y].getC()==Contenu.Vide || tab[x+j][y].getC()==Contenu.Perso) {
				tab[x+j][y].finBoom();
			}else {
				break;
			}
		}
		for(int j=1;j<portee;j++) {
			if(tab[x-j][j].getC()==Contenu.Vide || tab[x-j][y].getC()==Contenu.Perso) {
				tab[x-j][j].finBoom();
			}else {
				break;
			}
		}
	}
}
