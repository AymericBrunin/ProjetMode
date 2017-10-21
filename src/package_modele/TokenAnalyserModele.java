package package_modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import package_Bogo.LigneC;

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
		Iterator it = listeMot.iterator();
		String valCourante;
		
		if(listeMot.isEmpty()) return true;
		
		if(!it.next().equals("SCRIPT")) return false;
		
		while(it.hasNext()) {
			valCourante = (String)it.next();
			System.out.println("Valeur courante : "+valCourante);
			
			if(valCourante.equals("AVANT") && !estUnEntier((String) it.next())) {
				System.out.println("FALSEFALSE");
				return false;
			}
			else if(valCourante.equals("DROITE") && !estUnEntier((String) it.next())) return false;
		
		}
		return true;
		
	}
	
	public boolean estUnEntier(String s){
		try{
			Double.parseDouble(s);
		} catch(NumberFormatException e){return false;}

		return true;
	}
}
