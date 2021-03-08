package calculator;

import interfaces.Calculator;
import interfaces.Visitor;
import stack.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator {

    private final LinkedStack<Token> tokenStack;

    public CalculatorVisitor(){
        tokenStack = new LinkedStack<>();
    }

    @Override
    public int getResult() throws Exception {
        int result = 0;
        if(tokenStack.isEmpty()){
            return result;
        }else{
            result = ((Operand)tokenStack.pop()).getValue();
        }
        return result;
    }

    @Override
    public void visit(Operand operand) {
        tokenStack.push(operand);
    }

    @Override
    public void visit(Operator operator) {
        try{
            if(!tokenStack.isEmpty()){
                performOperation(operator);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void performOperation(Operator operator) throws Exception {
            int right = ((Operand)tokenStack.pop()).getValue();
            int left = ((Operand)tokenStack.pop()).getValue();

            int result = 0;

            switch (operator.getValue()) {
                case ADD:
                    result = left + right;
                    break;
                case SUBTRACT:
                    result = left - right;
                    break;
                case MULTIPLY:
                    result = left * right;
                    break;
                case DIVIDE:
                    if(right == 0){
                        throw new Exception("Dividing by 0 is forbidden");
                    }
                    result = left / right;
                    break;
            }

            pushOperand(new Operand(result));
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }
}
