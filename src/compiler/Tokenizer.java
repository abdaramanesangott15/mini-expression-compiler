package compiler;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private String text;
    private int pos;
    private char currentChar;

    public Tokenizer(String text) {
        this.text = text;
        this.pos = 0;
        this.currentChar = text.length() > 0 ? text.charAt(0) : '\0';
    }

    private void advance() {
        pos++;
        if (pos >= text.length()) {
            currentChar = '\0';
        } else {
            currentChar = text.charAt(pos);
        }
    }

    private void skipWhitespace() {
        while (currentChar == ' ') {
            advance();
        }
    }

    private String number() {
        StringBuilder result = new StringBuilder();
        while (Character.isDigit(currentChar)) {
            result.append(currentChar);
            advance();
        }
        return result.toString();
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while (currentChar != '\0') {

            if (currentChar == ' ') {
                skipWhitespace();
                continue;
            }

            if (Character.isDigit(currentChar)) {
                tokens.add(new Token(Token.Type.NUMBER, number()));
                continue;
            }

            if (currentChar == '+') {
                tokens.add(new Token(Token.Type.PLUS, "+"));
                advance();
                continue;
            }

            if (currentChar == '-') {
                tokens.add(new Token(Token.Type.MINUS, "-"));
                advance();
                continue;
            }

            if (currentChar == '*') {
                tokens.add(new Token(Token.Type.MUL, "*"));
                advance();
                continue;
            }

            if (currentChar == '/') {
                tokens.add(new Token(Token.Type.DIV, "/"));
                advance();
                continue;
            }

            if (currentChar == '(') {
                tokens.add(new Token(Token.Type.LPAREN, "("));
                advance();
                continue;
            }

            if (currentChar == ')') {
                tokens.add(new Token(Token.Type.RPAREN, ")"));
                advance();
                continue;
            }

            throw new RuntimeException("Invalid character: " + currentChar);
        }

        tokens.add(new Token(Token.Type.EOF, ""));
        return tokens;
    }
}
