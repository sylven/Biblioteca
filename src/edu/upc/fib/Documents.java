package edu.upc.fib;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Documents {
    //> TreeMap de títulos (donde cada título tiene asociado el contenido del documento)
    // v2: TreeMap de documentos donde los titulos son la clave y el valor es una lista decumentos con el mismo titulo
    private TreeMap<String, Vector<Document>> mDocuments;

    //> Vector de palabras con su frecuecia global
    private HashMap<String, Integer> mWordFrecuency;

    private Vector<String> connectorWords;

    public Documents() {
        mDocuments = new TreeMap<>();
        mWordFrecuency = new HashMap<>();

        // Cargar palabras funcioanales
        connectorWords = new Vector<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empty.sp"))) {
            String line = br.readLine();
            while (line != null) {
                connectorWords.add(new String(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean addDocument(String authorName, String title, Vector<String> content, Author author) {
        Document newDocument = new Document(authorName, title, content);
        author.addDocument(newDocument);
        Vector<Document> vDocuments;
        if (mDocuments.containsKey(title)) {
            //> ¿Comprobar si el documento ya existe mirando los autores de todos los documentos con el mismo titulo?
//            for (Document d : mDocuments.get(title)) {
//                // MEJOR usar equals? (Necesario Override de equals y HashCode? => Averiguarlo)
//                // (!) Podria ser ineficiente recorrer todos los documentos con el mismo título
//                if (d.getAutor().compareTo(author) == 0) return false;
//            }

            vDocuments = mDocuments.get(title);
            vDocuments.add(newDocument);
            mDocuments.remove(title);
            mDocuments.put(title, vDocuments);
        } else {
            vDocuments = new Vector<>();
            vDocuments.add(newDocument);
            mDocuments.put(title, vDocuments);
        }
        this.updatemWordFrecuency(content);
        return true;
    }

    public Boolean updatemWordFrecuency(Vector<String> content){
        Vector<String> words = new Vector<>();
        for (String s:content) {
            words = new Vector<>();
            Pattern pattern = Pattern.compile("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇçÑñ-])+|.");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) words.add(matcher.group());
            for (String st : words) {
                if(!connectorWords.contains(st) && !st.equals(" ")) {
                    if (mWordFrecuency.containsKey(st)) {
                        Integer i = mWordFrecuency.get(st);
                        ++i;
                        mWordFrecuency.remove(st);
                        mWordFrecuency.put(st, i);
                    } else {
                        Integer i = 1;
                        mWordFrecuency.put(st, i);
                    }
                }
            }
        }
        return true;
    }

    public Boolean deleteWordFrecuency(Content content){
        Vector<Sentence> sentences=content.getContent();
        for (Sentence sentence:sentences) {
            Vector<String> words = sentence.getWords();
            for (String s:words) {
                if(!connectorWords.contains(s) && !s.equals(" ")) {
                    Integer i = mWordFrecuency.get(s);
                    --i;
                    mWordFrecuency.remove(s);
                    if (i > 0) mWordFrecuency.put(s, i);
                }
            }
        }
        return true;
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.keySet();
    }

    public Boolean deleteDocument(String authorName, String title){
        Vector<Document> docs=mDocuments.get(title);
        Content content = null;
        Document d=null;
        for (Document doc: docs){
            Sentence fAuthor=doc.getAuthor();
            String sAuthor=fAuthor.toString();
            if(sAuthor.equals(authorName)){
                d=doc;
                content=doc.getContent();
            }
        }
        docs.remove(d);
        mDocuments.remove(title);
        if (!docs.isEmpty())mDocuments.put(title,docs);
        this.deleteWordFrecuency(content);
        return true;
    }

   /* public String getTituloAutor(Document doc) {
        Set<Sentence> Titulos= mDocuments.keySet();
        String ret=new String();
        System.out.println("12");
        for(Sentence F: Titulos){
            System.out.println("13");
            Vector<Document> docs=mDocuments.get(F);
            System.out.println(docs.size());
            for(Document documento: docs){
                System.out.println("14");
                if(documento.getTitulo()==doc.getTitulo()) {
                    System.out.println("15");
                    ret = documento.getTituloS();
                }
            }
        }
        return ret;
    }*/


}
