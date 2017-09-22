
public class Action {

	//DROITE,GAUCHE,AVANT,ARRIERE,COULEUR,EPAISSEUR;
	//Class provisoire
	
	/*
	 * parametre est un token de StreamTokenizer
	 */
	static boolean estDroite(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("DROITE");
	}
	static boolean estGauche(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("GAUCHE");
	}
	static boolean estAvant(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("AVANT");
	}
	static boolean estARRIERE(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("ARRIERE");
	}
	static boolean estCouleur(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("COULEUR");
	}
	static boolean estEpaisseur(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("EPAISSEUR");
	}
	
	
	
	
	}

