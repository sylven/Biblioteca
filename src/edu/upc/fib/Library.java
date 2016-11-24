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

    //((a|b)|(c|d)|e|f)

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
    public boolean verifyExpression(String sentenceToTest, String expressionToTest ){
        Vector<String> expression_cut = new Sentence(expressionToTest).getVector();

        // Expresión regular para partir la frase en palabras, signos y espacios.
        Pattern pattern = Pattern.compile("([A-Za-z0-9'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|[^ ]");
        Matcher matcher = pattern.matcher(sentenceToTest);
        Vector<String> expression_cut_2 = new Vector<>();
        while (matcher.find()) {
            if (!matcher.group().equals(" ")) {
                expression_cut_2.add(matcher.group());
            }
        }
        pattern = Pattern.compile("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|[0-9]+|[^ ]");
        matcher = pattern.matcher(expressionToTest);
        Vector<String> expressionToTest_2 = new Vector<>();
        while (matcher.find()) {
            if (!matcher.group().equals(" ")) {
                expressionToTest_2.add(matcher.group());
            }
        }
        return verifyExpression_rec(expression_cut_2, expressionToTest_2);

    }

    private boolean verifyExpression_rec(Vector<String> expression_cut, Vector<String> expressionToTest ) {
        if (expression_cut.size() == 0){return false;}
        boolean negate_result= false;
        int prof = 0;//----------------------------------------------------------------------------------------cambiar por pilaaaa y subir a no recursiva!! ;)
        for (int i = 0; i < expression_cut.size(); i++) {
            if (prof < 0) {
                return false;//si se cierra un parentesi no abierto la expresión es incorrecta.
            }
            else if (expression_cut.elementAt(i).equals("(")) {
                prof++;
            }
            else if (expression_cut.elementAt(i).equals(")")) {
                prof--;
            }
        }
        if(prof != 0){return false;}//si la profundidad no es 0, falta un parentesis como minimo, expresion incorrecta
        int pos_op = 0;
        prof = 0;
        //empieza por paréntesi
        if (expression_cut.elementAt(pos_op).equals("(")) {
            prof++;
            for (int i = 1; i < expression_cut.size() || prof!=0; i++) {
                if(prof == 0){
                    pos_op = i;
                    i = expression_cut.size();
                }
                else if (expression_cut.elementAt(i).equals("(")) {
                    prof++;
                } else if (expression_cut.elementAt(i).equals(")")) {
                    prof--;
                }
                if(prof == 0){pos_op = i+1;i = expression_cut.size();}
            }
        }
        //pos_op contiene operando que separa 2 casos recursivos
        else if (expression_cut.elementAt(pos_op).equals("{")){//ha de tener todas las palabras de este conjunto de palabras
            for (int i = 0; i < expression_cut.size(); i++){
                if (expression_cut.elementAt(i).equals("}")){pos_op = i+1;}
            }
        }
        else if (expression_cut.elementAt(pos_op).equals("\"")){//ha de tener este conjunto de palabras tal cual
            for (int i = 1; i < expression_cut.size(); i++){
                if (expression_cut.elementAt(i).equals("\"")){pos_op = i+1;}
            }
        }
        /*else if (expression_cut.elementAt(pos_op).equals("!")){//negar resultado--------------------------------------------------------------------------
            negate_result = true;
            pos_op++;
        }*/
        if (pos_op >= expression_cut.size()){//principio y final es mismo parentesi o expresion[ "- - -", {- - -}, (- - -) ]
            //recortar esos signos y retornar llamada pues estamos en caso base
            // si hay paréntesis, podría haber mas operaciones internas, en cambio, los otros, son operacion molecular
            if (expression_cut.elementAt(0).equals("(")) {
                Vector<String> expression_cut_1 = new Vector<>();
                for (int i = 1; i < pos_op-1; ++i) {
                    expression_cut_1.add(expression_cut.get(i));
                }
                return verifyExpression_rec(expression_cut_1,expressionToTest);
            }
            if (expression_cut.elementAt(0).equals("{")) {}
            if (expression_cut.elementAt(0).equals("\"")) {

            }
        }
        else{//cortar y llamar con 2 trozos
            for(int i = 0; i < expression_cut.size(); i++){
                if(expression_cut.elementAt(i).equals("|") || expression_cut.elementAt(i).equals("&")){
                    pos_op = i; i =expression_cut.size();
                }
            }

            Vector<String> expression_cut_1 = new Vector<>();
            for (int i = 0; i < pos_op; ++i) {
                expression_cut_1.add(expression_cut.get(i));
            }

            Vector<String> expression_cut_2 = new Vector<>();
            for (int i = pos_op + 1; i < expression_cut.size(); ++i) {
                expression_cut_2.add(expression_cut.get(i));
            }

            if (expression_cut.elementAt(pos_op).equals("|")){//hola
                return ( verifyExpression_rec(expression_cut_1, expressionToTest) || verifyExpression_rec(expression_cut_2, expressionToTest) );
            }
            else if (expression_cut.elementAt(pos_op).equals("&")){
                return ( verifyExpression_rec(expression_cut_1, expressionToTest) && verifyExpression_rec(expression_cut_2, expressionToTest) );
            }
            else if (expression_cut.elementAt(pos_op).equals("!")){
                return !( verifyExpression_rec(expression_cut_1, expressionToTest) && verifyExpression_rec(expression_cut_2, expressionToTest) );
            }
        }
        return false;
    }
}


