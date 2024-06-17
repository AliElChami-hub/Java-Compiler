package tinycc.implementation.type;

public class PointerTypeimp extends Type {
    private final Type pointsTo;

    public PointerTypeimp(Type pointsTo) {
        this.pointsTo = pointsTo;
    }



    // pointer changed to a string:


    @Override
    public String toString() {
        return "Pointer[" + pointsTo.toString() + "]";
    }
}
