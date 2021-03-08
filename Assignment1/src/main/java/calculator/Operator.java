package calculator;

public class Operator extends Token{
    private final Operation value;

    public Operator(Operation value){
        this.value = value;
    }

    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public Operation getValue() {
        return value;
    }
}
