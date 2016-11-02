package edu.upc.fib;

import sun.swing.StringUIClientPropertyKey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class Documentos {
    //> TreeMap de títulos (donde cada título tiene asociado el contenido del documento)
    // v2: TreeMap de documentos donde los titulos son la clave y el valor es una lista decumentos con el mismo titulo
    TreeMap<Frase, Vector<Documento>> mDocumentos;

    //> Vector de palabras con su frecuecia global
    HashMap<Palabra, Integer> mFrecuenciaPalabras;

    Vector<Palabra> palabrasFuncionales;

    public Documentos() {
        mDocumentos = new TreeMap<>();
        mFrecuenciaPalabras = new HashMap<>();

        // Cargar palabras funcioanales
        palabrasFuncionales = new Vector<>();
        try (BufferedReader br = new BufferedReader(new FileReader("empty.sp"))) {
            String line = br.readLine();

            while (line != null) {
                palabrasFuncionales.add(new Palabra(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Añade el documento y crea el autor si no existe
    public Boolean addDocumento(Frase autor, Frase titulo, Contenido contenido, Documento doc) {
        Documento nDocumento = new Documento(autor, titulo, contenido);
        Vector<Documento> vDocumentos;
        if (mDocumentos.containsKey(titulo)) {
            // MEJOR usar equals? (Necesario Override de equals y HashCode? => Averiguarlo)
            // (!) Podria ser ineficiente recorrer todos los documentos con el mismo título
            for (Documento d : mDocumentos.get(titulo)) {
                if (d.getAutor().compareTo(autor) == 0) return false;
            }
            // Añadir documento al vector
            vDocumentos = mDocumentos.get(titulo);
        } else {
            vDocumentos = new Vector<>();
        }
        vDocumentos.add(nDocumento);
        mDocumentos.put(titulo, vDocumentos);
        doc=nDocumento;
        return true;
    }

   /* public String getTituloAutor(Documento doc) {
        Set<Frase> Titulos= mDocumentos.keySet();
        String ret=new String();
        System.out.println("12");
        for(Frase F: Titulos){
            System.out.println("13");
            Vector<Documento> docs=mDocumentos.get(F);
            System.out.println(docs.size());
            for(Documento documento: docs){
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
