package Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorTest {

    private Operator operator;

    @BeforeEach
    void testSetUpOperator() {
        operator = new Operator(Operation.ADD);
    }

    @Test
    void testGetOperatorValue() {
        Assertions.assertEquals(Operation.ADD, operator.getValue());
    }

    @Test
    void testGetNewInstantiatedOperatorValue() {
        operator = new Operator(Operation.MULTIPLY);
        Assertions.assertEquals(Operation.MULTIPLY, operator.getValue());
    }
}