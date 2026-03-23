package compiler;

public class Token {
    public enum Type {
        NUMBER, PLUS, MINUS, MUL, DIV, LPAREN, RPAREN, EOF
    }

    public Type type;
    public String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
