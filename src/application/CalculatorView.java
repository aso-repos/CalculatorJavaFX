package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorView implements Initializable {

    @FXML
    private Label digitLabel;
    @FXML
    private Label digitGlowLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Font.loadFont(getClass().getResourceAsStream("/CalcFont.ttf"), 12);
        String digitText = "12345678";
        digitLabel.setText(digitText);
        digitGlowLabel.setText(digitText);

    }
}
