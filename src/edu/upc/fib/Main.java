package edu.upc.fib;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

     public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        // Console navigation
        int choice = 0;
        while (choice != -1) {
            System.out.println("[Menú]");
            System.out.println("1- Gestió de autors");
            System.out.println("2- Gestió de documents");
            System.out.println("0- Sortir del programa");
            System.out.print("Tria una opció: ");
            choice = scanner.nextInt();

            if (choice == 0) choice = -1;
            else if (choice == 1) {
                while (choice != 0) {
                    System.out.println("[Menú] Gestió de autors");
                    System.out.println("1- Veure llista d'autors");
                    System.out.println("2- Afegir autor");
                    System.out.println("0- Enrere");
                    System.out.print("Tria una opció: ");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        biblioteca.printAutors();
                    } else if (choice == 2) {
                        System.out.println("· Gestió de autors > Afegir autor");
                        biblioteca.afegirAutor();
                    }
                }
            }  else if (choice == 2) {
                while (choice != 0) {
                    System.out.println("[Menú] Gestió de documents");
                    System.out.println("1- Afegir document");
                    System.out.println("0- Enrere");
                    System.out.print("Tria una opció: ");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println("· Gestió de documents > Afegir document");
                        biblioteca.afegirDocument();
                    }
                }
            }
        }
    }
}