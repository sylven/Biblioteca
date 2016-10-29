package edu.upc.fib;

import java.util.HashMap;

public class Documento {
    private Frase mAutor;
    private Frase mTitulo;
    private Contenido mContenido;

    //> Vector de palabras y su frecuencia dentro de este documento
    HashMap<Palabra, Integer> mFrecuenciaPalabras;

    //> Estructura de datos que calcule el peso de cada palabra dentro de un documento (que se actualiza despues de
        // cada modificacion o alta
        // MOVER dentro de documento?
    HashMap<Palabra, Integer> weigtPalabras;

    //> Estructura que contenga parecidos entre mDocumentos
        // Probablemente igual que la de los pesos de las palabras
        // MOVER dentro de documento?
    HashMap<Documento, Integer> similarDocuments;

    public Documento(String autor, String titulo, String contenido) {
        // Si no existe el autor se crea
        // Si existe, se añade la información

        mTitulo = new Frase(titulo);
        mContenido = new Contenido(contenido);
        mFrecuenciaPalabras = mContenido.calcularFrecuenciaPalabras();
    }

    //private static Biblioteca Biblioteca;

    /*public Boolean ExisteixParaula(Palabra P){
        return Contenido.ExisteixParaula(P);
    }*/

    public Documento(Frase A, Frase T, Contenido C){
        /*setAutor(A);
        setTitulo(T);
        Contenido = C;

        Biblioteca.AfegirDocument(this);*/
    }

    /*public Frase getAutor() {
        return Autor;
    }*/

    /*public void setAutor(Frase autor) {
        Autor = autor;
    }*/

    /*public Frase getTitulo() {
        return Titulo;
    }*/

    /*public void setTitulo(Frase titulo) {
        Titulo = titulo;
    }*/
}