package com.apea.training.ecourse;

import com.apea.training.ecourse.labwork2.Word;

public class Main {

    public static void main( String[] args ) {
        Word word = Word.createWord(("Hello ").toCharArray());
        String some = "  My name - is Aleks!! \t";
        String another = some.replaceAll("([\\t\\s])+", " ");
        System.out.println(another);
    }
}
