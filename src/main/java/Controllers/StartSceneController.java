package Controllers;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class StartSceneController {

    @FXML
    private Button startButton;

    public void start(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/JuluMeterScene.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("JULU METER");
        stage.setScene(new Scene(root));
        stage.show();

        Stage prevStage = (Stage) startButton.getScene().getWindow();
        prevStage.hide();
    }
}
