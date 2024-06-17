package tinycc.implementation.expression;

import java.util.List;

public class CallExpression extends Expression {
    private final Expression callee;
    private final List<Expression> arguments;

    public CallExpression(Expression callee, List<Expression> arguments) {
        this.callee = callee;
        this.arguments = arguments;
    }


    // just as the tests, working with the Stringbuilder and appending things to it:
    

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Call[");
        build.append(callee.toString());
        for (Expression arg : arguments) {
            build.append(", ").append(arg.toString());
        }
        build.append("]");
        return build.toString();
    }
}
