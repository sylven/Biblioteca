package edu.upc.fib;

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

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null) return false;
//        if (getClass() != obj.getClass()) return false;
//        final Palabra other = (Palabra) obj;
//        if (word != other.word) return false;
//        return true;
//    }
}