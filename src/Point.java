
public class Point extends Coordonnees{
	private int angle;
	private Coordonnees coord=new Coordonnees(0,0);
	private boolean pose = true;
	
	public Point() {
		super();
	}
	public Point(int x, int y, int angle){
		super(x,y);
		if(angle >= 0 && angle <=360 ) {
			this.angle = angle;
		}
		else this.angle = 0;
	}

	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public boolean isPose() {
		return pose;
	}
	public void setPose(boolean pose) {
		this.pose = pose;
	}
	public void reset() {
		super.setX(0);
		super.setY(0);
		setAngle(0);
	}
	
	/*
	 * Calcul de la nouvelle position d'un point après déplacement(distance et angle)
	 * 
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
