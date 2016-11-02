package edu.upc.fib;

import java.util.HashMap;

public class Palabra {
    private String mPalabra;

    public Palabra(String word) {
        mPalabra = word;
    }

    public String getString() {
        return mPalabra;
    }

    public void setPalabra(String word) {
        mPalabra = word;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Palabra other = (Palabra) obj;
        if (mPalabra != other.mPalabra) return false;
        return true;
    }


    /*public static void main(String[] args) {
        Palabra P1= new Palabra("Juan");
        Palabra P2= new Palabra("Pepe");
        Palabra P3= new Palabra("Juan");
        if (!P1.equals(P2)) System.out.println("Good1");
        if(P1.equals(P3)) System.out.println("Good2");
        HashMap<Palabra, Integer> a = new HashMap<>();
        a.put(P1,1);
        if(a.containsKey(P1)) System.out.println("Good3");
        if(a.containsKey(P3)) System.out.println("Good4");
        if(a.containsKey("Juan")) System.out.println("Good5");
    }*/
}