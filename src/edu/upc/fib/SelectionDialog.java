package edu.upc.fib;

import javax.swing.*;

/**
 * Created by Javier on 10/12/2016.
 */
public class SelectionDialog extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JButton aceptarButton;
    private JButton cancelarButton;

    public SelectionDialog(){

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        feedlist();
    }

    public void feedlist(){

        DefaultListModel lista = new DefaultListModel();
        for(int i = 1; i < 101; i++){lista.addElement("pene"+ i);}
        list1.setModel(lista);


    }
}
