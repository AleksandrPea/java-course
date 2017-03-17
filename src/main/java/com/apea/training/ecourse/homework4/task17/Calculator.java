package com.apea.training.ecourse.homework4.task17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String OPERAND_REGEX = "(\\d+[*/])?\\s*\\d+";
    private static final String OPERATION_REGEX = "\\s*[*/+\\-]\\s*";
    private static final String SIMPLE_EXPR_REGEX =
            OPERAND_REGEX+OPERATION_REGEX+OPERAND_REGEX;
    private static final String EXPR_REGEX =
            OPERAND_REGEX + OPERATION_REGEX +"\\(?"+ SIMPLE_EXPR_REGEX+"\\)?";



    private Calculator() {}

    public static Operation parseExpression(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("null expression");
        }

        return null;
    }

//    private static Operation parse(String expression) {
//
//    }

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile(SIMPLE_EXPR_REGEX).matcher("4*(50+25)");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
