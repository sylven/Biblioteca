package edu.upc.fib;

import java.util.List;
import java.util.TreeMap;

public class Autores {
    //> TreeMap de autores (donde cada autor tendrá un vector con los punteros o ids de los documentos de los que es autor)
        // Separar en una clase aparte?
        // Crear una clase que implementa TreeMap y hacernos una versión con funcionalidades que necesitemos?
    TreeMap<Frase, List<Documento>> documentAuthors;

    public Autores() {
        documentAuthors = new TreeMap<>();
    }

    Boolean existsAuthor(Frase author) {

    }
}
