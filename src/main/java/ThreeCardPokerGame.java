import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;

/*
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.canvas.*; 
import javafx.scene.web.*; 
import javafx.scene.layout.*; 
import javafx.scene.image.*; 
import java.io.*; 
import javafx.geometry.*; 
import javafx.scene.Group;
*/



public class ThreeCardPokerGame extends Application {

	Player playerOne;
	Player playerTwo;
	Dealer theDealer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Let's Play Three Card Poker!!!");

	}

}


		//Background background = new Background(new BackgroundImage(new Image("/home/gueejla/UIC/342/Homework/Project2/CS342Project2/src/main/resources/ponay2.jpg")));
//
//
/*
		Button btn = new Button();
		btn.setText("Say yeet");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("yaat");
			}
		});

		//BorderPane myPane = new BorderPane();


		Image image = new Image("ponay2.jpg");
		ImageView background = new ImageView();

		background.setFitHeight(600);
		background.setFitWidth(1200);
		
		//root.setBackground(new Background(new BackgroundImage(defaultBackground)));

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		root.setBackground(new Background(new BackgroundImage()));
		Scene scene = new Scene(root,600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	
*/
