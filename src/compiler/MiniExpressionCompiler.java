package compiler;

import java.util.List;
import java.util.Scanner;

public class MiniExpressionCompiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Expression: ");
        String input = scanner.nextLine();

        try {
            Tokenizer tokenizer = new Tokenizer(input);
            List<Token> tokens = tokenizer.tokenize();

            System.out.println("Tokens: " + tokens);

            Parser parser = new Parser(tokens);
            Node tree = parser.parse();

            System.out.println("Parse: SUCCESS");

            printTree(tree, "", true);

            Evaluator evaluator = new Evaluator();
            int result = evaluator.evaluate(tree);

            System.out.println("Evaluation Result: " + result);

        } catch (Exception e) {
            System.out.println("Parse: FAILED");
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printTree(Node node, String indent, boolean last) {

        if (node instanceof NumberNode) {
            System.out.println(indent + (last ? "└── " : "├── ") + ((NumberNode) node).value);
            return;
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode u = (UnaryOpNode) node;
            System.out.println(indent + (last ? "└── " : "├── ") + u.op.value);
            printTree(u.expr, indent + "    ", true);
            return;
        }

        if (node instanceof BinaryOpNode) {
            BinaryOpNode b = (BinaryOpNode) node;

            System.out.println(indent + (last ? "└── " : "├── ") + b.op.value);

            printTree(b.left, indent + "    ", false);
            printTree(b.right, indent + "    ", true);
        }
    }
}
