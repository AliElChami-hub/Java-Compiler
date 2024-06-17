package tinycc.implementation.expression;

public class UnaryExpressionimp extends Expression {
    private final String operator;
    private final Expression operand;


    // the constructor:

    public UnaryExpressionimp(String operator, Expression operand) {
        this.operator = operator;
        this.operand = operand;
    }
    // just the unary string :
    @Override
    public String toString() {
        return operator + "[" + operand.toString() + "]";
    }
}
