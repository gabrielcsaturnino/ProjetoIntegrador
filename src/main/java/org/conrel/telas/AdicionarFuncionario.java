package org.conrel.telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static org.conrel.dal.ConnectDB.consulta;
import static org.conrel.dal.ConnectDB.insert;

public class AdicionarFuncionario extends JFrame{

    private JLabel nome;
    private JTextField txtname;
    private JButton button;
    private JPanel addPanel;
    private JLabel cpf;
    private JTextField txtcpf;
    private JTextField txtfone;
    private JTextField txtrg;
    private JTextField txtcontrato;
    private JTextField txtdata;
    private JTextField txtcargo;
    private JTextField txtdepartamento;
    private JTextField txtsalario;
    private JButton voltarButton;

    public AdicionarFuncionario() {
        setContentPane(addPanel);
        setTitle("CONREL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdicionarFuncionario.this, txtname.getText() + " Hello");
                try{
                    insert(txtname.getText());
                    consulta();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }


});




        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaPrincipal();
                setVisible(false);
            }
        });

    }



}




