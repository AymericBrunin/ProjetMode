
public enum Couleur {
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
	 * Retourne Vrai si la chaine de caractere est une Couleur valide.
	 * @param s
	 * @return boolean
	 */
	static boolean estCouleur(String s) {
		s=s.toUpperCase();
		for(int i=0; i<Couleur.values().length;i++) {
			if(s.equals(Couleur.values()[i].toString())){
				return true;
			}
		}
		return false;
	}
	

}
