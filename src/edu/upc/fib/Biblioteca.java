package edu.upc.fib;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Biblioteca {
    //> TreeMap de títulos (donde cada título tiene asociado el contenido del documento)
        // v2: TreeMap de documentos donde los titulos son la clave y el valor es una lista decumentos con el mismo titulo
    TreeMap<Frase, List<Documento>> documentos;

    //> TreeMap de autores (donde cada autor tendrá un vector con los punteros o ids de los documentos de los que es autor)
        // Separar en una clase aparte?
        // Crear una clase que implementa TreeMap y hacernos una versión con funcionalidades que necesitemos?
    TreeMap<Frase, List<Documento>> autoresDocumentos;

    //> Vector de palabras con su frecuecia global
    HashMap<Palabra, Integer> frecuenciaPalabras;







   //private Documento[] llistaDocuments;


    //private Map<Frase,Documento[]> IndexAutor;
    //private Map<Frase,Documento[]> IndexTitol;
    //private Map<Pair<Integer,Palabra>,Documento[]> Diccionario;

    public Biblioteca() {
        autores = new Hashtable<Frase, String[]>();
    }

    public void printAutors() {
        Enumeration listaAutores = autores.keys();
        while (listaAutores.hasMoreElements()) {
            Frase f = (Frase) listaAutores.nextElement();
            f.print();
        }
    }

    public void afegirAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el nom de l'autor: ");
        String autor = scanner.nextLine();
        String emptyArray[] = new String[0];
        autores.put(new Frase(autor), emptyArray);
    }

    /*public Documento[] LlistaAutor(Frase Autor){
        return IndexAutor.get(Autor);
    }*/

    /*public Documento[] LlistaTitol(Frase Titol){
        return IndexAutor.get(Titol);
    }*/

    public void afegirDocument() {
        // Seleccionar autor

        // Pedir título
        // Pedir documento
        // Indexar palabras

        //Afegeix a LListaDocuments
        /*Integer i=LlistaDocuments.length;
        LlistaDocuments[++i]=D;

        //Afegeix a IndexAutor
        Frase Autor = D.getAutor();
        //Ja Existia l'Autor
        if(IndexAutor.containsKey(Autor)){
            Documento[] Docs=IndexAutor.get(Autor);
            Integer j=Docs.length;
            Docs[++j]=D;
            IndexAutor.put(Autor,Docs);
        }
        //L'Autor no Existia
        else{
            Documento[] Docs={D};
            IndexAutor.put(Autor,Docs);
        }

        //Afegeix a IndexTitol
        Frase Titol = D.getTitulo();
        //Ja Existia el Titol
        if(IndexTitol.containsKey(Titol)){
            Documento[] Docs=IndexTitol.get(Titol);
            Integer j=Docs.length;
            Docs[++j]=D;
            IndexTitol.put(Titol,Docs);
        }
        //El Titol no Existia
        else{
            Documento[] Docs={D};
            IndexTitol.put(Autor,Docs);
        }

        //Falta Afegir a Diccionario*/

    }

	/*public Boolean ExisteixParaula(Integer index, Palabra P){
		return Biblioteca[index].ExisteixParaula(P);
	}*/

    //public Documento[] PrefixeAutor(String S){}

}
