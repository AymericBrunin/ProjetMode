import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Commande {
	private Color color = Color.BLACK;
	private Action action;
	private GraphicsContext gc;
	private Point tete;
	private List<LigneC> liste;
	
	/**
	 * Constructeur
	 * @param GraphicContext
	 * @param Point 
	 * @param ArrayList de LigneC (List de commandes)
	 */
	public Commande(GraphicsContext g, Point tete, ArrayList<LigneC> l){
		gc = g;
		this.tete = tete;
		liste = l;
		
	}
	/**
	 * Realise les commandes données par l'utilisateur.
	 * Modifie le GraphicContext, les angles, lever/poser, l'epaisseur
	 */
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
				if(tete.isPose()) {
					gc.strokeLine(tete.getX(), tete.getY(),Integer.parseInt(liste.get(i).val), Integer.parseInt(liste.get(i).val2));
				}
				tete.setX(Integer.parseInt(liste.get(i).val));
				tete.setY(Integer.parseInt(liste.get(i).val2));
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
	
	/**
	 * 
	 * @param int i (Indice de la commande concernee de la liste de commandes)
	 * @param boolean estArriere (true si déplacement en arriere)
	 * Realise le deplacement de la tete et modifie le GraphicContext
	 */
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
	
	/**
	 * 
	 * @param valeur (Valeur à ajouter à l'angle de base)
	 * @param angleTmp (Valeur de l'angle de base)
	 * @return int (nouvel angle)
	 * Fonction qui aplique l'angle à droite (0 <= angle <= 360), protection %360
	 */
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
	
	/**
	 * 
	 * @param valeur (Valeur à ajouter à l'angle de base)
	 * @param angleTmp (Valeur de l'angle de base)
	 * @return int (nouvel angle)
	 * Fonction qui aplique l'angle à gauche (0 <= angle <= 360), protection %360
	 */
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
	/**
	 * 
	 * @return Color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return Action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * 
	 * @param action
	 */
	public void setAction(Action action) {
		this.action = action;
	}
	
	/**
	 * 
	 * @return GraphicContext
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/**
	 * 
	 * @param gc
	 */
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	/**
	 * 
	 * @return Point
	 */
	public Point getTete() {
		return tete;
	}

	/**
	 * 
	 * @param tete
	 */
	public void setTete(Point tete) {
		this.tete = tete;
	}
	

}
