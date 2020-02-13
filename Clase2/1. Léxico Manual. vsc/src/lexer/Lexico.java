/*
Añadir EN ESTE ORDEN:
- Constantes reales: 3.15, 78.23, ... (parte entera obligatoria/parte decimal OPCIONAL)
- Operadores aritméticos y otros simbolos:  + - * / . : = ; [ ] ( ) { } < >
- Palabras reservadas: if, while, read, write, int y real
*/

package lexer;

import java.io.*;

public class Lexico {
    // public static final int POR = '*';  // '*' -> 42
    public static final int INT_CONSTANT = 256;
    public static final int IDENT = 257;
    public static final int REAL_CONSTANT = 258;
    public static final int IF = 259;
    public static final int WHILE = 260;
    public static final int READ = 261;
    public static final int WRITE = 262;
    public static final int INT = 263;
    public static final int REAL = 264;

    private Reader input;
    private int currentChar;

    public Lexico(Reader reader) throws IOException {
        input = reader;
        readNext();
    }

    // Funciones auxiliares -------------------------------
    private int readNext() throws IOException {
        currentChar = input.read();
        return currentChar;
    }

    private int getChar() throws IOException {
        return currentChar;
    }

    // Aquí empieza el Analizador Léxico ------------------
    public Token nextToken() throws IOException {

        while (true) {
            while (Character.isWhitespace(getChar()))
                readNext();

            if (getChar() == -1)
                return new Token(0, null);

            if (getChar() == '+') {
                readNext();
                return new Token('+', "+");
            }
            
            if (getChar() == '-') {
                readNext();
                return new Token('-', "-");
            }
            
            if (getChar() == '*') {
                readNext();
                return new Token('*', "*");
            }
            
            if (getChar() == '/') {
                readNext();
                return new Token('/', "/");
            }
            
            if (getChar() == '.') {
                readNext();
                return new Token('.', ".");
            }
            
            if (getChar() == ':') {
                readNext();
                return new Token(':', ":");
            }
            
            if (getChar() == '=') {
                readNext();
                return new Token('=', "=");
            }
            
            if (getChar() == ';') {
                readNext();
                return new Token(';', ";");
            }
            
            if (getChar() == '[') {
                readNext();
                return new Token('[', "[");
            }
            
            if (getChar() == ']') {
                readNext();
                return new Token(']', "]");
            }
            
            if (getChar() == '(') {
                readNext();
                return new Token('(', "(");
            }
            
            if (getChar() == ')') {
                readNext();
                return new Token(')', ")");
            }
            
            if (getChar() == '{') {
                readNext();
                return new Token('{', "{");
            }
            
            if (getChar() == '}') {
                readNext();
                return new Token('}', "}");
            }
            
            if (getChar() == '<') {
                readNext();
                return new Token('<', "<");
            }
            
            if (getChar() == '>') {
                readNext();
                return new Token('>', ">");
            }

            if (Character.isDigit(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                while (Character.isDigit(readNext()))
                    buffer.append((char) getChar());
                if (getChar() == '.' && Character.isDigit(readNext())) {
            		buffer.append("." + (char) getChar());
            		while (Character.isDigit(readNext()))
                		buffer.append((char) getChar());
            		return new Token(REAL_CONSTANT, buffer.toString());
                }
                return new Token(INT_CONSTANT, buffer.toString());
            }
            
            if (Character.isLetter(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                while (Character.isLetter(readNext()))
                    buffer.append((char) getChar());
                switch (buffer.toString()) {
		            case "if":
		            	return new Token(IF, buffer.toString());
		            case "while":
		            	return new Token(WHILE, buffer.toString());
		            case "read":
		            	return new Token(READ, buffer.toString());
		            case "write":
		            	return new Token(WRITE, buffer.toString());
		            case "int":
		            	return new Token(INT, buffer.toString());
		            case "real":
		            	return new Token(REAL, buffer.toString());
		            default:
		            	while (Character.isLetterOrDigit(getChar())) {
		                    buffer.append((char) getChar());
		                    readNext();
		            	}
		                return new Token(IDENT, buffer.toString());
                }
            }

            /*if (Character.isLetter(getChar())) {
                StringBuffer buffer = new StringBuffer();
                buffer.append((char) getChar());
                while (Character.isLetterOrDigit(readNext()))
                    buffer.append((char) getChar());
                return new Token(IDENT, buffer.toString());
            }*/

            System.out.println("Error lexico: " + getChar());
            readNext();
        }
    }
}
