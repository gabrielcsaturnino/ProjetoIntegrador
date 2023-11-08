package org.conrel.models;

import java.util.Date;

public class FactoryFuncionario extends Funcionario {
    public static Funcionario FactFunc(String nome, String cpf, String cargo, String rg, String departamento, Date data_admissao, String contrato, int salario_hora) {
        return new Funcionario(nome, cpf, cargo, rg, departamento, data_admissao, contrato, salario_hora);
    }
}
