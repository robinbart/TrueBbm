
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
	
	public void deplacement(int x,int y, int i, int j) { //plus du genre a se tp
		if(tab[x][y].getC() == Contenu.Perso) {
			if(tab[i][j].getC()== Contenu.Vide) {
				Case transi = tab[x][y];
				tab[x][y]=tab[i][j];
				tab[i][j]=transi;
			}
		}
	}
	 public void explosion(int portee, int x, int y) {
		 for(int i=0;i<4;i++) {
			 for(int j=0;j<portee;j++) {
				 if(tab[i][j].getC()==Contenu.Vide || tab[i][j].getC()==Contenu.Perso)
					 tab[i][j].setC(Contenu.Explo);
			 }
		 }
	 }
	 
	 public void finexplo(int portee, int x, int y) {
		 for(int i=0; i<4; i++) {
			 for(int j=0;j<portee;j++) {
				 if(tab[i][j].getC()==Contenu.Vide || tab[i][j].getC()==Contenu.Perso)
					 tab[i][j].setC(Contenu.Explo);
			 }
		 }
	 }
}
