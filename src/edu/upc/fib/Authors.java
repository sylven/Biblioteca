package edu.upc.fib;

import java.util.*;

public class Authors {
    private TreeMap<String, Author> mAuthors; // Estructura que contiene todos los autores <autor, Author>

    public Authors() {
        mAuthors = new TreeMap<>();
    }

    // Gestión de autores

    public boolean addAuthor(String authorName) {
        if (!existsAuthor(authorName)) {
            mAuthors.put(authorName, new Author(authorName));
            return true;
        }
        return false;
    }

    public boolean modifyAuthor(String authorName, String newAuthorName) {
        if (existsAuthor(authorName)) {
            Author newAuthor = mAuthors.get(authorName);
            newAuthor.modifyName(newAuthorName);
            mAuthors.remove(authorName);
            mAuthors.put(newAuthorName, newAuthor);
            return true;
        }
        return false;
    }

    public boolean removeAuthor(String authorName, Documents documents) {
        if (existsAuthor(authorName)) {
            // Delete all his documents
            for (String title : getAuthor(authorName).getDocumentTitles()) {
                documents.removeDocument(getAuthor(authorName), title);
            }
            mAuthors.remove(authorName);
            return true;
        }
        return false;
    }

    // Métodos auxiliares de gestión de autores

    public boolean existsAuthor(String authorName) {
        return mAuthors.containsKey(authorName);
    }

    // Consultas de autores

    public Author getAuthor(String authorName) {
        return mAuthors.get(authorName);
    }

    public Set<String> getAuthorNames() {
        return mAuthors.keySet();
    }

    public Set<String> getAuthorDocumentTitles(String author) {
        return getAuthor(author).getDocumentTitles();
    }

    public SortedMap<String, Author> getAutorsByPrefix(String prefix){
        return mAuthors.subMap(prefix, prefix + Character.MAX_VALUE);
    }

}
