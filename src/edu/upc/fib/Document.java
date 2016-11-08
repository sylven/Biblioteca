package edu.upc.fib;

import java.util.HashMap;
import java.util.Vector;

public class Document {
    private Sentence mAuthor;
    private Sentence mTitle;
    private Content mContent;

    //> Vector de palabras y su frecuencia dentro de este documento
    private HashMap<String, Integer> mWordFrequency;

    //> Estructura de datos que calcule el peso de cada palabra dentro de un documento (que se actualiza despues de
        // cada modificacion o alta
        // MOVER dentro de documento?
    private HashMap<String, Integer> mWordsWeight;

    //> Estructura que contenga parecidos entre mDocuments
        // Probablemente igual que la de los pesos de las palabras
        // MOVER dentro de documento?
    private HashMap<Document, Integer> mSimilarDocuments;

    public Document(String authorName, String title, Vector<String> content, Vector<String> connectorWords) {
        mAuthor = new Sentence(authorName);
        mTitle = new Sentence(title);
        mContent = new Content(content);
        mWordFrequency = mContent.getWordFrecuency(connectorWords);
    }

    public HashMap<String, Integer> getWordFrequency() {
        return mWordFrequency;
    }

    public Sentence getAuthor() {
        return mAuthor;
    }

    public void setAuthor(Sentence author) {
        mAuthor=author;
    }

    public Sentence getTitle() {
        return mTitle;
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

    public void updateWordFrecuency(Vector<String> connectorWords){
        mWordFrequency=mContent.getWordFrecuency(connectorWords);
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