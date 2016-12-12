package edu.upc.fib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Javier on 10/12/2016.
 */
public class SelectionDialog extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JButton aceptarButton;
    private JButton cancelarButton;
    String selection;

    public SelectionDialog(){

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        //feedlist();
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selection = list1.getSelectedValue().toString();
                dispose();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selection = "";
                dispose();
            }
        });
    }

    public String feedlist(Set<String> authors){

        /*DefaultListModel lista = new DefaultListModel();
        for(int i = 1; i < 101; i++){lista.addElement("pene"+ i);}
        list1.setModel(lista);*/
        DefaultListModel lista = new DefaultListModel();
        int i = 1;
        for (String s: authors){
            lista.addElement(s);
            i++;
        }
        list1.setModel(lista);
        return selection;
    }
    public void feedlist1a100(){
        DefaultListModel lista = new DefaultListModel();
        for(int i = 1; i < 101; i++){lista.addElement("test"+ i);}
        list1.setModel(lista);
    }
}
