package org.conrel.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.conrel.models.FactoryFuncionario.FactFunc;
import static org.conrel.models.dal.FuncionarioDAO.ValidarCpf;
import static org.conrel.models.dal.FuncionarioDAO.insert;

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



                try {


                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    java.util.Date dataAdmissaoUtil = dateFormat.parse(dataAdmissaoText); // Converte o texto da data para java.util.Date
                    java.sql.Date dataAdmissaoSql = new java.sql.Date(dataAdmissaoUtil.getTime()); // Converte java.util.Date para java.sql.Date

                    if(ValidarCpf(cpf)){
                        JOptionPane.showMessageDialog(AdicionarFuncionario.this, "CPF já existe no banco de dados. Insira um CPF diferente.");
                        return;
                    }


                    if(nome.isEmpty()){
                        JOptionPane.showMessageDialog(AdicionarFuncionario.this,
                                "O campo nome está vazio.");
                        return;
                    }


                    if (salario_horaText.isEmpty()) {
                        JOptionPane.showMessageDialog(AdicionarFuncionario.this,
                                "O campo de salário está vazio.");
                        return;
                    }

                    int salario_hora = Integer.parseInt(salario_horaText);


                    if (dataAdmissaoText.isEmpty()) {
                        JOptionPane.showMessageDialog(AdicionarFuncionario.this,
                                "O campo de data de admissão está vazio.");
                        return;
                    }





                    insert(FactFunc(nome, cpf, cargo, rg, dept, dataAdmissaoSql, contrato, salario_hora));


                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdicionarFuncionario.this, "O campo de salário contém um valor inválido.");
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(AdicionarFuncionario.this, "Erro ao inserir no banco de dados.");
                    ex.printStackTrace();


                }

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




