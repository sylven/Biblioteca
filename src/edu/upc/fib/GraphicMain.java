package edu.upc.fib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.function.BooleanSupplier;

import javafx.util.Pair;

public class GraphicMain extends JFrame {
    DomainController domainControler = new DomainController();
    private boolean modifyingDocument=false;
    private boolean modifyingAuthor=false;
    private String authorModyfied2;
    private String authorModyfied;
    private String titleModyfied;
    private String contentModyfied;
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
    private JButton buttonLibraryGestionAddSingle;
    private JButton buttonLibraryGestionAddFolder;
    private JTextField textFieldLibraryGestionAddAuthor;
    private JTextField textFieldLibraryGestionAddTitle;
    public JTextField textFieldConsutlsTitleAuthor;
    private JButton buttonConsutlsTitleAuthor11;
    private JList listConsutlsTitleAuthor;
    private JButton listTitlesButton;
    private JTextField textFieldConsultsContentAuthor;
    private JButton buttonConsultsContentAuthor;
    private JTextField textFieldConsultsContentTitle;
    private JButton buttonConsultsContentTitle;
    private JTextPane textPanelConsultsContent;
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
    private JButton buttonAuthorGestionListModify;
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
    private JSpinner spinnerbuttonConsultsSeems;
    private JButton buttonLibraryGestionAddAuthor;
    private JButton buttonListTitleShowDocument;
    private JButton buttonListSimilarShowDocument;
    private JButton buttonListExpressionShowDocument;
    private JButton buttonListTitleSimilarDocuments;
    private JButton buttonListExpressionSimilarDocuments;


    public GraphicMain() {
        //JFrame mainFrame = new JFrame("Biblioteca");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        GraphicMain2();
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
           @Override
           public void windowClosing(java.awt.event.WindowEvent e) {
               domainControler.saveStatuts();
               System.exit(0);
           }
        });

        buttonAuthorGestionListAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = domainControler.addAuthor(textFieldAuthorGestionList.getText().toString());
                if (result && ! (textFieldAuthorGestionList.getText().toString().length() == 0)){
                    textFieldAuthorGestionList.setText("");
                    JOptionPane.showMessageDialog(null, "Autor añadido correctamente");

                }
                else{JOptionPane.showMessageDialog(null, "ERROR, el autor ya existía o el campo está vacío");}
                update_listAuthorGestionList();
            }
        });
        buttonAuthorGestionListCharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_listAuthorGestionList();
            }
        });
        buttonAuthorGestionListDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listAuthorGestionList.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un autor y luego haz clic en \"Eliminar\"");
                }
                else {
                    boolean result = domainControler.removeAuthor(listAuthorGestionList.getSelectedValue().toString());
                    if (!result) {
                        JOptionPane.showMessageDialog(null, "ERROR! No se pudo borar... El autor tiene obras!");
                    }
                    update_listAuthorGestionList();
                }
            }
        });
        buttonAuthorGestionListModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!modifyingAuthor){
                    if(listAuthorGestionList.isSelectionEmpty()){
                         JOptionPane.showMessageDialog(null, "Selecciona un autor y luego haz clic en \"Modificar\"");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Modifica el nombre y haz clic en \"Guardar Cambios\" cuando hayas terminado");
                        modifyingAuthor = true;
                        textFieldAuthorGestionList.setBackground(Color.GREEN);
                        authorModyfied2 = listAuthorGestionList.getSelectedValue().toString();
                        buttonAuthorGestionListModify.setText("Guardar Cambios");
                        textFieldAuthorGestionList.setText(authorModyfied2);
                    }
                }
                else{
                    if (textFieldAuthorGestionList.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "El campo de Autor está vacio, por favor, verifíquelo y pulse \"Guardar Cambios\" de nuevo");
                    }
                    if (domainControler.modifyAuthor(authorModyfied2, textFieldAuthorGestionList.getText())) {
                        JOptionPane.showMessageDialog(null, "Cambios guardados");
                    }
                    modifyingAuthor=false;
                    textFieldAuthorGestionList.setBackground(Color.WHITE);
                    buttonAuthorGestionListModify.setText("Modificar");
                    update_listAuthorGestionList();
                }
            }
        });
        buttonConsultsContentAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> authorsStarting = new HashSet<String>();
                String pref = textFieldConsultsContentAuthor.getText().toString();
                authorsStarting = domainControler.getAuthorsByPrefix(pref);
                selectiondialog.feedlist(authorsStarting, textFieldConsultsContentAuthor);
            }
        });
        buttonConsultsContentTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> booksof = new HashSet<String>();
                String pref = textFieldConsultsContentAuthor.getText().toString();
                booksof = domainControler.getAuthorDocumentTitles(pref);
                selectiondialog.feedlist(booksof, textFieldConsultsContentTitle);
            }
        });
        buttonConsultsSeemsAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> authorsStarting = new HashSet<String>();
                String pref = textFieldConsultsSeemsAuthor.getText().toString();
                authorsStarting = domainControler.getAuthorsByPrefix(pref);
                selectiondialog.feedlist(authorsStarting, textFieldConsultsSeemsAuthor);
            }
        });
        buttonConsultsSeemsTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> booksof = new HashSet<String>();
                String pref = textFieldConsultsSeemsAuthor.getText().toString();
                booksof = domainControler.getAuthorDocumentTitles(pref);
                selectiondialog.feedlist(booksof, textFieldConsultsSeemsTitle);
            }
        });
        buttonLibraryGestionListAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> authorsStarting = new HashSet<String>();
                String pref = textFieldLibraryGestionListAuthor.getText().toString();
                authorsStarting = domainControler.getAuthorsByPrefix(pref);
                selectiondialog.feedlist(authorsStarting, textFieldLibraryGestionListAuthor);
            }
        });
        buttonLibraryGestionListTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> booksof = new HashSet<String>();
                String pref = textFieldLibraryGestionListAuthor.getText().toString();
                booksof = domainControler.getAuthorDocumentTitles(pref);
                selectiondialog.feedlist(booksof, textFieldLibraryGestionListTitle);
            }
        });
        buttonLibraryGestionAddAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> authorsStarting = new HashSet<String>();
                String pref = textFieldLibraryGestionAddAuthor.getText().toString();
                authorsStarting = domainControler.getAuthorsByPrefix(pref);
                selectiondialog.feedlist(authorsStarting, textFieldLibraryGestionAddAuthor);
            }
        });
        buttonConsultsSeemsMethodeA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldConsultsSeemsAuthor.getText().length() == 0 || textFieldConsultsSeemsTitle.getText().length() == 0 ||(Integer)spinnerbuttonConsultsSeems.getValue() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Valor de Búsqueda\" de nuevo");

                }
                java.util.List<Pair<String, String>> similarDocuments= domainControler.getSimilarDocuments(textFieldConsultsSeemsAuthor.getText(), textFieldConsultsSeemsTitle.getText(), (Integer)spinnerbuttonConsultsSeems.getValue());
                DefaultListModel lista = new DefaultListModel();
                int i = 1;
                String document;
                for (Pair<String,String> s: similarDocuments){
                    document=s.getValue() + "/" + s.getKey();
                    lista.addElement(document);
                    i++;
                }
                listConsultsSeems.setModel(lista);
            }
        });
        buttonLibraryGestionAddSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectionwindowfile = new JFileChooser();
                JPanel contentpane = new JPanel();
                int seleccion=selectionwindowfile.showOpenDialog(contentpane);
                if(seleccion==JFileChooser.APPROVE_OPTION) {
                    File fichero = selectionwindowfile.getSelectedFile();
                    String author = new String();
                    String title = new String();
                    String frase = new String();
                    Vector<String> content = new Vector();
                    //String content = "";
                    try {
                        convertTodocument(fichero.toString(), content);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    author = content.firstElement();
                    content.remove(0);
                    title = content.firstElement();
                    content.remove(0);
                    Boolean resutlt = domainControler.addDocument(author, title, content.firstElement());
                    if(resutlt){JOptionPane.showMessageDialog(null, "El documento de \"" + author +"\" con título \"" + title + "\" ha sido añadido satisfactoriamente");}
                    else {JOptionPane.showMessageDialog(null, "Error, el documento ya está importado?");}
                }
            }
        });
        buttonListTitleShowDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listConsutlsTitleAuthor.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un Documento y luego haz clic en \"Visualizar Documento\"");
                }
                else {
                    String author = textFieldConsutlsTitleAuthor.getText();
                    String title = listConsutlsTitleAuthor.getSelectedValue().toString();
                    tabbedPane1.setSelectedIndex(2);
                    tabbedPane4.setSelectedIndex(0);
                    textFieldLibraryGestionListAuthor.setText(author);
                    textFieldLibraryGestionListTitle.setText(title);
                    //Vector<String> content = domainControler.getDocumentContent(author, title);
                    //for (String sentence : content) {
                    //    try {
                    //        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), sentence, null);
                    //    } catch (Exception exc) {
                    //        System.out.println(e);
                    //    }
                    //}
                    String content = domainControler.getDocumentContent(author, title);
                    try {
                        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), content, null);
                    } catch (Exception exc) {
                        System.out.println(e);
                    }
                }
            }
        });
        buttonListSimilarShowDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listConsultsSeems.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un Documento y luego haz clic en \"Visualizar Documento\"");
                }
                else {
                    String documentIdentifyer = listConsultsSeems.getSelectedValue().toString();
                    String author = null;
                    String title = null;
                    for (int i = 0; i < documentIdentifyer.length(); ++i) {
                        if (documentIdentifyer.charAt(i) == '/') {
                            author = documentIdentifyer.substring(0, i);
                            title = documentIdentifyer.substring(i + 1);
                        }
                    }
                    tabbedPane1.setSelectedIndex(2);
                    tabbedPane4.setSelectedIndex(0);
                    textFieldLibraryGestionListAuthor.setText(author);
                    textFieldLibraryGestionListTitle.setText(title);
                    //Vector<String> content = domainControler.getDocumentContent(author, title);
                    //for (String sentence : content) {
                    //    try {
                    //        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), sentence, null);
                    //    } catch (Exception exc) {
                    //        System.out.println(e);
                    //    }
                    //}
                    String content = domainControler.getDocumentContent(author, title);
                    try {
                        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), content, null);
                    } catch (Exception exc) {
                        System.out.println(e);
                    }
                }
            }
        });
        buttonListExpressionShowDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listConsultsExpression.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un Documento y luego haz clic en \"Visualizar Documento\"");
                }
                String documentIdentifyer=listConsultsExpression.getSelectedValue().toString();
                String author=null;
                String title=null;
                for(int i=0;i<documentIdentifyer.length();++i) {
                    if(documentIdentifyer.charAt(i)=='/'){
                        author=documentIdentifyer.substring(0,i);
                        title=documentIdentifyer.substring(i+1);
                    }
                }
                tabbedPane1.setSelectedIndex(2);
                tabbedPane4.setSelectedIndex(0);
                textFieldLibraryGestionListAuthor.setText(author);
                textFieldLibraryGestionListTitle.setText(title);
                //Vector<String> content = domainControler.getDocumentContent(author, title);
                //for(String sentence:content){
                //    try {
                //        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), sentence, null);
                //    }
                //    catch(Exception exc) { System.out.println(e); }
                //}
                String content = domainControler.getDocumentContent(author, title);
                try {
                    textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), content, null);
                } catch (Exception exc) {
                    System.out.println(e);
                }
            }
        });
        buttonListTitleSimilarDocuments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listConsutlsTitleAuthor.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un Documento y luego haz clic en \"Visualizar Documentos Parecidos\"");
                }
                else {
                    String author = textFieldConsutlsTitleAuthor.getText();
                    String title = listConsutlsTitleAuthor.getSelectedValue().toString();
                    tabbedPane2.setSelectedIndex(2);
                    textFieldConsultsSeemsAuthor.setText(author);
                    textFieldConsultsSeemsTitle.setText(title);
                    JOptionPane.showMessageDialog(null, "Seleciona el número de documentos a mostrar y haz clic en el valor de busqueda que desees");
                }
            }
        });
        buttonListExpressionSimilarDocuments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listConsultsExpression.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Selecciona un Documento y luego haz clic en \"Visualizar Documentos Parecidos\"");
                }
                else {
                    String documentIdentifyer = listConsultsExpression.getSelectedValue().toString();
                    String author = null;
                    String title = null;
                    for (int i = 0; i < documentIdentifyer.length(); ++i) {
                        if (documentIdentifyer.charAt(i) == '/') {
                            author = documentIdentifyer.substring(0, i);
                            title = documentIdentifyer.substring(i + 1);
                        }
                    }
                    tabbedPane2.setSelectedIndex(2);
                    textFieldConsultsSeemsAuthor.setText(author);
                    textFieldConsultsSeemsTitle.setText(title);
                    JOptionPane.showMessageDialog(null, "Seleciona el número de documentos a mostrar y haz clic en el valor de busqueda que desees");
                }
            }
        });
        buttonLibraryGestionAddFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser selectionwindowfile = new JFileChooser();
                selectionwindowfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                JPanel contentpane = new JPanel();
                int seleccion=selectionwindowfile.showOpenDialog(contentpane);
                if(seleccion==JFileChooser.APPROVE_OPTION) {
                    File fichero = selectionwindowfile.getSelectedFile();
                    File[] listOfFiles = fichero.listFiles();
                    int totaladded = 0;
                    for(int i = 0; i < listOfFiles.length; i++){
                        String author = new String();
                        String title = new String();
                        Vector<String> content = new Vector();
                        try {
                            if(listOfFiles[i].toString().endsWith(".txt") ||listOfFiles[i].toString().endsWith(".TXT") ){
                                convertTodocument(/*fichero.toString() +*/ listOfFiles[i].toString(), content);
                                author = content.firstElement();
                                content.remove(0);
                                title = content.firstElement();
                                content.remove(0);
                                if(domainControler.addDocument(author, title, content.firstElement())){totaladded++;}
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han añadido " + totaladded + " documentos");
                }
            }
        });
        buttonConsultsExpression.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldConsultsExpression.getText().length() == 0 || textFieldConsultsExpression.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "No hay nada que buscar, por favor, verifíquelo y pulse \"Buscar en la bilbioteca\" de nuevo");
                }
                List<Pair<String, String>> result = domainControler.getBooleanDocuments(textFieldConsultsExpression.getText().toString());
                DefaultListModel lista = new DefaultListModel();
                int i = 1;
                String document;
                for (Pair<String,String> s: result){
                    document=s.getValue() + "/" + s.getKey();
                    lista.addElement(document);
                    i++;
                }
                listConsultsExpression.setModel(lista);
                if (result.size() == 0){JOptionPane.showMessageDialog(null, "Lamentándolo mucho no hemos podido encontrar nada, por favor, verifique ortografía y sintaxis booleana e inténtelo de nuevo");}
            }
        });
    }


    public void GraphicMain2() {
        textPaneLibraryGestionList.setEditable(false);
        buttonTestResetAddTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    String content;
                    content = "Donald John Trump (Nueva York, 14 de junio de 1946) es un empresario, político, personalidad televisiva y escritor estadounidense.\n\nSiendo el presidente electo de los Estados Unidos de América; se convertirá en el 45° presidente de la Unión tras su toma de posesión, programada para el 20 de enero de 2017. Es presidente de la Trump Organization y fundador de la empresa de hotel y juegos de azar Trump Entertainment Resorts, que es ahora propiedad de Carl Icahn. Trump es una celebridad televisiva, y entre otras cosas fue el presentador del reality show The Apprentice, de la NBC, entre 2004 y 2015. Es hijo de un empresario inmobiliario de Nueva York,4 en cuya compañía, Elizabeth Trump & Son, trabajó mientras estudiaba en la Escuela de Negocios Wharton de la Universidad de Pensilvania. En 1968, se unió oficialmente a esa sociedad,5 que controla desde 1971, cuando la renombró Trump Organization. En los años 1990 la empresa entró en bancarrota comercial, pero en la década siguiente se recuperó, lo que le reportó una fortuna de varios miles de millones de dólares. Su campaña para obtener la candidatura republicana a la Casa Blanca para las elecciones de 2016 se vio caracterizada desde su inicio por una gran atención mediática a nivel nacional e internacional debido a la sucesión de declaraciones polémicas por parte de Trump. Sus propuestas más repetidas consisten en la construcción de un muro a lo largo de la frontera con México y una política dura contra la inmigración ilegal, además de una prohibición temporal de la entrada de musulmanes en los Estados Unidos. En lo económico, aboga por modificar la política comercial del país y fortalecer la producción nacional en detrimento de la deslocalización, en consonancia con posiciones proteccionistas.";
                    domainControler.addDocument("Wikipedia", "Donald Trump", content);

                    content = "El presidente de los Estados Unidos (en inglés, President of the United States; acrónimo: POTUS) es el jefe de Estado y de Gobierno de los Estados Unidos. Es el más alto cargo político del país por influencia y reconocimiento. El presidente lidera el poder ejecutivo del Gobierno federal. Entre otros poderes y responsabilidades, el Artículo II de la Constitución de los Estados Unidos encarga al presidente la «fiel ejecución» de la ley federal, hace del presidente el comandante en jefe de las Fuerzas Armadas, lo autoriza a nombrar oficiales ejecutivos y judiciales con el consejo y consentimiento del Senado, lo sitúa al frente de la política exterior de los Estados Unidos, y permite al presidente conceder indultos o moratorias. El presidente es elegido mediante sufragio indirecto por un colegio electoral (o por la Cámara de Representantes si el colegio electoral no concede la mayoría de votos a ningún candidato) para un mandato de cuatro años. Desde la ratificación de la Vigesimosegunda Enmienda en 1951, ninguna persona puede ser elegida para el cargo de presidente más de dos veces. En caso de muerte, destitución, dimisión o renuncia de un presidente, el vicepresidente asume la presidencia. Hubo cuarenta y tres personas que asumieron el cargo y cuarenta y cuatro presidencias. De las personas elegidas para el cargo, cuatro murieron durante su mandato por causas naturales, uno dimitió y cuatro fueron asesinados. El primer presidente fue George Washington, que fue investido en 1789 después de un voto unánime del colegio electoral. William Henry Harrison fue el que menos tiempo permaneció en el cargo, con tan solo 32 días, y Franklin D. Roosevelt, con sus 12 años en el puesto, fue el que permaneció por más tiempo y el único presidente que sirvió por más de dos mandatos (ganó cuatro veces las elecciones presidenciales). El actual presidente es el demócrata Barack Obama, que fue investido para el puesto el 20 de enero de 2009. El 9 de noviembre de 2016, el candidato por el Partido Republicano, Donald Trump, resultó electo en las elecciones presidenciales. Desde principios del siglo XX, el papel hegemónico de los Estados Unidos en el escenario político y económico internacional ha llevado al presidente de este país a ser una figura conocida a nivel global y, debido a la condición del país como única superpotencia, en 2009 la revista Forbes calificaba a su titular como «la persona más poderosa del mundo».";
                    domainControler.addDocument("Wikipedia", "Presidente de los Estados Unidos", content);

                    content = "Android es un sistema operativo basado en el núcleo Linux. Fue diseñado principalmente para dispositivos móviles con pantalla táctil, como teléfonos inteligentes, tablets o tabléfonos; y también para relojes inteligentes, televisores y automóviles. Inicialmente fue desarrollado por Android Inc., empresa que Google respaldó económicamente y más tarde, en 2005, la compró. Android fue presentado en 2007 junto la fundación del Open Handset Alliance (un consorcio de compañías de hardware, software y telecomunicaciones) para avanzar en los estándares abiertos de los dispositivos móviles. El primer móvil con el sistema operativo Android fue el HTC Dream y se vendió en octubre de 2008. Los dispositivos de Android venden más que las ventas combinadas de Windows Phone e IOS. El éxito del sistema operativo se ha convertido en objeto de litigios sobre patentes en el marco de las llamadas «Guerras por patentes de teléfonos inteligentes» (en inglés, Smartphone patent wars) entre las empresas de tecnología. Según documentos secretos filtrados en 2013 y 2014, el sistema operativo es uno de los objetivos de las agencias de inteligencia internacionales. La versión básica de Android es conocida como Android Open Source Project (AOSP). El 25 de junio de 2014 en la Conferencia de Desarrolladores Google I/O, Google mostró una evolución de la marca Android, con el fin de unificar tanto el hardware como el software y ampliar mercados.";
                    domainControler.addDocument("Wikipedia", "Android", content);

                    content = "iOS es un sistema operativo móvil de la multinacional Apple Inc. Originalmente desarrollado para el iPhone (iPhone OS), después se ha usado en dispositivos como el iPod touch y el iPad. No permite la instalación de iOS en hardware de terceros. Tenía el 26 % de cuota de mercado de sistemas operativos móviles vendidos en el último cuatrimestre de 2010, detrás de Android y Windows Phone. Actualmente su sistema operativo se encuentra en la décima versión, mejor conocida como iOS 10. Apple anunció el lunes 21 de septiembre de 2015 que su nuevo sistema operativo iOS 9 ya ha superado el 70 % de adopción dentro de sus dispositivos compatibles. Según la marca de Cupertino, 2 de cada 3 dispositivos tienen iOS 9 instalado. El 23 de septiembre de 2015 (tan solo una semana después de la salida de iOS 9), Apple saca iOS 9.0.1 para solucionar problemas relacionados con las alarmas y temporizadores. Los elementos de control consisten de deslizadores, interruptores y botones. La respuesta a las órdenes del usuario es inmediata y provee una interfaz fluida. La interacción con el sistema operativo incluye gestos como deslices, toques, pellizcos, los cuales tienen definiciones diferentes dependiendo del contexto de la interfaz. Se utilizan acelerómetros internos para hacer que algunas aplicaciones respondan a sacudir el dispositivo (por ejemplo, para el comando deshacer) o rotarlo en tres dimensiones (un resultado común es cambiar de modo vertical al apaisado u horizontal). En el marco de las filtraciones acerca de los programas de vigilancia mundial de 2013-2014 de Edward Snowden, Der Spiegel publicó que la NSA estadounidense tiene grupos de trabajo dedicados a descifrar los sistemas de seguridad de iOS; además tiene pequeños programas conocidos como scripts que permiten a la agencia vigilar a los usuarios de las distintas versiones del sistema iOS su geolocalización, notas de voz, fotos y otras aplicaciones como Google Earth, Facebook o Yahoo! Messenger. iOS se deriva de macOS, que a su vez está basado en Darwin BSD, y por lo tanto es un sistema operativo Tipo Unix. iOS cuenta con cuatro capas de abstracción: la capa del núcleo del sistema operativo, la capa de \"Servicios Principales\", la capa de \"Medios\" y la capa de \"Cocoa Touch\".";
                    domainControler.addDocument("Wikipedia", "iOs", content);

                    content = "Un automóvil de turismo, también conocido simplemente como turismo o automóvil o automotor, es el tipo de automóvil destinado al transporte de personas, con al menos cuatro ruedas y un máximo de nueve plazas incluido el conductor.";
                    domainControler.addDocument("Wikipedia", "Automóvil de turismo", content);
                }
            }
        });
        buttonTestResetRenewLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                domainControler.restartStatus();
                JOptionPane.showMessageDialog(null, "Libreria Vacia");
            }
        });

        buttonLibraryGestionAddSaveIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldLibraryGestionAddAuthor.getText().length() == 0 || textFieldLibraryGestionAddTitle.getText().length() == 0 ||textPaneLibraryGestionAddContent.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Almacenar obra\" de nuevo");

                }
                else{
                    //Vector<String> content = new Vector<String>();
                    String content = "";
                    //content.add();
                    content += textPaneLibraryGestionAddContent.getText();
                    if(domainControler.addDocument(textFieldLibraryGestionAddAuthor.getText(), textFieldLibraryGestionAddTitle.getText(), content)) {
                        JOptionPane.showMessageDialog(null, "Obra añadida correctamente");
                        textFieldLibraryGestionAddAuthor.setText("");
                        textFieldLibraryGestionAddTitle.setText("");
                        textPaneLibraryGestionAddContent.setText("");
                    }
                    else JOptionPane.showMessageDialog(null, "Esta obra ya existe");
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
                    //Vector<String> content = domainControler.getDocumentContent(textFieldLibraryGestionListAuthor.getText(), textFieldLibraryGestionListTitle.getText());
                    //for(String sentence:content){
                    //    try {
                    //        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), sentence, null);
                    //    }
                    //    catch(Exception exc) { System.out.println(e); }
                    //}
                    String content = domainControler.getDocumentContent(textFieldLibraryGestionListAuthor.getText(), textFieldLibraryGestionListTitle.getText());
                    try {
                        textPaneLibraryGestionList.getStyledDocument().insertString(textPaneLibraryGestionList.getStyledDocument().getLength(), content, null);
                    } catch (Exception exc) {
                        System.out.println(e);
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
                    //Vector<String> content = domainControler.getDocumentContent(textFieldConsultsContentAuthor.getText(), textFieldConsultsContentTitle.getText());
                    //for(String sentence:content){
                    //    try {
                    //        textPanelConsultsContent.getStyledDocument().insertString(textPanelConsultsContent.getStyledDocument().getLength(), sentence, null);
                    //    }
                    //    catch(Exception exc) { System.out.println(e); }
                    //}
                    String content = domainControler.getDocumentContent(textFieldConsultsContentAuthor.getText(), textFieldConsultsContentTitle.getText());
                    try {
                        textPanelConsultsContent.getStyledDocument().insertString(textPanelConsultsContent.getStyledDocument().getLength(), content, null);
                    } catch (Exception exc) {
                        System.out.println(e);
                    }
                }
            }
        });


        listTitlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<String> authorDocuments = new HashSet<String>();
                authorDocuments = domainControler.getAuthorDocumentTitles(textFieldConsutlsTitleAuthor.getText().toString());
                DefaultListModel lista = new DefaultListModel();
                int i = 1;
                for (String s: authorDocuments){
                    lista.addElement(s);
                    i++;
                }
                listConsutlsTitleAuthor.setModel(lista);
            }
        });
        buttonConsutlsTitleAuthor11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SelectionDialog selectiondialog = new SelectionDialog();
                Set<String> authorsStarting = new HashSet<String>();
                String pref = textFieldConsutlsTitleAuthor.getText().toString();
                authorsStarting = domainControler.getAuthorsByPrefix(pref);
                selectiondialog.feedlist(authorsStarting, textFieldConsutlsTitleAuthor);

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
                        JOptionPane.showMessageDialog(null, "Obra eliminada correctamente");
                        textFieldLibraryGestionListAuthor.setText("");
                        textFieldLibraryGestionListTitle.setText("");
                        textPaneLibraryGestionList.setText("");
                    }
                }
            }
        });
        buttonLibraryGestionListModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(modifyingDocument==false) {
                    if (textFieldLibraryGestionListAuthor.getText().length() == 0 || textFieldLibraryGestionListTitle.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Modificar\" de nuevo");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Modifica los campos que quieras y haz clic en \"Guardar Cambios\" cuando hayas terminado");
                        textFieldLibraryGestionListAuthor.setBackground(Color.GREEN);
                        textFieldLibraryGestionListTitle.setBackground(Color.GREEN);
                        textPaneLibraryGestionList.setBackground(Color.GREEN);
                        textPaneLibraryGestionList.setEditable(true);


                        modifyingDocument = true;
                        authorModyfied = textFieldLibraryGestionListAuthor.getText();
                        titleModyfied = textFieldLibraryGestionListTitle.getText();
                        buttonLibraryGestionListModify.setText("Guardar Cambios");
                    }
                }
                else{
                    if (textFieldLibraryGestionListAuthor.getText().length() == 0 || textFieldLibraryGestionListTitle.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Algún campo está vacio, por favor, verifíquelo y pulse \"Guardar Cambios\" de nuevo");
                    }
                    if (authorModyfied!=textFieldLibraryGestionListAuthor.getText()){
                        domainControler.modifyDocumentAuthor(authorModyfied,titleModyfied,textFieldLibraryGestionListAuthor.getText());
                    }
                    if (titleModyfied!=textFieldLibraryGestionListTitle.getText()){
                        domainControler.modifyDocumentTitle(authorModyfied,titleModyfied,textFieldLibraryGestionListTitle.getText());
                    }
                    if (contentModyfied!=textPaneLibraryGestionList.getText()){
                        domainControler.modifyDocumentContent(authorModyfied,titleModyfied,textPaneLibraryGestionList.getText());
                    }
                        JOptionPane.showMessageDialog(null, "Cambios guardados");
                    textFieldLibraryGestionListAuthor.setBackground(Color.WHITE);
                    textFieldLibraryGestionListTitle.setBackground(Color.WHITE);
                    textPaneLibraryGestionList.setBackground(Color.WHITE);
                    textPaneLibraryGestionList.setEditable(false);

                    modifyingDocument=false;
                    buttonLibraryGestionListModify.setText("Modificar");
                }
            }
        });
    }
    private void update_listAuthorGestionList(){
        Set<String> authorsStarting = new HashSet<String>();
        authorsStarting = domainControler.getAuthorNames();
        DefaultListModel lista = new DefaultListModel();
        int i = 1;
        for (String s: authorsStarting){
            lista.addElement(s);
            i++;
        }
        listAuthorGestionList.setModel(lista);
    }

    private String readFile(File fichero) throws IOException {


        StringBuilder fileContents = new StringBuilder((int)fichero.length());
        Scanner scanner = new Scanner(fichero);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
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
    private void convertTodocument(String route, Vector<String> content) throws FileNotFoundException, IOException{
        String cadena;
        FileReader f = new FileReader(route);
        BufferedReader b = new BufferedReader(f);

        content.add(b.readLine());
        content.add(b.readLine());
        //content.add("");
        cadena = "";
        String s;
        while((s = b.readLine())!=null) {
            cadena += s;
        }
        content.add(cadena);
        b.close();
    }



    //public static void
}
