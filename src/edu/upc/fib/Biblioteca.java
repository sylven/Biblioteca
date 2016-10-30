package edu.upc.fib;

import java.util.*;

public class Biblioteca {
    Documentos documentos;
    Autores autores;

    public Biblioteca() {
        documentos = new Documentos();
        autores = new Autores();
    }

    // Asks Autores class to add an Author
    public Boolean addAutor(String authorName) {
        Frase autor = new Frase(authorName);
        return autores.addAuthor(autor);
    }

    // Asks Autores class to delete an Author
    public Boolean eliminarAutor(String nombreAutor) {
        Frase autor = new Frase(nombreAutor);
        return autores.deleteAuthor(autor);
    }

    // Asks Autores class to replace authorName with newAuthorName
    public Boolean modifyAutor(String nombreAutor, String nuevoNombreAutor) {
        Frase autor = new Frase(nombreAutor);
        Frase nuevoAutor = new Frase(nuevoNombreAutor);
        return autores.modifyAuthor(autor, nuevoAutor);
    }

    // Devuelve una vector de strings con todos los autores
    public Vector<String> getAutores() {
        Vector<String> nombresAutores = new Vector<String>();
        for (Frase f : autores.getAutores()) {
            String s = f.getPalabra(0).getString();
            for (int i = 1; i < f.getSize(); i++) {
                s += f.getPalabra(i).getString();
            }
            nombresAutores.add(s);
        }
        return nombresAutores;
    }

    // Añade un documento
    public Boolean addDocumento(String autor, String titulo, Vector<String> contenido) {
        Frase fAutor = new Frase(autor);
        autores.addAuthor(fAutor);
        Frase fTitulo = new Frase(titulo);
        Contenido fContenido = new Contenido(contenido);
        return documentos.addDocumento(fAutor, fTitulo, fContenido);
    }




   //private Documento[] llistaDocuments;


    //private Map<Frase,Documento[]> IndexAutor;
    //private Map<Frase,Documento[]> IndexTitol;
    //private Map<Pair<Integer,Palabra>,Documento[]> Diccionario;

//    public void printAutors() {
//        Enumeration listaAutores = autores.keys();
//        while (listaAutores.hasMoreElements()) {
//            Frase f = (Frase) listaAutores.nextElement();
//            f.print();
//        }
//    }

//    public void afegirAutor() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introdueix el nom de l'autor: ");
//        String autor = scanner.nextLine();
//        String emptyArray[] = new String[0];
//        autores.put(new Frase(autor), emptyArray);
//    }

    /*public Documento[] LlistaAutor(Frase Autor){
        return IndexAutor.get(Autor);
    }*/

    /*public Documento[] LlistaTitol(Frase Titol){
        return IndexAutor.get(Titol);
    }*/

    //public void afegirDocument() {
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

    //}

	/*public Boolean ExisteixParaula(Integer index, Palabra P){
		return Biblioteca[index].ExisteixParaula(P);
	}*/

    //public Documento[] PrefixeAutor(String S){}

}
