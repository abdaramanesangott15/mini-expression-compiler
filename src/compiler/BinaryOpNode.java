package compiler;

public class BinaryOpNode extends Node {
    public Node left;
    public Token op;
    public Node right;

    public BinaryOpNode(Node left, Token op, Node right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
