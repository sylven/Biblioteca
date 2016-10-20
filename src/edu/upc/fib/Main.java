package edu.upc.fib;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Biblioteca");
        System.out.println("1- Gestió documents");

        System.out.println("Tria una opció:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Biblioteca - Gestió de documents");
                System.out.println("1- Afegir document");
                break;
            default:
        }

        System.out.println("Tria una opció:");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Biblioteca - Añadir documento");
                biblioteca.afegirDocument();
                break;
            default:
                // The user input an unexpected choice.
        }
    }
}
