package package_Bogo;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InterfaceTest extends Application {
	static final int TAILLECANVAS = 300;

	TokenAnalyser tk = new TokenAnalyser();
	ArrayList<LigneC> listeCommande = new ArrayList<>();

	Canvas canvas = new Canvas();
	TextArea textCommande = new TextArea();
	TextArea valeurBouton = new TextArea();
	Label valeurBoutonlabel = new Label("Ajouter une valeur :");
	GraphicsContext gc = canvas.getGraphicsContext2D();

	private Point pointTete = new Point(0, 0, 0);
	private Commande commande;

	@Override
	public void start(Stage stage) throws Exception {
		// la Hbox fenetre contient tout
		HBox fenetre = new HBox();
		
		// la Hbox Menu contient les boutons du bas de l'interface
		HBox menu = new HBox();

		// la Vbox interaction contient le text Field et tous les boutons
		VBox interaction = new VBox();

		// la Hbox Bouton contient les boutons d'interaction
		HBox boutonDeplacement = new HBox();
		
		VBox groupeBouton = new VBox();
		VBox groupeBoutonZoneDeSaisie = new VBox();

		
		Button arriere = new Button();
		Image imgArriere = new Image("File:ressources/arriere.png");
		arriere.setGraphic(new ImageView(imgArriere));
		arriere.setTooltip(new Tooltip("arriere")); // les tooltips s'affichent lorsque la souris passe sur un bouton

		Button avance = new Button();
		Image imgAvance = new Image("File:ressources//avant.png");
		avance.setGraphic(new ImageView(imgAvance));
		avance.setTooltip(new Tooltip("avant"));

		Button droite = new Button();
		Image imgDroite = new Image("File:ressources/droite.png");
		droite.setGraphic(new ImageView(imgDroite));
		droite.setTooltip(new Tooltip("droite"));

		Button gauche = new Button();
		Image imgGauche = new Image("File:ressources/gauche.png");
		gauche.setGraphic(new ImageView(imgGauche));
		gauche.setTooltip(new Tooltip("gauche"));

		Button lever = new Button();
		Image imgLever = new Image("File:ressources/lever.png");
		lever.setGraphic(new ImageView(imgLever));
		lever.setTooltip(new Tooltip("lever le crayon"));

		Button poser = new Button();
		Image imgPoser = new Image("File:ressources/poser.png");
		poser.setGraphic(new ImageView(imgPoser));
		poser.setTooltip(new Tooltip("poser le crayon"));

		Button clear = new Button();
		Image imgClear = new Image("File:ressources/clear.png");
		clear.setGraphic(new ImageView(imgClear));
		clear.setTooltip(new Tooltip("effacer"));

		Button submit = new Button();
		Image imgSubmit = new Image("File:ressources/submit.png");
		submit.setGraphic(new ImageView(imgSubmit));
		submit.setTooltip(new Tooltip("dessiner"));

		Button quit = new Button();
		Image imgQuit = new Image("File:ressources/quit.png");
		quit.setGraphic(new ImageView(imgQuit));
		quit.setTooltip(new Tooltip("quitter"));
		
		// Configuration du canvas
		canvas.setWidth(TAILLECANVAS);
		canvas.setHeight(TAILLECANVAS);

		
		// CONFIGURATION DU TEXTAREA
		textCommande.setMinSize(100, 250);
		textCommande.setMaxSize(288, 290);
		textCommande.setFont(new Font("Trebuchet MS", 15));
		
		valeurBouton.setMaxWidth(287);
		valeurBouton.setMaxHeight(10);

		menu.getChildren().addAll(clear, submit, quit);
		menu.setAlignment(Pos.BOTTOM_RIGHT);
		
		boutonDeplacement.getChildren().addAll(arriere, avance, gauche, droite, lever, poser);
		groupeBouton.getChildren().addAll(valeurBoutonlabel, valeurBouton, boutonDeplacement);
		
		interaction.setSpacing(0);
		interaction.getChildren().addAll(textCommande, menu);
		
		groupeBoutonZoneDeSaisie.setSpacing(20);
		groupeBoutonZoneDeSaisie.getChildren().addAll(groupeBouton, interaction);
		
		fenetre.setSpacing(10);
		fenetre.getChildren().addAll(canvas, groupeBoutonZoneDeSaisie);

		avance.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "AVANT "+ valeurBouton.getText()+"\n");
			}
			
		});
		
		arriere.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "ARRIERE "+ valeurBouton.getText()+"\n");
			}
			
		});
		
		droite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "DROITE "+ valeurBouton.getText()+"\n");
			}
			
		});
		
		gauche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "GAUCHE "+ valeurBouton.getText()+"\n");
			}
		});
		
		lever.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "LEVER\n");
			}
			
		});
		
		poser.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				textCommande.insertText(textCommande.getCaretPosition(), "POSER\n");
			}
			
		});

		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				listeCommande.clear();
				pointTete.reset();
				pointTete.setPose(true);
				gc.setStroke(Color.BLACK);
				gc.setLineWidth(1);
				gc.clearRect(0, 0, TAILLECANVAS, TAILLECANVAS);
				
				listeCommande = tk.tokenAnalyse(textCommande.getText());
				commande = new Commande(gc, pointTete, listeCommande);
				commande.drawLines();
				gc = commande.getGc();
				pointTete = commande.getTete();
			}
		});

		// Programmation Evenementielle
		clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gc.clearRect(0, 0, TAILLECANVAS, TAILLECANVAS);
				textCommande.clear();
				pointTete.reset();
				pointTete.setPose(true);
			}
		});

		quit.setOnMouseClicked(e -> {
			stage.close();
		});
		
		Scene scene = new Scene(fenetre);
		stage.setScene(scene);
		stage.setTitle("Bogo");
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
