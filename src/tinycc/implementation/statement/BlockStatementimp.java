package tinycc.implementation.statement;


import java.util.List;

import tinycc.diagnostic.Locatable;

public class BlockStatementimp extends Statement {

    private Locatable loc;
    private List<Statement> statements;

    public BlockStatementimp(Locatable loc, List<Statement> statements) {
        this.loc = loc;
        this.statements = statements;
    }


    // appending the things through a for loop depending on the size of the statements:
    

    @Override
public String toString() {
     
    // since i am not going to use it anywhere i set the loc to null:
    loc = null;

    StringBuilder sb = new StringBuilder();
    sb.append("Block[");
    for (int i = 0; i < statements.size(); i++) {
        sb.append(statements.get(i).toString());
        if (i < statements.size() - 1) {
            sb.append(", ");
        }
    }
    sb.append("]");
    return sb.toString();
}


}
