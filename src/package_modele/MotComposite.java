package package_modele;

import java.util.ArrayList;
import java.util.List;

public class MotComposite implements Mot {
	private List<Mot> liste = new ArrayList<Mot>();
	
	public MotComposite() {}
	
	public boolean ajouterMot(Mot mot) {
		liste.add(mot);
		return true;
	}
	
	public List<Mot> getChildren(){
		return liste;
	}
}
