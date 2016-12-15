package edu.upc.fib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Vector;

public class SelectionDialog extends JFrame {
    private JPanel panel1;
    private JList list1;
    private JButton aceptarButton;
    private JButton cancelarButton;
    JTextField textField;

    public SelectionDialog(){
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        //feedlist();
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(list1.getSelectedValue().toString());
                dispose();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void feedlist(Set<String> authors, JTextField textField_ext){

        /*DefaultListModel lista = new DefaultListModel();
        for(int i = 1; i < 101; i++){lista.addElement("pene"+ i);}
        list1.setModel(lista);*/
        textField = textField_ext;
        DefaultListModel lista = new DefaultListModel();
        int i = 1;
        for (String s: authors){
            lista.addElement(s);
            i++;
        }
        list1.setModel(lista);
    }
    public void feedlist1a100(){
        DefaultListModel lista = new DefaultListModel();
        for(int i = 1; i < 101; i++){lista.addElement("test"+ i);}
        list1.setModel(lista);
    }
}
