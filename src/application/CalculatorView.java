/* Class for setting up the logic for the calculator button and screen layout and interaction */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorView implements Initializable {

    @FXML
    private Label digitLabel;
    @FXML
    private Label digitGlowLabel;

    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button plusButton;
    @FXML
    private Button minusButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button equalsButton;
    @FXML
    private Button pointButton;
    @FXML
    private Button acButton;
    @FXML
    private Button cButton;
    @FXML
    private Button mrButton;
    @FXML
    private Button squarerootButton;
    @FXML
    private Button percentButton;

    private String currentInput = "";
    private String initialDisplay = "0.";
    private String operator = "";    // Holds operatyor value (+, -, X, / etc.).
    private double firstOperand = 0;   // Create double from first display string.
    private boolean isEnteringSecondOperand = false; // Sets the state for entering second value.

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Font.loadFont(getClass().getResourceAsStream("/CalcFont.ttf"), 12);
        String digitText = "0.";
        digitLabel.setText(digitText);
        digitGlowLabel.setText(digitText);
    }

    @FXML
    public void oneClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "1";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("1");
    }

    @FXML
    public void twoClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "2";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("2");
    }

    @FXML
    public void threeClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "3";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("3");
    }

    @FXML
    public void fourClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "4";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("4");

    }

    @FXML
    public void fiveClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "5";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("5");
    }

    @FXML
    public void sixClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "6";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("6");
    }

    @FXML
    public void sevenClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "7";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("7");
    }

    @FXML
    public void eightClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "8";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("8");
    }

    @FXML
    public void nineClicked (ActionEvent event) {

        if (currentInput.length() < 8) {
            currentInput += "9";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("9");
    }

    @FXML
    public void zeroClicked (ActionEvent event) {

        if (currentInput.length() < 8 && currentInput.length() > 0) {
            currentInput += "0";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("0");
    }

    @FXML
    public void plusClicked (ActionEvent event) {

        firstOperand = Double.parseDouble(currentInput);
        operator = "+";
        isEnteringSecondOperand = true;


        System.out.println("+");
    }

    @FXML
    public void minusClicked (ActionEvent event) {

        System.out.println("-");
    }

    @FXML
    public void multiplyClicked (ActionEvent event) {

        System.out.println("X");
    }

    @FXML
    public void divideClicked (ActionEvent event) {

        System.out.println("\u00F7");
    }

    @FXML
    public void equalsClicked (ActionEvent event) {

        System.out.println("=");
    }

    @FXML
    public void pointClicked (ActionEvent event) {

        if (initialDisplay.equals("0.") && currentInput.equals("")) {
            currentInput += "0.";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
            } else if (currentInput.length() < 8  && !currentInput.contains(".")) {
            currentInput += ".";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println(".");
    }

    @FXML
    public void acClicked (ActionEvent event) {

        System.out.println("AC");
    }

    @FXML
    public void cClicked (ActionEvent event) {

        System.out.println("C");
    }

    @FXML
    public void mrClicked (ActionEvent event) {

        System.out.println("MR");
    }

    @FXML
    public void squarerootClicked (ActionEvent event) {

        System.out.println("\u221A");
    }

    @FXML
    public void percentClicked (ActionEvent event) {

        System.out.println("%");

    }
}
