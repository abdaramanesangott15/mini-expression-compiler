package compiler;

import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int pos;
    private Token currentToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.pos = 0;
        this.currentToken = tokens.get(pos);
    }

    private void eat(Token.Type type) {
        if (currentToken.type == type) {
            pos++;
            currentToken = tokens.get(pos);
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken.value);
        }
    }

    public Node parse() {
        Node node = expr();

        if (currentToken.type != Token.Type.EOF) {
            throw new RuntimeException("Unexpected token at end: " + currentToken.value);
        }

        return node;
    }

    private Node expr() {
        Node node = term();

        while (currentToken.type == Token.Type.PLUS || currentToken.type == Token.Type.MINUS) {
            Token op = currentToken;
            eat(op.type);
            node = new BinaryOpNode(node, op, term());
        }

        return node;
    }

    private Node term() {
        Node node = factor();

        while (currentToken.type == Token.Type.MUL || currentToken.type == Token.Type.DIV) {
            Token op = currentToken;
            eat(op.type);
            node = new BinaryOpNode(node, op, factor());
        }

        return node;
    }

    private Node factor() {
        Token token = currentToken;

        if (token.type == Token.Type.PLUS) {
            eat(Token.Type.PLUS);
            return new UnaryOpNode(token, factor());
        }

        if (token.type == Token.Type.MINUS) {
            eat(Token.Type.MINUS);
            return new UnaryOpNode(token, factor());
        }

        if (token.type == Token.Type.NUMBER) {
            eat(Token.Type.NUMBER);
            return new NumberNode(Integer.parseInt(token.value));
        }

        if (token.type == Token.Type.LPAREN) {
            eat(Token.Type.LPAREN);
            Node node = expr();
            eat(Token.Type.RPAREN);
            return node;
        }

        throw new RuntimeException("Invalid syntax at token: " + token.value);
    }
}
