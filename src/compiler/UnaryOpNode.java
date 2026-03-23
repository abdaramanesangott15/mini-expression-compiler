package compiler;

public class UnaryOpNode extends Node {
    public Token op;
    public Node expr;

    public UnaryOpNode(Token op, Node expr) {
        this.op = op;
        this.expr = expr;
    }
}
