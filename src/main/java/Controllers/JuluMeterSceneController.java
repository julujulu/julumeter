package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class JuluMeterSceneController {

    @FXML
    private Button berekenJuluButton;

    @FXML
    private TextField naamField;

    @FXML
    public void initialize() {
        naamField.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                try {
                    berekenJulu();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void berekenJulu() throws IOException {
        int resultaat = juluCalculator();
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/JuluResultaatScene.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("JULU METER");
        stage.setScene(new Scene(root));
        JuluResultaatSceneController controller = loader.getController();
        controller.initNaam(naamField.getText());
        controller.initResultaat(resultaat);
        controller.initialize(naamField.getText(), resultaat);
        stage.show();

        Stage prevStage = (Stage) berekenJuluButton.getScene().getWindow();
        prevStage.hide();
    }


    public int juluCalculator() {
        return (int) (Math.random()*100);
    }
}
