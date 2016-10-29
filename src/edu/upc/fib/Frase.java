package edu.upc.fib;

import java.util.Vector;

public class Frase implements Comparable<Frase> {
    private Vector<Palabra> sentence;

    public Frase(String sentence) {
        //String[] words = sentence.split("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇçÑñ-])+");
        String[] words = sentence.split(" ");
        this.sentence = new Vector();
        for (String s : words) {
            this.sentence.add(new Palabra(s));
        }
    }

    /*public void print() {
        for (Palabra w : sentence) {
            w.print();
        }
        System.out.println();
    }*/

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (getClass() != obj.getClass()) return false;
//        final Frase other = (Frase) obj;
//        if (!sentence.equals(other.sentence)) return false;
//        return true;
//    }

    public Palabra getPalabra(int index) {
        return sentence.get(index);
    }

    public int getSize() {
        return sentence.size();
    }

    public void addParaula(String word)  {
        //sentence.addElement(new Palabra(word));
    }

    public String getParaula(int position) {
        return sentence.get(position).getString();
    }

    @Override
    public int compareTo(Frase o) {
        for (int i = 0; i < Math.min(getSize(), o.getSize()); i++) {
            if (!sentence.get(i).getString().equals(o.getPalabra(i).getString())) {
                return sentence.get(i).getString().compareTo(o.getPalabra(i).getString());
            }
        }
        if (getSize() < o.getSize()) return -1;
        else if (getSize() > o.getSize()) return 1;
        return 0;
    }
}
