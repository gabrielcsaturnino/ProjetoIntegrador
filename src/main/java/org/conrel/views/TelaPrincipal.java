package org.conrel.views;

import org.conrel.models.Funcionario;
import org.conrel.models.FuncionarioTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import static org.conrel.models.dal.FuncionarioDAO.consulta;

public class TelaPrincipal  extends  JFrame{


    private JButton addButton;
    private JPanel mainPanel;
    private JTable jtable1;
    private FuncionarioTable tableList;

    public TelaPrincipal() throws SQLException {

        setContentPane(mainPanel);
        setTitle("CONREL");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);


        List<Funcionario> funcionarios = consulta();
        tableList = new FuncionarioTable(funcionarios);

        jtable1.setModel(tableList);


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
