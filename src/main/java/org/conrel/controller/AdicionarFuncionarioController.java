package org.conrel.controller;

import org.conrel.models.Funcionario;
import org.conrel.models.dal.ExceptionCustom;
import org.conrel.views.AdicionarFuncionario;
import org.conrel.views.TelaPrincipal;
import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdicionarFuncionarioController implements ActionListener {

    TelaPrincipal mv;
    Funcionario funcionario;

    public AdicionarFuncionarioController() {

    }

    public String getName() {
        return adicionarFuncionario.getName();
    }

    public String getCpf() {
        return adicionarFuncionario.getCpf();
    }

    public String getCargo() {
        return adicionarFuncionario.getCargo();
    }

    public String getDepartamento() {
        return adicionarFuncionario.getDepartamento();
    }

    public String getContrato() {
        return adicionarFuncionario.getContrato();
    }

    public String getFone() {
        return adicionarFuncionario.getFone();
    }

    public String getDataAdmissao() {
        return adicionarFuncionario.getDataAdmissao();
    }

    public String getSalario() {
        return adicionarFuncionario.getSalario();
    }

    public String getRg() {
        return adicionarFuncionario.getRg();
    }

    public AdicionarFuncionarioController(AdicionarFuncionario adicionarFuncionario, Funcionario funcionario, TelaPrincipal mv){
        this.funcionario = funcionario;
        this.adicionarFuncionario = adicionarFuncionario;
        this.mv = mv;
    }

    AdicionarFuncionario adicionarFuncionario;









    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);
        if(command.equals("Enviar")){
            String nome = getName();
            String cpf = getCpf();
            String cargo = getCargo();
            String dept = getDepartamento();
            String contrato = getContrato();
            String fone = getFone();
            String dataAdmissaoText = getDataAdmissao();
            String salario_horaText = getSalario();
            String rg = getRg();




            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataAdmissaoUtil = null;


            try {
                int salario_hora = Integer.parseInt(salario_horaText);
                dataAdmissaoUtil = dateFormat.parse(dataAdmissaoText);
                java.sql.Date dataAdmissaoSql = new java.sql.Date(dataAdmissaoUtil.getTime());
                funcionario.adicionarFuncionario(nome, cpf, cargo, rg, dept, dataAdmissaoSql, contrato, salario_hora);
                adicionarFuncionario.messageDialog("Cadastrado");
            } catch (ExceptionCustom ex) {
                adicionarFuncionario.messageDialog(ex.getMessage());
            } catch (PSQLException ex) {
                adicionarFuncionario.messageDialog("Erro ao inserir no banco");
            }catch (ParseException ex) {
                adicionarFuncionario.messageDialog("Valor de data é invalido: dd/MM/yyyy");
            }catch (NumberFormatException ex){
                adicionarFuncionario.messageDialog("Digite um valor numérico.");
            }



        }

        else if(command.equals("Voltar")){
            adicionarFuncionario.setVisibleFalse();
            mv.setVisibleTrue();

        }


    }
}
