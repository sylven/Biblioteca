package edu.upc.fib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Javier on 28/11/2016.
 */
public class GraphicMain {
    DomainController domainControler = new DomainController();
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JButton buttonTestResetAddTest;
    private JButton buttonTestResetRenewLibrary;
    private JTextField textFieldLibraryGestionListAuthor;
    private JButton buttonLibraryGestionListAuthor;
    private JTextField textFieldLibraryGestionListTitle;
    private JButton buttonLibraryGestionListLoad;
    private JTextPane textPaneLibraryGestionList;
    private JButton buttonLibraryGestionListModify;
    private JButton buttonLibraryGestionListSaveChanges;
    private JButton buttonLibraryGestionAddSingle;
    private JButton buttonLibraryGestionAddFolder;
    private JTextField textFieldLibraryGestionAddAuthor;
    private JTextField textFieldLibraryGestionAddTitle;
    private JTextField textFieldConsutlsTitleAuthor;
    private JButton buttonConsutlsTitleAuthor11;
    private JList listConsutlsTitleAuthor;
    private JButton listTitlesButton;
    private JTextField textFieldConsultsContentAuthor;
    private JButton buttonConsultsContentAuthor;
    private JTextField textFieldConsultsContentTitle;
    private JButton buttonConsultsContentTitle;
    private JTextPane textPanelConsultsContent;
    private JTextField textFieldConsultsSeemsNumberOfDocs;
    private JButton buttonConsultsSeemsMethodeB;
    private JButton buttonConsultsSeemsMethodeA;
    private JList listConsultsSeems;
    private JTextField textFieldConsultsExpression;
    private JButton buttonConsultsExpression;
    private JList listConsultsExpression;
    private JList listAuthorGestionList;
    private JButton buttonAuthorGestionListCharge;
    private JTextField textFieldAuthorGestionList;
    private JButton buttonAuthorGestionListAdd;
    private JButton ButtonAuthorGestionListModify;
    private JButton buttonAuthorGestionListDelete;
    private JButton buttonLibraryGestionListTitle;
    private JButton buttonLibraryGestionListDelete;
    private JTextPane textPaneLibraryGestionAddContent;
    private JButton buttonLibraryGestionAddSaveIt;
    private JTextField textFieldConsultsSeemsAuthor;
    private JButton buttonConsultsSeemsAuthor;
    private JTextField textFieldConsultsSeemsTitle;
    private JButton buttonConsultsSeemsTitle;
    private JButton showContentButton;
    private SelectionDialog frame1;


    public GraphicMain() {
        buttonTestResetRenewLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //main(null);
            }
        });
        buttonTestResetAddTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String[] content = {"Donald John Trump (Nueva York, 14 de junio de 1946) es un empresario, político, personalidad televisiva y escritor estadounidense.",
                            "Siendo el presidente electo de los Estados Unidos de América; se convertirá en el 45° presidente de la Unión tras su toma de posesión, programada para el 20 de enero de 2017.",
                            "Es presidente de la Trump Organization y fundador de la empresa de hotel y juegos de azar Trump Entertainment Resorts, que es ahora propiedad de Carl Icahn.",
                            "Trump es una celebridad televisiva, y entre otras cosas fue el presentador del reality show The Apprentice, de la NBC, entre 2004 y 2015.",
                            "Es hijo de un empresario inmobiliario de Nueva York,4 en cuya compañía, Elizabeth Trump & Son, trabajó mientras estudiaba en la Escuela de Negocios Wharton de la Universidad de Pensilvania.",
                            "En 1968, se unió oficialmente a esa sociedad,5 que controla desde 1971, cuando la renombró Trump Organization.",
                            "En los años 1990 la empresa entró en bancarrota comercial, pero en la década siguiente se recuperó, lo que le reportó una fortuna de varios miles de millones de dólares.",
                            "Su campaña para obtener la candidatura republicana a la Casa Blanca para las elecciones de 2016 se vio caracterizada desde su inicio por una gran atención mediática a nivel nacional e internacional debido a la sucesión de declaraciones polémicas por parte de Trump.",
                            "Sus propuestas más repetidas consisten en la construcción de un muro a lo largo de la frontera con México y una política dura contra la inmigración ilegal, además de una prohibición temporal de la entrada de musulmanes en los Estados Unidos.",
                            "En lo económico, aboga por modificar la política comercial del país y fortalecer la producción nacional en detrimento de la deslocalización, en consonancia con posiciones proteccionistas."};
                    Vector<String> vStrings = new Vector(Arrays.asList(content));
                    domainControler.addDocument("Wikipedia", "Donald Trump", vStrings);
                    String[] content2 = {"El presidente de los Estados Unidos (en inglés, President of the United States; acrónimo: POTUS) es el jefe de Estado y de Gobierno de los Estados Unidos.",
                            "Es el más alto cargo político del país por influencia y reconocimiento.",
                            "El presidente lidera el poder ejecutivo del Gobierno federal.",
                            "Entre otros poderes y responsabilidades, el Artículo II de la Constitución de los Estados Unidos encarga al presidente la «fiel ejecución» de la ley federal, hace del presidente el comandante en jefe de las Fuerzas Armadas, lo autoriza a nombrar oficiales ejecutivos y judiciales con el consejo y consentimiento del Senado, lo sitúa al frente de la política exterior de los Estados Unidos, y permite al presidente conceder indultos o moratorias.",
                            "El presidente es elegido mediante sufragio indirecto por un colegio electoral (o por la Cámara de Representantes si el colegio electoral no concede la mayoría de votos a ningún candidato) para un mandato de cuatro años.",
                            "Desde la ratificación de la Vigesimosegunda Enmienda en 1951, ninguna persona puede ser elegida para el cargo de presidente más de dos veces.",
                            "En caso de muerte, destitución, dimisión o renuncia de un presidente, el vicepresidente asume la presidencia.",
                            "Hubo cuarenta y tres personas que asumieron el cargo y cuarenta y cuatro presidencias.",
                            "De las personas elegidas para el cargo, cuatro murieron durante su mandato por causas naturales, uno dimitió y cuatro fueron asesinados.",
                            "El primer presidente fue George Washington, que fue investido en 1789 después de un voto unánime del colegio electoral.",
                            "William Henry Harrison fue el que menos tiempo permaneció en el cargo, con tan solo 32 días, y Franklin D. Roosevelt, con sus 12 años en el puesto, fue el que permaneció por más tiempo y el único presidente que sirvió por más de dos mandatos (ganó cuatro veces las elecciones presidenciales).",
                            "El actual presidente es el demócrata Barack Obama, que fue investido para el puesto el 20 de enero de 2009.",
                            "El 9 de noviembre de 2016, el candidato por el Partido Republicano, Donald Trump, resultó electo en las elecciones presidenciales.",
                            "Desde principios del siglo XX, el papel hegemónico de los Estados Unidos en el escenario político y económico internacional ha llevado al presidente de este país a ser una figura conocida a nivel global y, debido a la condición del país como única superpotencia, en 2009 la revista Forbes calificaba a su titular como «la persona más poderosa del mundo»."};
                    Vector<String> vStrings2 = new Vector(Arrays.asList(content2));
                    domainControler.addDocument("Wikipedia", "Presidente de los Estados Unidos", vStrings2);
                    String[] content3 = {"Android es un sistema operativo basado en el núcleo Linux.",
                            "Fue diseñado principalmente para dispositivos móviles con pantalla táctil, como teléfonos inteligentes, tablets o tabléfonos; y también para relojes inteligentes, televisores y automóviles.",
                            "Inicialmente fue desarrollado por Android Inc., empresa que Google respaldó económicamente y más tarde, en 2005, la compró.",
                            "Android fue presentado en 2007 junto la fundación del Open Handset Alliance (un consorcio de compañías de hardware, software y telecomunicaciones) para avanzar en los estándares abiertos de los dispositivos móviles.",
                            "El primer móvil con el sistema operativo Android fue el HTC Dream y se vendió en octubre de 2008.",
                            "Los dispositivos de Android venden más que las ventas combinadas de Windows Phone e IOS.",
                            "El éxito del sistema operativo se ha convertido en objeto de litigios sobre patentes en el marco de las llamadas «Guerras por patentes de teléfonos inteligentes» (en inglés, Smartphone patent wars) entre las empresas de tecnología.",
                            "Según documentos secretos filtrados en 2013 y 2014, el sistema operativo es uno de los objetivos de las agencias de inteligencia internacionales.",
                            "La versión básica de Android es conocida como Android Open Source Project (AOSP).",
                            "El 25 de junio de 2014 en la Conferencia de Desarrolladores Google I/O, Google mostró una evolución de la marca Android, con el fin de unificar tanto el hardware como el software y ampliar mercados."};
                    Vector<String> vStrings3 = new Vector(Arrays.asList(content3));
                    domainControler.addDocument("Wikipedia", "Android", vStrings3);
                    String[] content4 = {"iOS es un sistema operativo móvil de la multinacional Apple Inc.",
                            "Originalmente desarrollado para el iPhone (iPhone OS), después se ha usado en dispositivos como el iPod touch y el iPad.",
                            "No permite la instalación de iOS en hardware de terceros.",
                            "Tenía el 26 % de cuota de mercado de sistemas operativos móviles vendidos en el último cuatrimestre de 2010, detrás de Android y Windows Phone.",
                            "Actualmente su sistema operativo se encuentra en la décima versión, mejor conocida como iOS 10.",
                            "Apple anunció el lunes 21 de septiembre de 2015 que su nuevo sistema operativo iOS 9 ya ha superado el 70 % de adopción dentro de sus dispositivos compatibles.",
                            "Según la marca de Cupertino, 2 de cada 3 dispositivos tienen iOS 9 instalado.",
                            "El 23 de septiembre de 2015 (tan solo una semana después de la salida de iOS 9), Apple saca iOS 9.0.1 para solucionar problemas relacionados con las alarmas y temporizadores.",
                            "Los elementos de control consisten de deslizadores, interruptores y botones.",
                            "La respuesta a las órdenes del usuario es inmediata y provee una interfaz fluida.",
                            "La interacción con el sistema operativo incluye gestos como deslices, toques, pellizcos, los cuales tienen definiciones diferentes dependiendo del contexto de la interfaz.",
                            "Se utilizan acelerómetros internos para hacer que algunas aplicaciones respondan a sacudir el dispositivo (por ejemplo, para el comando deshacer) o rotarlo en tres dimensiones (un resultado común es cambiar de modo vertical al apaisado u horizontal).",
                            "En el marco de las filtraciones acerca de los programas de vigilancia mundial de 2013-2014 de Edward Snowden, Der Spiegel publicó que la NSA estadounidense tiene grupos de trabajo dedicados a descifrar los sistemas de seguridad de iOS; además tiene pequeños programas conocidos como scripts que permiten a la agencia vigilar a los usuarios de las distintas versiones del sistema iOS su geolocalización, notas de voz, fotos y otras aplicaciones como Google Earth, Facebook o Yahoo! Messenger.",
                            "iOS se deriva de macOS, que a su vez está basado en Darwin BSD, y por lo tanto es un sistema operativo Tipo Unix.",
                            "iOS cuenta con cuatro capas de abstracción: la capa del núcleo del sistema operativo, la capa de \"Servicios Principales\", la capa de \"Medios\" y la capa de \"Cocoa Touch\"."};
                    Vector<String> vStrings4 = new Vector(Arrays.asList(content4));
                    domainControler.addDocument("Wikipedia", "iOs", vStrings4);
                    String[] content5 = {"Un automóvil de turismo, también conocido simplemente como turismo o automóvil o automotor, es el tipo de automóvil destinado al transporte de personas, con al menos cuatro ruedas y un máximo de nueve plazas incluido el conductor."};
                    Vector<String> vStrings5 = new Vector(Arrays.asList(content5));
                    domainControler.addDocument("Wikipedia", "Automóvil de turismo", vStrings5);
                }
            }
        });
        buttonTestResetRenewLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                domainControler = new DomainController();
            }
        });

        buttonLibraryGestionAddSaveIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldLibraryGestionAddAuthor.getText().length() == 0 || textFieldLibraryGestionAddTitle.getText().length() == 0 ||textPaneLibraryGestionAddContent.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Almacenar obra\" de nuevo");

                }
                else{
                    Vector<String> content = new Vector<String>();
                    content.add(textPaneLibraryGestionAddContent.getText());
                    if(domainControler.addDocument(textFieldLibraryGestionAddAuthor.getText(), textFieldLibraryGestionAddTitle.getText(), content)) {
                        JOptionPane.showMessageDialog(null, "Obra añadida correctamente");
                        textFieldLibraryGestionAddAuthor.setText("");
                        textFieldLibraryGestionAddTitle.setText("");
                        textPaneLibraryGestionAddContent.setText("");
                    }
                }
            }
        });
        buttonLibraryGestionListLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPaneLibraryGestionList.setText("");
                if(textFieldLibraryGestionListAuthor.getText().length() == 0 || textFieldLibraryGestionListTitle.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Cargar Contenido de la obra\" de nuevo");
                }
                else{
                    Vector<String> content = domainControler.getDocumentContent(textFieldLibraryGestionListAuthor.getText(), textFieldLibraryGestionListTitle.getText());
                    for(String sentence:content){
                        try {
                            textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), sentence, null);
                        }
                        catch(Exception exc) { System.out.println(e); }
                    }
                }
            }
        });
        showContentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanelConsultsContent.setText("");
                if(textFieldConsultsContentAuthor.getText().length() == 0 || textFieldConsultsContentTitle.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Mostrar Contenido\" de nuevo");
                }
                else{
                    Vector<String> content = domainControler.getDocumentContent(textFieldConsultsContentAuthor.getText(), textFieldConsultsContentTitle.getText());
                    for(String sentence:content){
                        try {
                            textPanelConsultsContent.getStyledDocument().insertString(textPanelConsultsContent.getStyledDocument().getLength(), sentence, null);
                        }
                        catch(Exception exc) { System.out.println(e); }
                    }
                }
            }
        });


        listTitlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String consultString = new String(textFieldConsutlsTitleAuthor.getText());
                Set<String> authorDocumentTitles =  domainControler.getAuthorDocumentTitles(consultString);
                int i = 1;
                DefaultListModel<String> resultset = new DefaultListModel<String>();
                //for (String s : authorDocumentTitles) {
                for (i = 0; i < 10;i++) {
                    //System.out.println(i + ". " + s);
                    //listConsutlsTitleAuthor.add(s.getChars();)
                    //resultset.addElement(s);
                    resultset.addElement("element " + i);
                    //i++;
                }
                listConsutlsTitleAuthor = new JList(resultset);
                listConsutlsTitleAuthor.setVisible(true);
            }
        });
        buttonConsutlsTitleAuthor11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                selectiondialog.main();
                selectiondialog.feedlist();
            }
        });
        buttonLibraryGestionListDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldLibraryGestionListAuthor.getText().length() == 0 || textFieldLibraryGestionListTitle.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Eliminar obra\" de nuevo");
                }
                else{
                    if(domainControler.removeDocument(textFieldLibraryGestionListAuthor.getText(), textFieldLibraryGestionListTitle.getText())) {
                        JOptionPane.showMessageDialog(null, "Obra añadida correctamente");
                        textFieldLibraryGestionListAuthor.setText("");
                        textFieldLibraryGestionListTitle.setText("");
                        textPaneLibraryGestionList.setText("");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Biblioteca");
        mainFrame.setContentPane(new GraphicMain().panel1);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    //public static void
}
