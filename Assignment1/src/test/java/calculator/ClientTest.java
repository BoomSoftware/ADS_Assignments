package calculator;

import Exceptions.EmptyListException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.LinkedList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    private CalculatorVisitor calculatorVisitor;

    @BeforeEach
    void setUpCalculatorVisitor()
    {
         client = new Client(calculatorVisitor);
    }

    @Test
    void testEvaluateExpression() {

        ArrayList<Token> tokens = new ArrayList<>();
        Assertions.assertThrows(EmptyListException.class, () -> client.evaluateExpression(tokens));
    }
}