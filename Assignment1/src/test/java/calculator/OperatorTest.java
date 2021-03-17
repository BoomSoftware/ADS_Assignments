package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    private Operator operator;

    @BeforeEach
    void testSetUpOperator() {
        operator = new Operator(Operation.ADD);
    }

    @Test
    void testAccept() {
        operator = new Operator(Operation.MULTIPLY);
        Assertions.assertEquals(Operation.MULTIPLY, operator.getValue());
    }

    @Test
    void testGetValue() {
        Assertions.assertEquals(Operation.ADD, operator.getValue());
    }
}