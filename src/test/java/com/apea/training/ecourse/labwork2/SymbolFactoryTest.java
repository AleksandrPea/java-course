package com.apea.training.ecourse.labwork2;

import org.junit.Assert;
import org.junit.Test;

public class SymbolFactoryTest {

    private SymbolFactory factory = SymbolFactory.getInstance();

    @Test
    public void getSymbolTest() {
        Symbol s1 = factory.getSymbol('a');
        Symbol s2 = factory.getSymbol('a');
        Assert.assertSame(s1, s2);
    }

    @Test
    public void getPunctSymbolTest() {
        SentenceMark sm1 = (SentenceMark) factory.getSymbol('.');
        SentenceMark sm2 = (SentenceMark) factory.getSymbol('.');
        Assert.assertSame(sm1, sm2);
    }

    @Test
    public void getPunctuationMarkTest() {
        SentenceMark sm1 = factory.getPunctuationMark('.');
        SentenceMark sm2 = factory.getPunctuationMark('.');
        Assert.assertSame(sm1, sm2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionGetPunctuationMarkTest() {
        factory.getPunctuationMark('a');
    }

    @Test
    public void getSymbolsTest() {
        Symbol[] symbols = factory.getSymbols(new char[]{'a', ' ', 'd', 'o', 'g', '!'},
                1, 6);
        Assert.assertArrayEquals(new Symbol[]{
                    new SentenceMark(' '), new Symbol('d'),
                    new Symbol('o'), new Symbol('g'), new SentenceMark('!')},
                symbols);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSymbolsWithNullTest() {
        factory.getSymbols(null, 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSymbolsWithWrondIndicesTest() {
        factory.getSymbols(new char[]{'a', 'b'}, -5, 25);
    }
}
