package org.conrel.telas;

import org.conrel.test;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaPrincipal  extends  JFrame{


    private JButton addButton;
    private JPanel mainPanel;
    private JList list1;

    public TelaPrincipal(){

        setContentPane(mainPanel);
        setTitle("CONREL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);

            addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarFuncionario();
                setVisible(false);
            }
        });

        DefaultListModel<test> t = new DefaultListModel<>();
        t.addElement(new test("Gabriel"));
        t.addElement(new test("Pedro"));

        list1.setModel(t);



    }




    public static void main(String[] args) throws SQLException {
        new TelaPrincipal();




    }
}
