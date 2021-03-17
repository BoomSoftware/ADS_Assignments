package calculator;

import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testGetResultInvalidExpression()
    {
        calculatorVisitor.visit(new Operand(5));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultValidExpression()
    {
        calculatorVisitor.visit(new Operand(6));
        calculatorVisitor.visit(new Operator(Operation.SUBTRACT));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultTwoOperands()
    {
        calculatorVisitor.visit(new Operand(3));
        calculatorVisitor.visit(new Operand(5));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
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
    void testGetResultMultiplicationByZero()
    {
        calculatorVisitor.visit(new Operand(6));
        calculatorVisitor.visit(new Operand(0));
        calculatorVisitor.visit(new Operator(Operation.MULTIPLY));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultNotEmpty()
    {
        calculatorVisitor.visit(new Operand(1));
        calculatorVisitor.visit(new Operand(2));
        calculatorVisitor.visit(new Operand(3));
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }

    @Test
    void testGetResultNoOperands()
    {
        calculatorVisitor.visit(new Operator(Operation.ADD));

        Assertions.assertThrows(MalformedExpressionException.class, () -> calculatorVisitor.getResult());
    }
}