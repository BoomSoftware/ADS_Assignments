package interfaces;

import calculator.Operand;
import calculator.Operator;

public interface Visitor {
    void visit(Operand operand);
    void visit(Operator operator);
}

