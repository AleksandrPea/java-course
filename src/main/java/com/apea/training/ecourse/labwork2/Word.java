package com.apea.training.ecourse.labwork2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {

    private List<Symbol> symbols;

    private Word(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public static Word createWord(Symbol[] symbolsArr) {
        if (symbolsArr == null) {
            throw new IllegalArgumentException("Null array");
        }
        List<Symbol> symbolList = new ArrayList<>();
        Collections.addAll(symbolList, symbolsArr);
        if (symbolList.contains(null)) {
            throw new IllegalArgumentException("Null sentence");
        }
        return new Word(symbolList);
    }

    public static Word createWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Null string");
        }
        return createWord(word.toCharArray());
    }

    public static Word createWord(char[] word) {
        return createWord(word, 0, word.length);
    }

    public static Word createWord(char[] charArr, int from, int to) {
        List<Symbol> symbolList = new ArrayList<>();
        Collections.addAll(symbolList, SymbolFactory.getInstance().getSymbols(charArr, from ,to));
        return new Word(symbolList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return symbols.equals(word.symbols);
    }

    @Override
    public int hashCode() {
        return symbols.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : symbols) {
            result.append(symbol.toString());
        }
        return result.toString();
    }
}
