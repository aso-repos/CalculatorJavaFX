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
    private String operator = "";    // Holds operator value (+, -, X, / etc.).
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

        appendDigit("1");
        System.out.println("1");
    }

    @FXML
    public void twoClicked (ActionEvent event) {

        appendDigit("2");
        System.out.println("2");
    }

    @FXML
    public void threeClicked (ActionEvent event) {

        appendDigit("3");
        System.out.println("3");
    }

    @FXML
    public void fourClicked (ActionEvent event) {

        appendDigit("4");
        System.out.println("4");

    }

    @FXML
    public void fiveClicked (ActionEvent event) {

        appendDigit("5");
        System.out.println("5");
    }

    @FXML
    public void sixClicked (ActionEvent event) {

        appendDigit("6");
        System.out.println("6");
    }

    @FXML
    public void sevenClicked (ActionEvent event) {

        appendDigit("7");
        System.out.println("7");
    }

    @FXML
    public void eightClicked (ActionEvent event) {

        appendDigit("8");
        System.out.println("8");
    }

    @FXML
    public void nineClicked (ActionEvent event) {

        appendDigit("9");
        System.out.println("9");
    }

    @FXML
    public void zeroClicked (ActionEvent event) {

        appendDigit("0");
        System.out.println("0");
    }

    @FXML
    public void plusClicked (ActionEvent event) {

        addOperator("+");
    }

    @FXML
    public void minusClicked (ActionEvent event) {

        addOperator("-");
    }

    @FXML
    public void multiplyClicked (ActionEvent event) {

        addOperator("*");;
    }

    @FXML
    public void divideClicked (ActionEvent event) {

        addOperator("/");;
    }

    @FXML
    public void equalsClicked (ActionEvent event) {

        if (!isEnteringSecondOperand && !operator.isEmpty()) {
            double result = calculateResult(firstOperand, currentInput, operator);
            currentInput = formatResult(result);
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);

            operator = "";
            isEnteringSecondOperand = true;
        }

        System.out.println("=");
    }

    @FXML
    public void pointClicked (ActionEvent event) {

        if (initialDisplay.equals("0.") && currentInput.equals("")) {
            currentInput += "0.";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
            } else if (isEnteringSecondOperand) {
            currentInput = "0.";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
            isEnteringSecondOperand = false;
            } else if (currentInput.length() < 8  && !currentInput.contains(".")) {
            currentInput += ".";
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println(".");
    }

    @FXML
    public void acClicked (ActionEvent event) {

        currentInput = "";
        operator = "";
        firstOperand = 0;
        digitLabel.setText(initialDisplay);
        digitGlowLabel.setText(initialDisplay);
        isEnteringSecondOperand = false;

        System.out.println("AC");
    }

    @FXML
    public void cClicked (ActionEvent event) {

        currentInput = "";
        digitLabel.setText(initialDisplay);
        digitGlowLabel.setText(initialDisplay);


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

    // Helper method for numeric digit logic and behavior when clicked.
    public void appendDigit (String digit) {
        if (isEnteringSecondOperand) {
            currentInput = "";
            isEnteringSecondOperand = false;
        }

        if (digitLabel.getText().equals("0.") && currentInput.isEmpty()) {
            currentInput = "";
        }

        if (currentInput.length() < 8) {
            currentInput += digit;
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }
    }

    public void addOperator (String opValue) {
        if (!operator.isEmpty()) {
            double result = calculateResult(firstOperand, currentInput, operator);
            firstOperand = result;
            currentInput = formatResult(result);
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        } else {
            firstOperand = Double.parseDouble(currentInput);
        }

        operator = opValue;
        isEnteringSecondOperand = true;

        System.out.println(opValue);
    }

    public double calculateResult (double leftOperand, String rightOperand, String op) {
        rightOperand = rightOperand.replace(',', '.');
        Double right = Double.parseDouble(rightOperand);
        switch (op.charAt(0)) {
            case '+':
                return leftOperand + right;
            case '-':
                return leftOperand - right;
            case '*':
                return leftOperand * right;
            case '/':
                return right != 0 ? leftOperand / right : 0;
            default:
                return 0;
        }
    }

    // Remove decimal from display if no decimal values
    private String formatResult (double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        } else {
            return String.format("%.7f", value).replaceAll("0+$", "").replaceAll("\\.$", "");
        }
    }
}
