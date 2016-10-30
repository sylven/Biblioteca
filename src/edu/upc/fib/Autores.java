package edu.upc.fib;

import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

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
}
