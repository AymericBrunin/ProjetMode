import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Commande {
	private Color color = Color.BLACK;
	private Color colorSave = Color.BLACK;
	private Action action;
	//private int distance=0;
	private int angle=0;
	private GraphicsContext gc;
	private Point tete;
	private List<LigneC> liste;
	private boolean positionLever = false;
	
	public Commande(GraphicsContext g, Point tete, ArrayList<LigneC> l){
		gc = g;
		this.tete = tete;
		liste = l;
		angle = tete.getAngle();
		
	}
	public void actionAvant(int i) {
		Point p = new Point();
		double conversionValeurDouble = Double.parseDouble(liste.get(i).val);
		int conversionValeurInt = (int)(conversionValeurDouble);
		p = tete.createNewPoint(conversionValeurInt, angle);
		gc.strokeLine(tete.getX(), tete.getY(), p.getX(), p.getY() );
		tete=p;
	}
	
	public void drawLines(){
		for(int i=0;i<liste.size();i++){
			System.out.println(liste.get(i).action +" : "+liste.get(i).val);
			if(Action.estAvant(liste.get(i).action)){
				actionAvant(i);
			}
			else if(Action.estDroite(liste.get(i).action)){
				 angle = calculAngleDroite(Integer.parseInt(liste.get(i).val), angle);
				 tete.setAngle(angle);
			 }
			 
			else if(Action.estGauche(liste.get(i).action)){
				 angle = calculAngleGauche(Integer.parseInt(liste.get(i).val), angle);
				 tete.setAngle(angle);
			 }
			 
			else if(Action.estEpaisseur(liste.get(i).action)){
				 gc.setLineWidth(Integer.parseInt(liste.get(i).val));
				 
			 }
			 
			else if(Action.estCouleur(liste.get(i).action)){
				 liste.get(i).val = liste.get(i).val.toUpperCase();
				 
				 if(liste.get(i).val.equals("NOIR")){
					 color = Color.BLACK;
				 }
				 else if(liste.get(i).val.equals("BLANC")){
					 color = Color.WHITE;
				 }
				 else if(liste.get(i).val.equals("GRIS")){
					 color = Color.GREY;
				 }
				 else if(liste.get(i).val.equals("BLEU")){
					 color = Color.BLUE;
				 }
				 else if(liste.get(i).val.equals("VERT")){
					 color = Color.GREEN;
				 }
				 else if(liste.get(i).val.equals("ROUGE")){
					 color = Color.RED;
				 }
				 else if(liste.get(i).val.equals("ORANGE")){
					 color = Color.ORANGE;
				 }
				 else if(liste.get(i).val.equals("JAUNE")){
					 color = Color.YELLOW;
				 }
				 else if(liste.get(i).val.equals("ROSE")){
					 color = Color.PINK;
				 }
				 else if(liste.get(i).val.equals("VIOLET")){
					 color = Color.PURPLE;
				 }
				 else if(liste.get(i).val.equals("MARRON")){
					 color = Color.BROWN;
				 }
				 gc.setFill(color);
				 if(positionLever) { //Si le point est leve et que l'utilisateur change de couleur, rien ne se passe.
					 gc.setFill(Color.WHITE);
				 }
			 }
			else if(liste.get(i).action.equals("LEVER")){
				 colorSave = color;
				 color = Color.WHITE;
				 positionLever = true;
			 }
			else if(liste.get(i).action.equals("POSER")){
				 color = colorSave;
				 positionLever = false;
			 }
		}
	}
	
	public int calculAngleDroite(int valeur, int angleTmp) {
		int stockage=0;
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
	
	public int calculAngleGauche(int valeur, int angleTmp) {
		int stockage = 0;
		while(valeur >= 360) {
			valeur -=360;
		}
		if(angleTmp-valeur < 0) {//-20
			stockage = angleTmp - valeur;
			angleTmp = 360 + stockage;
		}
		else {
			angleTmp -= valeur;
		}
		return angleTmp;
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
