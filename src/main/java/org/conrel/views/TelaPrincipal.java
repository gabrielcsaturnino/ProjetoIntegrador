package org.conrel.views;

import org.conrel.models.Funcionario;
import org.conrel.models.dal.ButtonColumn;
import org.conrel.models.dal.FuncionarioTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;

import static org.conrel.models.dal.FuncionarioDAO.consulta;

public class TelaPrincipal  extends  JFrame{


    private JButton addButton;

    private JPanel mainPanel;
    private JTable jtable1;
    private JButton addBeneficio;
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


        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Botão pressionado na linha: " + e.getActionCommand());
                int row = Integer.parseInt(e.getActionCommand());
        }
        };

        ButtonColumn buttonColumn = new ButtonColumn(jtable1, delete, 5);
        buttonColumn.setMnemonic(KeyEvent.VK_D);









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
