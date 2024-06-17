package tinycc.implementation.type;

import java.util.List;

public class FunctionTypeimp extends Type {
    private final Type returnType;
    private final List<Type> parameters;

    public FunctionTypeimp(Type returnType, List<Type> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
    }   



    // using stringbuilder and appending things to it according to the size of the paramaters:
    

    @Override
    public String toString() {
        StringBuilder building = new StringBuilder();
        building.append("FunctionType[");
        building.append(returnType);
        for (Type param : parameters) {
            building.append(", ").append(param);
        }
        building.append("]");
        return building.toString();
    }
}
