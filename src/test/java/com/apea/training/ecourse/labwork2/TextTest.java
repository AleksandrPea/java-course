package com.apea.training.ecourse.labwork2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TextTest {

    private Text text;
    private List<Word> wordList;

    public TextTest() {
        this.text = Text.createText("doggy is dog. puppy and puppy are dog. dog is not a cat!");
        this.wordList = new ArrayList<>();
        wordList.add(Word.createWord("dog"));
        wordList.add(Word.createWord("doggy"));
        wordList.add(Word.createWord("puppy"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createTextNullElementTest() {
        Text.createText(new Sentence[]{null});
    }

    @Test
    public void parseEmptyTextTest() {
        Text text = Text.createText("");
        Sentence[] sentences = text.getSentences();
        Assert.assertEquals(0, sentences.length);
    }

    @Test
    public void parseTextTest() {
        String textStr =
                ". My name is Aleks  .\n" +
                ",How do you   do??" +
                "\n\tExcellent\t\t!!!";
        Text text = Text.createText(textStr);
        Sentence[] sentencesActual = text.getSentences();
        Sentence[] sentencesExpected = new Sentence[]{
                Sentence.createSentence("."),
                Sentence.createSentence(" My name is Aleks  ."),
                Sentence.createSentence("\n,How do you   do??"),
                Sentence.createSentence("\n\tExcellent\t\t!!!")};
        Assert.assertArrayEquals(sentencesExpected, sentencesActual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOccurrencesInWithNullTest() {
        text.findOccurrencesIn(0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOveralOccurrencesWithNullTest() {
        text.findOverallOccurrences(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortOnOccurrencesWithNullTest() {
        text.sortOnOccurrences(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOccurrencesInWithEmptyTest() {
        text.findOccurrencesIn(0, new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOveralOccurrencesWithEmptyTest() {
        text.findOverallOccurrences(new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortOnOccurrencesWithEmptyTest() {
        text.sortOnOccurrences(new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOccurrencesInWrongIndexTest() {
        text.findOccurrencesIn(-5, new ArrayList<Word>(){{add(Word.createWord("A"));}});
    }

    @Test
    public void findOccurrencesInTest() {
        Assert.assertEquals(new ArrayList<Integer>(){{add(1);add(1);add(0);}},
            text.findOccurrencesIn(0, wordList));
    }

    @Test
    public void findOveralOccurrencesTest() {
        Assert.assertEquals(new ArrayList<Integer>(){{add(3);add(1);add(2);}},
                text.findOverallOccurrences(wordList));
    }

    @Test
    public void sortOnOccurrencesTest() {
        List<Word> words = new ArrayList<>();
        words.addAll(wordList);
        text.sortOnOccurrences(words);
        Assert.assertEquals(new ArrayList<Word>(){{
            add(Word.createWord("dog"));add(Word.createWord("puppy"));add(Word.createWord("doggy"));;
        }}, words);
    }

    @Test
    public void toStringTest() {
        String textStr =
                ". My name is Aleks  .\n" +
                ",How do you   do??" +
                "\n\tExcellent\t\t!!!";
        Text text = Text.createText(textStr);
        String textStrExpected =
                ". My name is Aleks .\n" +
                ",How do you do??" +
                "\n Excellent !!!";
        Assert.assertEquals(textStrExpected, text.toString());
    }
}
