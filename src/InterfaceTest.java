import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfaceTest extends Application{



	@Override
	public void start(Stage stage) throws Exception {
		HBox fenetre = new HBox();
		VBox interaction = new VBox();
		HBox Bouton = new HBox();
		Button Avanc = new Button();
		Button Recul = new Button("Re");
		Button Droite = new Button("Dr");
		Button Gauche = new Button("Ga");
		Button Epaisseur = new Button("Ep");
		Button Couleur = new Button("Co");
		Button Clear = new Button("Clear");
		Button Submit = new Button("Submit");
		Button Quit = new Button("Quit");
		HBox Menu = new HBox();
		Menu.getChildren().addAll(Clear,Submit,Quit);
		Bouton.getChildren().addAll(Avanc,Recul,Droite,Gauche,Epaisseur,Couleur);
		TextArea commande = new TextArea();
		commande.setMaxSize(210, 180);
		interaction.getChildren().addAll(Bouton,commande,Menu);
		Canvas canvas = new Canvas();
		canvas.setWidth(200);
		canvas.setHeight(200);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		fenetre.getChildren().addAll(canvas,interaction);
		Scene scene = new Scene(fenetre);
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
