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
public class Beneficio {
    private float custo;
    private String nome;
    private String tipo;
    private Date dataTermino;
    private int cod; // Chave primária
    private String status;
    private Funcionario funcionario; // Chave estrangeira
}