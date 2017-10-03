
public class Point extends Coordonnees{
	private int angle;
	private Coordonnees coord=new Coordonnees(0,0);
	
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
	public void reset() {
		super.setX(0);
		super.setY(0);
		setAngle(0);
	}
	
	/*
	 * Calcul de la nouvelle position d'un point après déplacement(distance et angle)
	 * 
	 */
	public Point createNewPoint(int distance, int angle) {
		Point nouveauPoint = new Point();
		System.out.println("ICI : "+ angle);
		nouveauPoint.setX((int)(this.getX()+distance*Math.cos(Math.toRadians(angle))));
		nouveauPoint.setY((int)(this.getY()+distance*Math.sin(Math.toRadians(angle))));
		if(nouveauPoint.getX() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setX(InterfaceTest.TAILLECANVAS);
		}
		if(nouveauPoint.getY() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setY(InterfaceTest.TAILLECANVAS);
		}
		return nouveauPoint;
	}
	
	
}
