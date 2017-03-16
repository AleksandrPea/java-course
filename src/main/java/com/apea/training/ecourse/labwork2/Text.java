package com.apea.training.ecourse.labwork2;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Text {

    private static final String SENTENCE_REGEX = "\\s*[^.!?]*[.!?]+";

    private List<Sentence> sentences;

    private Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public static Text createText(Sentence[] sentencesArr) {
        if (sentencesArr == null) {
            throw new IllegalArgumentException("Null array");
        }
        List<Sentence> sentenceList = new ArrayList<>();
        Collections.addAll(sentenceList, sentencesArr);
        if (sentenceList.contains(null)) {
            throw new IllegalArgumentException("Null sentence");
        }
        return new Text(sentenceList);
    }

    public static Text createText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null string");
        }
        return parseText(text);
    }

    private static Text parseText(String text) {
        Matcher m = Pattern.compile(SENTENCE_REGEX).matcher(text);
        List<Sentence> sentenceList = new ArrayList<>();
        while (m.find()) {
            sentenceList.add(Sentence.createSentence(m.group()));
        }
        return new Text(sentenceList);
    }

    /** for each word find number of occurrences in specified sentence */
    public List<Integer> findOccurrencesIn(int sentenceIndex, List<Word> wordList) {
        if (sentenceIndex < 0 || sentenceIndex >= sentences.size()) {
            throw new IllegalArgumentException("Wrong index");
        }
        if (wordList == null || wordList.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        return wordList.stream()
                .map(w -> sentences.get(sentenceIndex).findOccurrences(w))
                .collect(Collectors.toList());
    }

    public List<Integer> findOverallOccurrences(List<Word> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        return wordList.stream()
                .map(w -> sentences.stream()
                        .map(s -> s.findOccurrences(w))
                        .reduce(0, (i1, i2) -> i1 + i2))
                .collect(Collectors.toList());
    }

    public void sortOnOccurrences(List<Word> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }
        List<Integer> occurrences = findOverallOccurrences(wordList);

        List<Word> sortedList = IntStream.range(0, wordList.size())
                .mapToObj(i -> new Pair<>(wordList.get(i), occurrences.get(i)))
                .sorted((p1, p2) -> p2.getValue() - p1.getValue())
                .map(Pair::getKey)
                .collect(Collectors.toList());
        wordList.clear();
        wordList.addAll(sortedList);
    }

    public Sentence[] getSentences() {
        Sentence[] sentenceArr = new Sentence[sentences.size()];
        return sentences.toArray(sentenceArr);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.toString());
        }
        return result.toString();
    }
}
