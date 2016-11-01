package edu.upc.fib;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Contenido {
    private Vector<Frase> mContenido;

    public Contenido(Vector<String> contenido) {
        mContenido = new Vector<>();
        for (String s : contenido) {
            mContenido.add(new Frase(s));
        }
    }


    public  HashMap<String, Integer> calcularFrecuenciaPalabras(){
        HashMap<String, Integer> ret=new HashMap<String ,Integer>();
        Integer value;
        String S;
        for(Frase F: mContenido) {
            for(int i=0; i<F.getSize();++i){
                S=F.getParaula(i);
                if(ret.containsKey(S)){
                    value=ret.get(S);
                    ++value;
                    ret.replace(S,value);
                }
                else{
                    ret.put(S,1);
                }
            }
        }
        /*Set<String> Prova=ret.keySet();
        for (String St: Prova) {
            System.out.println("\n" + St + " " + ret.get(St));
        }*/
        return ret;
    }
//    public HashMap<Palabra, Integer> calcularFrecuenciaPalabras() {
//        return new HashMap<>();
//    }

    //private Frase[] Contenido;

    //private SparseVector Palabras; Pot fer productes vectorials que es el que necessitem per fer les comparacions de mDocumentos

    // Retorna el HashMap poblat amb la freqüència de les paraules


    /*public Boolean ExisteixParaula(Palabra P){
        return true;
    }*/

    /*public Frase[] getContenido() {
        return Contenido;
    }*/

    /*public void setContenido(Frase[] contenido) {
        Contenido = contenido;
    }*/
}