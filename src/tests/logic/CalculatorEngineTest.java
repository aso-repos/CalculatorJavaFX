package tests.logic;

import logic.CalculatorEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorEngineTest {

    @Test
    public void testAddition() {
        double result = CalculatorEngine.calculateResult(2, "3", "+");
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSubtraction() {
        double result = CalculatorEngine.calculateResult(15, "7", "-");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testMultiply() {
        double result = CalculatorEngine.calculateResult(17, "11", "*");
        assertEquals(187.0, result, 0.001);
    }

    @Test
    public void testDivision () {
        double result = CalculatorEngine.calculateResult(45, "10", "/");
        assertEquals(4.5, result, 0.001);
    }

}
