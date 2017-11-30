
package package_arbre;

import java.util.ArrayList;
import java.util.List;

import package_vue.Visiteur;

public class ArbreScript extends ArbreMot {
	
	private List<ArbreMot> liste;
	private ArbreScript papa;
	
	public ArbreScript(){
		liste = new ArrayList<ArbreMot>();
	}
	
	@Override
	public void add(ArbreMot arbreMot) {
		liste.add(arbreMot);
		
	}
	@Override
	public void executer() {
		// TODO Auto-generated method stub
	}

	@Override
	public void accept(Visiteur v) {
		v.visite(this);
		
	}

	public List<ArbreMot> getListe() {
		return liste;
	}
	
	
	
}
