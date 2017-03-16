package com.apea.training.ecourse.labwork2;

import java.util.HashMap;
import java.util.Map;

public class SymbolFactory {

    private Map<Character, Symbol> symbolMap = new HashMap<>();

    private static SymbolFactory instance = new SymbolFactory();

    private SymbolFactory() {}

    public static SymbolFactory getInstance() {return instance;}

    public Symbol getSymbol(char charr) {
        Symbol symbol = symbolMap.get(charr);
        if (symbol == null) {
            if (SentenceMark.isPunctuationMark(charr)) {
                symbol = new SentenceMark(charr);
            } else {
                symbol = new Symbol(charr);
            }
            symbolMap.put(charr, symbol);
        }
        return symbol;
    }

    public SentenceMark getPunctuationMark(char charr) {
        if (!SentenceMark.isPunctuationMark(charr)) {
            throw new IllegalArgumentException(charr+" is not a punctuation mark");
        }
        SentenceMark mark = (SentenceMark)symbolMap.get(charr);
        if (mark == null) {
            mark = new SentenceMark(charr);
            symbolMap.put(charr, mark);
        }
        return mark;
    }

    public Symbol[] getSymbols(char[] charArr) {
        return getSymbols(charArr, 0, charArr.length);
    }

    public Symbol[] getSymbols(char[] charArr, int from, int to) {
        if (charArr == null) {
            throw new IllegalArgumentException("Null arr");
        }
        if (from >= to || from < 0 || to > charArr.length) {
            throw new IllegalArgumentException("Wrong indices");
        }
        Symbol[] symbols = new Symbol[to - from];
        for (int i = from, j = 0; i < to; i++, j++) {
            symbols[j] = getSymbol(charArr[i]);
        }
        return symbols;
    }
}
