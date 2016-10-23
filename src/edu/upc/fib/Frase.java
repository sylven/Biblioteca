package edu.upc.fib;

import java.util.Vector;

public class Frase {
    private Vector<Palabra> sentence;

    public Frase(String sentence) {
        String[] words = sentence.split("(?i)[\\w'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-]");
        this.sentence = new Vector();
        for (String s : words) {
            this.sentence.add(new Palabra(s));
        }
    }

    public void print() {
        for (Palabra w : sentence) {
            w.print();
        }
        System.out.println();
    }

    public void addParaula(String word) {
        sentence.addElement(new Palabra(word));
    }

    public String getParaula(int position) {
        return sentence.get(position).getString();
    }
}
