package org.conrel.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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




    }




    public static void main(String[] args) throws SQLException {
        new TelaPrincipal();



    }
}
