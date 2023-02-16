package org.learn;

import org.junit.jupiter.api.Test;
import org.learn.unitTesting.model.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Red -> Green -> Refactor -> Repeat
// write a failing test
// write application code to make the unit test pass
// refactor: clean up. improve unit test & application code
// repeat: repeat these 3 steps for the next piece of functionality

public class CalculatorTest {

    @Test
    void integerDivision() {
        Calculator calc = new Calculator();
        int result = calc.integerDivision(4, 2);
        assertEquals(2, result, "Integer Division Failed");
    }
}
