package com.apea.training.ecourse.labwork2;

import junit.framework.Assert;
import org.junit.Test;

public class WordTest {

    @Test(expected = IllegalArgumentException.class)
    public void createWordWithNullTest() {
        Word.createWord(new Symbol[]{new Symbol('a'), null});
    }

    @Test
    public void toStringTest() {
        Word word = Word.createWord("guys!");
        Assert.assertEquals("guys!", word.toString());
    }
}
