package compiler;

public class Evaluator {

    public int evaluate(Node node) {

        if (node instanceof NumberNode) {
            return ((NumberNode) node).value;
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode u = (UnaryOpNode) node;
            int val = evaluate(u.expr);
            if (u.op.type == Token.Type.MINUS) return -val;
            return val;
        }

        if (node instanceof BinaryOpNode) {
            BinaryOpNode b = (BinaryOpNode) node;

            int left = evaluate(b.left);
            int right = evaluate(b.right);

            switch (b.op.type) {
                case PLUS: return left + right;
                case MINUS: return left - right;
                case MUL: return left * right;
                case DIV: return left / right;
            }
        }

        throw new RuntimeException("Invalid node");
    }
}
