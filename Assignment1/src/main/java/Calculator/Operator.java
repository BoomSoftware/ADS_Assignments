package Calculator;

public class Operator extends Token{
    private final Operation operation;

    public Operator(Operation value){
        this.operation = value;
    }

    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public Operation getValue() {
        return operation;
    }
}
