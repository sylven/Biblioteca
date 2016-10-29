package edu.upc.fib;

import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        // BUG: scanner skipping input after nextInt(), 2 workarounds (consider using 2nd one)
        // http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo

        // Navegación en consola
        int choice = 0;
        while (choice != -1) {
            System.out.println("[ Biblioteca ]------------------------------|");
            System.out.println("| 1- Consultas                              |");
            System.out.println("| 2- Gestión de autores                     |");
            System.out.println("| 3- Gestión de documentos                  |");
            System.out.println("| 0- Salir del programa                     |");
            System.out.println("|-------------------------------------------|");
            System.out.print("  >> Escoge una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) choice = -1;
            else if (choice == 1) {
                while (choice != 0) {
                    //System.out.println("[Menú]");
                    System.out.println("\n[ Biblioteca > Consultas ]------------------|");
                    System.out.println("| 0- Volver atrás                           |");
                    System.out.println("|-------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            } else if (choice == 2) {
                while (choice != 0) {
                    System.out.println("\n[ Biblioteca > Gestión de autores ]---------|");
                    System.out.println("| 1- Ver lista de autores                   |");
                    System.out.println("| 2- Añadir autor                           |");
                    System.out.println("| 3- Modificar autor                        |");
                    System.out.println("| 4- Eliminar autor                         |");
                    System.out.println("| 0- Volver atrás                           |");
                    System.out.println("|-------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        // Print list of authors
                        System.out.println("\n[Biblioteca > Gestión de autores > Ver lista de autores]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 2) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Añadir autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.anadirAuthor(author)) System.out.println("(i) Autor \""+author+"\" añadido satisfractoriamente.");
                        else System.out.println("(i) El autor \""+author+"\" ya existe.");
                    } else if (choice == 3) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Modificar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el nuevo nombre del autor: ");
                        String newAuthorName = scanner.nextLine();
                        if (biblioteca.modifyAuthor(authorName, newAuthorName)) System.out.println("(i) Autor \""+authorName+"\" modificado a \""+newAuthorName+"\" satisfactoriamente.");
                        else System.out.println("(i) No se ha encontrado el autor \""+authorName+"\"");
                    } else if (choice == 4) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Eliminar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.eliminarAuthor(author)) System.out.println("(i) Autor \""+author+"\" eliminado satisfactoriamente");
                        else System.out.println("(i) No se ha encontrado el autor \""+author+"\"");
                    }
                }
            }  else if (choice == 3) {
                while (choice != 0) {
                    System.out.println("\n[ Biblioteca > Gestión de documentos ]------|");
                    System.out.println("| 1- Ver lista de documentos               |");
                    System.out.println("| 2- Añadir documento                       |");
                    System.out.println("| 3- Modificar documento                    |");
                    System.out.println("| 4- Eliminar documento                     |");
                    System.out.println("| 0- Volver atrás                           |");
                    System.out.println("|-------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Biblioteca > Gestión de documentos > Ver lista de documentos]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 2) {
                        System.out.println("\n[Biblioteca > Gestión de documentos > Añadir documento]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String author = scanner.nextLine();
                        System.out.print("  >> Introdueix el títol: ");
                        String title = scanner.nextLine();
                        System.out.print("  >> Introduce el contenido: ");
                        String content = scanner.nextLine();
                        biblioteca.addDocument(author, title, content);
                    } else if (choice == 3) {
                        System.out.println("\n[Biblioteca > Gestión de documentos > Modificar documento]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 4) {
                        System.out.println("\n[Biblioteca > Gestión de documentos > Eliminar documento]");
                        System.out.println("To Be Implemented");
                    }
                }
            }
            System.out.println("");
        }
    }
}