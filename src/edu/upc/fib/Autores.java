package edu.upc.fib;

import java.util.TreeMap;
import java.util.Vector;

public class Autores {
    //> TreeMap de autores (donde cada autor tendrá un vector con los punteros o ids de los mDocumentos de los que es autor)
        // Separar en una clase aparte?
        // Crear una clase que implementa TreeMap y hacernos una versión con funcionalidades que necesitemos?
    TreeMap<Frase, Vector<Documento>> mDocumentAuthors;

    public Autores() {
        mDocumentAuthors = new TreeMap<>();
    }

    public Boolean existsAuthor(Frase author) {
        return mDocumentAuthors.containsKey(author);
    }

    // Returns if "mDocumentAuthors" contains "author"
    public Boolean containsAuthor(Frase author) {
        return mDocumentAuthors.containsKey(author);
    }

    // Adds "author" to "mDocumentAuthors" if it doesn't exist
    public Boolean addAuthor(Frase author) {
        if (!containsAuthor(author)) {
            mDocumentAuthors.put(author, new Vector<Documento>());
            return true;
        }
        return false;
    }

    // Changes the "author" name for "newAuthor"
    public Boolean modifyAuthor(Frase author, Frase newAuthor) {
        if (containsAuthor(author)) {
            Vector<Documento> documents = mDocumentAuthors.get(author);
            mDocumentAuthors.remove((author));
            mDocumentAuthors.put(newAuthor, documents);
            return true;
        }
        return false;
    }

    // Deletes "author" from "mDocumentAuthors"
    public Boolean deleteAuthor(Frase author) {
        if (containsAuthor(author)) {
            mDocumentAuthors.remove(author);
            return true;
        }
        return false;
    }

    // Adds a document to the author
    public void addDocumentToAuthor() {

    }
}
