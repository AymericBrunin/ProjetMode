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
		
		boolean estAction = false;
		String action ="";
		int entier=0;
		for(String boucle : mot) {
			if((Action.estAvant(boucle) || Action.estDroite(boucle) || Action.estGauche(boucle) || Action.estEpaisseur(boucle)) && estAction == false) {
				estAction = true;
				action = boucle;
			}
			else if((Action.estLever(boucle) || Action.estPoser(boucle)) && estAction == false) {
				action = boucle;
				commande.add(new LigneC(action));
				estAction = false;
			}
			
			else if(estUnEntier(boucle) && estAction == true) {
				entier = Integer.parseInt(boucle);
				commande.add(new LigneC(action, String.valueOf(entier)));
				estAction = false;
			}
			
			else {
				throw new NoSuchElementException();
			}
			
		}
		return commande;
		

			//System.out.println(action+" "+parametre);
			//Vérification mise de coté
			 //if(correct(action,parametre,null)){
				//System.out.println("Valeur token :"+action +" "+ parametre);
				//commande.add(new LigneC(action,parametre));
			//}
	}
	
	
	
	/*  Vérification Mise de coté  
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
