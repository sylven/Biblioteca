package edu.upc.fib;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Vector;

public class Content {
    private Vector<Sentence> mContent;

    public Content(Vector<String> content) {
        mContent = new Vector<>();
        for (String s : content) {
            mContent.add(new Sentence(s));
        }
    }

    public HashMap<String, Integer> getWordFrequency(Vector<String> connectorWords){
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (Sentence sentence : mContent) {
            for (int i = 0; i < sentence.getSize(); i++) {
                String word = sentence.getWord(i);
                // Si no es una palabra funcional y su longitud es mayor a 1 carácter => la guardamos
                if(!connectorWords.contains(word) && word.length() > 1) {
                    if (wordFrequency.containsKey(word)) {
                        wordFrequency.put(word, wordFrequency.get(word) + 1);
                    } else {
                        wordFrequency.put(word, 1);
                    }
                }
            }
        }
        return wordFrequency;
    }




















    public Vector<Sentence> getContent() {
        return mContent;
    }

    public void print(){
        for (Sentence sentence:mContent){
            for(int i=0; i<sentence.getSize();++i){
                String word=sentence.getWord(i);
                System.out.print(word);
            }
            System.out.println();
        }
    }
//    public  HashMap<String, Integer> calcularFrecuenciaPalabras(){
//        HashMap<String, Integer> ret=new HashMap<String ,Integer>();
//        Integer value;
//        String S;
//        for(Sentence F: mContent) {
//            for(int i=0; i<F.getSize();++i){
//                S=F.getParaula(i);
//                if(ret.containsKey(S)){
//                    value=ret.get(S);
//                    ++value;
//                    ret.replace(S,value);
//                }
//                else{
//                    ret.put(S,1);
//                }
//            }
//        }
//        /*Set<String> Prova=ret.keySet();
//        for (String St: Prova) {
//            System.out.println("\n" + St + " " + ret.get(St));
//        }*/
//        return ret;
//    }

//    public HashMap<String, Integer> calcularFrecuenciaPalabras() {
//        return new HashMap<>();
//    }

    //private Sentence[] Content;

    //private SparseVector Palabras; Pot fer productes vectorials que es el que necessitem per fer les comparacions de mDocuments

    // Retorna el HashMap poblat amb la freqüència de les paraules


    /*public Boolean ExisteixParaula(String P){
        return true;
    }*/

    /*public Sentence[] getContenido() {
        return Content;
    }*/

    /*public void setContenido(Sentence[] contenido) {
        Content = contenido;
    }*/
}