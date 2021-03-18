package Calculator;

import Exceptions.MalformedExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ClientTest {

    private Client client;

    @BeforeEach
    void setUpCalculatorVisitor()
    {
         CalculatorVisitor calculatorVisitor = new CalculatorVisitor();
         client = new Client(calculatorVisitor);
    }

    @Test
    void testEvaluateEmptyExpression() {
        ArrayList<Token> tokens = new ArrayList<>();
        Assertions.assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokens));
    }

    @Test
    void testNotEmptyEvaluateExpression() throws Exception {
        ArrayList<Token> tokens = new ArrayList<>();

        int value1 = 3;
        int value2 = 7;

        tokens.add(new Operand(3));
        tokens.add(new Operand(7));
        tokens.add(new Operator(Operation.ADD));

        Assertions.assertEquals(value1 + value2, client.evaluateExpression(tokens));
    }

//    All test connected to expressions can be found in CalculatorVisitorTest
}