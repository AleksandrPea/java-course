package com.apea.training.ecourse.labwork2;

import java.util.*;

public class Sentence {

    private List<Word> words;
    private List<SentenceMark> marks;

    private Sentence(List<Word> words, List<SentenceMark> marks) {
        this.words = words;
        this.marks = marks;
    }

    public static Sentence createSentence(Word[] wordArr, SentenceMark[] markArr) {
        if (wordArr == null || markArr == null) {
            throw new IllegalArgumentException("Null array");
        }
        List<Word> wordList = new ArrayList<>();
        Collections.addAll(wordList, wordArr);
        List<SentenceMark> markList = new ArrayList<>();
        Collections.addAll(markList, markArr);
        if (wordList.contains(null) || markList.contains(null)) {
            throw new IllegalArgumentException("Null word or punctuation mark");
        }
        return new Sentence(wordList, markList);
    }

    public static Sentence createSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Null string");
        }
        return parseSentence(sentence);
    }

    private static Sentence parseSentence(String sentence) {
        String refinedSentence = sentence.replaceAll("[\\t ]+", " ");
        List<SentenceMark> markList = new ArrayList<>();
        List<Word> wordList = new ArrayList<>();
        char[] chars = refinedSentence.toCharArray();
        int cursor = 0;
        while (cursor < chars.length && SentenceMark.isPunctuationMark(chars[cursor])) {
            markList.add(SymbolFactory.getInstance().getPunctuationMark(chars[cursor]));
            cursor++;
        }
        int wordStartIndex = cursor;
        while (wordStartIndex < chars.length) {
            while (cursor < chars.length && !SentenceMark.isPunctuationMark(chars[cursor])) {
                cursor++;
            }
            wordList.add(Word.createWord(chars, wordStartIndex, cursor));
            markList.add(SentenceMark.WORD_MARK);
            while (cursor < chars.length && SentenceMark.isPunctuationMark(chars[cursor])) {
                markList.add(SymbolFactory.getInstance().getPunctuationMark(chars[cursor]));
                cursor++;
            }
            wordStartIndex = cursor;
            cursor++;
        }
        return new Sentence(wordList, markList);
    }

    public int findOccurrences(Word word) {
        if (word == null) {
            throw new IllegalArgumentException("Null word");
        }
        return (int)words.stream()
                .filter(w -> w.equals(word))
                .count();
    }

    public boolean isEmpty() {
        return words.size() == 0 && marks.size() == 0;
    }

    public Word[] getWords() {
        Word[] wordArr = new Word[words.size()];
        return words.toArray(wordArr);
    }

    public SentenceMark[] getMarks() {
        SentenceMark[] markArr = new SentenceMark[marks.size()];
        return marks.toArray(markArr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (!words.equals(sentence.words)) return false;
        return marks.equals(sentence.marks);
    }

    @Override
    public int hashCode() {
        int result = words.hashCode();
        result = 31 * result + marks.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Iterator<Word> wordIter = words.iterator();
        for (SentenceMark mark : marks) {
            if (mark.isWordMark()) {
                result.append(wordIter.next().toString());
            } else {
                result.append(mark.toString());
            }
        }
        return result.toString();
    }
}
