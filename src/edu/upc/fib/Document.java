package edu.upc.fib;

import javax.print.Doc;
import java.util.*;

public class Document {
    private Author mAuthor;
    private Sentence mTitle;
    private Content mContent;
    private Vector<String> mConnectorWords;

    private Hashtable<String, Double> mWordFrequency; // Frecuencia de cada palabra en este documento
    private Hashtable<String, Double> mWordsWeight; // Peso de cada palabra en este documento
    //private HashMap<Document, Integer> mSimilarDocuments; // Documentos parecidos a este

    public Document(Author author, String title, Vector<String> content, Vector<String> connectorWords) {
        mAuthor = author;
        mTitle = new Sentence(title);
        mContent = new Content(content);
        mConnectorWords = connectorWords;
        calculateWordFrequency();
    }

    public void calculateWordFrequency() {
        mWordFrequency = mContent.getWordFrequency(mConnectorWords);
    }

    public void calculateWordsWeight(Hashtable<String, Double> inverseDocumentFrequency) {
        Hashtable<String, Double> newWordsWeight = new Hashtable<>();
        for (Map.Entry<String, Double> entry : inverseDocumentFrequency.entrySet()) {
            mWordsWeight.put(entry.getKey(), mWordFrequency.get(entry.getKey()) * entry.getValue());
        }
        mWordsWeight = newWordsWeight;
    }

    public Sentence getTitle() {
        return mTitle;
    }

    public Content getContent() {
        return mContent;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public void setTitle(Sentence title) {
        mTitle = title;
    }

    public void setContent(Content content) {
        mContent = content;
        calculateWordFrequency();
    }

    public Hashtable<String, Double> getWordFrequency() {
        return mWordFrequency;
    }


//    public void calculateInverseDocumentFrequency() {
//        for(Map.Entry<String, Integer> word : mWordFrequency.entrySet()) {
//
//            mWordsWeight.put(word.getKey(), Math.log10(mDocuments.size()/word.getValue()));
//        }
//    }
//


}