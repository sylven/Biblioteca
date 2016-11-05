package edu.upc.fib;

import java.util.*;

public class Autores {
    //> TreeMap de autores (donde cada autor tendrá un vector con los punteros o ids de los mDocumentos de los que es autor)
        // Separar en una clase aparte?
        // Crear una clase que implementa TreeMap y hacernos una versión con funcionalidades que necesitemos?
    TreeMap<Frase, Vector<Documento>> mAutoresDocumentos;

    public Autores() {
        mAutoresDocumentos = new TreeMap<>();
    }

    // Returns if "mAutoresDocumentos" contains "author"
    public Boolean containsAuthor(Frase author) {
        return mAutoresDocumentos.containsKey(author);
    }

    // Adds "author" to "mAutoresDocumentos" if it doesn't exist
    public Boolean addAuthor(Frase author) {
        if (!containsAuthor(author)) {
            mAutoresDocumentos.put(author, new Vector<Documento>());
            return true;
        }
        return false;
    }

    public void addDocumento(Documento doc, Frase fAutor){
        Vector<Documento> docs;
        if (mAutoresDocumentos.containsKey(fAutor)) {
            docs=mAutoresDocumentos.get(fAutor);
        } else{
            docs=new Vector<>();
        }
        docs.add(doc);
        mAutoresDocumentos.put(fAutor,docs);
    }

    // Changes the "author" name for "newAuthor"
    public Boolean modifyAuthor(Frase author, Frase newAuthor) {
        if (containsAuthor(author)) {
            Vector<Documento> documents = mAutoresDocumentos.get(author);
            mAutoresDocumentos.remove((author));
            mAutoresDocumentos.put(newAuthor, documents);
            return true;
        }
        return false;
    }

    // Deletes "author" from "mAutoresDocumentos"
    public Boolean deleteAuthor(Frase author) {
        if (containsAuthor(author)) {
            mAutoresDocumentos.remove(author);
            return true;
        }
        return false;
    }

    public Set<Frase> getAutores() {
        return mAutoresDocumentos.keySet();
    }

    // Adds a document to the author
    public void addDocumentToAuthor() {

    }

   /* public Vector<Documento> consultarDocumentos(String AuthorName){
        Frase F=new Frase(AuthorName);
        if(mAutoresDocumentos.containsKey(F)) System.out.println("4");
        Vector<Documento> ret =mAutoresDocumentos.get(F);
        System.out.println(ret.size());
        return ret;
    }*/

     public SortedMap<Frase, Vector<Documento>> prefixeAutor(String prefijo){
         return (NavigableMap) mAutoresDocumentos.subMap(new Frase(prefijo), true, new Frase(prefijo + Character.MAX_VALUE), true);
     }
}
