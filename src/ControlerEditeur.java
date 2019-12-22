
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ControlerEditeur implements MouseListener {
	
	private PanneauEditeur edit;
	
	public ControlerEditeur(PanneauEditeur edit) {
		this.edit=edit;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		////System.out.println("cliqué en : "+event.getX()/100+" , "+event.getX()/100);
		edit.setXY(event.getX()/100,(event.getY()-27)/100);
		
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		////System.out.println("entré en : "+event.getX()+" , "+event.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		////System.out.println("sortie en : "+event.getX()+" , "+event.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	

}
