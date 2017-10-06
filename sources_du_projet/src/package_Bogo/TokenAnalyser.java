package package_Bogo;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenAnalyser {
	private StringTokenizer st;
	ArrayList<LigneC> commande = new ArrayList<LigneC>();
	LigneC ligne;
	
	/**
	 * Reçoit en paramètre le texte de l'utilisateur.
	 * Vérification de la conformité du texte (Actions respectées, pas d'erreurs).
	 * @param s
	 * @return ArrayList<LigneC> (Liste de Commandes)
	 */
	public ArrayList<LigneC> tokenAnalyse(String s){
		commande.clear();
		st = new StringTokenizer(s);
		List<String> mot = new ArrayList<String>();
		
		while(st.hasMoreTokens()){
			mot.add(st.nextToken());
		}
		boolean estActionSimple = false;
		boolean estCouleurBoolean = false;
		boolean estAllerA = false;
		boolean estPremierEntier = false;
		String action ="";
		int entier=0;
		int entierAllerA = 0;
		
		
		for(String boucle : mot) {
			
			if((Action.estAvant(boucle) || Action.estDroite(boucle) || Action.estGauche(boucle) || Action.estEpaisseur(boucle) || Action.estArriere(boucle)) && estActionSimple == false && estCouleurBoolean == false && estAllerA == false) {
				estActionSimple = true;
				action = boucle;
			}
			else if((Action.estLever(boucle) || Action.estPoser(boucle)) && estActionSimple == false && estCouleurBoolean == false && estAllerA == false) {
				action = boucle;
				commande.add(new LigneC(action));
				estActionSimple = false;
			}
			else if(Action.estCouleur(boucle) && estActionSimple == false && estCouleurBoolean == false && estAllerA == false){
				action = boucle;
				estCouleurBoolean = true;
			}
			else if(Action.estAllera(boucle) && estActionSimple == false && estCouleurBoolean == false && estAllerA == false) {
				action = boucle;
				estAllerA = true;
			}
			else if(estUnEntier(boucle) && estActionSimple == false && estCouleurBoolean == false && estAllerA == true) {
				if(estPremierEntier) {
					commande.add(new LigneC(action, String.valueOf(entierAllerA), String.valueOf(boucle)));
					estAllerA = false;
					estPremierEntier = false;
				}
				else {
					entierAllerA = Integer.parseInt(boucle);
					estPremierEntier = true;
				}
			}
			
			else if(estUnEntier(boucle) && estActionSimple == true && estCouleurBoolean == false && estAllerA == false) {
				entier = Integer.parseInt(boucle);
				commande.add(new LigneC(action, String.valueOf(entier)));
				estActionSimple = false;
			}
			else if(Couleur.estCouleur(boucle) && estActionSimple == false && estCouleurBoolean == true && estAllerA == false){
				commande.add(new LigneC(action, boucle));
				estCouleurBoolean = false;
			}
			
			else {
				throw new NoSuchElementException();
			}
			
		}
		return commande;

	}
	
	/**
	 * Renvoie Vrai si la chaine de caractere en entree est un entier
	 * @param String s
	 * @return boolean
	 */
	public boolean estUnEntier(String s){
		try{
			Double.parseDouble(s);
		} catch(NumberFormatException e){return false;}

		return true;
	}
}
