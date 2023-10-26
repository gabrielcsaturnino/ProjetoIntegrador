package org.conrel.telas;

import org.conrel.dal.ConnectDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo extends JFrame{

    private JLabel nome;
    private JTextField textName;
    private JButton button;
    private JPanel mainPanel;

    public Demo() {
        setContentPane(mainPanel);
        setTitle("Gui teste");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Demo.this, textName.getText() + " Hello");
            }
        });
    }

    public static void main(String[] args) throws SQLException {
        //new Demo();

        ConnectDB db = new ConnectDB();

        db.consulta();
        System.out.println("Test");

    }
}




