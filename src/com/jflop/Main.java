
package com.jflop;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, IndexOutOfBoundsException {
        if (args.length == 0) {
            System.out.println("<No arguments passed in>");
        } else {
            System.out.println(args.length + " arguments passed in!\n");

            for (String arg : args) {
                System.out.println(arg);
            }
        }

//        ListLexer lexer = new ListLexer(args[0]);
//        Token token = lexer.nextToken();
//
//        while (token.type != Lexer.EOF_TYPE) {
//            System.out.println(token);
//            token = lexer.nextToken();
//        }
//
//        System.out.println(token);
    }
}
