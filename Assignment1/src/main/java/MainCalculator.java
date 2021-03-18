import Calculator.*;

import java.util.ArrayList;

public class MainCalculator {
    public static void main(String[] args) throws Exception {
        CalculatorVisitor visitor = new CalculatorVisitor();
        Client client = new Client(visitor);

        ArrayList<Token> tokens = new ArrayList<>();

        // Addition
        tokens.add(new Operand(3));
        tokens.add(new Operand(7));
        tokens.add(new Operator(Operation.ADD));

        // Subtraction
        tokens.add(new Operand(7));
        tokens.add(new Operator(Operation.SUBTRACT));

        // Multiplication
        tokens.add(new Operand(5));
        tokens.add(new Operator(Operation.MULTIPLY));

        // Division
        tokens.add(new Operand(3));
        tokens.add(new Operator(Operation.DIVIDE));

        System.out.println("Total result: " + client.evaluateExpression(tokens));
    }
}
