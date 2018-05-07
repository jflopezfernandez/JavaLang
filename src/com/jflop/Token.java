package com.jflop;

public class Token {
    public int type;
    public String text;

    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String toString() {
        String tokenName = ListLexer.tokenNames[type];

        return "<'" + text + "''" + tokenName + ">";
    }
}
