import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MenuPrincipal extends JPanel{
	private JButton play;
	private JButton exit;
	private JButton edit;
	private Image img1;
	
	public MenuPrincipal(Oui fen) {

        try {
			this.img1 = ImageIO.read(new File("bomberlogo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBackground(Color.black);
		play = new JButton(new ActionButton(fen,"play"));
		edit = new JButton(new ActionButton(fen,"editeur de niveau"));
		exit = new JButton(new ActionButton(fen, "exit"));
		play.setBackground(Color.orange);
		this.add(play);
		this.add(edit);
		this.add(exit);
		this.setSize(100, 100);
	}
	
	public void paintComponent(Graphics g) {
        g.drawImage(img1, -50, -125, 980, 475, 0, 0, 1000, 600, this);
	}
	
}
