package edu.upc.fib;

public class Contenido {
    private Frase[] Contenido;
    //private SparseVector Palabras; Pot fer productes vectorials que es el que necessitem per fer les comparacions de documents

    public Boolean ExisteixParaula(Palabra P){
        return true;
    }

    public Frase[] getContenido() {
        return Contenido;
    }

    public void setContenido(Frase[] contenido) {
        Contenido = contenido;
    }
}
