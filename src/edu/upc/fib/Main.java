package edu.upc.fib;

import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

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
                    System.out.println("| 1- Consulta por autor                     |");
                    System.out.println("| 2- Consulta d'autor per prefixe           |");
                    System.out.println("| 0- Volver atrás                           |");
                    System.out.println("|-------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                       /* System.out.println("\n[Biblioteca > Consultas > Consulta por autor]");
                        System.out.println("\nElija un autor");
                        for (String s : biblioteca.getAutores()) {
                            System.out.println(s);
                        }
                        String AuthorName = scanner.nextLine();
                        System.out.println("1");
                        Vector<String> TitulosAutor = biblioteca.consultarTituloAutor(AuthorName);
                        System.out.println("2");
                        for (String titulo : TitulosAutor) {
                            System.out.println("3");
                            System.out.print("\nAutor:");
                            ;
                            System.out.print(titulo);
                            System.out.println("8");
                        }*/
                    } else if (choice == 2) {
                        System.out.println("\n[Biblioteca > Consulta > Consulta d'autor per prefixe ]");
                        System.out.print("  >> Introduce el prefixe: ");
                        String author = scanner.nextLine();
                        Vector<String> prefixes=biblioteca.prefixeAutor(author);
                        for (String s: prefixes){
                            System.out.print("\n" + s);
                        }
                    }
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
                        System.out.println("\n[Biblioteca > Gestión de autores > Ver lista de autores]");
                        for (String s : biblioteca.getAutores()) {
                            System.out.println(s);
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Añadir autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.addAutor(author)) System.out.println("(i) Autor \""+author+"\" añadido satisfractoriamente.");
                        else System.out.println("(i) El autor \""+author+"\" ya existe.");
                    } else if (choice == 3) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Modificar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el nuevo nombre del autor: ");
                        String newAuthorName = scanner.nextLine();
                        if (biblioteca.modifyAutor(authorName, newAuthorName)) System.out.println("(i) Autor \""+authorName+"\" modificado a \""+newAuthorName+"\" satisfactoriamente.");
                        else System.out.println("(i) No se ha encontrado el autor \""+authorName+"\"");
                    } else if (choice == 4) {
                        System.out.println("\n[Biblioteca > Gestión de autores > Eliminar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String author = scanner.nextLine();
                        if (biblioteca.eliminarAutor(author)) System.out.println("(i) Autor \""+author+"\" eliminado satisfactoriamente");
                        else System.out.println("(i) No se ha encontrado el autor \""+author+"\"");
                    }
                }
            }  else if (choice == 3) {
                while (choice != 0) {
                    System.out.println("\n[ Biblioteca > Gestión de documentos ]------|");
                    System.out.println("| 1- Ver lista de documentos                |");
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
                        String autor = scanner.nextLine();
                        System.out.print("  >> Introduce el título: ");
                        String titulo = scanner.nextLine();
                        System.out.println("  >> Introduce el contenido (finalizar con una línea con un 0): ");
                        String contenido = scanner.nextLine();
                        Vector<String> vContenido = new Vector<>();
                        while (!contenido.equals("0")) {
                            vContenido.add(contenido);
                            contenido = scanner.nextLine();
                        }
                        if (biblioteca.addDocumento(autor, titulo, vContenido)) System.out.println("Documento añadido satisfactoriamente.");
                        else System.out.println("El documento no se ha añadido porque ya existe.");
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