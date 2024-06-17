package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class ReturnStatement extends Statement {
    private final Locatable loc;
    private final Expression expression;

    public ReturnStatement(Locatable loc, Expression expression) {
        this.loc = loc;
        this.expression = expression;
    }


    // appending the stuff and checking if the expression is not null:

    @Override
    public String toString() {

        
        StringBuilder building = new StringBuilder();
        building.append("Return[");
        if (expression != null) {
            building.append(expression.toString());
        }
        building.append("]");
        return building.toString();
    }
}
