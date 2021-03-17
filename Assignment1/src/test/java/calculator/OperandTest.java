package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandTest {

    private Operand operand;
    private int number1;
    private int number2;

    @BeforeEach
    void testSetUpOperand() {
        number1 = 1;
        number2 = 2;
        operand = new Operand(number1);
    }

    @Test
    void testAccept() {
        operand = new Operand(number2);
        Assertions.assertEquals(number2, operand.getValue());
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(number1, operand.getValue());
    }
}