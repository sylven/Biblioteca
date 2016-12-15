package edu.upc.fib;

import java.io.Serializable;
import java.util.*;

public class Content implements Serializable {
    private Vector<Sentence> mContent;

    public Content(Vector<String> content) {
        mContent = new Vector<>();
        for (String s : content) {
            mContent.add(new Sentence(s));
        }
    }

    public Hashtable<String, Double> getWordFrequency(Vector<String> connectorWords){
        Hashtable<String, Double> wordFrequency = new Hashtable<>();
        double maxFrequency = 0;
        for (Sentence sentence : mContent) {
            for (int i = 0; i < sentence.getSize(); i++) {
                String word = sentence.getWord(i);
                // Si no es una palabra funcional y su longitud es mayor a 1 carácter => la guardamos
                if(!connectorWords.contains(word.toLowerCase()) && word.length() > 1) {
                    if (wordFrequency.containsKey(word)) {
                        wordFrequency.put(word.toLowerCase(), wordFrequency.get(word) + 1);
                    } else {
                        wordFrequency.put(word.toLowerCase(), (double) 1);
                    }
                    if (wordFrequency.get(word.toLowerCase()) > maxFrequency) {
                        maxFrequency = wordFrequency.get(word.toLowerCase());
                    }
                }
            }
        }
        for (Map.Entry<String, Double> entry : wordFrequency.entrySet()) {
            wordFrequency.replace(entry.getKey(), entry.getValue()/maxFrequency);
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