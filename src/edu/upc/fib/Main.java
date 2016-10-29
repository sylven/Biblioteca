package edu.upc.fib;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

     public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        // BUG: scanner skipping input after nextInt(), 2 workarounds (consider using 2nd one)
        // http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo

        // Console navigation
        int choice = 0;
        while (choice != -1) {
            System.out.println("[Biblioteca]");
            System.out.println(" 1- Consultes");
            System.out.println(" 2- Gestió d'autors");
            System.out.println(" 3- Gestió de documents");
            System.out.println(" 0- Sortir del programa");
            System.out.print("Tria una opció: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) choice = -1;
            else if (choice == 1) {
                while (choice != 0) {
                    //System.out.println("[Menú]");
                    System.out.println("[Biblioteca > Consultes]");
                    System.out.println(" 0- Enrere");
                    System.out.print("Tria una opció: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            } else if (choice == 2) {
                while (choice != 0) {
                    System.out.println("[Biblioteca > Gestió d'autors]");
                    System.out.println(" 1- Veure llista d'autors");
                    System.out.println(" 2- Afegir autor");
                    System.out.println(" 3- Modificar autor");
                    System.out.println(" 4- Eliminar autor");
                    System.out.println(" 0- Enrere");
                    System.out.print("Tria una opció: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        // Print list of authors
                        System.out.println("[Biblioteca > Gestió d'autors > Veure llista d'autors]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 2) {
                        System.out.println("[Biblioteca > Gestió d'autors > Afegir autor]");
                        System.out.print("Introdueix el nom de l'autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.addAuthor(author)) System.out.println("Autor "+author+" afegit satisfactoriament.");
                        else System.out.println("L'autor "+author+" ja existeix.");
                    } else if (choice == 3) {
                        System.out.println("[Biblioteca > Gestió d'autors > Modificar autor]");
                        System.out.print("Introdueix el nom de l'autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("Introdueix el nou nom de l'autor: ");
                        String newAuthorName = scanner.nextLine();
                        if (biblioteca.modifyAuthor(authorName, newAuthorName)) System.out.println("Autor "+authorName+" modificat a "+newAuthorName+" satisfactoriament.");
                        else System.out.println("No s'ha trobat l'autor "+authorName);
                    } else if (choice == 4) {
                        System.out.println("[Biblioteca > Gestió d'autors > Eliminar autor]");
                        System.out.print("Introdueix el nom de l'autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.deleteAuthor(author)) System.out.println("Autor "+author+" eliminat satisfactoriament");
                        else System.out.println("No s'ha trobat l'autor "+author);
                    }
                }
            }  else if (choice == 3) {
                while (choice != 0) {
                    System.out.println("[Biblioteca > Gestió de documents]");
                    System.out.println(" 1- Veure llista de documents");
                    System.out.println(" 2- Afegir document");
                    System.out.println(" 3- Modificar document");
                    System.out.println(" 4- Eliminar document");
                    System.out.println(" 0- Enrere");
                    System.out.print("Tria una opció: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("[Biblioteca > Gestió de documents > Veure llista de documents]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 2) {
                        System.out.println("[Biblioteca > Gestió de documents > Afegir document]");
                        System.out.print("Introdueix el nom de l'autor: ");
                        String author = scanner.nextLine();
                        System.out.print("Introdueix el títol: ");
                        String title = scanner.nextLine();
                        System.out.print("Introdueix el contingut: ");
                        String content = scanner.nextLine();
                        biblioteca.addDocument(author, title, content);
                    } else if (choice == 3) {
                        System.out.println("[Biblioteca > Gestió de documents > Modificar document]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 4) {
                        System.out.println("[Biblioteca > Gestió de documents > Eliminar document]");
                        System.out.println("To Be Implemented");
                    }
                }
            }
        }
    }
}