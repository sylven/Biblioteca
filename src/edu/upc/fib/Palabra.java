package edu.upc.fib;

public class Palabra {
    private String mWord;

    public Palabra(String word) {
        mWord = word;
    }

    public String getString() {
        return mWord;
    }

    public void setPalabra(String word) {
        mWord = word;
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