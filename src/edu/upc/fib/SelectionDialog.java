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

    public SelectionDialog(){}

    public static void main(){
        JFrame frame1 = new JFrame("Seleccione un elemento de la lista y pulse aceptar:");
        frame1.setContentPane(new SelectionDialog().panel1);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }
    public void feedlist(){
        String[] ar = {"one", "two", "three"};
        JList list1 = new JList(ar);
    }
}
