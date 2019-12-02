public class Case {

	private Contenu c;
	private boolean amorce;
	private boolean explo;

	public Case(Contenu c) {
		amorce = false;
		this.c = c;
	}

	public void amorcage() {
		amorce = true;
	}

	public void deflag() {
		amorce = false;
		explo = true;
	}

	public void finBoom() {
		/*c=Contenu.Vide;*/
		explo = false;
	}

	public Contenu getC() {
		return c;
	}

	public void setC(Contenu cont) {
		c = cont;
	}

	public void setExplo() {
		explo = true;
	}

	public boolean isAmorce() {
		return amorce;
	}

	public boolean isExplo() {
		return explo;
	}
}
