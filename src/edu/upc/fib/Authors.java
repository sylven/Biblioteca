package edu.upc.fib;

import java.util.*;

public class Authors {
    //> TreeMap de autores (donde cada autor tendrá un vector con los punteros o ids de los mDocuments de los que es autor)
        // Separar en una clase aparte?
        // Crear una clase que implementa TreeMap y hacernos una versión con funcionalidades que necesitemos?
    TreeMap<String, Author> mAuthors;

    public Authors() {
        mAuthors = new TreeMap<>();
    }

    public Boolean containsAuthor(String authorName) {
        return mAuthors.containsKey(authorName);
    }

    public Boolean addAuthor(String authorName) {
        if (!containsAuthor(authorName)) {
            mAuthors.put(authorName, new Author(authorName));
            return true;
        }
        return false;
    }

    public Boolean modifyAuthor(String authorName, String newAuthorName) {
        if (containsAuthor(authorName)) {
            Author newAutor = mAuthors.get(authorName);
            newAutor.modifyName(newAuthorName);
            mAuthors.remove(authorName);
            mAuthors.put(newAuthorName, newAutor);
            return true;
        }
        return false;
    }

    public Boolean removeAuthor(String authorName) {
        if (containsAuthor(authorName)) {
            mAuthors.remove(authorName);
            return true;
        }
        return false;
    }

    public Boolean deleteDocument(String authorName, String title){
        Author author = mAuthors.get(authorName);
        if(author.deleteDocument(title)) mAuthors.remove(authorName);
        return true;
    }

    public Author getAuthor(String authorName) {
        return mAuthors.get(authorName);
    }

    public Set<String> getAuthorNames() {
        return mAuthors.keySet();
    }

    public Vector<String> getAuthorDocumentTitles(String authorName) {
        return mAuthors.get(authorName).getDocumentTitles();
    }

//    public void addDocument(String author, Document document){
//        mAuthors.get(author).addDocument(document);
//    }







//    // Adds a document to the author
//    public void addDocumentToAuthor() {
//
//    }

   /* public Vector<Document> consultarDocumentos(String AuthorName){
        Sentence F=new Sentence(AuthorName);
        if(mAuthors.containsKey(F)) System.out.println("4");
        Vector<Document> ret =mAuthors.get(F);
        System.out.println(ret.size());
        return ret;
    }*/

     public SortedMap<String, Author> getAutorsByPrefix(String prefix){
         return mAuthors.subMap(prefix, prefix + Character.MAX_VALUE);
         //return mAuthors.subMap(prefix, true, prefix + Character.MAX_VALUE, true);
//         NavigableMap<String, Author> nm = mAuthors;
//         //return (NavigableMap) mAuthors.subMap(prefix, true, prefix + Character.toString(Character.MAX_VALUE), true);
//         String s = prefix + Character.toString(Character.MAX_VALUE);
//         return mAuthors.subMap(prefix, prefix + Character.MAX_VALUE);
//         return nm.subMap(prefix, new StringBuilder().append(prefix).append('z').toString());
//         ;
     }
}
