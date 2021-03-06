package calculator;

public class Operator extends Token{
    private Operator operator;

    public void accept(CalculatorVisitor visitor) {
        super.accept(visitor);
    }
}
