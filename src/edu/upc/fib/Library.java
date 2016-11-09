package edu.upc.fib;

import java.util.*;

public class Library {
    private Documents mDocuments;
    private Authors mAuthors;

    public Library() {
        mDocuments = new Documents();
        mAuthors = new Authors();
    }

     // Gestión de autores

    public boolean addAutor(String authorName) {
        return mAuthors.addAuthor(authorName);
    }

    public boolean modifyAuthor(String authorName, String newAuthorName) {
        return mAuthors.modifyAuthor(authorName, newAuthorName, mDocuments);
    }

    public boolean removeAuthor(String authorName) {
        return mAuthors.removeAuthor(authorName, mDocuments);
    }

    public Set<String> getAuthorNames() {
        return mAuthors.getAuthorNames();
    }

    public boolean addDocument(String authorName, String title, Vector<String> content) {
        addAutor(authorName);
        return mDocuments.addDocument(mAuthors.getAuthor(authorName), title, content);
    }

    public boolean removeDocument(String authorName, String title) {
        return mDocuments.removeDocument(mAuthors.getAuthor(authorName), title);
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.getDocumentTitles();
    }

    // Mejorar para incluir a los autores?
    public Set<String> getAuthorDocumentTitles(String authorName) {
        return mAuthors.getAuthorDocumentTitles(authorName);
    }

    public boolean existsAuthor(String authorName) {
        return mAuthors.existsAuthor(authorName);
    }

    public Set<String> getAuthorsByPrefix(String prefix) {
        return mAuthors.getAutorsByPrefix(prefix).keySet();
    }

    public boolean existsDocument(String authorName, String title) {
        return mDocuments.existsDocument(mAuthors.getAuthor(authorName), title);
    }

    public boolean modifyDocumentAuthor(String authorName, String title, String newAuthorName) {
        addAutor(newAuthorName);
        if (mAuthors.existsAuthor(authorName)
                && mAuthors.existsAuthor(newAuthorName)
                && !existsDocument(newAuthorName, title)) {
            mDocuments.modifyDocumentAuthor(mAuthors.getAuthor(authorName), title, mAuthors.getAuthor(newAuthorName));
            return true;
        }
        return false;
    }

    public boolean modifyDocumentTitle(String authorName, String title, String newTitle) {
        if (mAuthors.existsAuthor(authorName)
                && !existsDocument(authorName, newTitle)) {
            mDocuments.modifyDocumentTitle(mAuthors.getAuthor(authorName), title, newTitle);
            return true;
        }
        return false;
    }

    public boolean modifyDocumentContent(String authorName, String title, Vector<String> newContent) {
        if (existsDocument(authorName, title)) {
            mDocuments.modifyDocumentContent(mAuthors.getAuthor(authorName), title, newContent);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Library library = new Library();
        String authorName = "Patrick Rothfuss";
        library.addAutor(authorName);
        String authorName2 = "George R. R. Martin";
        library.modifyAuthor(authorName, authorName2);
        library.removeAuthor(authorName2);
    }

//    public Boolean printContent(String author, String title){
//        mDocuments.printContent(author,title);
//        return true;
//    }

}
