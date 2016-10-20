package edu.upc.fib;
import java.util.Map;

public class Biblioteca {
    private Documento[] LlistaDocuments;
    private Map<Frase,Documento[]> IndexAutor;
    private Map<Frase,Documento[]> IndexTitol;
    private Map<Pair<Integer,Palabra>,Documento[]> Diccionario;

    public Documento[] LlistaAutor(Frase Autor){
        return IndexAutor.get(Autor);
    }

    public Documento[] LlistaTitol(Frase Titol){
        return IndexAutor.get(Titol);
    }

    public void AfegirDocument(Documento D){

        //Afegeix a LListaDocuments
        Integer i=LlistaDocuments.length;
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

        //Falta Afegir a Diccionario

    }

	/*public Boolean ExisteixParaula(Integer index, Palabra P){
		return Biblioteca[index].ExisteixParaula(P);
	}*/

    //public Documento[] PrefixeAutor(String S){}

}
