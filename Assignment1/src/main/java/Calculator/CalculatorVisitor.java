package Calculator;

import Exceptions.EmptyStackException;
import Exceptions.MalformedExpressionException;
import Interfaces.Calculator;
import Interfaces.Visitor;
import Stack.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator {

    private final LinkedStack<Token> tokenStack;

    public CalculatorVisitor(){
        tokenStack = new LinkedStack<Token>();
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        try{
            return ((Operand)tokenStack.pop()).getValue();
        }
        catch (EmptyStackException e){
            throw new MalformedExpressionException("Error: Inserted expression is invalid!");
        }

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

    private void performOperation(Operator operator) throws MalformedExpressionException {
        try{

            Token tempRight = tokenStack.pop();
            Token tempLeft = tokenStack.pop();

            if(tempRight instanceof Operator || tempLeft instanceof  Operator) {
                throw new MalformedExpressionException("Error: Inserted expression is invalid!");
            }

            int right = ((Operand) tempRight).getValue();
            int left = ((Operand) tempLeft).getValue();

            int result;
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
                        throw new MalformedExpressionException("Dividing by 0 is forbidden");
                    }
                    result = left / right;
                    break;
                default:
                    throw new MalformedExpressionException("Error: Invalid operation type");
            }

            pushOperand(new Operand(result));
        }catch (EmptyStackException e) {
            throw new MalformedExpressionException("Error: Inserted expression is invalid!");
        }

    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }
}
