import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.event.EventHandler;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;


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
		
		playerOne = new Player();
		playerTwo = new Player();
		theDealer = new Dealer();

		playerOne.hand = theDealer.dealHand();
		playerTwo.hand = theDealer.dealHand();
		theDealer.dealersHand = theDealer.dealHand();

		ArrayList<ImageView> playerOneViews = new ArrayList<ImageView>();
		ArrayList<ImageView> playerTwoViews = new ArrayList<ImageView>();
		ArrayList<ImageView> dealerViews = new ArrayList<ImageView>();

		for (int i = 0; i < 3; i++) {
			String suitTemp = String.valueOf(playerOne.hand.get(i).suit);
			String valTemp = String.valueOf(playerOne.hand.get(i).value);
			String cardTemp = valTemp + suitTemp + ".jpg";
			ImageView imageViewTemp = new ImageView( new Image(cardTemp));
			imageViewTemp.setFitHeight(150);
			imageViewTemp.setPreserveRatio(true);
			imageViewTemp.relocate(i * 110 + 50, 500);
			playerOneViews.add(imageViewTemp);

			suitTemp = String.valueOf(playerTwo.hand.get(i).suit);
			valTemp = String.valueOf(playerTwo.hand.get(i).value);
			cardTemp = valTemp + suitTemp + ".jpg";
			imageViewTemp = new ImageView( new Image(cardTemp));
			imageViewTemp.setFitHeight(150);
			imageViewTemp.setPreserveRatio(true);
			imageViewTemp.relocate(i * 110 + 600, 500);
			playerTwoViews.add(imageViewTemp);

			suitTemp = String.valueOf(theDealer.dealersHand.get(i).suit);
			valTemp = String.valueOf(theDealer.dealersHand.get(i).value);
			cardTemp = valTemp + suitTemp + ".jpg";
			imageViewTemp = new ImageView( new Image(cardTemp));
			imageViewTemp.setFitHeight(150);
			imageViewTemp.setPreserveRatio(true);
			imageViewTemp.relocate(i * 110 + 350, 50);
			dealerViews.add(imageViewTemp);

		}

		
		Button playerOnePlay = new Button("Play");
		playerOnePlay.relocate(140, 700);
		Button playerOneFold = new Button("Fold");
		playerOneFold.relocate(240, 700);
		Button playerTwoPlay = new Button("Play");
		playerTwoPlay.relocate(690, 700);
		Button playerTwoFold = new Button("Fold");
		playerTwoFold.relocate(790, 700);

		playerOnePlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("yaat");
			}
		});

		TextField playerOneAnteField = new TextField("Ante Bid");
		playerOneAnteField.relocate(110, 400);
		TextField playerOnePairField = new TextField("PairPlus Bid");
		playerOnePairField.relocate(110, 450);
		TextField playerTwoAnteField = new TextField("Ante Bid");
		playerTwoAnteField.relocate(690, 400);
		TextField playerTwoPairField = new TextField("PairPlus Bid");
		playerTwoPairField.relocate(690, 450);

		Text announcePlayerOneResults = new Text(350, 240, "player 1 lose");
		announcePlayerOneResults.setStroke(Color.WHITE);
		announcePlayerOneResults.setFill(Color.WHITE);
		announcePlayerOneResults.setFont(Font.font("verdana", 20));
		Text announcePlayerTwoResults = new Text(350, 270, "lmao haha");
		announcePlayerTwoResults.setStroke(Color.WHITE);
		announcePlayerTwoResults.setFill(Color.WHITE);
		announcePlayerTwoResults.setFont(Font.font("verdana", 20));
		Text playerOneMoneyAmount = new Text(110, 380, "$10231");
		playerOneMoneyAmount.setStroke(Color.WHITE);
		playerOneMoneyAmount.setFill(Color.WHITE);
		playerOneMoneyAmount.setFont(Font.font("veradana", 20));
		Text playerTwoMoneyAmount = new Text(690, 380, "$69, Nice.");
		playerTwoMoneyAmount.setStroke(Color.WHITE);
		playerTwoMoneyAmount.setFill(Color.WHITE);
		playerTwoMoneyAmount.setFont(Font.font("veradana", 20));


		Menu menu = new Menu("Options");
		MenuItem exit = new MenuItem("Exit");
		MenuItem freshStart = new MenuItem("Fresh Start");
		MenuItem newLook = new MenuItem("NewLook");
		menu.getItems().add(exit);
		menu.getItems().add(freshStart);
		menu.getItems().add(newLook);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(menu);

		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: darkgreen;");

		pane.getChildren().addAll(playerOneViews);
		pane.getChildren().addAll(playerTwoViews);
		pane.getChildren().addAll(dealerViews);

		pane.getChildren().addAll(playerOnePlay);
		pane.getChildren().addAll(playerOneFold);
		pane.getChildren().addAll(playerTwoPlay);
		pane.getChildren().addAll(playerTwoFold);

		pane.getChildren().addAll(playerOneAnteField);
		pane.getChildren().addAll(playerOnePairField);
		pane.getChildren().addAll(playerTwoAnteField);
		pane.getChildren().addAll(playerTwoPairField);

		pane.getChildren().addAll(announcePlayerOneResults);
		pane.getChildren().addAll(announcePlayerTwoResults);
		pane.getChildren().addAll(playerOneMoneyAmount);
		pane.getChildren().addAll(playerTwoMoneyAmount);

		pane.getChildren().addAll(menuBar);


		//StackPane root = new StackPane();
		//root.getChildren().add(btn);
		Scene scene = new Scene(pane,600,1200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
