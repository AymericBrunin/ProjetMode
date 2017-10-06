package package_Bogo;

public class Coordonnees {
	private int x;
	private int y;
 
	public Coordonnees(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Coordonnees() {}

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
	
	public void ajouterCoordonnees(int x, int y){
		this.x += x;
		this.y += y;
	}
}
