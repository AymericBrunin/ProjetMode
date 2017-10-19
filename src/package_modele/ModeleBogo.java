package package_modele;

import java.util.Observable;


public class ModeleBogo extends Observable {

	private static final int TAILLECANVAS = 300;
	
	private PointModele pointCourant;
	private PointModele pointDestination;
	private boolean estPoser;
	
	
	
	public PointModele getPointCourant() {
		return pointCourant;
	}

	public PointModele getPointDestination() {
		return pointDestination;
	}



	public static int getTAILLECANVAS() {
		return TAILLECANVAS;
	}	
}
