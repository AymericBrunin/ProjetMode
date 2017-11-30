package package_vue;

import java.util.List;

import javafx.scene.canvas.Canvas;
import package_arbre.ArbreMot;
import package_arbre.ArbreScript;
import package_modele.Crayon;

public class Visiteur {
	Crayon crayon;
	Canvas canvas;
	
	public Visiteur(Canvas canvas) {
		this.canvas = canvas;
		crayon = new Crayon();
	}
	
	public void visite(ArbreScript a) {
		List<ArbreMot> tmp = a.getListe();
		for(ArbreMot boucle : tmp) {
			boucle.accept(this);
		}
	}

}
