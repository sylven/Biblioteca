package edu.upc.fib;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Vector;

public class Content {
    private Vector<Sentence> mContent;

    public Content(Vector<String> content) {
        mContent = new Vector<>();
        for (String s : content) {
            mContent.add(new Sentence(s));
        }
    }

    public Hashtable<String, Integer> getWordFrequency(Vector<String> connectorWords){
        Hashtable<String, Integer> wordFrequency = new Hashtable<>();
        for (Sentence sentence : mContent) {
            for (int i = 0; i < sentence.getSize(); i++) {
                String word = sentence.getWord(i);
                // Si no es una palabra funcional y su longitud es mayor a 1 carácter => la guardamos
                if(!connectorWords.contains(word) && word.length() > 1) {
                    if (wordFrequency.containsKey(word)) {
                        wordFrequency.put(word, wordFrequency.get(word) + 1);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
            }
        }
        return wordFrequency;
    }

    public Vector<String> toStrings() {
        Vector<String> vContent = new Vector<>();
        for (Sentence sentence : mContent) {
            vContent.add(sentence.toString());
        }
        return vContent;
    }
}