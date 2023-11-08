package org.conrel.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treinamento {
    private String nome;
    private String tipo;
    private String prioridade;
    private int id; // Chave primária
}