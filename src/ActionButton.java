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
			switch(text) {
				case "play":
					fenetre.afficherJeu();
					break;
				case "restart":
					fenetre.restartJeu();
					break;
				case "exit":
					System.exit(1);
					break;
				case "affichermenu":
					fenetre.afficherMenuPrincipale();
					break;
				case "editeur de niveau":
					fenetre.afficherEditeurNiveau();
			}/*
			if(text == "play") {
				fenetre.afficherJeu();
			}
			if(text == "restart"){
				fenetre.restartJeu();
			}
			if(text == "exit"){
				System.exit(1);
			}*/
		}
	}