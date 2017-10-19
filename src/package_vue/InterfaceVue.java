package package_vue;

import java.util.Observable;
import java.util.Observer;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import package_modele.ModeleBogo;

public class InterfaceVue implements Observer {

	private Stage stage = new Stage();
	private HBox fenetre = new HBox();
	private VBox groupeBoutonZoneDeSaisie = new VBox();
	private VBox groupeBouton = new VBox();
	private HBox boutonDeplacement = new HBox();
	private VBox interaction = new VBox();
	private HBox menu = new HBox();
	private Scene scene = new Scene(fenetre);
	private Button arriere = new Button();
	private Button avance = new Button();
	private Button droite = new Button();
	private Button gauche = new Button();
	private Button lever = new Button();
	private Button poser = new Button();
	private Button clear = new Button();
	private Button submit = new Button();
	private Button quit = new Button();
	private Canvas canvas = new Canvas();
	private TextArea textCommande = new TextArea();
	private TextArea valeurBouton = new TextArea();
	private Label valeurBoutonLabel = new Label();
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	private ModeleBogo modele;
	
	public InterfaceVue(ModeleBogo mb){
		modele = mb;
		modele.addObserver(this);
		
		Image imgArriere = new Image("File:sources_du_projet/ressources/arriere.png");
		arriere.setGraphic(new ImageView(imgArriere));
		arriere.setTooltip(new Tooltip("arriere"));

		Image imgAvance = new Image("File:sources_du_projet/ressources//avant.png");
		avance.setGraphic(new ImageView(imgAvance));
		avance.setTooltip(new Tooltip("avant"));

		Image imgDroite = new Image("File:sources_du_projet/ressources/droite.png");
		droite.setGraphic(new ImageView(imgDroite));
		droite.setTooltip(new Tooltip("droite"));

		Image imgGauche = new Image("File:sources_du_projet/ressources/gauche.png");
		gauche.setGraphic(new ImageView(imgGauche));
		gauche.setTooltip(new Tooltip("gauche"));

		Image imgLever = new Image("File:sources_du_projet/ressources/lever.png");
		lever.setGraphic(new ImageView(imgLever));
		lever.setTooltip(new Tooltip("lever le crayon"));

		Image imgPoser = new Image("File:sources_du_projet/ressources/poser.png");
		poser.setGraphic(new ImageView(imgPoser));
		poser.setTooltip(new Tooltip("poser le crayon"));

		Image imgClear = new Image("File:sources_du_projet/ressources/clear.png");
		clear.setGraphic(new ImageView(imgClear));
		clear.setTooltip(new Tooltip("effacer"));

		Image imgSubmit = new Image("File:sources_du_projet/ressources/submit.png");
		submit.setGraphic(new ImageView(imgSubmit));
		submit.setTooltip(new Tooltip("dessiner"));

		Image imgQuit = new Image("File:sources_du_projet/ressources/quit.png");
		quit.setGraphic(new ImageView(imgQuit));
		quit.setTooltip(new Tooltip("quitter"));
				
		menu.getChildren().addAll(clear, submit, quit);
		menu.setAlignment(Pos.BOTTOM_RIGHT);
		
		boutonDeplacement.getChildren().addAll(arriere, avance, gauche, droite, lever, poser);
		groupeBouton.getChildren().addAll(valeurBoutonLabel, valeurBouton, boutonDeplacement);
		
		interaction.setSpacing(0);
		interaction.getChildren().addAll(textCommande, menu);
		
		groupeBoutonZoneDeSaisie.setSpacing(20);
		groupeBoutonZoneDeSaisie.getChildren().addAll(groupeBouton, interaction);
		
		canvas.setWidth(modele.getTaillecanvas());
		canvas.setHeight(modele.getTaillecanvas());
		
		textCommande.setMinSize(100, 250);
		textCommande.setMaxSize(288, 290);
		textCommande.setFont(new Font("Trebuchet MS", 15));
		
		valeurBouton.setMaxWidth(287);
		valeurBouton.setMaxHeight(10);
		
		
		
		fenetre.setSpacing(10);
		fenetre.getChildren().addAll(canvas, groupeBoutonZoneDeSaisie);
		stage.setScene(scene);
		stage.setTitle("Bogo");
		stage.show();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
