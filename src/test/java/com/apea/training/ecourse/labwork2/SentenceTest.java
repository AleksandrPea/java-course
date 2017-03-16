package com.apea.training.ecourse.labwork2;

import org.junit.Assert;
import org.junit.Test;

public class SentenceTest {

    @Test(expected = IllegalArgumentException.class)
    public void createSentenceNullArrTest() {
        Sentence.createSentence(new Word[0], null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createSentenceNullElementTest() {
        Sentence.createSentence(new Word[0], new SentenceMark[]{null});
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseSentenceWithNullTest() {
        Sentence.createSentence(null);
    }

    @Test
    public void parseEmptySentenceTest() {
        Sentence sentence = Sentence.createSentence("");
        Word[] words = sentence.getWords();
        SentenceMark[] marks = sentence.getMarks();
        Assert.assertEquals(0, words.length);
        Assert.assertEquals(0, marks.length);
    }

    @Test
    public void isEmptyTest() {
        Sentence sentence = Sentence.createSentence("");
        Assert.assertTrue(sentence.isEmpty());
    }

    @Test
    public void parseSentenceTest() {
        Sentence sentence = Sentence.createSentence("  My name - is Aleks!! \t");
        Word[] words = sentence.getWords();
        SentenceMark[] marks = sentence.getMarks();
        Assert.assertArrayEquals(new Word[]{
                    Word.createWord(("My")),
                    Word.createWord("name"),
                    Word.createWord("is"),
                    Word.createWord("Aleks")},
                words);
        SymbolFactory factory = SymbolFactory.getInstance();
        Assert.assertArrayEquals(new SentenceMark[]{
                    factory.getPunctuationMark(' '),
                        SentenceMark.WORD_MARK,
                    factory.getPunctuationMark(' '),
                        SentenceMark.WORD_MARK,
                    factory.getPunctuationMark(' '),
                    factory.getPunctuationMark('-'),
                    factory.getPunctuationMark(' '),
                        SentenceMark.WORD_MARK,
                    factory.getPunctuationMark(' '),
                        SentenceMark.WORD_MARK,
                    factory.getPunctuationMark('!'),
                    factory.getPunctuationMark('!'),
                    factory.getPunctuationMark(' ')
                },
                marks);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findOccurrencesWithNullTest() {
        Sentence sentence = Sentence.createSentence("  My name - is Aleks!! \t");
        sentence.findOccurrences(null);
    }

    @Test
    public void findOccurrencesTest() {
        Sentence sentence = Sentence.createSentence("Tree  trees tree, tree:: treemap - tree");
        Word word = Word.createWord("tree");
        Assert.assertEquals(3, sentence.findOccurrences(word));
    }

    @Test
    public void toStringTest() {
        Sentence sentence = Sentence.createSentence("  My name - is Aleks!! \t");
        Assert.assertEquals(" My name - is Aleks!! ", sentence.toString());
    }
}
