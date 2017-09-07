package tray;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
  public void start(Stage primaryStage) throws Exception
  {
    Parent root = (Parent)FXMLLoader.load(getClass().getResource("playing.fxml"));
    
    primaryStage.setResizable(false);
    primaryStage.setScene(new Scene(root));
    primaryStage.sizeToScene();
    
    primaryStage.setTitle("Notification tester");
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}
