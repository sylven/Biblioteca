package edu.upc.fib;

import java.util.Vector;

public class Frase implements Comparable<Frase> {
    private Vector<Palabra> mFrase;

    public Frase(String frase) {
        //String[] words = frase.split("([A-Za-z'ÁáÄäÀàÉéËëÈèÍíÏïÌìÓóÖöÒòÚúÜüÙùÑñÇçÑñ-])+");
        String[] words = frase.split(" ");
        mFrase = new Vector();
        for (String s : words) {
            mFrase.add(new Palabra(s));
        }
    }

    /*public void print() {
        for (Palabra w : frase) {
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
//        if (!frase.equals(other.frase)) return false;
//        return true;
//    }

    public Palabra getPalabra(int index) {
        return mFrase.get(index);
    }

    public int getSize() {
        return mFrase.size();
    }

    public void addParaula(String word)  {
        //frase.addElement(new Palabra(word));
    }

    public String getParaula(int position) {
        return mFrase.get(position).getString();
    }

    @Override
    public int compareTo(Frase o) {
        for (int i = 0; i < Math.min(getSize(), o.getSize()); i++) {
            if (!mFrase.get(i).getString().equals(o.getPalabra(i).getString())) {
                return mFrase.get(i).getString().toLowerCase().compareTo(o.getPalabra(i).getString().toLowerCase());
            }
        }
        if (getSize() < o.getSize()) return -1;
        else if (getSize() > o.getSize()) return 1;
        return 0;
    }
}
