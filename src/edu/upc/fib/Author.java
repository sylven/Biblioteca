package edu.upc.fib;

import javax.print.Doc;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public class Author implements Comparable<Author>, Serializable {
    private Sentence mName; // Nombre del autor
    //private Vector<Document> mDocuments; // Lista de documentos de los que es autor
    private Hashtable<String, Document> mDocuments; // Lista de documentos de los que es autor <titulo, Document>

    public Author(String name) {
        mName = new Sentence(name);
        //mDocuments = new Vector<>();
        mDocuments = new Hashtable<>();
    }

    // Gestión del autor

    public void modifyName(String newName) {
        mName = new Sentence(newName);
    }

    public boolean addDocument(Document document) {
        // Comprobar que un documento con el mismo título no existe ya ???????????????????????????????????????
        String title = document.getTitle().toString();
        if (!mDocuments.containsKey(title)) {
            mDocuments.put(title, document);
            return true;
        }
        return false;
    }

    public boolean removeDocument(String title){
        if (mDocuments.containsKey(title)) {
            mDocuments.remove(title);
            return true;
        }
        return false;
    }

    public Sentence getName() {
        return mName;
    }

    public Set<String> getDocumentTitles() {
        return mDocuments.keySet();
    }

    @Override
    public int compareTo(Author o) {
        return mName.toString().compareTo(o.getName().toString());
    }

}