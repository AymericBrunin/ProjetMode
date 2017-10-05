import javafx.scene.paint.Color;

public enum Couleur {
	NOIR(Color.BLACK),
	BLANC(Color.WHITE),
	GRIS(Color.GREY),
	BLEU(Color.BLUE),
	VERT(Color.GREEN),
	ROUGE(Color.RED),
	JAUNE(Color.YELLOW),
	ROSE(Color.PINK),
	ORANGE(Color.ORANGE),
	VIOLET(Color.PURPLE),
	MARRON(Color.BROWN);
	
	Color c;
	
	private Couleur(Color c){};
	
	static boolean estCouleur(String s) {
		s=s.toUpperCase();
		for(int i=0; i<Couleur.values().length;i++) {
			if(s.equals(Couleur.values()[i].toString())){
				return true;
			}
		}
		return false;
	}
	

}
