package org.conrel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Licenca {
    private Date dataValidade;
    private Date dataEmissao;
    private String tipo;
    private String status;
    private int id; // Chave primária
    private Funcionario funcionario; // Chave estrangeira
}
