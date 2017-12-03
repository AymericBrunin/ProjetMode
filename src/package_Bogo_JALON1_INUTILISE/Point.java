package package_Bogo_JALON1_INUTILISE;

public class Point{
	private int angle;
	private boolean pose = true;
	private int x;
	private int y;
	
	/**
	 * Constructeur vide
	 */
	public Point() {
	}
	
	/**
	 * Constructeur Point
	 * @param x
	 * @param y
	 * @param angle
	 */
	public Point(int x, int y, int angle){
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
	 * Vrai si le crayon est pose
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
	 * Cree un nouveau point grace a une distance et un angle.
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
