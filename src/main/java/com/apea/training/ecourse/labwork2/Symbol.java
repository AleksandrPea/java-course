package com.apea.training.ecourse.labwork2;

public class Symbol {

    private char symbol;

    protected Symbol(char symbol) {
        this.symbol = symbol;
    }

    protected Symbol() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;
    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

    @Override
    public String toString() {
        return ""+symbol;
    }
}
