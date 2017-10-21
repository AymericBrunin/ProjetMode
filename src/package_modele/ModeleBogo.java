package package_modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;


public class ModeleBogo extends Observable {
	
	private static final int TAILLECANVAS = 300;
	
	private PointModele pointCourant;
	private PointModele pointDestination;
	private TokenAnalyserModele tokenAnalyser;
	private boolean estPoser;
	private List<String> scriptToken = new ArrayList<String>();
	
	
	public ModeleBogo(PointModele p) {
		pointCourant = p;
		estPoser = true;
		pointDestination = null;
		tokenAnalyser = new TokenAnalyserModele();
		
	}
	public void reset() {
		pointCourant.reset();
		pointDestination = null;
		estPoser = true;
	}
	
	public void avancer(int distance) {
		if(estPoser) {
			pointDestination = pointCourant.createNewPoint(distance);
			actualiser();
			pointCourant = pointDestination;
		}
	}
	
	public void droite(int valeurAngle) {
		pointCourant.setAngle(pointCourant.calculAngleDroite(valeurAngle));
	}
	
	public void ajouteNouveauScript(String script) throws Exception {
		reset();
		tokenAnalyser.setScript(script);
		System.out.println("script save");
		tokenAnalyser.decoupeEnToken();
		System.out.println("script decoupe");
		if((tokenAnalyser.verificationScript())) {
			scriptToken = tokenAnalyser.getListeMot();
		}
		else {
			throw new Exception("La syntaxe du script n'est pa valide.");
		}
		executeScript();
	}
	
	public void executeScript() {
		Iterator it = scriptToken.iterator();
		String valCourante;
		//On skip l'instruction SCRIPT de depart
		valCourante = (String) it.next();
		while(it.hasNext()) {
			valCourante = (String)it.next();
			if(valCourante.equals("AVANT")) {
				avancer(Integer.parseInt((String) it.next()));
			}
			else if(valCourante.equals("DROITE")) {
				droite(Integer.parseInt((String) it.next()));
			}
		}
		actualiser();
	}
	
	
	
	public PointModele getPointCourant() {
		return pointCourant;
	}

	public PointModele getPointDestination() {
		return pointDestination;
	}

	public static int getTAILLECANVAS() {
		return TAILLECANVAS;
	}	
	
	private void actualiser() {
			setChanged();
			notifyObservers();
	}
	
}
