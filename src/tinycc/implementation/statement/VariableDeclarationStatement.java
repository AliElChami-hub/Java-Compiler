package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;
import tinycc.implementation.type.Type;

public class VariableDeclarationStatement extends Statement {
    private final Type type;
    private final String name;
    private final Expression initialization;

    // constructor for the class:

    public VariableDeclarationStatement(Type type, String name, Expression initialization) {
        this.type = type;
        this.name = name;
        this.initialization = initialization;
    }



    // variable declaration and checking if null babyyyyy:

    @Override
    public String toString() {
        StringBuilder building = new StringBuilder();
        if(initialization == null){

            building.append("Declaration_");
            building.append(name).append("[");
            building.append(type).append("]");
        return building.toString();
        }
        building.append("Declaration_");
        building.append(name).append("[");
        building.append(type).append(",").append(initialization).append("]");
        return building.toString();
    }
}
