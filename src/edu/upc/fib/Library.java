package edu.upc.fib;

import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library implements Serializable {
    private Documents mDocuments;
    private Authors mAuthors;

    public Library() {
        mDocuments = new Documents();
        mAuthors = new Authors();
        //loadStatus();
    }


    public void restartStatus(){
        mDocuments = new Documents();
        mAuthors = new Authors();
    }
     // Gestión de autores

    public void saveStatus() {
        try {
            FileOutputStream fout = new FileOutputStream("library.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(mDocuments);
            oos.writeObject(mAuthors);
            oos.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public void loadStatus() {
        try {
            FileInputStream fin = new FileInputStream("library.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            mDocuments = (Documents) ois.readObject();
            mAuthors = (Authors) ois.readObject();
            ois.close();
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public boolean addAuthor(String authorName) {
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

    public boolean addDocument(String authorName, String title, String content) {
        addAuthor(authorName);
        return mDocuments.addDocument(mAuthors.getAuthor(authorName), title, content);
    }

    public boolean removeDocument(String authorName, String title) {
        return mDocuments.removeDocument(mAuthors.getAuthor(authorName), title);
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.getDocumentTitles();
    }

    /*public Vector<String> getDocumentContent(String authorName, String title) {
        if (existsDocument(authorName, title)) {
            return mDocuments.getDocumentContent(mAuthors.getAuthor(authorName), title);
        }
        return new Vector<>();
    }*/
    public String getDocumentContent(String authorName, String title) {
        if (existsDocument(authorName, title)) {
            return mDocuments.getDocumentContent(mAuthors.getAuthor(authorName), title);
        }
        return "";
    }

    public List<Pair<String, String>> getSimilarDocuments(String authorName, String title, int nDocuments) {
        if (existsDocument(authorName, title)) {
            List<Map.Entry<Document, Double>> similarDocuments = mDocuments.getSimilarDocuments(mAuthors.getAuthor(authorName), title);
            List<Pair<String, String>> resultsList = new ArrayList<>();
            int i = 0;
            for (Map.Entry<Document, Double> result : similarDocuments) {
                resultsList.add(new Pair(result.getKey().getTitle().toString(), result.getKey().getAuthor().getName().toString()));
                ++i;
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
        addAuthor(newAuthorName);
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

    public boolean modifyDocumentContent(String authorName, String title, String newContent) {
        if (existsDocument(authorName, title)) {
            mDocuments.modifyDocumentContent(mAuthors.getAuthor(authorName), title, newContent);
            return true;
        }
        return false;
    }


    public static Vector<Document> getDocumentExpression_rec(Vector<String> expression_cut){

        int a = 0;
        int z = expression_cut.size()-1;
        int numparentesis = 0;
        for(int i = 0; i < expression_cut.size(); i++){
            if (expression_cut.get(i).equals("(")) {numparentesis++;}
        }

        int cont=0;
        int separador=0;
        for(int i=a; i<z;++i){
            if (expression_cut.get(i).equals("(")) ++cont;
            else if (expression_cut.get(i).equals(")")) --cont;
            else if((expression_cut.get(i).equals("|") | expression_cut.get(i).equals("&")) & cont==0) separador=i;
        }

        if(separador==0 & expression_cut.get(a).equals("(") & expression_cut.get(z).equals(")")){
            expression_cut.remove(a);
            expression_cut.remove(z);
            getDocumentExpression_rec(expression_cut);
        }

        if(separador!=0) {
            Vector<String> s1 = new Vector<>();
            for (int i = a; i < separador; ++i) {
                s1.add(expression_cut.get(i));
            }

            Vector<String> s2 = new Vector<>();
            for (int i = separador + 1; i <= z; ++i) {
                s2.add(expression_cut.get(i));
            }

            Vector<Document> d1 = getDocumentExpression_rec(s1);
            Vector<Document> d2 = getDocumentExpression_rec(s2);

            if (expression_cut.get(separador).equals("|")) {

            }

            if (expression_cut.get(separador).equals("&")) {

            }
        }

        else if(separador==0){
            if(expression_cut.get(0).equals("{")){

            }
            else if(expression_cut.equals("!")){

            }
            else {

            }
        }

        return null;
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

        Vector<Document> result= getDocumentExpression_rec(expression_cut);

        //-----------------------------------------------------------------------------------------
        return results;
    }
    public boolean verifyExpression(String expression1, String expression2){
        return VerifyExpression.verifyExpression(expression1, expression2);
    }

    public List<Pair<String,String>> getBooleanDocuments(String expressionToTest) {
            return mDocuments.getBoleanDocuments(expressionToTest);
    }
}


