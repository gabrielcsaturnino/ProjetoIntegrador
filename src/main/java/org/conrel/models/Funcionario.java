package org.conrel.models;

import lombok.*;
import org.conrel.models.dal.ExceptionCustom;
import org.postgresql.util.PSQLException;

import java.util.Date;

import static org.conrel.models.dal.FactoryFuncionario.FactFunc;
import static org.conrel.models.dal.FuncionarioDAO.ValidarCpf;
import static org.conrel.models.dal.FuncionarioDAO.insert;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Funcionario {
    private String nome;
    private String cpf;
    private String cargo;
    private String rg;
    private String departamento;
    private Date data_admissao;
    private String contrato;
    private int salario_hora;


    public  void adicionarFuncionario(String nome, String cpf, String cargo, String rg, String departamento, Date dataAdmissao, String contrato, int salarioHora) throws ExceptionCustom, PSQLException {
        if (ValidarCpf(cpf)) {
            throw new ExceptionCustom("CPF já existe no banco de dados. Insira um CPF diferente.");
        }

        if (nome.isEmpty()) {
            throw new ExceptionCustom("O campo nome está vazio.");
        }

        if (salarioHora <= 0) {
            throw new ExceptionCustom("O campo de salário é inválido.");
        }

        if (dataAdmissao == null) {
            throw new ExceptionCustom("A data de admissão não foi especificada.");
        }

        insert(FactFunc(nome, cpf, cargo, rg, departamento, dataAdmissao, contrato, salarioHora));
    }
}
