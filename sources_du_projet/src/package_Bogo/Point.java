package package_Bogo;

public class Point extends Coordonnees{
	private int angle;
	private boolean pose = true;
	
	/**
	 * Constructeur vide
	 */
	public Point() {
		super();
	}
	/**
	 * Constructeur Point
	 * @param x
	 * @param y
	 * @param angle
	 */
	public Point(int x, int y, int angle){
		super(x,y);
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
	 * Vrai si le crayon est posé
	 * @return boolean
	 */
	public boolean isPose() {
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
		super.setX(0);
		super.setY(0);
		setAngle(0);
	}
	
	/**
	 * Crée un nouveau point grâce à une distance et un angle.
	 * @param distance
	 * @param angle
	 * @param b
	 * @return Point
	 */
	public Point createNewPoint(int distance, int angle, boolean b) {
		Point nouveauPoint = new Point();
		nouveauPoint.setAngle(angle);
		nouveauPoint.setPose(b);
		nouveauPoint.setX((int)(this.getX()+distance*Math.cos(Math.toRadians(angle))));
		nouveauPoint.setY((int)(this.getY()+distance*Math.sin(Math.toRadians(angle))));
		if(nouveauPoint.getX() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setX(InterfaceTest.TAILLECANVAS);
		}
		if(nouveauPoint.getX() < 0) {
			nouveauPoint.setX(0);
		}
		if(nouveauPoint.getY() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setY(InterfaceTest.TAILLECANVAS);
		}
		if(nouveauPoint.getY() < 0) {
			nouveauPoint.setY(0);
		}
		
		return nouveauPoint;
	}
	
	
}
