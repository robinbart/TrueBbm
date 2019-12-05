import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionButton extends AbstractAction {
		private Oui fenetre;
	 
		public ActionButton(Oui fenetre, String texte){
			super(texte);
	 
			this.fenetre = fenetre;
		}
	 
		public void actionPerformed(ActionEvent event){
			fenetre.afficherJeu();
		}
	}