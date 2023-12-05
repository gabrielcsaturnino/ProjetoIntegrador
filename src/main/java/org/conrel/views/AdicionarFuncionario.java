package org.conrel.views;

import org.conrel.controller.AdicionarFuncionarioController;
import org.conrel.controller.MainViewController;
import org.conrel.models.dal.ExceptionCustom;
import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdicionarFuncionario extends JFrame {

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
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);




    }

    public  String getName(){
        return this.txtname.getText();
    }

    public String getCpf(){
        return this.txtcpf.getText();
    }
    public String getCargo(){
        return this.txtcargo.getText();
    }
    public String getDepartamento(){
        return this.txtdepartamento.getText();
    }

    public String getContrato(){
        return this.txtcontrato.getText();
    }

    public String getFone(){
        return this.txtfone.getText();
    }

    public String getDataAdmissao(){
        return this.txtdata.getText();
    }

    public String getSalario(){
        return this.txtsalario.getText();
    }

    public String getRg(){
        return this.txtrg.getText();
    }

    public void setListeners(AdicionarFuncionarioController adicionarFuncionarioController){
        button.addActionListener(adicionarFuncionarioController);
        voltarButton.addActionListener(adicionarFuncionarioController);
    }

    public void messageDialog(String msg){
        JOptionPane.showMessageDialog(AdicionarFuncionario.this, msg);
    }

    public void setVisibleFalse(){
        setVisible(false);
    }

    public  void setVisibleTrue(){
        setVisible(true);
    }



}




