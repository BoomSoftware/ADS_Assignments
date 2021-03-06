package calculator;

import exceptions.MalformedExpressionException;
import interfaces.Calculator;
import interfaces.Visitor;
import stack.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedStack tokenStack;

    @Override
    public int getResult() throws MalformedExpressionException {
        return 0;
    }

    @Override
    public void visit(Operand operand) {

    }

    @Override
    public void visit(Operator operator) {

    }

    private void pushOperand(Operand operand) {

    }

    private void performOperation(Operator operator) throws MalformedExpressionException {

    }
}
