package tinycc.implementation.expression;

public class Binaryimp extends Expression {
    private final String operator;
    private final Expression left;
    private final Expression right;

    // the constructor of the thinggg:

    public Binaryimp(String operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    // just a tostring thing that does as the tests lmaoooo:

    

    @Override
    public String toString() {
        return  "Binary_" + operator + "["  + left.toString() + "," +  right.toString() + "]";
    }
    
    
}
