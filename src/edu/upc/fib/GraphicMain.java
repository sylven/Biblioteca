package edu.upc.fib;

import javax.swing.*;

/**
 * Created by Javier on 28/11/2016.
 */
public class GraphicMain {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JButton añadirDocumentosDePruebaButton;
    private JButton vaciarPapeleraButton;

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Biblioteca");
        mainFrame.setContentPane(new GraphicMain().panel1);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
