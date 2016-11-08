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
    private HashMap<String, Vector<Document>> mWordFrecuency;

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
        Document newDocument = new Document(authorName, title, content,connectorWords);
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
        this.updatemWordFrecuency(content, newDocument);
        return true;
    }

    public Boolean updatemWordFrecuency(Vector<String> content, Document document){
        Vector<String> words = new Vector<>();
        for (String s:content) {
            words = new Vector<>();
            Pattern pattern = Pattern.compile("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|.");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) words.add(matcher.group());
            for (String st : words) {
                if(!connectorWords.contains(st) && !st.equals(" ")) {
                    if (mWordFrecuency.containsKey(st)) {
                        Vector<Document> documents = mWordFrecuency.get(st);
                        if(!documents.contains(document))documents.add(document);
                        mWordFrecuency.put(st,documents);
                    }
                    else{
                        Vector<Document> documents=new Vector<>();
                        documents.add(document);
                        mWordFrecuency.put(st, documents);
                        if(!documents.isEmpty()) mDocuments.put(st,documents);
                    }
                }
            }
        }
        return true;
    }

    public Boolean deleteWordFrecuency(Content content, Document document){
        Vector<Sentence> sentences=content.getContent();
        for (Sentence sentence:sentences) {
            Vector<String> words = sentence.getWords();
            for (String s:words) {
                if(!connectorWords.contains(s) && !s.equals(" ")) {
                    Vector<Document> documents = mWordFrecuency.get(s);
                    documents.remove(document);
                    mWordFrecuency.remove(s);
                    if (!documents.isEmpty())mWordFrecuency.put(s,documents);
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
        this.deleteWordFrecuency(content,d);
        return true;
    }

    public Boolean modifyDocumentAuthor(String authorName, String title, String newAuthorName){
        Vector<Document> docs=mDocuments.get(title);
        for (Document doc:docs){
            Sentence sentenceAuthor=doc.getAuthor();
            String stringAuthor=sentenceAuthor.toString();
            if(stringAuthor.equals(authorName)){
                Sentence sAuthor= new Sentence(newAuthorName);
                doc.setAuthor(sAuthor);
            }
        }
        return true;
    }

    public Boolean modifyDocumentTitle(String authorName, String title, String newTitle){
        Vector<Document> docs=mDocuments.get(title);
        Document oldDoc=null;
        for(Document doc:docs){
            Sentence sentenceAuthor=doc.getAuthor();
            String stringAuthor=sentenceAuthor.toString();
            if(stringAuthor.equals(authorName)){
                oldDoc=doc;
            }
        }
        docs.remove(oldDoc);
        mDocuments.remove(title);
        if(!docs.isEmpty())mDocuments.put(title,docs);
        oldDoc.setTitle(new Sentence(newTitle));
        if(mDocuments.containsKey(newTitle)){
            Vector<Document> documents=mDocuments.get(newTitle);
            documents.add(oldDoc);
            mDocuments.put(newTitle,documents);
        }
        else{
            Vector<Document> documents =new Vector<>();
            documents.add(oldDoc);
            mDocuments.put(newTitle,documents);
        }
        return true;
    }

    public Boolean modifyDocumentContent(String authorName, String title, Vector<String> newContent){
        Vector<Document> docs=mDocuments.get(title);
        Content content= new Content(newContent);
        Content oldContent= null;
        Document d=null;
        for (Document doc:docs){
        Sentence sentenceAuthor=doc.getAuthor();
        String stringAuthor=sentenceAuthor.toString();
        if(stringAuthor.equals(authorName)){
            d=doc;
            oldContent=doc.getContent();
            doc.setContent(content);
        }
    }
        d.updateWordFrecuency(connectorWords);
        this.deleteWordFrecuency(oldContent,d);
        this.updatemWordFrecuency(newContent,d);
        return true;
}

    public Boolean printContent(String author, String title){
        Vector<Document> docs=mDocuments.get(title);
        for(Document doc:docs){
            Sentence sentenceAuthor=doc.getAuthor();
            String stringAuthor=sentenceAuthor.toString();
            if(stringAuthor.equals(author)){
                doc.printContent();
            }
        }
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
