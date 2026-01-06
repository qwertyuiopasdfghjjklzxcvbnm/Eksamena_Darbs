package service;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
	public class MainService extends Application {
		@Override
public void start(Stage primaryStage) {
			try {
				HBox root = new HBox();
				root.getChildren().add(new Button("Nospied mani!"));
				Scene scene = new Scene(root,400,400);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			launch(args);
		}
}