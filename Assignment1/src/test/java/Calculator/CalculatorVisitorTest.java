package Calculator;

import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorVisitorTest {

    private CalculatorVisitor calculatorVisitor;

    @BeforeEach
    void setUpCalculatorVisitor()
    {
        calculatorVisitor = new CalculatorVisitor();
    }

    @Test
    void testGetResultEmptyStack()
    {
        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultValidSubtractExpression() throws MalformedExpressionException {
        int value1 = 6;
        int value2 = 18;
        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operator(Operation.SUBTRACT));

        Assertions.assertEquals(value1 - value2, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultValidMultiplyExpression() throws MalformedExpressionException {
        int value1 = 6;
        int value2 = 18;
        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operator(Operation.MULTIPLY));

        Assertions.assertEquals(value1 * value2, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultValidAddExpression() throws MalformedExpressionException {
        int value1 = 6;
        int value2 = 18;
        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertEquals(value1 + value2, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultValidDivideExpression() throws MalformedExpressionException {
        int value1 = 50;
        int value2 = 5;
        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operator(Operation.DIVIDE));

        Assertions.assertEquals(value1 / value2, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultWithOnlyOperator() {
        calculatorVisitor.visit(new Operator(Operation.DIVIDE));
        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultInvalidExpressionOneOperand() {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultWithoutOperator() throws MalformedExpressionException {
        int value1 = 55;
        int value2 = 55;
        int value3 = 55;

        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operand(value3));

        Assertions.assertEquals(value3, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultDivisionByZero()
    {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operand(0));
        calculatorVisitor.visit(new Operator(Operation.DIVIDE));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultWithMoreThanTwoOperands() throws MalformedExpressionException {
        int value1 = 55;
        int value2 = 55;
        int value3 = 55;

        calculatorVisitor.visit(new Operand(value1));
        calculatorVisitor.visit(new Operand(value2));
        calculatorVisitor.visit(new Operand(value3));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertEquals(value2 + value3, calculatorVisitor.getResult());
    }

    @Test
    void testGetResultNoOperands()
    {
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }
}