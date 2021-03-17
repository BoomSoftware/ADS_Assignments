package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    private Operator operator;

    @BeforeEach
    void setUpOperator() {
        operator = new Operator(Operation.ADD);
    }

    @Test
    void accept() {
        operator = new Operator(Operation.MULTIPLY);
        Assertions.assertEquals(Operation.MULTIPLY, operator.getValue());
    }

    @Test
    void getValue() {
        Assertions.assertEquals(Operation.ADD, operator.getValue());
    }
}