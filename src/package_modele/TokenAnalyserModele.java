package package_modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class TokenAnalyserModele {
	private StringTokenizer st;
	private List<String> listeMot;
	private String script;
	
	
	
	public void setScript(String script) {
		this.script = script;
	}
	

	public List<String> getListeMot() {
		return listeMot;
	}


	public void decoupeEnToken() {
		listeMot = new ArrayList<String>();
		st = new StringTokenizer(script);
		while(st.hasMoreTokens()){
			listeMot.add(st.nextToken().toUpperCase());
		}
		System.out.println(listeMot.toString());
	}
	
	public boolean verificationScript() {
		Iterator<String> it = listeMot.iterator();
		String valCourante;
		
		if(listeMot.isEmpty()) return true;
		
		if(!it.next().equals("SCRIPT")) return false;
		
		while(it.hasNext()) {
			valCourante = it.next();
			System.out.println("Valeur courante : "+valCourante);
			
			if(valCourante.equals("AVANT") && !estUnEntier(it.next())) {
				return false;
			}
			else if(valCourante.equals("DROITE") && !estUnEntier(it.next())) return false;
			else if(valCourante.equals("GAUCHE") && !estUnEntier(it.next())) return false;
			else if(valCourante.equals("LEVER") || valCourante.equals("POSER"));
			else if(valCourante.equals("COULEUR") && !EnumCouleurModele.estCouleur(it.next())) return false;
			else if(valCourante.equals("ALLERA") && (!estUnEntier(it.next()) || !it.next().equals(",") || !estUnEntier(it.next()))) return false;
			if(valCourante.equals("FIN") && !it.hasNext()) return true;
		}
		return false;
		
	}
	
	public boolean estUnEntier(String s){
		try{
			Double.parseDouble(s);
		} catch(NumberFormatException e){return false;}

		return true;
	}
}
