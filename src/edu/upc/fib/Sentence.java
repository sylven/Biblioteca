package edu.upc.fib;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private Vector<String> mWords; // Vector de las palabras de la frase

    public Sentence(String sentence) {
        // Expresión regular para partir la frase en palabras, signos y espacios.
        Pattern pattern = Pattern.compile("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇç-])+|[0-9]+|[^ ]");
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

    public Vector<String> getVector() {
        return mWords;
    }

    public String toString() {
        // Usar StringBuilder ??????????????????????????????????????????????????????????????????????????
        String ret = "";
        for (String word : mWords) {
            if (ret.equals("")) {
                ret = word;
            } else if (!ret.equals("") && (ret.substring(ret.length() - 1).equals("(") || ret.substring(ret.length() - 1).equals("«") || word.equals("!") || word.equals("?") || word.equals(",") || word.equals(".") || word.equals(":") || word.equals(")"))) {
                // Controlar de otra forma los momentos en los que no hay que poner espacio
                ret += word;
            } else {
                ret += " " + word;
            }
        }
        return ret;
    }

//    // Needed?
//    // Revisar que funcione
//    @Override
//    public int compareTo(Sentence o) {
//        for (int i = 0; i < Math.min(getSize(), o.getSize()); i++) {
//            if (!mWords.get(i).equals(o.getWord(i)))
//                return mWords.get(i).toLowerCase().compareTo(o.getWord(i).toLowerCase());
//        }
//        if (getSize() < o.getSize()) return -1;
//        else if (getSize() > o.getSize()) return 1;
//        return 0;
//    }

}
