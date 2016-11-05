package edu.upc.fib;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

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

    public Boolean addDocument(String author, String title, Vector<String> content) {
        Document newDocument = new Document(author, title, content);
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
