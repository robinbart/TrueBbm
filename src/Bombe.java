
public class Bombe implements Runnable {
	
	private int portee;
	private Plateau p;
	private int x, y;
	
public Bombe(int portee, Plateau p, int x, int y) {
	this.p=p;
	this.portee=portee;
	this.x = x;
	this.y = y;
}

public void run() {
	try{
		p.getTab(x, y).amorcage();
		Thread.sleep(3000);
		p.explosion(portee,x,y);;
		Thread.sleep(1000);
		p.finexplo(portee,x,y);
	}catch(InterruptedException e) {
		System.out.println("Sleep bombe bugue");
	}
}
}