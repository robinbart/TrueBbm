public class Case {
	
private Contenu c;
private boolean amorce;

public Case(Contenu c) {
	amorce=false;
	this.c=c;
}

public void amorcage() {
	amorce=true;
}

public void deflagration(int portee) {
	c=Contenu.Explo;
	amorce=false;
}

public void finBoom() {
	c=Contenu.Vide;
}

public void fire() {
	
}

public Contenu getC() {
	return c;
}
public void setC(Contenu cont) {
	c=cont;
}
}
