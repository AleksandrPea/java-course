package com.apea.training.ecourse.labwork2;

/**
 * Represents punctuation mark or word mark. Word mark is abstraction
 * that helps to recover structure of sentence.
 */
public class SentenceMark extends Symbol {

    private static final String PUNCTUATION_REGEX = "[ .,!?:;\\-'\"{}\\[\\]/\\n]";

    public static final SentenceMark WORD_MARK = new SentenceMark();

    SentenceMark(char symbol) {
        super(symbol);
    }

    private SentenceMark() {}

    public boolean isWordMark() {
        return this == WORD_MARK;
    }

    public static boolean isPunctuationMark(char symbol) {
        return (""+symbol).matches(PUNCTUATION_REGEX);
    }
}
