package edu.upc.fib;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return mDocuments.addDocument(mAuthors.getAuthor(authorName), title, content);
    }

    public boolean removeDocument(String authorName, String title) {
        return mDocuments.removeDocument(mAuthors.getAuthor(authorName), title);
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.getDocumentTitles();
    }

    public Vector<String> getDocumentContent(String authorName, String title) {
        if (existsDocument(authorName, title)) {
            return mDocuments.getDocumentContent(mAuthors.getAuthor(authorName), title);
        }
        return new Vector<>();
    }

    public List<Pair<String, String>> getSimilarDocuments(String authorName, String title, int nDocuments) {
        if (existsDocument(authorName, title)) {
            List<Map.Entry<Document, Double>> similarDocuments = mDocuments.getSimilarDocuments(mAuthors.getAuthor(authorName), title);
            List<Pair<String, String>> resultsList = new ArrayList<>();
            int i = 0;
            for (Map.Entry<Document, Double> result : similarDocuments) {
                resultsList.add(new Pair(result.getKey().getTitle().toString(), result.getKey().getAuthor().getName().toString()));
                if (i >= nDocuments) {
                    break;
                }
            }
             return resultsList;
        }
        return new ArrayList<>();
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

    public static HashMap<String, Vector<String>> getDocumentExpression(String expression){
        HashMap<String, Vector<String>> results = new HashMap<>();
        //-----------------------------------------------------------------------------------------
        Vector<String> expression_cut = new Sentence(expression).getVector();

            // Expresión regular para partir la frase en palabras, signos y espacios.
            Pattern pattern = Pattern.compile("([A-Za-z0-9'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|[^ ]");
            Matcher matcher = pattern.matcher(expression);
            expression_cut = new Vector<>();
            while (matcher.find()) {
                if (!matcher.group().equals(" ")) {
                    expression_cut.add(matcher.group());
                } 
            }
        boolean basicA = false;
        boolean basicB = false;

        //-----------------------------------------------------------------------------------------
        return results;
    }

}
