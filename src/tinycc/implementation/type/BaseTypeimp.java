package tinycc.implementation.type;

public class BaseTypeimp extends Type {
    private String typeString;

    public BaseTypeimp(String typeString) {
        this.typeString = typeString;
    }


    // just return it as a string as the following:

    @Override
    public String toString() {
        return "Type_" + typeString;
    }
}
