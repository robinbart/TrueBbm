import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel{
	private JButton play;
	private JButton restart;
	private JButton exit;
	private JButton menuprincipale;
	
	public Menu(Oui fen) {
		this.setBackground(Color.black);
		play = new JButton(new ActionButton(fen,"play"));
		restart = new JButton(new ActionButton(fen, "restart"));
		exit = new JButton(new ActionButton(fen, "exit"));
		menuprincipale = new JButton(new ActionButton(fen,"menu principal"));
		play.setBackground(Color.orange);
		this.add(play);
		this.add(restart);
		this.add(exit);
		this.add(menuprincipale);
		this.setSize(100, 100);
	}
	
}
