package main;

import java.io.*;

import lexer.*;

public class Main {
    public static void main(String[] args) {
        try {

            // Lexico lex = new Lexico(new FileReader("source.txt"));
            Lexico lex = new Lexico(new FileReader("test.txt"));

            Token token;
            while ((token = lex.nextToken()).getType() != 0)
                System.out.println("Token: " + token.getType() + "\tLexema: " + token.getText());

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
