import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenAnalyser {
	private StringTokenizer st;
	ArrayList<LigneC> commande = new ArrayList<LigneC>();
	LigneC ligne;
	
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
			if((Action.estAvant(boucle) || Action.estDroite(boucle) || Action.estGauche(boucle) || Action.estEpaisseur(boucle)) && estActionSimple == false && estCouleurBoolean == false && estAllerA == false) {
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
		

			//System.out.println(action+" "+parametre);
			//V�rification mise de cot�
			 //if(correct(action,parametre,null)){
				//System.out.println("Valeur token :"+action +" "+ parametre);
				//commande.add(new LigneC(action,parametre));
			//}
	}
	
	
	
	/*  V�rification Mise de cot�  
	public boolean correct(String s,String s2,String s3){
		boolean pc = false;
		if(s.equals("DROITE")|| s.equals("GAUCHE") || s.equals("AVANT") || s.equals("EPAISSEUR")){
			if(estUnEntier(s2)){pc = true;}
		}
		if(s.equals("ALLERA")){ 
			if(estUnEntier(s2)&&estUnEntier(s3)){pc = true;}
		}
		
		if(s.equals("POSER")){ if(s2 == null){pc = true;}}
		if(s.equals("LEVER")){ if(s2 == null){pc = true;}}
		if(s.equals("COULEUR")){
			if(s2.equals("NOIR")){ pc = true;}
			if(s2.equals("BLANC")){ pc = true;}
			if(s2.equals("GRIS")){ pc = true;}
			if(s2.equals("BLEU")){ pc = true;}
			if(s2.equals("VERT")){ pc = true;}
			if(s2.equals("ROUGE")){ pc = true;}
			if(s2.equals("JAUNE")){ pc = true;}
			if(s2.equals("ROSE")){ pc = true;}
			if(s2.equals("ORANGE")){ pc = true;}
			if(s2.equals("VIOLET")){ pc = true;}
			if(s2.equals("MARRON")){ pc = true;}			
		}
		

		return pc ;
	}
	*/
	public boolean estUnEntier(String s){
		try{
			Double.parseDouble(s);
		} catch(NumberFormatException e){return false;}

		return true;
	}
}
