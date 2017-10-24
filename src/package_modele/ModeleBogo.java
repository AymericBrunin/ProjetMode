package package_modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;


public class ModeleBogo extends Observable {
	
	private static final int TAILLECANVAS = 300;
	
	private static ModeleBogo instance = null;
	private PointModele pointCourant;
	private PointModele pointDestination;
	private TokenAnalyserModele tokenAnalyser;
	private boolean estPoser;
	private String couleur;
	private List<String> scriptToken = new ArrayList<String>();
	
	public static ModeleBogo getInstance(PointModele p){
		if(instance == null){
			instance = new ModeleBogo(p);
		}
		return instance;
	}
	
	
	private ModeleBogo(PointModele p) {
		pointCourant = p;
		estPoser = true;
		pointDestination = new PointModele();
		tokenAnalyser = new TokenAnalyserModele();
		couleur = "NOIR";
		
	}
	public void reset() {
		pointCourant.reset();
		pointDestination.reset();
		estPoser = true;
	}
	
	public void avancer(int distance) {
		pointDestination = pointCourant.createNewPoint(distance);
		actualiser();
		pointCourant = pointDestination;
	}
	
	public void droite(int valeurAngle) {
		pointCourant.setAngle(pointCourant.calculAngleDroite(valeurAngle));
	}
	
	public void gauche(int valeurAngle) {
		pointCourant.setAngle(pointCourant.calculAngleGauche(valeurAngle));
	}
	/**
	 * Fonction qui change les coordonnees des points dans le cas de la commande ALLERA
	 * @param int valeurX
	 * @param int valeurY
	 */
	public void allerA(int valeurX, int valeurY) {
		pointDestination.setX(valeurX);
		pointDestination.setY(valeurY);
		actualiser();
		pointCourant.setX(pointDestination.getX());
		pointCourant.setY(pointDestination.getY());
	}
	
	public void leverPoint() {
		setEstPoser(false);
	}
	
	public void poserPoint() {
		setEstPoser(true);
	}
	
	public void ajouteNouveauScript(String script) throws Exception {
		reset();
		tokenAnalyser.setScript(script);
		tokenAnalyser.decoupeEnToken();
		if((tokenAnalyser.verificationScript())) {
			scriptToken = tokenAnalyser.getListeMot();
		}
		else {
			throw new Exception("La syntaxe du script n'est pas valide.");
		}
		executeScript();
	}
	
	public void executeScript() {
		Iterator<String> it = scriptToken.iterator();
		String valCourante;
		//On skip l'instruction SCRIPT de depart
		valCourante = it.next();
		while(it.hasNext()) {
			valCourante = it.next();
			if(valCourante.equals("AVANT")) {
				avancer(Integer.parseInt(it.next()));
			}
			else if(valCourante.equals("DROITE")) {
				droite(Integer.parseInt(it.next()));
			}
			else if(valCourante.equals("GAUCHE")) {
				gauche(Integer.parseInt(it.next()));
			}
			else if(valCourante.equals("LEVER")) {
				leverPoint();
			}
			else if(valCourante.equals("POSER")) {
				poserPoint();
			}
			else if(valCourante.equals("COULEUR")) {
				setCouleur(it.next());
			}
			else if (valCourante.equals("ALLERA")) {
				int valeurX = Integer.parseInt(it.next());
				it.next(); //Pour passer la virgule :-)
				int valeurY = Integer.parseInt(it.next());
				allerA(valeurX, valeurY);
				
			}
		}
		//actualiser();
	}
	
	
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setEstPoser(boolean estPoser) {
		this.estPoser = estPoser;
	}
	
	public boolean isEstPoser() {
		return estPoser;
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
