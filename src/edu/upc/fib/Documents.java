package edu.upc.fib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Documents {
    //> TreeMap de títulos (donde cada título tiene asociado el contenido del documento)
    // v2: TreeMap de documentos donde los titulos son la clave y el valor es una lista decumentos con el mismo titulo
    private TreeMap<String, Vector<Document>> mDocuments;

    //> Vector de palabras con su frecuecia global
    private HashMap<String, Integer> mWordFrequency;

    //> Vector de palabras con los documentos en los que aparecen
    private HashMap<String, Vector<Document>> mWordDocuments;

    // Lista de palabras funcionales
    private Vector<String> connectorWords;

    public Documents() {
        mDocuments = new TreeMap<>();
        mWordFrequency = new HashMap<>();
        mWordDocuments = new HashMap<>();

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

    //> Actualizar mWordFrequency y mWordDocuments
    // Recalcular la frecuencia global de todas las palabras despues de cada modificacion no es eficiente
    // Esta funcion se usara para añadir y quitar frecuencias
    // Cuando haya modificaciones o borrados, se llamara primero a esta funcion para quitar la frencuencia de las palabras
    public void updateWordFrequency(Document document, boolean increase) {
        HashMap<String, Integer> wordFrequency = document.getWordFrequency();
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            String word = entry.getKey();
            if (!increase) {
                mWordFrequency.put(word, mWordFrequency.get(word) - entry.getValue());
            } else if (mWordFrequency.containsKey(word)) {
                mWordFrequency.put(word, entry.getValue() + mWordFrequency.get(word));
            } else {
                mWordFrequency.put(word, entry.getValue());
            }

            if (!increase) {
                if (mWordDocuments.get(word).size() == 1) {
                    mWordDocuments.remove(word);
                } else {
                    Vector<Document> newVDocuments = mWordDocuments.get(word);
                    newVDocuments.remove(document);
                    mWordDocuments.put(word, newVDocuments);
                }
            } else if (mWordDocuments.containsKey(word)) {
                Vector<Document> newVDocuments = mWordDocuments.get(word);
                newVDocuments.add(document);
                mWordDocuments.put(word, newVDocuments);
            } else {
                Vector<Document> newVDocuments = new Vector<>();
                newVDocuments.add(document);
                mWordDocuments.put(word, newVDocuments);
            }
        }
    }

    public boolean addDocument(String authorName, String title, Vector<String> content, Author author) {
        Document newDocument = new Document(authorName, title, content, connectorWords);
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
        } else {
            vDocuments = new Vector<>();
        }
        vDocuments.add(newDocument);
        mDocuments.put(title, vDocuments);

        // Puede ser que no envie la direccion de memoria que tendra en mDocuments? => FIX IT
        updateWordFrequency(newDocument, true);
        return true;
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.keySet();
    }

    public boolean removeDocument(String authorName, String title) {
        Vector<Document> newVDocuments = mDocuments.get(title);
        Document removedDocument = null;
        for (Document document : newVDocuments) {
            if (authorName.equals(document.getAuthor())) {
                newVDocuments.remove(document);
                removedDocument = document;
            }
        }
        if (removedDocument != null) {
            mDocuments.put(title, newVDocuments);
            updateWordFrequency(removedDocument, false);
            return true;
        }
        return false;
    }

    public boolean modifyDocumentAuthor(String authorName, String title, String newAuthorName) {
        Vector<Document> newVDocuments = mDocuments.get(title);
        for (Document document : newVDocuments) {
            String author = document.getAuthor().toString();
            if (authorName.equals(author)) {
                document.setAuthor(new Sentence(newAuthorName));
                return true;
            }
        }
        return false;
    }

    public boolean modifyDocumentTitle(String authorName, String title, String newTitle) {
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

    public boolean modifyDocumentContent(String authorName, String title, Vector<String> newContent) {
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
        d.updateWordFrequency(connectorWords);
        //this.deleteWordFrecuency(oldContent,d);
        //this.updatemWordFrecuency(newContent,d);
        return true;
    }

    public boolean printContent(String author, String title){
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
