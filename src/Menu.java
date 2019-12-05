import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private JButton b;
	
	public Menu(Oui fen) {
		b = new JButton("jouer");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				fen.afficherJeu();
			}
		});
		this.add(b);
	}
}
