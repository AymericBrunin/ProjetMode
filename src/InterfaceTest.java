import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	ArrayList<LigneC> listeCommande = new ArrayList<>();

	Canvas canvas = new Canvas();
	TextArea textCommande = new TextArea();
	GraphicsContext gc = canvas.getGraphicsContext2D();

	private Point pointTete = new Point(0,0,0);
	private Commande commande;

	@Override
	public void start(Stage stage) throws Exception {
		// la Hbox fenetre contient tout
		HBox fenetre = new HBox();

		//la Vbox interaction contient le text Field et tous les bouton
		VBox interaction = new VBox();

		//la Hbox Bouton contient les boutons d'interaction 
		HBox boutonDeplacement = new HBox();
		Button avance = new Button("Av");
		Button droite = new Button("Dr");
		Button gauche = new Button("Ga");
		Button epaisseur = new Button("Ep");
		Button couleur = new Button("Co");

		//la Hbox Menu contient les boutons du bas de l'interface
		HBox menu = new HBox();
		Button clear = new Button("Clear");
		Button submit = new Button("Submit");
		Button quit = new Button("Quit");
		menu.getChildren().addAll(clear,submit,quit);
		boutonDeplacement.getChildren().addAll(avance,droite,gauche,epaisseur,couleur);
		//Config du TextArea
		textCommande.setMaxSize(210, 180);
		interaction.getChildren().addAll(boutonDeplacement,textCommande,menu);

		//streamtokenizer

		submit.setOnMouseClicked(e->{listeCommande = tk.tokenAnalyse(textCommande.getText());});
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				listeCommande = tk.tokenAnalyse(textCommande.getText());
				for(int i=0; i<listeCommande.size();i++) {
					//System.out.println(listeCommande.get(i).action);
					//System.out.println(listeCommande.get(i).val);
				}
				commande = new Commande(gc,pointTete,listeCommande);
				commande.drawLines();
				gc = commande.getGc();
				pointTete = commande.getTete();
				System.out.println("Bouton détecté fin de submit");
				
			}
			
		});


		//Programmation Evenementielle

		clear.setOnMouseClicked(e->{gc.clearRect(0, 0, TAILLECANVAS, TAILLECANVAS);textCommande.clear();});
		quit.setOnMouseClicked(e->{stage.close();});
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
