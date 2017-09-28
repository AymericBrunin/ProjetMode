import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Commande {
	private Color color;
	private Action action;
	private int distance;
	private int angle;
	private GraphicsContext gc;
	private Point tete;
	private List<LigneC> liste;
	
	public Commande(GraphicsContext g, Point tete,ArrayList<LigneC> l){
		gc = g;
		this.tete = tete;
		liste = l;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public int getAngle() {
		return angle;
	}


	public void setAngle(int angle) {
		this.angle = angle;
	}


	public GraphicsContext getGc() {
		return gc;
	}


	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}


	public Point getTete() {
		return tete;
	}


	public void setTete(Point tete) {
		this.tete = tete;
	}
	

}
