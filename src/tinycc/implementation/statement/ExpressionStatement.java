package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class ExpressionStatement extends Statement {

    private final Locatable loc;
    private final Expression expression;

    public ExpressionStatement(Locatable loc, Expression expression) {
        this.loc = loc;
        this.expression = expression;
    }   


    // just return the expression as a string :
    

    @Override
    public String toString() {
        return expression.toString();
    }
}
