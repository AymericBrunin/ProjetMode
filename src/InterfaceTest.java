import com.sun.prism.paint.Color;

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
	Canvas canvas = new Canvas();
	TextArea commande = new TextArea();
	GraphicsContext gc = canvas.getGraphicsContext2D();


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
		
		//Programmation évenementielle
		Clear.setOnMouseClicked(e->{gc.clearRect(0, 0, 200, 200);commande.clear();});
		
		//Configuration du canvas
		canvas.setWidth(200);
		canvas.setHeight(200);	
		fenetre.getChildren().addAll(canvas,interaction);
		
		Scene scene = new Scene(fenetre);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}


}
