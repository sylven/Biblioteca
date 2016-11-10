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
        return mAuthors.modifyAuthor(authorName, newAuthorName);
    }

    public boolean removeAuthor(String authorName) {
        return mAuthors.removeAuthor(authorName, mDocuments);
    }

    public Set<String> getAuthorNames() {
        return mAuthors.getAuthorNames();
    }

    public boolean addDocument(String authorName, String title, Vector<String> content) {
        addAutor(authorName);
        Author author = mAuthors.getAuthor(authorName);
        return mDocuments.addDocument(author, title, content);
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

    public boolean modifyDocumentAuthor(String authorName, String title, String newAuthorName) {
        // Asegurarse que el autor antiguo existe
        // Quitar documento del autor antiguo
        // Asegurarse que el nuevo autor existe
        // Añadir documento al nuevo autor

        // Quitar documento de Documentos y añadir el nuevo con el nuevo autor

        //mDocuments.modifyDocumentAuthor(authorName,title,newAuthorName);
        //mAuthors.modifyDocumentAuthor(authorName,title,newAuthorName);
        return true;
    }





//
//    public Boolean modifyDocumentTitle(String authorName, String title, String newTitle){
//        mDocuments.modifyDocumentTitle(authorName,title,newTitle);
//        mAuthors.modifyDocumentTitle(authorName,title,newTitle);
//        return true;
//    }
//
//    public Boolean modifyDocumentContent(String authorName, String title, Vector<String> newContent){
//        mDocuments.modifyDocumentContent(authorName,title,newContent);
//        mAuthors.modifyDocumentContent(authorName,title,newContent);
//        return true;
//    }
//
//    public Boolean printContent(String author, String title){
//        mDocuments.printContent(author,title);
//        return true;
//    }

}
