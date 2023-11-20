package org.conrel.views;

import org.conrel.controller.AdicionarFuncionarioController;
import org.conrel.models.dal.ExceptionCustom;
import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.conrel.models.dal.FactoryFuncionario.FactFunc;
import static org.conrel.models.dal.FuncionarioDAO.ValidarCpf;
import static org.conrel.models.dal.FuncionarioDAO.insert;

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

        java.util.Date dataUtil = new java.util.Date(); // Exemplo de java.util.Date
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime()); // Converte java.util.Date para java.sql.Date


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = txtname.getText();
                String cpf = txtcpf.getText();
                String cargo = txtcargo.getText();
                String dept = txtdepartamento.getText();
                String contrato = txtcontrato.getText();
                String fone = txtfone.getText();
                String dataAdmissaoText = txtdata.getText();
                String salario_horaText = txtsalario.getText().trim();
                String rg = txtrg.getText();

                int salario_hora = Integer.parseInt(salario_horaText);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date dataAdmissaoUtil = null;

                try {

                    dataAdmissaoUtil = dateFormat.parse(dataAdmissaoText);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                java.sql.Date dataAdmissaoSql = new java.sql.Date(dataAdmissaoUtil.getTime());


                try {
                    AdicionarFuncionarioController.adicionarFuncionario(nome, cpf, cargo, rg, dept, dataAdmissaoSql, contrato, salario_hora);
                } catch (ExceptionCustom ex) {
                    JOptionPane.showMessageDialog(AdicionarFuncionario.this, ex.getMessage());
                } catch (PSQLException ex) {
                    JOptionPane.showMessageDialog(AdicionarFuncionario.this, "Erro ao inserior no banco!");
                }

                JOptionPane.showMessageDialog(AdicionarFuncionario.this, "Cadastrado com sucesso!");
            }
        });


        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new TelaPrincipal();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });

    }


}




