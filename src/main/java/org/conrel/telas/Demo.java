package org.conrel.telas;

import org.conrel.dal.ConnectDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static org.conrel.dal.ConnectDB.consulta;
import static org.conrel.dal.ConnectDB.insert;

public class Demo extends JFrame{

    private JLabel nome;
    private JTextField textName;
    private JButton button;
    private JPanel mainPanel;

    public Demo() {
        setContentPane(mainPanel);
        setTitle("Gui teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Demo.this, textName.getText() + " Hello");
                try{
                    insert(textName.getText());
                    consulta();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }




});





    }


    public static void main(String[] args) throws SQLException {
        //new Demo();
        new Demo();
        ConnectDB db = new ConnectDB();
        consulta();
        System.out.println("Testt");




    }
}




