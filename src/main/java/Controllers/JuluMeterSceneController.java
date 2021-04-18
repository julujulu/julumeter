package Controllers;


import java.io.IOException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JuluMeterSceneController {

    @FXML
    private Button berekenJuluButton;

    @FXML
    private TextField naamField;

    @FXML
    private Label juluLoadingLabel;

    @FXML
    private AnchorPane juluPane;
    
    @FXML
    public void initialize() {
        juluLoadingLabel.setVisible(false);
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
        juluLoadingLabel.setVisible(true);
        juluAnimatie();
        PauseTransition pause = new PauseTransition(Duration.seconds((int) (Math.random() * 3 + 2)));
        pause.setOnFinished(event ->
        {
            try {
                juluWisselScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
);
        pause.play();

    }


    public int juluCalculator() {
        return (int) (Math.random()*100);
    }

    public void juluWisselScene() throws IOException {
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

    public void juluAnimatie() {
        Image superJulu = new Image(getClass().getResourceAsStream("/superjulu.jpeg"));
        Circle juluCirkel = new Circle(35);
        juluCirkel.setFill(new ImagePattern(superJulu));

            juluCirkel.relocate(100, 100);

            juluPane.getChildren().addAll(juluCirkel);

            final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
                double deltaX = 3;
                double deltaY = 3;

                @Override
                public void handle(final ActionEvent t) {
                    juluCirkel.setLayoutX(juluCirkel.getLayoutX() + deltaX);
                    juluCirkel.setLayoutY(juluCirkel.getLayoutY() + deltaY);

                    final Bounds bounds = juluPane.getBoundsInLocal();
                    final boolean atRightBorder = juluCirkel.getLayoutX() >= (bounds.getMaxX() - juluCirkel.getRadius());
                    final boolean atLeftBorder = juluCirkel.getLayoutX() <= (bounds.getMinX() + juluCirkel.getRadius());
                    final boolean atBottomBorder = juluCirkel.getLayoutY() >= (bounds.getMaxY() - juluCirkel.getRadius());
                    final boolean atTopBorder = juluCirkel.getLayoutY() <= (bounds.getMinY() + juluCirkel.getRadius());

                    if (atRightBorder || atLeftBorder) {
                        deltaX *= -1;
                    }
                    if (atBottomBorder || atTopBorder) {
                        deltaY *= -1;
                    }
                }
            }));

            loop.setCycleCount(Timeline.INDEFINITE);
            loop.play();
        }

    }

