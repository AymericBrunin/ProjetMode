package package_modele;

import package_Bogo_JALON1_INUTILISE.Couleur;

public enum EnumCouleurModele {
	NOIR("NOIR"),
	BLANC("BLANC"),
	GRIS("GRIS"),
	BLEU("BLEU"),
	VERT("VERT"),
	ROUGE("ROUGE"),
	JAUNE("JAUNE"),
	ROSE("ROSE"),
	ORANGE("ORANGE"),
	VIOLET("VIOLET"),
	MARRON("MARRON");
	
	private String nomCouleur;
	
	private EnumCouleurModele(String s) {
		nomCouleur=s;
	}
	
	public String getNomCouleur() {
		return nomCouleur;
	}

	/*
	 * Retourne Vrai si la chaine de caractere est une Couleur valide, presente dans l'enumeration de cette classe.
	 * @param String
	 * @return boolean
	 *
	public static boolean estCouleur(String s) {
		s=s.toUpperCase();
		for(int i=0; i<Couleur.values().length;i++) {
			if(s.equals(Couleur.values()[i].toString())){
				return true;
			}
		}
		return false;
	}
	*/
	

}

