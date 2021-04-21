package Controllers;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class JuluResultaatSceneController {

    private String naam;

    private int resultaat;

    @FXML
    private Label juluPercentageLabel;

    @FXML
    private Button opnieuwButton;

    @FXML
    private ImageView juluAchtergrond;


    public void initNaam(String naam) {
        this.naam = naam;
    }

    public void initResultaat(int resultaat) {
        this.resultaat = resultaat;
    }


    public void initialize(String naam, int resultaat) {
        Image julu = new Image(getClass().getResourceAsStream("/lachendeJulu.jpg"));
        Image superJulu = new Image(getClass().getResourceAsStream("/superjulu.jpeg"));
        Image gigachad = new Image(getClass().getResourceAsStream("/gigachad.jpg"));
        Image tjeeeeerd = new Image(getClass().getResourceAsStream("/tjeeeeerd.jpg"));

        if (naam.toLowerCase().trim().equals("julu")) {
            juluAchtergrond.setImage(superJulu);
            juluPercentageLabel.setText("JULU OVERLOAD 934934SADASDJNKQWKJ");
        }
        else if (naam.toLowerCase().trim().equals("erwin")) {
            juluAchtergrond.setImage(gigachad);
            juluPercentageLabel.setText("ERWIN: GEEN JULU DETECTED");
            juluPercentageLabel.setTextFill(Color.web("#FFFFFF"));
        }
        else if (naam.toLowerCase().trim().equals("tjeerd")) {
            juluAchtergrond.setImage(tjeeeeerd);
            juluPercentageLabel.setText("tjeerd%");
            juluPercentageLabel.setTextFill(Color.web("#FFFFFF"));
        }
        else if (resultaat >= 85) {
            juluAchtergrond.setImage(superJulu);
            juluPercentageLabel.setText(resultaat + "% HODEE " + naam.toUpperCase() + " IS KAOLO JULU");
        }
        else if (resultaat <= 15) {
            juluAchtergrond.setImage(gigachad);
            juluPercentageLabel.setText(resultaat + "% " + naam.toUpperCase() + " HEEFT WALOU JULU");
            juluPercentageLabel.setTextFill(Color.web("#FFFFFF"));
        }
        else {
            juluAchtergrond.setImage(julu);
        juluPercentageLabel.setText(naam.toUpperCase() + " IS " + resultaat + "% JULU");
        }

    }
    public void opnieuw() throws IOException {
        if (naam.toLowerCase().trim().equals("julu")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("JULU OVERLOAD");
            alert.setHeaderText(null);
            alert.setContentText("JULU OVERLOAD SYSTEM CLOSING");
            alert.showAndWait();
            System.exit(0);
        }
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/StartScene.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("JULU METER");
        stage.setScene(new Scene(root));
        stage.show();

        Stage prevStage = (Stage) opnieuwButton.getScene().getWindow();
        prevStage.hide();
    }
}
