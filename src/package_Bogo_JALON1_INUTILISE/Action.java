package package_Bogo;

public class Action {
	
	/**
	 * Verifie si le parametre est l'action DROITE
	 * @param mot
	 * @return boolean
	 */
	static boolean estDroite(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("DROITE");
	}
	/**
	 * Verifie si le parametre est l'action GAUCHE
	 * @param mot
	 * @return boolean
	 */
	static boolean estGauche(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("GAUCHE");
	}
	/**
	 * Verifie si le parametre est l'action AVANT
	 * @param mot
	 * @return boolean
	 */
	static boolean estAvant(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("AVANT");
	}
	/**
	 * Verifie si le parametre est l'action ARRIERE
	 * @param mot
	 * @return boolean
	 */
	static boolean estArriere(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("ARRIERE");
	}
	/**
	 * Verifie si le parametre est l'action COULEUR
	 * @param mot
	 * @return boolean
	 */
	static boolean estCouleur(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("COULEUR");
	}
	/**
	 * Verifie si le parametre est l'action EPAISSEUR
	 * @param mot
	 * @return boolean
	 */
	static boolean estEpaisseur(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("EPAISSEUR");
	}
	/**
	 * Verifie si le parametre est l'action POSER
	 * @param mot
	 * @return boolean
	 */
	static boolean estPoser(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("POSER");
	}
	/**
	 * Verifie si le parametre est l'action LEVER
	 * @param mot
	 * @return boolean
	 */
	static boolean estLever(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("LEVER");
	}
	/**
	 * Verifie si le parametre est l'action ALLERA
	 * @param mot
	 * @return boolean
	 */
	static boolean estAllera(String mot) {
		mot = mot.toUpperCase();
		return mot.equals("ALLERA");
	}
	
	
	}

