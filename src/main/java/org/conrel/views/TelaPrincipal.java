package org.conrel.views;

import org.conrel.controller.AdicionarFuncionarioController;
import org.conrel.controller.DeletarFuncionarioController;
import org.conrel.controller.MainViewController;
import org.conrel.models.Funcionario;
import org.conrel.models.dal.ButtonColumn;
import org.conrel.models.dal.FuncionarioTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;


import static org.conrel.models.dal.FuncionarioDAO.consulta;

public class TelaPrincipal  extends  JFrame{


    private JButton addButton;

    private  ButtonColumn buttonDelete;
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


        AdicionarFuncionarioController ad = new AdicionarFuncionarioController();

        ButtonColumn buttonPonto = new ButtonColumn(jtable1,  7);
        ButtonColumn buttonBeneficio = new ButtonColumn(jtable1, 6);
        buttonDelete = new ButtonColumn(jtable1, 5);













    }


    public void setListeners(MainViewController adicionarFuncionarioController, DeletarFuncionarioController deletarFuncionarioController){
        addButton.addActionListener(adicionarFuncionarioController);
        buttonDelete.addActionListener(deletarFuncionarioController);
    }



    public static void main(String[] args) throws SQLException {
       TelaPrincipal mv =  new TelaPrincipal();
       MainViewController telaPrincipalController = new MainViewController(mv);
       DeletarFuncionarioController delete = new DeletarFuncionarioController(mv);
       mv.setListeners(telaPrincipalController, delete);

    }

    public void setVisibleFalse(){
        setVisible(false);
    }

    public  void setVisibleTrue(){
        setVisible(true);
    }

    public int getIndex(){
        return buttonDelete.getColumn();
    }

}
