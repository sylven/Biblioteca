package edu.upc.fib;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class Library {
    private Documents mDocuments;
    private Authors mAuthors;

    public Library() {
        mDocuments = new Documents();
        mAuthors = new Authors();
    }

    public Set<String> getAuthorNames() {
        return mAuthors.getAuthorNames();
    }

    public Boolean existsAuthor(String authorName) {
        return mAuthors.existsAuthor(authorName);
    }

    public Boolean addAutor(String authorName) {
        return mAuthors.addAuthor(authorName);
    }

    public Boolean modifyAuthor(String authorName, String newAuthorName) {
        return mAuthors.modifyAuthor(authorName, newAuthorName);
    }

    public Boolean removeAutor(String authorName) {
        return mAuthors.removeAuthor(authorName);
    }

    public Vector<String> getAuthorDocumentTitles(String authorName) {
        return mAuthors.getAuthorDocumentTitles(authorName);
    }

//    public Set<String> getDocuments() {
//        return
//    }

    // Mejorar para incluir a los autores?
    public Set<String> getDocumentTitles() {
        return mDocuments.getDocumentTitles();
    }



    public Boolean addDocument(String authorName, String title, Vector<String> content) {
        // Probamos a crear el autor por si no existe, para asegurarnos que el documento se añade a algun autor.
        mAuthors.addAuthor(authorName);
        return mDocuments.addDocument(authorName, title, content, mAuthors.getAuthor(authorName));
    }

    public Boolean deleteDocument(String authorName, String title){
        mAuthors.deleteDocument(authorName, title);
        mDocuments.deleteDocument(authorName,title);
        return true;
    }

    public Boolean modifyDocumentAuthor(String authorName, String title, String newAuthorName){
        mDocuments.modifyDocumentAuthor(authorName,title,newAuthorName);
        mAuthors.modifyDocumentAuthor(authorName,title,newAuthorName);
        return true;
    }

    public Boolean modifyDocumentTitle(String authorName, String title, String newTitle){
        mDocuments.modifyDocumentTitle(authorName,title,newTitle);
        mAuthors.modifyDocumentTitle(authorName,title,newTitle);
        return true;
    }

    public Boolean modifyDocumentContent(String authorName, String title, Vector<String> newContent){
        mDocuments.modifyDocumentContent(authorName,title,newContent);
        mAuthors.modifyDocumentContent(authorName,title,newContent);
        return true;
    }

    public Boolean printContent(String author, String title){
        mDocuments.printContent(author,title);
        return true;
    }

   /* public Vector<String> consultarTituloAutor(String AuthorName){
        Vector<Document> docs=autores.consultarDocumentos(AuthorName);
        Vector<String> autors=new Vector<>();
        System.out.println("9");
        for (Document doc: docs){
            System.out.println("10");
            String s=documentos.getTituloAutor(doc);
            System.out.println(s);
            System.out.println("11");
            autors.add(s);
        }
        return autors;
    }*/

//    public Vector<String> getAutoresPrefijo(String prefijo){
//        SortedMap<Sentence, Vector<Document>> autores = mAuthors.prefixeAutor(prefijo);
//        Vector<String> autoresString = new Vector<>();
//        Set<Sentence> keysAutores = autores.keySet();
//        for(Sentence f: keysAutores){
//            String s = f.getPalabra(0).getString();
//            for (int i = 1; i < f.getSize(); i++)
//                s += " "+f.getPalabra(i).getString();
//            autoresString.add(s);
//        }
//        return autoresString;
//    }

    public Set<String> getAuthorsByPrefix(String prefix) {
        return mAuthors.getAutorsByPrefix(prefix).keySet();
    }


   //private Document[] llistaDocuments;


    //private Map<Sentence,Document[]> IndexAutor;
    //private Map<Sentence,Document[]> IndexTitol;
    //private Map<Pair<Integer,String>,Document[]> Diccionario;

//    public void printAutors() {
//        Enumeration listaAutores = autores.keys();
//        while (listaAutores.hasMoreElements()) {
//            Sentence f = (Sentence) listaAutores.nextElement();
//            f.print();
//        }
//    }

//    public void afegirAutor() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Introdueix el nom de l'autor: ");
//        String autor = scanner.nextLine();
//        String emptyArray[] = new String[0];
//        autores.put(new Sentence(autor), emptyArray);
//    }

    /*public Document[] LlistaAutor(Sentence Author){
        return IndexAutor.get(Author);
    }*/

    /*public Document[] LlistaTitol(Sentence Titol){
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
        Sentence Author = D.getAutor();
        //Ja Existia l'Author
        if(IndexAutor.containsKey(Author)){
            Document[] Docs=IndexAutor.get(Author);
            Integer j=Docs.length;
            Docs[++j]=D;
            IndexAutor.put(Author,Docs);
        }
        //L'Author no Existia
        else{
            Document[] Docs={D};
            IndexAutor.put(Author,Docs);
        }

        //Afegeix a IndexTitol
        Sentence Titol = D.getTitulo();
        //Ja Existia el Titol
        if(IndexTitol.containsKey(Titol)){
            Document[] Docs=IndexTitol.get(Titol);
            Integer j=Docs.length;
            Docs[++j]=D;
            IndexTitol.put(Titol,Docs);
        }
        //El Titol no Existia
        else{
            Document[] Docs={D};
            IndexTitol.put(Author,Docs);
        }

        //Falta Afegir a Diccionario*/

    //}

	/*public Boolean ExisteixParaula(Integer index, String P){
		return Library[index].ExisteixParaula(P);
	}*/

    //public Document[] PrefixeAutor(String S){}

}
