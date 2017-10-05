import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Commande {
	private Color color = Color.BLACK;
	private Action action;
	private GraphicsContext gc;
	private Point tete;
	private List<LigneC> liste;
	private boolean positionLever = false;
	
	public Commande(GraphicsContext g, Point tete, ArrayList<LigneC> l){
		gc = g;
		this.tete = tete;
		liste = l;
		
	}
	public void actionDeplacement(int i, boolean estArriere) {
		Point p = new Point();
		p.setPose(tete.isPose());
		double conversionValeurDouble = Double.parseDouble(liste.get(i).val);
		int conversionValeurInt = (int)(conversionValeurDouble);
		if(estArriere) {
			p = tete.createNewPoint(-conversionValeurInt, tete.getAngle(), tete.isPose());
		}
		else {
			p = tete.createNewPoint(conversionValeurInt, tete.getAngle(), tete.isPose());
		}
		
		if(p.isPose()) {
			gc.strokeLine(tete.getX(), tete.getY(), p.getX(), p.getY() );
		}
		tete=p;
	}
	
	//modifie le nom de la fonction pour quelle soit plus representative de son action
	//ajout de allerA dans drawline
	public void drawLines(){
		for(int i=0;i<liste.size();i++){
			
			if(Action.estAvant(liste.get(i).action)){
				actionDeplacement(i, false);
			}
			else if(Action.estArriere(liste.get(i).action)) {
				actionDeplacement(i,true);
			}
			else if(Action.estDroite(liste.get(i).action)){
				 tete.setAngle(calculAngleDroite(Integer.parseInt(liste.get(i).val), tete.getAngle()));
			 }
			 
			else if(Action.estGauche(liste.get(i).action)){
				 tete.setAngle(calculAngleGauche(Integer.parseInt(liste.get(i).val), tete.getAngle()));
			 }
			 
			else if(Action.estEpaisseur(liste.get(i).action)){
				 gc.setLineWidth(Integer.parseInt(liste.get(i).val));
				 
			 }
			else if(Action.estLever(liste.get(i).action)) {
				tete.setPose(false);
			}
			else if(Action.estPoser(liste.get(i).action)) {
				tete.setPose(true);
			}
			else if(Action.estAllera(liste.get(i).action)) {
				gc.strokeLine(tete.getX(), tete.getY(),Integer.parseInt(liste.get(i).val), Integer.parseInt(liste.get(i).val2));	
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
				 gc.setStroke(color);
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
