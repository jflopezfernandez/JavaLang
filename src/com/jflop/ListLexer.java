package com.jflop;

public class ListLexer extends Lexer {
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;

    public static String[] tokenNames = {
            "n/a",
            "<EOF>",
            "NAME",
            "COMMA",
            "LBRACK",
            "RBRACK"
    };

    public String getTokenName(int x) {
        return tokenNames[x];
    }

    public ListLexer(String input) {
        super(input);
    }

    boolean isLetter() {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }

    Token NAME() {
        StringBuilder buffer = new StringBuilder();

        do {
            buffer.append(c);
            consume();
        } while (isLetter());

        return new Token(NAME, buffer.toString());
    }

    void ConsumeWhitespace() {
        while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
            consume();
        }
    }

    public Token nextToken() {
        while (c != EOF) {
            switch (c) {
                case ' ': case '\t': case '\n': case '\r': ConsumeWhitespace(); continue;
                case ',': consume(); return new Token(COMMA, ",");
                case '[': consume(); return new Token(LBRACK, "[");
                case ']': consume(); return new Token(RBRACK, "]");

                default:
                    if (isLetter()) { return NAME(); }

                    throw new Error("Invalid character: " + c);
            }
        }

        return new Token(EOF_TYPE, "<EOF>");
    }
}
