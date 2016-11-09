package edu.upc.fib;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence implements Comparable<Sentence> {
    private Vector<String> mWords; // Vector de las palabras de la frase

    public Sentence(String sentence) {
        // Expresión regular para partir la frase en palabras, signos y espacios.
        Pattern pattern = Pattern.compile("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|.");
        Matcher matcher = pattern.matcher(sentence);
        mWords = new Vector<>();
        while (matcher.find()) {
            if (!matcher.group().equals(" ")) {
                mWords.add(matcher.group());
            }
        }
    }

    public int getSize() {
        return mWords.size();
    }

    public String getWord(int index) {
        return mWords.get(index);
    }

    public String toString() {
        // Usar StringBuilder ??????????????????????????????????????????????????????????????????????????
        String ret = "";
        for (String word : mWords) {
            if (ret == "") {
                ret = word;
            } else {
                ret += " " + word;
            }
        }
        return ret;
    }



















    // Size or Length?




    public Vector<String> getWords() {
        return mWords;
    }


    //    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (getClass() != obj.getClass()) return false;
//        final Sentence other = (Sentence) obj;
//        if (!frase.equals(other.frase)) return false;
//        return true;


    /*public void print() {
        for (String w : frase) {
            w.print();
        }
        System.out.println();
    }*/

//    }



   /* public String toString(Sentence F){
        String s = F.getPalabra(0).getString();
        for (int i = 1; i < F.getSize(); i++) {
            s += F.getPalabra(i).getString();
        }
        return s;
    }*/

//    public void addWord(String word)  {
//        //frase.addElement(new String(word));
//    }


    // Revisar que funcione
    @Override
    public int compareTo(Sentence o) {
        for (int i = 0; i < Math.min(getSize(), o.getSize()); i++) {
            if (!mWords.get(i).equals(o.getWord(i)))
                return mWords.get(i).toLowerCase().compareTo(o.getWord(i).toLowerCase());
        }
        if (getSize() < o.getSize()) return -1;
        else if (getSize() > o.getSize()) return 1;
        return 0;
    }

//    public static void main(String[] args) {
//        Sentence s1 = new Sentence("String");
//        Sentence s2 = new Sentence("String String");
//        Sentence s3 = new Sentence("String");
//        Sentence s4 = s1;
//
//        System.out.println("s1 no es igual a s2: " + s1.equals(s2));
//
//    }

}
