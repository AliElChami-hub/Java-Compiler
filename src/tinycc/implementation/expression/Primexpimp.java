package tinycc.implementation.expression;

public class Primexpimp extends Expression {

    private String value;

    // the constructor:

    public Primexpimp(String value) {
        this.value = value;
    }

    // all the work is in the factory babbyyy:

    @Override
    public String toString() {
        return value;
    }

}

