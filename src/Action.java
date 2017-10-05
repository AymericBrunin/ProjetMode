
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
	static boolean estArriere(String mot) {
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
	static boolean estPoser(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("POSER");
	}
	static boolean estLever(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("LEVER");
	}
	static boolean estAllera(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("ALLERA");
	}
	
	
	}

