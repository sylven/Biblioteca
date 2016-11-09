package edu.upc.fib;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

public class Document {
    private Author mAuthor;
    private Sentence mTitle;
    private Content mContent;

    private Hashtable<String, Integer> mWordFrequency; // Frecuencia de cada palabra en este documento
    private Hashtable<String, Double> mWordsWeight; // Peso de cada palabra en este documento
    //private HashMap<Document, Integer> mSimilarDocuments; // Documentos parecidos a este

    public Document(Author author, String title, Vector<String> content, Vector<String> connectorWords) {
        mAuthor = author;
        mTitle = new Sentence(title);
        mContent = new Content(content);
        mWordFrequency = mContent.getWordFrequency(connectorWords);
    }

    public Sentence getTitle() {
        return mTitle;
    }

//    public void updateWordWeight() {
//        for(Map.Entry<String, Integer> word : mWordFrequency.entrySet()) {
//
//            mWordsWeight.put(word.getKey(), Math.log10(mDocuments.size()/word.getValue()));
//        }
//    }












    public Hashtable<String, Integer> getWordFrequency() {
        return mWordFrequency;
    }


    public Author getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Author author) {
        mAuthor = author;
    }



    public void setTitle(Sentence title) {
        mTitle=title;
    }

    public Content getContent() {
        return mContent;
    }

    public void setContent(Content content) {
        mContent=content;
    }

    public void updateWordFrequency(Vector<String> connectorWords){
        mWordFrequency=mContent.getWordFrequency(connectorWords);
    }

    public Boolean printContent(){
        mContent.print();
        return true;
    }

   /* public String getTituloS(){
        System.out.println("6");
        String s = mTitle.getPalabra(0).getString();
        for (int i = 1; i < mTitle.getSize(); i++) {
            s += mTitle.getPalabra(i).getString();
        }
        System.out.println("7");
        return s;
    }


    public Sentence getTitulo() {
        return mTitle;
    }*/

//    public Sentence getTitulo() {
//        return mTitle;
//    }

    //private static Library Library;

    /*public Boolean ExisteixParaula(String P){
        return Content.ExisteixParaula(P);
    }*/

//    public Document(Sentence A, Sentence T, Content C){
//        /*setAutor(A);
//        setTitulo(T);
//        Content = C;
//
//        Library.AfegirDocument(this);*/
//    }

    /*public Sentence getAutor() {
        return Author;
    }*/

    /*public void setAutor(Sentence autor) {
        Author = autor;
    }*/

    /*public void setTitulo(Sentence titulo) {
        Titulo = titulo;
    }*/
}