package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class IfStatementimp extends Statement {
    private final Expression condition;
    private final Statement consequence;
    private final Statement alternative;
    private final Locatable loc;

    public IfStatementimp(Locatable loc, Expression condition, Statement consequence, Statement alternative) {
        this.condition = condition;
        this.consequence = consequence;
        this.alternative = alternative;
        this.loc = loc;
    }
    // just appending things to the string through a string builder:
    @Override
    public String toString() {

        

        StringBuilder building = new StringBuilder();

        building.append("If[");
        building.append(condition);
        building.append(",");
        building.append(consequence);
        if (alternative != null) {
            building.append(",")
                   .append(alternative);
        }
        building.append("]");
        return building.toString();
    }
}
