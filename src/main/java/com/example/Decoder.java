package com.example;

public class Decoder {
    public void run(char[] alphabet, String expression) {
        for (int shift = 1; shift <= alphabet.length-1; shift++) {
            System.out.println("Shift: " + shift);
            System.out.println(getExpressionWithShift(alphabet, expression, shift));
            System.out.println();
        }
    }

    private String getExpressionWithShift(char[] alphabet, String expression, int shift) {
        StringBuilder expressionWithShift = new StringBuilder(expression.length());
        char symbol;
        for (int i = 0; i < expression.length(); i++) {
            symbol = expression.charAt(i);
            expressionWithShift.append(getSymbolWithShift(alphabet, symbol, shift));
        }
        return expressionWithShift.toString();
    }

    private char getSymbolWithShift(char[] alphabet, char symbol, int shift) {
        boolean isUpperCase = false;
        int positionOfLetterOnAlphabet;
        char symbolWithShift;
        if (!Character.isLetter(symbol)) {
            return symbol;
        }
        if (Character.isUpperCase(symbol)) {
            isUpperCase = true;
            symbol = Character.toLowerCase(symbol);
        }
        positionOfLetterOnAlphabet = getPositionOfLetterOnAlphabet(alphabet, symbol);
        symbolWithShift = getLetterFromAlphabetByShift(alphabet, positionOfLetterOnAlphabet, shift);
        if (isUpperCase) {
            symbolWithShift = Character.toUpperCase(symbolWithShift);
        }
        return symbolWithShift;
    }

    private int getPositionOfLetterOnAlphabet(char[] alphabet, char letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (letter == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }

    private char getLetterFromAlphabetByShift(char[] alphabet, int positionOfLetter, int shift) {
        int countOfLetters = alphabet.length;
        return alphabet[(positionOfLetter + shift) % countOfLetters];
    }
}
