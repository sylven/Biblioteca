package edu.upc.fib;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public class Document {
    private Author mAuthor;
    private Sentence mTitle;
    private Content mContent;
    private Vector<String> mConnectorWords;

    private Hashtable<String, Integer> mWordFrequency; // Frecuencia de cada palabra en este documento
    private Hashtable<String, Double> mWordsWeight; // Peso de cada palabra en este documento
    //private HashMap<Document, Integer> mSimilarDocuments; // Documentos parecidos a este

    public Document(Author author, String title, Vector<String> content, Vector<String> connectorWords) {
        mAuthor = author;
        mTitle = new Sentence(title);
        mContent = new Content(content);
        mConnectorWords = connectorWords;
        mWordFrequency = mContent.getWordFrequency(mConnectorWords);
    }

    public Sentence getTitle() {
        return mTitle;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }

    public void setTitle(Sentence title) {
        mTitle = title;
    }

    public void setContent(Content content) {
        mContent = content;
        mWordFrequency = mContent.getWordFrequency(mConnectorWords);
    }

    public Hashtable<String, Integer> getWordFrequency() {
        return mWordFrequency;
    }


//    public void updateWordWeight() {
//        for(Map.Entry<String, Integer> word : mWordFrequency.entrySet()) {
//
//            mWordsWeight.put(word.getKey(), Math.log10(mDocuments.size()/word.getValue()));
//        }
//    }
//


}