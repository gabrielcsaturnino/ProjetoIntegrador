package org.conrel.models;

import lombok.*;

import java.util.Date;

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


}
