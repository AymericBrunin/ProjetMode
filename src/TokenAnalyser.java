import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TokenAnalyser {
	private StreamTokenizer st;
	ArrayList<LigneC> commande = new ArrayList<>();
	LigneC ligne;
	public ArrayList<LigneC> TokenAnalyse(String s){
		try{
			st=new StreamTokenizer(new StringReader(s));
			int type;
			while ((type = st.nextToken()) != StreamTokenizer.TT_EOF) {
				
				switch (type) {
				case StreamTokenizer.TT_NUMBER:
					//System.out.println(st.nval);
					break;
				case StreamTokenizer.TT_WORD:
					//System.out.println(st.sval);
					break;
				}
				if(correct(st.sval,st.nval+"",null)){
				System.out.println(st.sval +" "+ st.nval);
				commande.add(ligne = new LigneC(st.sval,st.nval+""));
				}
			}
			commande.toString();
		}
		catch (Exception E){

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
			if(s.equals("NOIR")){ pc = true;}
			if(s.equals("BLANC")){ pc = true;}
			if(s.equals("GRIS")){ pc = true;}
			if(s.equals("BLEU")){ pc = true;}
			if(s.equals("VERT")){ pc = true;}
			if(s.equals("ROUGE")){ pc = true;}
			if(s.equals("JAUNE")){ pc = true;}
			if(s.equals("ROSE")){ pc = true;}
			if(s.equals("ORANGE")){ pc = true;}
			if(s.equals("VIOLET")){ pc = true;}
			if(s.equals("MARRON")){ pc = true;}			
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
