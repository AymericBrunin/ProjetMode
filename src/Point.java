
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
	
	/*
	 * Calcul de la nouvelle position d'un point après déplacement(distance et angle)
	 * 
	 */
	public Point createNewPoint(int distance, int angle) {
		Point nouveauPoint = new Point();
		nouveauPoint.setX((int)(this.getX()+distance*Math.cos(angle)));
		nouveauPoint.setY((int)(this.getY()+distance*Math.sin(angle)));
		if(nouveauPoint.getX() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setX(InterfaceTest.TAILLECANVAS);
		}
		if(nouveauPoint.getY() > InterfaceTest.TAILLECANVAS) {
			nouveauPoint.setY(InterfaceTest.TAILLECANVAS);
		}
		return nouveauPoint;
	}
	
	
}
