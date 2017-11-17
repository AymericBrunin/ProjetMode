package package_modele;

import package_Bogo.Couleur;

public enum EnumCouleurModele {
	NOIR,
	BLANC,
	GRIS,
	BLEU,
	VERT,
	ROUGE,
	JAUNE,
	ROSE,
	ORANGE,
	VIOLET,
	MARRON;
	

	/**
	 * Retourne Vrai si la chaine de caractere est une Couleur valide, presente dans l'enumeration de cette classe.
	 * @param String
	 * @return boolean
	 */
	public static boolean estCouleur(String s) {
		s=s.toUpperCase();
		for(int i=0; i<Couleur.values().length;i++) {
			if(s.equals(Couleur.values()[i].toString())){
				return true;
			}
		}
		return false;
	}
	
	

}

