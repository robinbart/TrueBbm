import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel{
	private JButton play;
	private JButton restart;
	
	public Menu(Oui fen) {
		this.setBackground(Color.black);
		play = new JButton(new ActionButton(fen,"play"));
		restart = new JButton(new ActionButton(fen, "restart"));
		this.add(play);
		this.add(restart);
		this.setSize(100, 100);
	}
	
}
