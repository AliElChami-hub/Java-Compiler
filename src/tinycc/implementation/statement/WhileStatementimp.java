package tinycc.implementation.statement;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Expression;

public class WhileStatementimp extends Statement {
    private final Locatable loc;
    private final Expression cond;
    private final Statement body;
    // the constructor :

    public WhileStatementimp(Locatable loc, Expression cond, Statement body) {
        this.loc = loc;
        this.cond = cond;
        this.body = body;
    }


    // appending things to the while string:

    @Override
    public String toString() {
        return "While[" + cond.toString() + ", " + body.toString() + "]";
    }
}
