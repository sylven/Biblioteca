package edu.upc.fib;

import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Main {

     public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        // BUG: scanner skipping input after nextInt(), 2 workarounds (consider using 2nd one)
        // http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo

         // CONSIDER CHANGING: Read option as String and then convert

        // Navegación en consola
        int choice = 0;
        while (choice != -1) {
            System.out.println("[ Library ]----------------------------------------|");
            System.out.println("| 1- Consultas                                     |");
            System.out.println("| 2- Gestión de autores                            |");
            System.out.println("| 3- Gestión de documentos                         |");
            System.out.println("| 0- Salir del programa                            |");
            System.out.println("|--------------------------------------------------|");
            System.out.print("  >> Escoge una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) choice = -1;
            else if (choice == 1) {
                while (choice != 0) {
                    //System.out.println("[Menú]");
                    System.out.println("\n[ Library > Consultas ]----------------------------|");
                    System.out.println("| 1- Lista de títulos de un autor                  |");
                    System.out.println("| 2- Lista de autores que empiecen con un prefijo  |");
                    System.out.println("| 0- Volver atrás                                  |");
                    System.out.println("|--------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                       /* System.out.println("\n[Library > Consultas > Consulta por autor]");
                        System.out.println("\nElija un autor");
                        for (String s : biblioteca.getAuthors()) {
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
                        System.out.println("\n[Library > Consulta > Consulta de autor por prefijo ]");
                        System.out.print("  >> Introduce el prefijo: ");
                        String author = scanner.nextLine();
                        Set<String> authors = library.getAuthorsByPrefix(author);
                        if (authors.size() == 0) System.out.println("(i) No hay autores con ese prefijo.");
                        else {
                            for (String s: authors){
                                System.out.println(s);
                            }
                        }
                    }
                }
            } else if (choice == 2) {
                while (choice != 0) {
                    System.out.println("\n[ Library > Gestión de autores ]-------------------|");
                    System.out.println("| 1- Ver lista de autores                          |");
                    System.out.println("| 2- Añadir autor                                  |");
                    System.out.println("| 3- Modificar autor                               |");
                    System.out.println("| 4- Eliminar autor                                |");
                    System.out.println("| 0- Volver atrás                                  |");
                    System.out.println("|--------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Library > Gestión de autores > Ver lista de autores]");
                        Set<String> authorNames = library.getAuthorNames();
                        if (authorNames.size() == 0) System.out.println("(i) No hay autores.");
                        else {
                            for (String s : authorNames) {
                                System.out.println(s);
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Library > Gestión de autores > Añadir autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        if (library.addAutor(authorName)) System.out.println("(i) Author \""+authorName+"\" añadido satisfractoriamente.");
                        else System.out.println("(i) El autor \""+authorName+"\" ya existe.");
                    } else if (choice == 3) {
                        System.out.println("\n[Library > Gestión de autores > Modificar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el nuevo nombre del autor: ");
                        String newAuthorName = scanner.nextLine();
                        if (library.modifyAuthor(authorName, newAuthorName)) System.out.println("(i) Author \""+authorName+"\" modificado a \""+newAuthorName+"\" satisfactoriamente.");
                        else System.out.println("(i) No se ha encontrado el autor \""+authorName+"\"");
                    } else if (choice == 4) {
                        System.out.println("\n[Library > Gestión de autores > Eliminar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        if (library.removeAutor(authorName)) System.out.println("(i) Author \""+authorName+"\" eliminado satisfactoriamente.");
                        else System.out.println("(i) No se ha encontrado el autor \""+authorName+"\"");
                    }
                }
            }  else if (choice == 3) {
                while (choice != 0) {
                    System.out.println("\n[ Library > Gestión de documentos ]----------------|");
                    System.out.println("| 1- Ver lista de documentos                       |");
                    System.out.println("| 2- Añadir documento                              |");
                    System.out.println("| 3- Modificar documento                           |");
                    System.out.println("| 4- Eliminar documento                            |");
                    System.out.println("| 0- Volver atrás                                  |");
                    System.out.println("|--------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Library > Gestión de documentos > Ver lista de documentos]");
                        Set<String> documentTitles = library.getDocumentTitles();
                        if (documentTitles.size() == 0) System.out.println("(i) No hay documentos.");
                        else {
                            for (String s : documentTitles) {
                                System.out.println(s);
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Library > Gestión de documentos > Añadir documento]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título: ");
                        String title = scanner.nextLine();
                        System.out.println("  >> Introduce el contenido (finalizar con una línea con un 0): ");
                        String content = scanner.nextLine();
                        Vector<String> vContenido = new Vector<>();
                        while (!content.equals("0")) {
                            vContenido.add(content);
                            content = scanner.nextLine();
                        }
                        if (library.addDocument(authorName, title, vContenido)) System.out.println("(i) Document añadido satisfactoriamente.");
                        else System.out.println("El documento no se ha añadido porque ya existe.");
                    } else if (choice == 3) {
                        System.out.println("\n[Library > Gestión de documentos > Modificar documento]");
                        System.out.println("To Be Implemented");
                    } else if (choice == 4) {
                        System.out.println("\n[Library > Gestión de documentos > Eliminar documento]");
                        System.out.println("To Be Implemented");
                    }
                }
            }
            System.out.println("");
        }
    }
}