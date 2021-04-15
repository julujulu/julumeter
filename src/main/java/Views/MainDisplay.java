package Views;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainDisplay extends Application {

    /**
     * loads first scene of application.
     * @param primaryStage stage
     * @throws IOException exception.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/StartScene.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        primaryStage.setTitle("JULU METER");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * main method.
     * @param args parameter
     */
    public static void main(String[] args) {
        launch(args);
    }
}
