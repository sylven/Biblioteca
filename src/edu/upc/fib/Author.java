package edu.upc.fib;

import java.util.Set;
import java.util.Vector;

public class Author {
    private Sentence mName;
    private Vector<Document> mDocuments;

    public Author(String name) {
        mName = new Sentence(name);
        mDocuments = new Vector<>();
    }

    public void addDocument(Document document) {
        // Comprobar si ya existe (o hacerlo automatico, quizas un hashmap?)
        mDocuments.add(document);
    }

    public void modifyName(String newName) {
        mName = new Sentence(newName);
    }

    public Vector<String> getDocumentTitles() {
        Vector<String> documentTitles = new Vector<>();
        for (Document document : mDocuments) {
            documentTitles.add(document.getTitle().toString());
        }
        return documentTitles;
    }
}