package package_modele;

import javafx.application.Application;
import javafx.stage.Stage;
import package_vue.InterfaceVue;

public class ApplicationMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ModeleBogo modele = ModeleBogo.getInstance(new PointModele(0,0,0));
		InterfaceVue vue = new InterfaceVue(modele);
	}
	
	public static void main(String args[]){
		Application.launch(args);
	}

}
