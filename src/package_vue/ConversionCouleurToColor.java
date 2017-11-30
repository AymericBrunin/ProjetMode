package package_vue;

import javax.print.attribute.standard.RequestingUserName;

import javafx.scene.paint.Color;
import package_modele.EnumCouleurModele;

public class ConversionCouleurToColor {
	public ConversionCouleurToColor() {}
	
	public Color couleurToColor(EnumCouleurModele c) {
		
		switch(c.getNomCouleur()) {
		
		case "ROUGE" :
			return Color.RED;
		case "BLEU" :
			return Color.BLUE;
		case "JAUNE" :
			return Color.YELLOW;
		case "NOIR" :
			return Color.BLACK;
		default :
			return Color.BLACK;
		}	
	}
	
	public EnumCouleurModele getCouleurEnum(String s) {
		
		switch(s) {
		
		case "ROUGE" :
			return EnumCouleurModele.ROUGE;
		case "NOIR" :
			return EnumCouleurModele.NOIR;
		default :
			return EnumCouleurModele.NOIR;
		}
	}
	
}
