package tinycc.parser;

import java.util.List;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.Binaryimp;
import tinycc.implementation.expression.CallExpression;
import tinycc.implementation.expression.CondExp;
import tinycc.implementation.expression.Expression;
import tinycc.implementation.expression.Primexpimp;
import tinycc.implementation.expression.UnaryExpressionimp;
import tinycc.implementation.statement.BlockStatementimp;
import tinycc.implementation.statement.ExpressionStatement;
import tinycc.implementation.statement.IfStatementimp;
import tinycc.implementation.statement.ReturnStatement;
import tinycc.implementation.statement.Statement;
import tinycc.implementation.statement.VariableDeclarationStatement;
import tinycc.implementation.statement.WhileStatementimp;
import tinycc.implementation.type.BaseTypeimp;
import tinycc.implementation.type.FunctionTypeimp;
import tinycc.implementation.type.PointerTypeimp;
import tinycc.implementation.type.Type;


public class Astimp implements ASTFactory{

    @Override
public Statement createBlockStatement(Locatable loc, List<Statement> statements) {
    return new BlockStatementimp(loc, statements);
}

@Override
public Statement createDeclarationStatement(Type type, Token name, Expression init) {
    // Create a new VariableDeclarationStatement with the provided type, name, and initialization expression
    return new VariableDeclarationStatement(type, name.getText(), init);
}





@Override
public Statement createExpressionStatement(Locatable loc, Expression expression) {
    return new ExpressionStatement(loc, expression);
}


@Override
public Statement createIfStatement(Locatable loc, Expression condition, Statement consequence, Statement alternative) {
    return new IfStatementimp(loc, condition, consequence, alternative);
}


@Override
public Statement createReturnStatement(Locatable loc, Expression expression) {
    return new ReturnStatement(loc, expression);
}


@Override
public Statement createWhileStatement(Locatable loc, Expression condition, Statement body) {
    return new WhileStatementimp(loc, condition, body);
}


    @Override
public Type createFunctionType(Type returnType, List<Type> parameters) {
    return new FunctionTypeimp(returnType, parameters);
}


    @Override
    public Type createPointerType(Type pointsTo) {
        return new PointerTypeimp(pointsTo);
    }
    

    @Override
public Type createBaseType(TokenKind kind) {
    // Convert the TokenKind to a corresponding type string
    String typeString;
    switch (kind) {
        case INT:
            typeString = "int";
            break;
        case CHAR:
            typeString = "char";
            break;
        case VOID:
            typeString = "void";
            break;
        default:
            throw new IllegalArgumentException("Invalid token kind: " + kind);
    }

    // Create a new BaseType with the type string
    return new BaseTypeimp(typeString);
}


    @Override
public Expression createBinaryExpression(Token operator, Expression left, Expression right) {
    // Retrieve the operator's text from the Token
    String operatorText = operator.getText();
    
    // Create a new Binaryimp expression with the operator and operands
    return new Binaryimp(operatorText, left, right);
}

    

@Override
public Expression createCallExpression(Token token, Expression callee, List<Expression> arguments) {
    return new CallExpression(callee, arguments);
}


@Override
public Expression createConditionalExpression(Token token, Expression condition, Expression consequence, Expression alternative) {
   return new CondExp(token, condition, consequence, alternative);
}


    @Override
    public Expression createUnaryExpression(Token operator, boolean postfix, Expression operand) {
        String operatorText = operator.getText();
        if (operator.getKind() == TokenKind.SIZEOF) {
            return new UnaryExpressionimp("Unary_sizeof", operand);
        } else if (operator.getKind() == TokenKind.AND) {
            return new UnaryExpressionimp("Unary_&", operand);
        } else if (operator.getKind() == TokenKind.ASTERISK) {
            return new UnaryExpressionimp("Unary_*", operand);
        } else {
            throw new IllegalArgumentException("Unsupported unary operator: " + operatorText);
        }
    }
    


    @Override
    public Expression createPrimaryExpression(Token token) {
        String text = token.getText();
        if (token.getKind() == TokenKind.IDENTIFIER) {
            return new Primexpimp("Var_" + text);
        } else if (token.getKind() == TokenKind.CHARACTER) {
            return new Primexpimp("Const_'" + text + "'");
        } else if (token.getKind() == TokenKind.STRING) {
            return new Primexpimp("Const_\"" + text + "\"");
        } else {
            return new Primexpimp("Const_" + text);
        }
    }
    

    
    

    @Override
    public void createExternalDeclaration(Type type, Token name) {
        // Retrieve the type string and name from the objects
        String typeString = type.toString();
        String nameString = name.getText();
    
        // Print the external declaration
        System.out.println(typeString + " " + nameString + ";");
    }
    

    @Override
public void createFunctionDefinition(Type type, Token name, List<Token> parameterNames, Statement body) {
    // Retrieve the type string and name from the objects
    String typeString = type.toString();
    String nameString = name.getText();
    
    // Print the function definition
   System.out.print(typeString + " " + nameString + "(");
    
    // Print the parameter names
    for (int i = 0; i < parameterNames.size(); i++) {
        Token parameterName = parameterNames.get(i);
        System.out.print(parameterName.getText());
        if (i < parameterNames.size() - 1) {
            System.out.print(", ");
        }
    }
    
    System.out.println(") {");
    
    // Print the body of the function
    System.out.println(body.toString());
    
    System.out.println("}");
}

    
}
