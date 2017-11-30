package package_modele;

import package_vue.ConversionCouleurToColor;

public class Crayon {
	private int x;
	private int y;
	private int angle;
	private boolean pose;
	private int epaisseur;
	private EnumCouleurModele couleur;
	
	public Crayon() {
		x=0;
		y=0;
		couleur = new ConversionCouleurToColor().getCouleurEnum("NOIR");
		epaisseur = 2;
		pose = true;
		angle = 0;
	}
	
	public void reset() {
		x=0;
		y=0;
		couleur = new ConversionCouleurToColor().getCouleurEnum("NOIR");
		epaisseur = 2;
		pose = true;
		angle = 0;
	}
	
	

}
