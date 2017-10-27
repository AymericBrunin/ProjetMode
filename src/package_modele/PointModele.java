package package_modele;

public class PointModele {

	
	private int angle;
	private boolean pose = true;
	private int x;
	private int y;
	
	/**
	 * Constructeur vide
	 */
	public PointModele() {
	}
	
	/**
	 * Constructeur Point
	 * @param x
	 * @param y
	 * @param angle
	 */
	public PointModele(int x, int y, int angle){
		this.x=x;
		this.y=y;
		if(angle >= 0 && angle <=360 ) {
			this.angle = angle;
		}
		else this.angle = 0;
	}
	
	/**
	 * Getter Angle
	 * @return angle
	 */
	public int getAngle() {
		return angle;
	}
	/**
	 * Setter Angle
	 * @param angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}
	/**
	 * Vrai si le crayon est posï¿½
	 * @return boolean
	 */
	public boolean getPoser() {
		return pose;
	}
	/**
	 * Setter de pose
	 * @param pose
	 */
	public void setPose(boolean pose) {
		this.pose = pose;
	}
	/**
	 * Reset la tete du crayon
	 */
	public void reset() {
		setX(0);
		setY(0);
		setAngle(0);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Crï¿½e un nouveau point grï¿½ce ï¿½ une distance et un angle.
	 * @param distance
	 * @param angle
	 * @param b
	 * @return Point
	 */
	public PointModele createNewPoint(int distance) {
		PointModele nouveauPoint = new PointModele();
		nouveauPoint.setAngle(getAngle());
		nouveauPoint.setPose(getPoser());
		nouveauPoint.setX((int)(this.getX()+distance*Math.cos(Math.toRadians(getAngle()))));
		nouveauPoint.setY((int)(this.getY()+distance*Math.sin(Math.toRadians(getAngle()))));
		
		if(nouveauPoint.getX() > (ModeleBogo.getTAILLECANVAS())) {
			nouveauPoint.setX(ModeleBogo.getTAILLECANVAS());
		}
		if(nouveauPoint.getX() < 0) {
			nouveauPoint.setX(0);
		}
		if(nouveauPoint.getY() > ModeleBogo.getTAILLECANVAS()) {
			nouveauPoint.setY(ModeleBogo.getTAILLECANVAS());
		}
		if(nouveauPoint.getY() < 0) {
			nouveauPoint.setY(0);
		}
		
		return nouveauPoint;
	}
	
	/**
	 * Calcul l'angle de la commande "DROITE", modulo, limite à 360d
	 * @param valeur a ajouter a l'angle courant
	 * @return Integer du nouvel angle
	 */
	public int calculAngleDroite(int valeur) {
		int stockage=0;
		int angleTmp = getAngle();
		while(valeur >=360){
			valeur -= 360;
		}
		if(angleTmp+valeur >= 360) {
			stockage = (angleTmp + valeur) - 360;
			angleTmp = stockage;
		}
		else {
			angleTmp += valeur;
		}
		return angleTmp;
	}
	
	/**
	 * Calcul l'angle de la commande "GAUCHE", modulo, limite à 360d
	 * @param valeur a ajouter a l'angle courant
	 * @return Integer du nouvel angle
	 */
	public int calculAngleGauche(int valeur) {
		int stockage = 0;
		int angleTmp = getAngle();
		while(valeur >= 360) {
			valeur -=360;
		}
		if(angleTmp-valeur < 0) {
			stockage = angleTmp - valeur;
			angleTmp = 360 + stockage;
		}
		else {
			angleTmp -= valeur;
		}
		return angleTmp;
	}
	
	
}
