package edu.upc.fib;

public class Palabra {
    private String word;

    public Palabra(String word) {
        this.word = word;
    }

    public void print() {
        System.out.print(word);
    }

    public String getString() {
        return word;
    }

    public void setPalabra(String palabra) {
        this.word = word;
    }

}