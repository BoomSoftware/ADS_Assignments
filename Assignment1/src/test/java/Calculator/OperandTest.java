package Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperandTest {

    private Operand operand;
    private int value;

    @BeforeEach
    void testSetUpOperand() {
        value = 15;
        operand = new Operand(value);
    }

    @Test
    void  testGetOperandValue() {
        Assertions.assertEquals(value, operand.getValue());
    }

    @Test
    void testGetNewInstantiatedOperandValue() {
        int tempValue = 1143;

        operand = new Operand(tempValue);
        Assertions.assertEquals(tempValue, operand.getValue());
    }
}