package calculator;

public class Operand extends Token {
    private int value;

    public void accept(CalculatorVisitor visitor) {
        super.accept(visitor);
    }
}
