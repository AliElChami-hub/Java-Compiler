package tinycc.implementation.expression;

import tinycc.parser.Token;

public class CondExp extends Expression {
    private final Expression condition;
    private final Expression consequence;
    private final Expression alternative;
    private final Token token;

    // constructor for the class:

    public CondExp(Token token, Expression condition, Expression consequence, Expression alternative) {
        this.token = token;
        this.condition = condition;
        this.consequence = consequence;
        this.alternative = alternative;
    }

    
    // the to string for the condition expression just like the if statement:
    @Override
    public String toString() {
        
        StringBuilder building = new StringBuilder();
        building.append("If[");
        building.append(condition);
        building.append(",")
               .append(consequence);
        if (alternative != null) {
            building.append(",")
                   .append(alternative);
        }
        building.append("]");
        return building.toString();
    }
}
