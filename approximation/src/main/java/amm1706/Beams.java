package amm1706;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Beams implements Initializable {
    @FXML
    ImageView imageBeams;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image1 = new Image(new ByteArrayInputStream(PlotGraphic.figure2));
        imageBeams.setImage(image1);
        imageBeams.setVisible(true);
    }
}
