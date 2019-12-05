import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private JButton b;
	
	public Menu(Oui fen) {
		b = new JButton(new ActionButton(fen,"jouer"));
		this.add(b);
	}
	
}
