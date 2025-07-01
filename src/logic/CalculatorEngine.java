/* Class for handling the actual calculator logic, including the basic math logic,
determining and formatting results, etc.
 */

package logic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalculatorEngine {

    // Calculate the basic math operations
    public static double calculateResult (double leftOperand, String rightOperand, String op) {

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
    public static String formatResult (double value) {

        DecimalFormatSymbols symbols  = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.########", symbols);

        String formatted = df.format(value);
        return formatted.contains(".") ? formatted.replaceAll("0+$", "").replaceAll("\\.$", "") : formatted;
    }

    // Remove decimal from display if no decimal values when calculating
    public static String formatPercentResult (double value) {

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
