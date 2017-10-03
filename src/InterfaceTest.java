import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InterfaceTest extends Application{
	static final int TAILLECANVAS = 300;
	
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

		//la Vbox interaction contient le text Field et tous les boutons
		VBox interaction = new VBox();

		//la Hbox Bouton contient les boutons d'interaction 
		HBox boutonDeplacement = new HBox();
		
		Button arriere=new Button();
		Image imgArriere=new Image(getClass().getResource("arriere.png").toExternalForm());
		arriere.setGraphic(new ImageView(imgArriere));
		arriere.setTooltip(new Tooltip("arriere"));		//les tooltip permettent de voir � quoi correspond un bouton en passant la souris dessus
		
		Button avance = new Button();
		Image imgAvance=new Image(getClass().getResource("avant.png").toExternalForm());
		avance.setGraphic(new ImageView(imgAvance));
		avance.setTooltip(new Tooltip("avant"));
		
		Button droite = new Button();
		Image imgDroite=new Image(getClass().getResource("droite.png").toExternalForm());
		droite.setGraphic(new ImageView(imgDroite));
		droite.setTooltip(new Tooltip("droite"));
		
		Button gauche = new Button();
		Image imgGauche=new Image(getClass().getResource("gauche.png").toExternalForm());
		gauche.setGraphic(new ImageView(imgGauche));
		gauche.setTooltip(new Tooltip("gauche"));
		
		Button lever = new Button();
		Image imgLever=new Image(getClass().getResource("lever.png").toExternalForm());
		lever.setGraphic(new ImageView(imgLever));
		lever.setTooltip(new Tooltip("lever le crayon"));
		
		Button poser = new Button();
		Image imgPoser=new Image(getClass().getResource("poser.png").toExternalForm());
		poser.setGraphic(new ImageView(imgPoser));
		poser.setTooltip(new Tooltip("poser le crayon"));

		//la Hbox Menu contient les boutons du bas de l'interface
		HBox menu = new HBox();
		
		Button clear = new Button();
		Image imgClear=new Image(getClass().getResource("clear.png").toExternalForm());
		clear.setGraphic(new ImageView(imgClear));
		clear.setTooltip(new Tooltip("effacer"));
		
		Button submit = new Button();
		Image imgSubmit=new Image(getClass().getResource("submit.png").toExternalForm());
		submit.setGraphic(new ImageView(imgSubmit));
		submit.setTooltip(new Tooltip("dessiner"));
		
		
		Button quit = new Button();
		Image imgQuit=new Image(getClass().getResource("quit.png").toExternalForm());
		quit.setGraphic(new ImageView(imgQuit));
		quit.setTooltip(new Tooltip("quitter"));
		
		menu.getChildren().addAll(clear,submit,quit);
		menu.setAlignment(Pos.BOTTOM_RIGHT);
		boutonDeplacement.getChildren().addAll(arriere,avance,gauche,droite,lever,poser);
		
		//CONFIGURATION DU TEXTAREA 
		textCommande.setMinSize(100, 250);
		textCommande.setMaxSize(288, 290);
		textCommande.setFont(new Font("Trebuchet MS", 15));
		interaction.getChildren().addAll(boutonDeplacement,textCommande,menu);

		//STREAMTOKENIZER

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
				System.out.println("Bouton detecte fin de submit");
				
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
		stage.setTitle("Bogo");
		stage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}


}
