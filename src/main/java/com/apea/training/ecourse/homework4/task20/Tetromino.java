package com.apea.training.ecourse.homework4.task20;

public enum Tetromino {

    I("iiii"),
    O("oo\noo"),
    T(" t\nttt"),
    J(" j\n j\njj"),
    L("l\nl\nll"),
    S(" ss\n s\nss"),
    Z("zz\n z\n zz"),

    SU("susu\n susu\n  susu\n   susu");

    private String form;

    private static double Psuper = 0.009;
    private static double Psimple = (1 - Psuper) / (Tetromino.values().length-1);

    Tetromino(String form) {
        this.form = form;
    }

    public String getForm() {return form;}

    public static Tetromino getRandomFigure() {
        double p = Math.random();
        Tetromino[] tetrominos = Tetromino.values();
        int i = 1;
        while (p > i*Psimple) {
            i++;
        }
        return tetrominos[i-1];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getRandomFigure().getForm());
        }
    }
}
