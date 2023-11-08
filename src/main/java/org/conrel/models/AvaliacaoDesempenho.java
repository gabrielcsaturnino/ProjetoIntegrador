package org.conrel.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDesempenho {
    private String descricao;
    private Date data;
    private int id; // Chave primária
    private int pontuacao;
    private Funcionario funcionario; // Chave estrangeira
    private List<AvaliacaoDesempenhoTreinamento> treinamentos;
}
