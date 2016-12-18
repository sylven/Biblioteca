package edu.upc.fib;

import javafx.util.Pair;

import java.util.*;

public class Main {

     public static void main(String[] args) {
         GraphicMain pedo = new GraphicMain();
         //GraphicMain.main(null);//--------------------------------------------->si se comenta, se usa main en consola<---------------------------------------------
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
         DomainController domainController= new DomainController();

        // BUG: scanner skipping input after nextInt(), 2 workarounds (consider using 2nd one)
        // http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo

         // CONSIDER CHANGING: Read option as String and then convert

        // Navegación en consola
        int choice = 0;
        while (choice != -1) {
            System.out.println("[ Library ]--------------------------------------------|");
            System.out.println("| 1- Consultas                                         |");
            System.out.println("| 2- Gestión de autores                                |");
            System.out.println("| 3- Gestión de documentos                             |");
            System.out.println("| 4- Cargar datos de prueba                            |");
            System.out.println("| 0- Salir del programa                                |");
            System.out.println("|------------------------------------------------------|");
            System.out.print("  >> Escoge una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) choice = -1;
            else if (choice == 1) {
                while (choice != 0) {
                    System.out.println("\n[ Library > Consultas ]--------------------------------|");
                    System.out.println("| 1- Lista de títulos de un autor                      |");
                    System.out.println("| 2- Lista de autores que empiecen con un prefijo      |");
                    System.out.println("| 3- Contenido de un documento por autor y título      |");
                    System.out.println("| 4- Número de documentos más parecidos a un documento |");
                    System.out.println("| 5- Busqueda por expresión                            |");
                    System.out.println("| 6- Lista de títulos que empiecen con un prefijo      |");
                    System.out.println("| 0- Volver atrás                                      |");
                    System.out.println("|------------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Library > Consultas > Consulta por autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        if (library.existsAuthor(authorName)) {
                            Set<String> authorDocumentTitles = library.getAuthorDocumentTitles(authorName);
                            if (authorDocumentTitles.size() == 0) {
                                System.out.println("(i) El autor \"" + authorName + "\" no tiene documentos.");
                            } else {
                                int i = 1;
                                for (String s : authorDocumentTitles) {
                                    System.out.println(i + ". " + s);
                                    i++;
                                }
                            }
                        } else {
                            System.out.println("(i) El autor no existe.");
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Library > Consulta > Consulta de autor por prefijo]");
                        System.out.print("  >> Introduce el prefijo: ");
                        String prefijo = scanner.nextLine();
                        Set<String> authors = library.getAuthorsByPrefix(prefijo);
                        if (authors.size() == 0) System.out.println("(i) No hay autores con el prefijo " + prefijo + ".");
                        else {
                            int i = 1;
                            for (String s: authors){
                                System.out.println(i + ". " + s);
                                i++;
                            }
                        }
                    } else if (choice == 3) {
                        System.out.println("\n[Library > Consulta > Consulta contenido por autor y título]");
                        System.out.print("  >> Introduce el autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título: ");
                        String title = scanner.nextLine();
                        //Vector<String> content = library.getDocumentContent(authorName, title);
                        //for (String s : content) {
                        //    System.out.println(s);
                        //}
                        String content = library.getDocumentContent(authorName, title);
                        System.out.println(content);
                    } else if (choice == 4) {
                        System.out.println("\n[Library > Consulta > Número de documentos más parecidos a un documento]");
                        System.out.print("  >> Introduce el autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título: ");
                        String title = scanner.nextLine();
                        System.out.print("  >> Introduce el número de documentos parecidos: ");
                        int nDocuments = Integer.parseInt(scanner.nextLine());
                        List<Pair<String, String>> similarDocuments = library.getSimilarDocuments(authorName, title, nDocuments);
                        if (similarDocuments.size() == 0) {
                            System.out.println("(i) El documento no existe.");
                        } else {
                            int i = 1;
                            for (Pair<String, String> p : similarDocuments) {
                                System.out.println(i + ". \"" + p.getKey() + "\" de " + p.getValue());
                                i++;
                            }
                            if (i <= nDocuments) {
                                System.out.println("(i) No hay suficientes documentos para mostrar los solicitados.");
                            }
                        }
                    } else if (choice == 5) {
                        System.out.println("\n[Library > Consulta > Consulta por expresión]");
                        System.out.print("  >> Introduce la expresión a buscar(booleana): ");
                        String expression1 = scanner.nextLine();
                        System.out.print("  >> Introduce la expresión sobre la que buscar: ");
                        String expression2 = scanner.nextLine();
                        if( library.verifyExpression(expression1, expression2)){
                            System.out.print("La frase cumple la expresión");
                        }
                        else{
                            System.out.print("La frase **NO** cumple la expresión");
                        }
                        //HashMap<String, Vector<String> > content = library.getDocumentExpression(expression);
                        /*for (String s : content) { // implementar impresion autor + vector obras que cumplen
                            System.out.println(s);
                        }*/
                    } else if (choice == 6) {
                        System.out.println("\n[Library > Consulta > Lista de títulos que empiecen con un prefijo]");
                        System.out.print("  >> Introduce un prefijo de título: ");
                        String titlePrefix = scanner.nextLine();

                        List<Pair<String, String>> documents = library.getDocumentsByPrefix(titlePrefix);
                        if (documents.size() == 0) System.out.println("(i) No hay documentos con el prefijo " + titlePrefix + ".");
                        else {
                            int i = 1;
                            for (Pair<String, String> p: documents){
                                System.out.println(i + ". " + p.getKey() + " de " + p.getValue());
                                i++;
                            }
                        }
                    }
                }
            } else if (choice == 2) {
                while (choice != 0) {
                    System.out.println("\n[ Library > Gestión de autores ]-----------------------|");
                    System.out.println("| 1- Ver lista de autores                              |");
                    System.out.println("| 2- Añadir autor                                      |");
                    System.out.println("| 3- Modificar autor                                   |");
                    System.out.println("| 4- Eliminar autor                                    |");
                    System.out.println("| 0- Volver atrás                                      |");
                    System.out.println("|------------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Library > Gestión de autores > Ver lista de autores]");
                        Set<String> authorNames = library.getAuthorNames();
                        if (authorNames.size() == 0) {
                            System.out.println("(i) No hay autores.");
                        } else {
                            int i = 1;
                            for (String s : authorNames) {
                                System.out.println(i + ". " + s);
                                i++;
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Library > Gestión de autores > Añadir autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        if (library.addAuthor(authorName)) {
                            System.out.println("(i) Author \"" + authorName + "\" añadido satisfractoriamente.");
                        } else {
                            System.out.println("(i) Error: El autor \"" + authorName + "\" ya existe.");
                        }
                    } else if (choice == 3) {
                        System.out.println("\n[Library > Gestión de autores > Modificar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el nuevo nombre del autor: ");
                        String newAuthorName = scanner.nextLine();
                        if (library.modifyAuthor(authorName, newAuthorName)) {
                            System.out.println("(i) Author \"" + authorName + "\" modificado a \"" + newAuthorName +
                                    "\" satisfactoriamente.");
                        } else {
                            System.out.println("(i) Error: No se ha encontrado el autor \"" + authorName + "\".");
                        }
                    } else if (choice == 4) {
                        System.out.println("\n[Library > Gestión de autores > Eliminar autor]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        if (library.removeAuthor(authorName)) {
                            System.out.println("(i) Author \"" + authorName + "\" eliminado satisfactoriamente.");
                        } else {
                            System.out.println("(i) Error: No se ha encontrado el autor \"" + authorName + "\".");
                        }
                    }
                }
            }  else if (choice == 3) {
                while (choice != 0) {
                    System.out.println("\n[ Library > Gestión de documentos ]--------------------|");
                    System.out.println("| 1- Ver lista de documentos                           |");
                    System.out.println("| 2- Añadir documento                                  |");
                    System.out.println("| 3- Modificar documento                               |");
                    System.out.println("| 4- Eliminar documento                                |");
                    System.out.println("| 0- Volver atrás                                      |");
                    System.out.println("|------------------------------------------------------|");
                    System.out.print("  >> Escoge una opción: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 1) {
                        System.out.println("\n[Library > Gestión de documentos > Ver lista de documentos]");
                        Set<String> documentTitles = library.getDocumentTitles();
                        if (documentTitles.size() == 0) System.out.println("(i) No hay documentos.");
                        else {
                            int i = 1;
                            for (String s : documentTitles) {
                                System.out.println(i + ". " + s);
                                i++;
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("\n[Library > Gestión de documentos > Añadir documento]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título: ");
                        String title = scanner.nextLine();

                        System.out.println("  >> Introduce el contenido (finalizar con una línea con un 0):");
                        //Vector<String> vContenido = new Vector<>();
                        String vContenido = "";
                        String content = scanner.nextLine();
                        do {
                            vContenido += content;
                            content = scanner.nextLine();
                        } while (!content.equals("0"));

                        if (library.addDocument(authorName, title, vContenido)) {
                            System.out.println("(i) Documento añadido satisfactoriamente.");
                        } else {
                            System.out.println("(i) Error: El documento no se ha añadido porque ya existe.");
                        }
                    } else if (choice == 3) {
                        System.out.println("\n[Library > Gestión de documentos > Modificar documento]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título del documento: ");
                        String title = scanner.nextLine();
                        if (library.existsDocument(authorName, title)) {
                            while (choice != 0) {
                                System.out.println("\n[ Library > Gestión de documentos >                |");
                                System.out.println("| Modificar documento ]----------------------------|");
                                System.out.println("| 1- Modificar autor                               |");
                                System.out.println("| 2- Modificar título                              |");
                                System.out.println("| 3- Modificar contenido                           |");
                                System.out.println("| 0- Volver atrás                                  |");
                                System.out.println("|--------------------------------------------------|");
                                System.out.print("  >> Escoge una opción: ");
                                choice = scanner.nextInt();
                                scanner.nextLine();
                                if (choice == 1) {
                                    System.out.print("  >> Introduce el nuevo autor del documento: ");
                                    String newAuthorName = scanner.nextLine();
                                    if(library.modifyDocumentAuthor(authorName, title, newAuthorName)) {
                                        System.out.println("(i) Autor del documento modificado satisfactoriamente.");
                                    } else {
                                        System.out.println("(i) Error: El nuevo autor ya tiene un documento con el mismo título.");
                                    }
                                } else if (choice == 2) {
                                    System.out.print("  >> Introduce el nuevo titulo del documento: ");
                                    String newTitle = scanner.nextLine();
                                    if(library.modifyDocumentTitle(authorName, title, newTitle)) {
                                        System.out.println("(i) Título del documento modificado satisfactoriamente.");
                                    } else {
                                        System.out.println("(i) Error: El autor ya tenía un documento con el mismo título.");
                                    }
                                } else if (choice == 3) {
                                    System.out.println("  >> Introduce el nuevo contenido del documento (finalizar con una línea con un 0):");
                                    String content = scanner.nextLine();
                                    //Vector<String> newContent = new Vector<>();
                                    String newContent = "";
                                    while (!content.equals("0")) {
                                        //newContent.add(content);
                                        newContent += content;
                                        content = scanner.nextLine();
                                    }
                                    if(library.modifyDocumentContent(authorName, title, newContent)) {
                                        System.out.println("(i) Contenido del documento modificado satisfactoriamente.");
                                    } else {
                                        System.out.println();
                                    }
                                }
                            }
                        } else {
                            System.out.println("(i) El documento no existe o no pertenece a este autor.");
                        }

                    } else if (choice == 4) {
                        System.out.println("\n[Library > Gestión de documentos > Eliminar documento]");
                        System.out.print("  >> Introduce el nombre del autor: ");
                        String authorName = scanner.nextLine();
                        System.out.print("  >> Introduce el título del documento: ");
                        String title = scanner.nextLine();
                        if (library.removeDocument(authorName, title)) {
                            System.out.println("(i) Documento eliminado satisfactoriamente.");
                        } else {
                            System.out.println("(i) El documento \"" + title + "\" del autor \"" + authorName +
                                    "\" no existe.");
                        }
                    }
                }
            }
            else if (choice == 4) {
                String content;
                content = "Donald John Trump (Nueva York, 14 de junio de 1946) es un empresario, político, personalidad televisiva y escritor estadounidense.\nSiendo el presidente electo de los Estados Unidos de América; se convertirá en el 45° presidente de la Unión tras su toma de posesión, programada para el 20 de enero de 2017. Es presidente de la Trump Organization y fundador de la empresa de hotel y juegos de azar Trump Entertainment Resorts, que es ahora propiedad de Carl Icahn. Trump es una celebridad televisiva, y entre otras cosas fue el presentador del reality show The Apprentice, de la NBC, entre 2004 y 2015. Es hijo de un empresario inmobiliario de Nueva York,4 en cuya compañía, Elizabeth Trump & Son, trabajó mientras estudiaba en la Escuela de Negocios Wharton de la Universidad de Pensilvania. En 1968, se unió oficialmente a esa sociedad,5 que controla desde 1971, cuando la renombró Trump Organization. En los años 1990 la empresa entró en bancarrota comercial, pero en la década siguiente se recuperó, lo que le reportó una fortuna de varios miles de millones de dólares. Su campaña para obtener la candidatura republicana a la Casa Blanca para las elecciones de 2016 se vio caracterizada desde su inicio por una gran atención mediática a nivel nacional e internacional debido a la sucesión de declaraciones polémicas por parte de Trump. Sus propuestas más repetidas consisten en la construcción de un muro a lo largo de la frontera con México y una política dura contra la inmigración ilegal, además de una prohibición temporal de la entrada de musulmanes en los Estados Unidos. En lo económico, aboga por modificar la política comercial del país y fortalecer la producción nacional en detrimento de la deslocalización, en consonancia con posiciones proteccionistas.";                library.addDocument("Wikipedia", "Donald Trump", content);

                content = "El presidente de los Estados Unidos (en inglés, President of the United States; acrónimo: POTUS) es el jefe de Estado y de Gobierno de los Estados Unidos. Es el más alto cargo político del país por influencia y reconocimiento. El presidente lidera el poder ejecutivo del Gobierno federal. Entre otros poderes y responsabilidades, el Artículo II de la Constitución de los Estados Unidos encarga al presidente la «fiel ejecución» de la ley federal, hace del presidente el comandante en jefe de las Fuerzas Armadas, lo autoriza a nombrar oficiales ejecutivos y judiciales con el consejo y consentimiento del Senado, lo sitúa al frente de la política exterior de los Estados Unidos, y permite al presidente conceder indultos o moratorias. El presidente es elegido mediante sufragio indirecto por un colegio electoral (o por la Cámara de Representantes si el colegio electoral no concede la mayoría de votos a ningún candidato) para un mandato de cuatro años. Desde la ratificación de la Vigesimosegunda Enmienda en 1951, ninguna persona puede ser elegida para el cargo de presidente más de dos veces. En caso de muerte, destitución, dimisión o renuncia de un presidente, el vicepresidente asume la presidencia. Hubo cuarenta y tres personas que asumieron el cargo y cuarenta y cuatro presidencias. De las personas elegidas para el cargo, cuatro murieron durante su mandato por causas naturales, uno dimitió y cuatro fueron asesinados. El primer presidente fue George Washington, que fue investido en 1789 después de un voto unánime del colegio electoral. William Henry Harrison fue el que menos tiempo permaneció en el cargo, con tan solo 32 días, y Franklin D. Roosevelt, con sus 12 años en el puesto, fue el que permaneció por más tiempo y el único presidente que sirvió por más de dos mandatos (ganó cuatro veces las elecciones presidenciales). El actual presidente es el demócrata Barack Obama, que fue investido para el puesto el 20 de enero de 2009. El 9 de noviembre de 2016, el candidato por el Partido Republicano, Donald Trump, resultó electo en las elecciones presidenciales. Desde principios del siglo XX, el papel hegemónico de los Estados Unidos en el escenario político y económico internacional ha llevado al presidente de este país a ser una figura conocida a nivel global y, debido a la condición del país como única superpotencia, en 2009 la revista Forbes calificaba a su titular como «la persona más poderosa del mundo».";
                library.addDocument("Wikipedia", "Presidente de los Estados Unidos", content);

                content = "Android es un sistema operativo basado en el núcleo Linux. Fue diseñado principalmente para dispositivos móviles con pantalla táctil, como teléfonos inteligentes, tablets o tabléfonos; y también para relojes inteligentes, televisores y automóviles. Inicialmente fue desarrollado por Android Inc., empresa que Google respaldó económicamente y más tarde, en 2005, la compró. Android fue presentado en 2007 junto la fundación del Open Handset Alliance (un consorcio de compañías de hardware, software y telecomunicaciones) para avanzar en los estándares abiertos de los dispositivos móviles. El primer móvil con el sistema operativo Android fue el HTC Dream y se vendió en octubre de 2008. Los dispositivos de Android venden más que las ventas combinadas de Windows Phone e IOS. El éxito del sistema operativo se ha convertido en objeto de litigios sobre patentes en el marco de las llamadas «Guerras por patentes de teléfonos inteligentes» (en inglés, Smartphone patent wars) entre las empresas de tecnología. Según documentos secretos filtrados en 2013 y 2014, el sistema operativo es uno de los objetivos de las agencias de inteligencia internacionales. La versión básica de Android es conocida como Android Open Source Project (AOSP). El 25 de junio de 2014 en la Conferencia de Desarrolladores Google I/O, Google mostró una evolución de la marca Android, con el fin de unificar tanto el hardware como el software y ampliar mercados.";
                library.addDocument("Wikipedia", "Android", content);

                content = "iOS es un sistema operativo móvil de la multinacional Apple Inc. Originalmente desarrollado para el iPhone (iPhone OS), después se ha usado en dispositivos como el iPod touch y el iPad. No permite la instalación de iOS en hardware de terceros. Tenía el 26 % de cuota de mercado de sistemas operativos móviles vendidos en el último cuatrimestre de 2010, detrás de Android y Windows Phone. Actualmente su sistema operativo se encuentra en la décima versión, mejor conocida como iOS 10. Apple anunció el lunes 21 de septiembre de 2015 que su nuevo sistema operativo iOS 9 ya ha superado el 70 % de adopción dentro de sus dispositivos compatibles. Según la marca de Cupertino, 2 de cada 3 dispositivos tienen iOS 9 instalado. El 23 de septiembre de 2015 (tan solo una semana después de la salida de iOS 9), Apple saca iOS 9.0.1 para solucionar problemas relacionados con las alarmas y temporizadores. Los elementos de control consisten de deslizadores, interruptores y botones. La respuesta a las órdenes del usuario es inmediata y provee una interfaz fluida. La interacción con el sistema operativo incluye gestos como deslices, toques, pellizcos, los cuales tienen definiciones diferentes dependiendo del contexto de la interfaz. Se utilizan acelerómetros internos para hacer que algunas aplicaciones respondan a sacudir el dispositivo (por ejemplo, para el comando deshacer) o rotarlo en tres dimensiones (un resultado común es cambiar de modo vertical al apaisado u horizontal). En el marco de las filtraciones acerca de los programas de vigilancia mundial de 2013-2014 de Edward Snowden, Der Spiegel publicó que la NSA estadounidense tiene grupos de trabajo dedicados a descifrar los sistemas de seguridad de iOS; además tiene pequeños programas conocidos como scripts que permiten a la agencia vigilar a los usuarios de las distintas versiones del sistema iOS su geolocalización, notas de voz, fotos y otras aplicaciones como Google Earth, Facebook o Yahoo! Messenger. iOS se deriva de macOS, que a su vez está basado en Darwin BSD, y por lo tanto es un sistema operativo Tipo Unix. iOS cuenta con cuatro capas de abstracción: la capa del núcleo del sistema operativo, la capa de \"Servicios Principales\", la capa de \"Medios\" y la capa de \"Cocoa Touch\".";
                library.addDocument("Wikipedia", "iOs", content);

                content = "Un automóvil de turismo, también conocido simplemente como turismo o automóvil o automotor, es el tipo de automóvil destinado al transporte de personas, con al menos cuatro ruedas y un máximo de nueve plazas incluido el conductor.";
                library.addDocument("Wikipedia", "Automóvil de turismo", content);
            }
            System.out.println("");
        }
    }

}
