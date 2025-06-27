/* Class for setting up the logic for the calculator button and screen layout and interaction */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
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
    private double memoryRecall = 0; // Stores the last result in memory
    private boolean isNegativeInputPending = false;

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

        if (currentInput.isEmpty() && operator.isEmpty()) {
            isNegativeInputPending = true;
            return;
        }

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

        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double result = calculateResult(firstOperand, currentInput, operator);
            memoryRecall = result;
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

        currentInput = formatResult(memoryRecall);
        digitLabel.setText(currentInput);
        digitGlowLabel.setText(currentInput);
        isEnteringSecondOperand = true;


        System.out.println("MR");
    }

    @FXML
    public void squarerootClicked (ActionEvent event) {

        Double result = Double.parseDouble(currentInput);
        if (result >= 0) {
            currentInput = formatResult(Math.sqrt(result));
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

        System.out.println("\u221A");
    }

    @FXML
    public void percentClicked (ActionEvent event) {

        if (!operator.isEmpty()) {
            double result = 0;
            double a = firstOperand;
            double b = Double.parseDouble(currentInput);

            switch (operator) {
                case "+":
                    result = a / (1 - b/100);
                    break;
                case "-":
                    result = a / (1 + b/100);
                    break;
                case "*":
                    result = a * (b/100);
                    break;
                case "/":
                    result = a / (b/100);
                    break;
            }

            currentInput = formatPercentResult(result);
            System.out.println("Formatted Result: " + currentInput);
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }

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

        if (currentInput.length() < 9) {
            currentInput += digit;
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        }
    }

    // Add logic for all operator buttons
    public void addOperator (String opValue) {

        if (!operator.isEmpty()) {
            double result = calculateResult(firstOperand, currentInput, operator);
            firstOperand = result;
            currentInput = formatResult(result);
            digitLabel.setText(currentInput);
            digitGlowLabel.setText(currentInput);
        } else {
            String input = currentInput;
            if (isNegativeInputPending) {
                input = "-" + input;
                isNegativeInputPending = false;
                digitLabel.setText(input);
                digitGlowLabel.setText(input);
            }
            firstOperand = Double.parseDouble(input);
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
        DecimalFormatSymbols symbols  = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.########", symbols);

        String formatted = df.format(value);
        return formatted.contains(".") ? formatted.replaceAll("0+$", "").replaceAll("\\.$", "") : formatted;
    }

    // Remove decimal from display if no decimal values when calculating
    private String formatPercentResult (double value) {
        // Force a decimal point to be "." instead of ","
        DecimalFormatSymbols symbols  = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.########", symbols);
        // Convert to a normal string
        String raw = df.format(value);

        if (raw.length() <= 8) {
            return raw;
        }

        // Trim decimal digits to fit 8 chars
        if (raw.contains(".")) {
            int integerLength = raw.indexOf(".");
            int decimalPlacesAllowed = 8 - integerLength - 1; // Minus 1 for decimal point

            if (decimalPlacesAllowed < 0) {
                // Not enough space for integer part
                return raw.substring(0, 8);
            }

            String format = "%." + decimalPlacesAllowed + "f";
            raw = String.format(format, value);

            // Deletes trailing zeros / points if present
            raw = raw.replaceAll("0+$", "").replaceAll("\\.$", "");
        }

        return raw.length() <= 8 ? raw : raw.substring(0, 8);
    }
}
