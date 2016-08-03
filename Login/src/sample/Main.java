package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Sign in");
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.getChildren().add(button);     //set button as one of hBox's nodes

		//Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		gridPane.add(hBox, 1, 4);           //把hBox放在gridPane中的第1列，第4行


		//content in gripPane
		Text sceneTitle = new Text("Welcome, Username == Password");
		sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 22));
		gridPane.add(sceneTitle, 0, 0, 2, 1);

		//创建Label对象，并将其放在第0列，第1行
		Label usernameLabel = new Label("Username: ");
		gridPane.add(usernameLabel, 0, 1);

		//创建文本输入框，并将其放在第1列，第1行
		TextField userTextField = new TextField();
		gridPane.add(userTextField, 1, 1);

		Label passwordLabel = new Label("Password: ");
		gridPane.add(passwordLabel, 0, 2);
		PasswordField passwordField = new PasswordField();
		gridPane.add(passwordField, 1, 2);


		final Text actionTarget = new Text();       //用于显示信息的文本
		gridPane.add(actionTarget, 1, 6);
		//For debug purpose
		//gridPane.setGridLinesVisible(true);


		//Handle Event
		button.setOnKeyTyped("ENTER");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (userTextField.getText().equals(passwordField.getText())){
					actionTarget.setFill(Color.GREEN);
					actionTarget.setText("Login Success~~~");
				}else {
					System.out.println(userTextField.getText());
					System.out.println(passwordField.getText());
					actionTarget.setFill(Color.FIREBRICK);
					actionTarget.setText("Login Error");
				}
			}
		});

		primaryStage.setTitle("JavaFX Welcome");
		primaryStage.setScene(new Scene(gridPane, 500, 300));       //set gridPane as a root node
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
