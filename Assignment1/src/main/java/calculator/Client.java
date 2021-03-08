package calculator;

import java.util.ArrayList;

public class Client {
    private CalculatorVisitor calculatorVisitor;

    public Client(CalculatorVisitor calculatorVisitor){
        this.calculatorVisitor = calculatorVisitor;
    }


    public int evaluateExpression(ArrayList<Token> list) throws Exception {
        for(Token token : list) {
            token.accept(calculatorVisitor);
        }

        return calculatorVisitor.getResult();
    }
}
