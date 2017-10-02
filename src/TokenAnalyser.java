import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;

public class TokenAnalyser {
	private StreamTokenizer st;
	ArrayList<LigneC> commande = new ArrayList<>();
	LigneC ligne;
	
	public ArrayList<LigneC> tokenAnalyse(String s){
		try{
			st=new StreamTokenizer(new StringReader(s));
			int type;
			String parametre="";
			String action = "";
			while ((type = st.nextToken()) != StreamTokenizer.TT_EOF) {

				switch (type) {
				case StreamTokenizer.TT_NUMBER:
					parametre = String.valueOf(st.nval);
					break;
					
				case StreamTokenizer.TT_WORD:
					if(action.equals("")) {
						action = st.sval;
					}
					else {
						parametre = st.sval;
					}
					break;
				}
			}
			//System.out.println(action+" "+parametre);
			if(correct(action,parametre,null)){
				//System.out.println("Valeur token :"+action +" "+ parametre);
				commande.add(new LigneC(action,parametre));
			}
			commande.toString();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return commande;
	}
	
	
	
	
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
	public boolean estUnEntier(String s){
		try{
			Double.parseDouble(s);
		} catch(NumberFormatException e){return false;}

		return true;
	}
}
