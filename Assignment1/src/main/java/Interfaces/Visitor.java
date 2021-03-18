package Interfaces;

import Calculator.Operand;
import Calculator.Operator;

public interface Visitor {
    void visit(Operand operand);
    void visit(Operator operator);
}

