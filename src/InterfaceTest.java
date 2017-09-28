import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceTest extends Application{
	static final int TAILLECANVAS = 200;
	TokenAnalyser tk = new TokenAnalyser();
	ArrayList<LigneC> ligne = new ArrayList<>();

	Canvas canvas = new Canvas();
	TextArea commande = new TextArea();
	GraphicsContext gc = canvas.getGraphicsContext2D();

	private Point pointTete = new Point(0,0,0);

	@Override
	public void start(Stage stage) throws Exception {
		// la Hbox fenetre contient tout
		HBox fenetre = new HBox();

		//la Vbox interaction contient le text Field et tous les bouton
		VBox interaction = new VBox();

		//la Hbox Bouton contient les boutons d'interaction 
		HBox Bouton = new HBox();
		Button Avanc = new Button("Av");
		Button Recul = new Button("Re");
		Button Droite = new Button("Dr");
		Button Gauche = new Button("Ga");
		Button Epaisseur = new Button("Ep");
		Button Couleur = new Button("Co");

		//la Hbox Menu contient les boutons du bas de l'interface
		HBox Menu = new HBox();
		Button Clear = new Button("Clear");
		Button Submit = new Button("Submit");
		Button Quit = new Button("Quit");
		Menu.getChildren().addAll(Clear,Submit,Quit);
		Bouton.getChildren().addAll(Avanc,Recul,Droite,Gauche,Epaisseur,Couleur);
		//Config du TextArea
		commande.setMaxSize(210, 180);
		interaction.getChildren().addAll(Bouton,commande,Menu);

		//streamtokenizer

		Submit.setOnMouseClicked(e->{ligne = tk.TokenAnalyse(commande.getText());});



		//Programmation Evenementielle

		Clear.setOnMouseClicked(e->{gc.clearRect(0, 0, TAILLECANVAS, TAILLECANVAS);commande.clear();});
		Quit.setOnMouseClicked(e->{stage.close();});
		//Configuration du canvas
		canvas.setWidth(TAILLECANVAS);
		canvas.setHeight(TAILLECANVAS);	
		fenetre.getChildren().addAll(canvas,interaction);
		//Test du dessin sur canvas. A midifier en methode != de lambda expression. Antoine
		canvas.setOnMouseClicked(e->{gc.strokeLine(pointTete.getX(), pointTete.getY(), 50, 50);});

		Scene scene = new Scene(fenetre);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}


}
