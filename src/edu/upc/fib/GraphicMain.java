package edu.upc.fib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public GraphicMain() {
        vaciarPapeleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //main(null);
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


    //public static void
}
