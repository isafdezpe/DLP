package main;

import org.antlr.v4.runtime.*;

import parser.*;

public class Main {
    public static final String program = "source.txt"; // Usar args[0] en la versi√≥n final

    public static void main(String[] args) throws Exception {

        Lexicon textLexer = new Lexicon(CharStreams.fromFileName("test.txt"));
        // Lexicon textLexer = new Lexicon(CharStreams.fromFileName("test.txt"));

        Token token;
        while ((token = textLexer.nextToken()).getType() != Lexicon.EOF) {
            System.out.print("Token: " + token.getType());
            System.out.print("\tLexema: " + token.getText());
            System.out.print("\tLÌnea: " + token.getLine());
            System.out.println("\tColumna: " + token.getCharPositionInLine());
        }

    }
}
