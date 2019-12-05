import java.awt.event.ActionEvent;

import javax.swing.*;

public class ActionButton extends AbstractAction {
		private Oui fenetre;
		private String text;
	 
		public ActionButton(Oui fenetre, String texte){
			super(texte);
			this.fenetre = fenetre;
			this.text = texte;
		}
	 
		public void actionPerformed(ActionEvent event){
			if(text == "play") {
				fenetre.afficherJeu();
			}
			if(text == "restart"){
				fenetre.restartJeu();
			}
		}
	}